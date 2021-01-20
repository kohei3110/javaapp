package ApplicationArchitecture1.common;

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

@ApplicationScoped
public class LoggerProducer implements Serializable {

    private Logger logger;
    
    public static final String LOGGER_NAME = "applicationarchitecture.logger";
    public static final String LOG_FILE_PATH = "/Users/kohei/sample_app_1.log";
    public static final String LOG_FORMAT_PROPERTY_NAME = "java.util.logging.SimpleFormatter.format";
    
    public static final String LOG_FORMAT_PROPERTY_VALUE = "%1$tc %2$s%n%4$s: %5$s%6$s%n";

    @PostConstruct
    public void doInitialize() {
        logger = Logger.getLogger(LOGGER_NAME);
        configFileHandler();
    }

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

    @Produces
    public Logger getLogger() {
        return logger;
    }
}