package net.mitrol.pandoraBotConnector.model;

import java.util.List;

public class WsMessage {

    /**
     * originating/destination channel-name
     * (MSN, GTalk, ICQ, web, websocket, Telegram, facebook-messenger, tweet, etc.)
     */
    private String Channel;

    /**
     * name of the targetted automated: bot-agent/human-agent
     */
    private String BotName;


    /**
     * Additional information, concerning to labels: in/out
     */
    private String Lang;

    /**
     * Name of the event, in case of a text message type='*text', this name
     * might be used as sub-channel as in twitter/facebook an other complex/social networks.
     * The static class: EventType has the mainly Recognized-strings
     */
    private String EventName;

    /**
     * Original sent message (user originated)
     */
    private String Message;

    /**
     * Type of message, might be only a message, or even a command, a keep-alive, etc.
     */
    private String MimeType;

    /**
     * encoding type, utf-8 plain rich-text (default), base-64 default for binary
     */
    private String Encoding;

    /**
     * unique target / originator (user-id)
     */
    private String UserID;

    /**
     * sub-channel chain information, like session-ID, connectionID, etc.
     */
    private String Source;

    /**
     * custom-parameters,
     * all of them, regardless of format, should be copied back to the response
     * usage: set/get internal or new context-variables into the chat-object,
     * like:
     * variableName=JSON-Value (Value in JSON format)
     * QUERY:
     * to get specific-information out of the DDL chat/user/global objects
     * variablename?
     * where: variable name is any DDL variable, including sub-structures (in JSON format)
     * for example:
     * user.name
     * -> the result should return in the same format
     * variableName=JSON-Value (Value in JSON format)
     */
    private List<String> Parameters;

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }

    public String getBotName() {
        return BotName;
    }

    public void setBotName(String botName) {
        BotName = botName;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        MimeType = mimeType;
    }

    public String getEncoding() {
        return Encoding;
    }

    public void setEncoding(String encoding) {
        Encoding = encoding;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public List<String> getParameters() {
        return Parameters;
    }

    public void setParameters(List<String> parameters) {
        Parameters = parameters;
    }
}
