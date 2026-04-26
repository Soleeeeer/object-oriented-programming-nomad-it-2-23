import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTracker extends JFrame {
    public MouseTracker() {
        setTitle("Tracking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                updateTitle(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                updateTitle(e);
            }

            private void updateTitle(MouseEvent e) {
                setTitle("Координаты — X: " + e.getX() + " Y: " + e.getY());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MouseTracker().setVisible(true);
        });
    }
}