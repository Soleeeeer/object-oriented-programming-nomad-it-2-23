import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Buy milk");
        tasks.add("Wash Car");
        tasks.add("Learn Java");

        System.out.println("Size of list: " + tasks.size());
        tasks.remove(1);
        tasks.set(0,"Buy another milk");

        System.out.println("Final task list");
        for (String task: tasks){
            System.out.println(task);
        }
    }
}
