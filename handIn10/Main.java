public class Main {
    public static void main(String[] args) {
        RejseKort rejs = new RejseKort();
        rejs.checkIn(0, 0, 20);
        System.out.println(rejs.isCheckedIn(140));;
    }
}
