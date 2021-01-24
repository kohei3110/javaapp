package websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author kohei
 */
@ServerEndpoint(value = "/echows/room/{room-descriptor}")
public class SampleWebSocket {
    
    private static Set<Session> ses = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(@PathParam("room-descriptor") final String pRoomDescriptor, Session session){
        System.out.println("Opening Session : " + session);
        System.out.println("Protocol version : " + session.getProtocolVersion());
        ses.add(session);
    }
    
    @OnMessage
    public String echo(@PathParam("room-descriptor") final String pRoomDescriptor, String message){
        System.out.println("Sent message : " + message);
        return message;
    }
    
    @OnClose
    public void onClose(@PathParam("room-descriptor") final String pRoomDescriptor, Session session){
        System.out.println("Closing Session : " + session);
        ses.remove(session);
    }
    
    public static void sendMessage(String msg){
        ses.forEach(s -> {
            s.getAsyncRemote().sendText(msg);
        });
    }
}
