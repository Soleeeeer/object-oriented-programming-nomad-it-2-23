import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList();
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter grade(neg num = end)");

        while(true){
            int grade=scanner.nextInt();
            if (grade < 0) {
                break;
            }
            grades.add(grade);
        }
        if (grades.isEmpty()) {
            System.out.println("No grades found");
            return;
        }
        int sum=0;
        for (int grade : grades) {
            sum += grade;
        }
        double average=(double) sum/grades.size();
        System.out.println("Average grade is "+average);

        int max = grades.get(0);

        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        System.out.println("Maximum grade is "+max);
        scanner.close();


    }
}
