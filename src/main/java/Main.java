import javax.swing.*;
import java.util.Arrays;

import static javax.swing.SwingUtilities.*;

public class Main {
    public static void main(String[] args) {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        invokeLater(new Runnable() {
            public void run() {
                setUpFrame();
            }
        });

    }

    private static void setUpFrame() {
        JFrame frame = new JFrame("TIC TAC TOE!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JComponent contentPane = new Grid(3, 3, 2, 2);
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
