import java.util.Arrays;

public class User {

    private Message[] inbox;
    private int messageCount;
    
    public User() {
        inbox = new Message[20];
        messageCount = 0;
    }

    public String addMessage(Message msg) {
        if (messageCount >= 20) {
            return "Sorry, the inbox is full!";
        } else {
            inbox[messageCount++] = msg;
            return "Message is added!";
        }
    }

    public boolean sendMessage(Message msg) {
        User receiver = msg.getReceiver();
        if (receiver.addMessage(msg).equals("Message is added!")) {
            return true;
        } else {
            return false;
        }
    }

    public String readMessage() {
        if (messageCount == 0) {
            return "There is no message to read!";
        } else {
            String txt = inbox[0].getText();
            for (int i = 1; i < messageCount; i++) {
                inbox[i-1] = inbox[i]; 
            }
            messageCount--;
            return txt;
        }
    }

}
