import java.util.ArrayList;
import java.util.Scanner;

public class Task5App {
    public static void main(String[] args) {

        ArrayList<Task5Book> library = new ArrayList<>();

        library.add(new Task5Book("10 years past", "D'Uma"));
        library.add(new Task5Book("Capitan's daughter", "Alexander Sergeyvich Pushkin"));
        library.add(new Task5Book("Shingeki no Kyojin", "Hajima Isayama"));
        library.add(new Task5Book("Lord of the ring", "Jonh Tolkin"));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Authors name: ");
        String inputAuthor = scanner.nextLine();

        System.out.println("Authors book " + inputAuthor + ":");

        boolean found = false;

        for (Task5Book book : library) {
            if (book.author.equalsIgnoreCase(inputAuthor)) {
                System.out.println(book.title);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Cannot find book.");
        }

        scanner.close();
    }
}