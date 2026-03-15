import java.util.ArrayList;
import java.util.Random;


public class Task3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++){
            int num = random.nextInt(50) +1;
            numbers.add(num);
        }

        System.out.println("beofre changes");
        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println("after changes");
        System.out.println(numbers);


     }



}

