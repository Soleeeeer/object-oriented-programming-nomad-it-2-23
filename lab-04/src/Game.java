import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Game");
        setVisible(true);
    }

    public static void main(String[] args){
        new Game();
    }
}