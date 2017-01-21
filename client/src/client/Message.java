package client;

enum MessageType {
    NONE,
    DISCONNECTED,
    NICKNAME,
    SEND_TABLES,
    CREATE_TABLE,
    JOIN_TABLE,
    CARDS,
    START_BID,
    GIVEN_BID,
    SEND_BID,
    BIDDING_RESULT,
    PLAY_CARD,
    GIVEN_CARD,
    SEND_CARD,
    ROUND_OVER,
    GAME_RESULT
}

public class Message {
    private final MessageType type;
    private final String message;
    
    Message(String msg) {
        this.type = parseIntToMessageType(getIdFromMsg(msg));
        this.message = msg.substring(3);
    }
    
    Message(MessageType msgType, String msg) {
        this.type  = msgType;
        this.message = parseMessageTypeToString(msgType) + ":" + msg;
        System.out.println("Message " + type + " " + message + " created.");
    }
    
    public String getMessage() {
        return this.message;
    }
    
    protected MessageType getMessageType() {
        return type;
    }
    
    protected int getNumberOfTables() throws Exception {
        if (this.type != MessageType.SEND_TABLES)
            throw new Exception("SEND_TABLES: Wrong type of message.");
        
        return (message.length() / 4);
    }
    
    protected String getTableID(int position) throws Exception {
        if (this.type != MessageType.SEND_TABLES)
            throw new Exception("SEND_TABLES: Wrong type of message.");
        
        String msg = message.substring(4*position, 4*position+1);
        return msg;
    }
    
    protected String getTableNumberOfPlayers(int position) throws Exception {
        if (this.type != MessageType.SEND_TABLES)
            throw new Exception("SEND_TABLES: Wrong type of message");
        
        String msg = message.substring(4*position+2, 4*position+3);
        return msg;
    }
    
    private int getIdFromMsg(String msg) {
        String idStr = msg.substring(0, 2);
        return Integer.parseInt(idStr);
    }
    
    private MessageType parseIntToMessageType(int number) {
        switch (number) {
            case 0: return MessageType.DISCONNECTED;
            case 1: return MessageType.NICKNAME;
            case 2: return MessageType.SEND_TABLES;
            case 3: return MessageType.CREATE_TABLE;
            case 4: return MessageType.JOIN_TABLE;
            case 5: return MessageType.CARDS;
            case 6: return MessageType.START_BID;
            case 7: return MessageType.GIVEN_BID;
            case 8: return MessageType.SEND_BID;
            case 9: return MessageType.BIDDING_RESULT;
            case 10: return MessageType.PLAY_CARD;
            case 11: return MessageType.GIVEN_CARD;
            case 12: return MessageType.SEND_CARD;       
            case 13: return MessageType.ROUND_OVER;       
            case 14: return MessageType.GAME_RESULT;     
            default: return MessageType.NONE;     
        }
    }
    
    private String parseMessageTypeToString(MessageType msgType) {
        switch (msgType) {
            case DISCONNECTED: return "00";
            case NICKNAME: return "01";
            case SEND_TABLES: return "02";
            case CREATE_TABLE: return "03";
            case JOIN_TABLE: return "04";
            case CARDS: return "05";
            case START_BID: return "06";
            case GIVEN_BID: return "07";
            case SEND_BID: return "08";
            case BIDDING_RESULT: return "09";
            case PLAY_CARD: return "10";
            case GIVEN_CARD: return "11";
            case SEND_CARD: return "12";
            case ROUND_OVER: return "13";
            case GAME_RESULT: return "14";
            default: return "xx";
        }
    }
}
