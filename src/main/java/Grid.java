import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class Grid extends JPanel implements MouseListener {
    List<Component> components = new ArrayList<>();
    TicTacToe game = new TicTacToe();

    public Grid(int row, int col, int hgap, int vgap) {
        super(new GridLayout(row, col, hgap, vgap));
        int GRID_COUNT = 9;
        for (int i = 0; i < GRID_COUNT; i++) {
            Canvas canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(200, 200));
            canvas.setFocusable(true);
            canvas.addMouseListener(this);
            canvas.setBackground(Color.GREEN);
            this.add(canvas);

        }
        Collections.addAll(components, this.getComponents());
        this.setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Component component = mouseEvent.getComponent();
        if (!this.components.contains(component)) {
            return;
        }
        int index = Arrays.asList(this.getComponents()).indexOf(component);
        game.score(TicTacToe.Player.HUMAN, index);
        this.components.remove(component);
        component.setBackground(Color.RED);
        if (this.game.hasWon(TicTacToe.Player.HUMAN)) {
            System.out.println("You Won!");
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (this.components.isEmpty()) {
            return;
        }
        Component newComponent = this.components.get(new Random().nextInt(this.components.size()));
        int newIndex = Arrays.asList(this.getComponents()).indexOf(newComponent);
        game.score(TicTacToe.Player.COMPUTER, newIndex);
        this.components.remove(newComponent);
        newComponent.setBackground(Color.CYAN);
        if (this.game.hasWon(TicTacToe.Player.COMPUTER)) {
            System.out.println("Computer Won!");
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private static class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked on Grid");
        }
    }
}
