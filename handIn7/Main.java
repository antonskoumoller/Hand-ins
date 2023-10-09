public class Main {
    public static void main(String[] args) {
        Pizza piz = new Pizza();
        // piz.addTopping("tomat");
        // piz.addTopping("bulse");
        // piz.addTopping("hund");

        Order ord = new Order();
        ord.addFood(piz);

        Food burger = new Food("Burger", 100);

        ord.addFood(burger);

        ord.display();


    }
}
