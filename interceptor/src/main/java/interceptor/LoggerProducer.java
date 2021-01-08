package interceptor;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * ロガーのCDIプロデューサクラス。<br>
 * 現在は、サンプルとして、以下の実装を行っている。<br>
 * <ul>
 * <li>ロガーの名前を指定</li>
 * <li>ログファイルの出力先を指定</li>
 * <li>ログフォーマットを指定</li>
 * </ul>
 * 本実装では、アプリケーション単位でロガーのオブジェクトが、アプリケーションの起動から停止まででヒープメモリ上に1つのインスタンスしか作成しないよう、ApplicationScoped注釈を付与している。<br>
 * プロデューサメソッドのスコープ定義には、特に注意が必要である。<br>
 * デフォルトのスコープは@Dependentのままにしておくと、プロデューサメソッドで返すオブジェクト（ここではロガー）が、呼び出し元のクラスのスコープに依存してしまい、望ましくない。<br>
 * もしプロデューサクラスに適切なスコープを定義しないと、オブジェクトが長期間ヒープ上に生存したり、不要なオブジェクトが多数作成されてしまったりして、問題が発生してしまう可能性がある。
 * @author 日本オラクル株式会社
 */
@ApplicationScoped
public class LoggerProducer implements Serializable {

    private Logger logger;
    
    // プロパティの設定
    /**
     * 取得するロガーの名前。<br>
     * これはドットで区切られた名前にすべきであり、通常はjava.netやjavax.swingなど、サブシステムのパッケージ名またはクラス名に基づいた名前にする。<br>
     */
    public static final String LOGGER_NAME = "jp.co.test";
    /**
     * ログファイルの出力先。<br>
     * FileHandlerコンストラクタで引数として指定し、指定されたファイルにログが書き込まれる。
     */
    public static final String LOG_FILE_PATH = "/Users/kohei/oracle-project/sample.log";
    /**
     * 指定された LogRecord をフォーマットするキー。<br>
     * フォーマットは、java.util.logging.SimpleFormatter.format プロパティーでフォーマット文字列を指定することでカスタマイズ可能。
     */
    public static final String LOG_FORMAT_PROPERTY_NAME = "java.util.logging.SimpleFormatter.format";
    
    /**
     * ログフォーマット（値）<br>
     * フォーマットは、java.util.logging.SimpleFormatter.format プロパティーでフォーマット文字列を指定することでカスタマイズ可能。<br>
     * 指定された LogRecord は、次を呼び出すようにフォーマットされる。<br>
     * String.format(format, date, source, logger, level, message, thrown);
     * ここで、引数は次のとおり。<br>
     * <ul>
     * <li>format - java.util.logging.SimpleFormatter.format プロパティーまたはデフォルトのフォーマットで指定された java.util.Formatter のフォーマット文字列。</li>
     * <li>date - ログレコードのイベント時間を表す、Date オブジェクト。</li>
     * <li>source - 使用可能な場合は、呼び出し元を表す文字列。使用できない場合は、ロガーの名前。</li>
     * <li>logger - ロガーの名前。</li>
     * <li>level - ログレベル。</li>
     * <li>message - Formatter.formatMessage(LogRecord) メソッドから返された、フォーマットされたログメッセージ。java.text のフォーマットを使用し、java.util.Formatter format 引数は使用しない。</li>
     * <li>thrown - ログレコードおよび改行文字で始まるそのバックトレースに関連付けられた throwable を表現する文字列 (存在する場合)。バックトレースがない場合は、空の文字列。</li>
     * </ul>
     * 本実装では、1行目にはタイムスタンプ(1$)とソース(2$)、2行目にはログ・レベル(4$)とログ・メッセージ(5$)、使用可能な場合は、その後にスロー可能オブジェクトとそのバックトレース(6$)を含む、2行を出力する。
     */
    public static final String LOG_FORMAT_PROPERTY_VALUE = "%1$tc %2$s 4$s: %5$s%6$s%n";

    /**
     * PostConstruct注釈を付与し、依存性を注入した後、初期化時に実行する。<br>
     * コンストラクタでの初期化直後に、getLoggerファクトリメソッドを呼び出し、ロガーオブジェクトを取得する。<br>
     * また、configFileHandler()を呼び出し、ファイルハンドラの設定を行う。
     */
    @PostConstruct
    public void doInitialize() {
        logger = Logger.getLogger(LOGGER_NAME);
        configFileHandler();
    }

    /**
     * ファイルハンドラの設定を行うメソッド。<br>
     * 指定したログ・フォーマットをシステム・プロパティに設定する。<br>
     * ログハンドラを追加し、指定したパスにログが書き込まれる。
     * 親となるロガーには出力を送信しない。<br>
     * 全てのメッセージ・レベルをロギングする。<br>
     * IOExceptionが発生した場合は、詳細メッセージを標準出力し、ログに書き込み、例外をスローする。
     */
    public void configFileHandler() {
        Handler handler;
        try {
            System.setProperty(LOG_FORMAT_PROPERTY_NAME, LOG_FORMAT_PROPERTY_VALUE);
            handler = new FileHandler(LOG_FILE_PATH);
            logger.addHandler(handler);
            Formatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    /**
     * Produces注釈を付与し、インジェクションするロガーオブジェクトを動的に制御可能にする。<br>
     * ロガーを呼び出すクラスでインジェクションポイントをインターフェースで定義し、プロデューサメソッド内で条件に応じて実装クラスを選択して返す仕組みを作ることで、プログラムに柔軟性を持たせている。
     * @return logger ロガーオブジェクト
     */
    @Produces
    public Logger getLogger() {
        return logger;
    }
}