import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyAdapter extends KeyAdapter {

    private final GameBoard gameBoard;
    private final GamePanel gamePanel;

    public CustomKeyAdapter(GameBoard gameBoard, GamePanel gamePanel) {
        this.gameBoard = gameBoard;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key pressed: " + keyCode);

        if (keyCode == KeyEvent.VK_RIGHT) {
            gameBoard.right();
            gamePanel.repaint();
            System.out.println("Right arrow");
        } else if (keyCode == KeyEvent.VK_LEFT) {
            gameBoard.left();
            gamePanel.repaint();
            System.out.println("Left arrow");
        } else if (keyCode == KeyEvent.VK_UP) {
            gameBoard.up();
            gamePanel.repaint();
            System.out.println("Up arrow");
        } else if (keyCode == KeyEvent.VK_DOWN) {
            gameBoard.down();
            gamePanel.repaint();
            System.out.println("Down arrow");
        }
    }
}