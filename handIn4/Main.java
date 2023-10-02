public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        Message msg1 = new Message(user1,"Hello 1");
        Message msg2 = new Message(user1,"Hello 2");
        System.out.println(user1.sendMessage(msg1));
        System.out.println(user1.sendMessage(msg2));
        System.out.println(user1.readMessage());
        System.out.println(user1.readMessage());







    }
}
