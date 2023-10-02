import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees;
    
    
    public Forest() {
        trees = new ArrayList<>();

    }

    public void addTree(int growthRate) {
        Tree tree = new Tree(growthRate);
        trees.add(tree);

    }

    public String toString() {
        String returnString = "Forest("; 
        int i = 0;
        while (i < trees.size()) {
            returnString = returnString + trees.get(i).toString();
            i++;
        }
        return returnString + ")";  
    }

    public void growOneYear() {
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).growOneYear();
        }
    }
}
