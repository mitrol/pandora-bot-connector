package net.mitrol.pandoraBotConnector.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.mitrol.pandoraBotConnector.model.WsMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class PandoraBotService {

    private final Logger logger = Logger.getLogger(PandoraBotService.class);

    @Value("${pandora.url}")
    private String pandoraUrl;

    private WebSocketClient webSocketClient;
    private ObjectMapper objectMapper;

    public PandoraBotService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.webSocketClient = new StandardWebSocketClient();
    }

    @PostConstruct
    private void init() {
        logger.info("connecting to " + pandoraUrl + "...");

        this.webSocketClient.doHandshake(new WebSocketHandler() {

            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                logger.info("afterConnectionEstablished");

                WsMessage wsMessage = new WsMessage();
                wsMessage.setChannel("web_sock");
                wsMessage.setBotName("mvl");
                wsMessage.setLang("es");
                wsMessage.setEventName("*text");
                wsMessage.setMessage("hola");
                wsMessage.setMimeType("text/plain");
                wsMessage.setEncoding("utf-8");
                wsMessage.setUserID("andy2");
                wsMessage.setSource("aqui");
                wsMessage.setParameters(Arrays.asList("user.name=andy2", "user.mail=mymail@myserver.com"));

                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(wsMessage)));
                logger.info("message sent");
            }

            @Override
            public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
                logger.info("handleMessage\t" + message.getPayload());
                WsMessage wsMessage = objectMapper.readValue(message.getPayload().toString(), WsMessage.class);
                logger.info(wsMessage);
            }

            @Override
            public void handleTransportError(WebSocketSession session, Throwable exception) {
                logger.info("handleTransportError");
            }

            @Override
            public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
                logger.info("afterConnectionClosed");
            }

            @Override
            public boolean supportsPartialMessages() {
                return false;
            }

        }, pandoraUrl);
    }
}
