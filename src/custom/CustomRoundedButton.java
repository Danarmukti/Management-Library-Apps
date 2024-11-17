package custom;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomRoundedButton extends JButton {

    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    public CustomRoundedButton(String text) {
        super(text);
        initButton();
    }

    public CustomRoundedButton() {
        super();
        initButton();
    }

    private void initButton() {
        // Inisialisasi nilai default
        topLeftRadius = 0;
        topRightRadius = 0;
        bottomLeftRadius = 0;
        bottomRightRadius = 0;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    public int getTopLeftRadius() {
        return topLeftRadius;
    }

    public void setTopLeftRadius(int topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
        repaint();
    }

    public int getTopRightRadius() {
        return topRightRadius;
    }

    public void setTopRightRadius(int topRightRadius) {
        this.topRightRadius = topRightRadius;
        repaint();
    }

    public int getBottomLeftRadius() {
        return bottomLeftRadius;
    }

    public void setBottomLeftRadius(int bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
        repaint();
    }

    public int getBottomRightRadius() {
        return bottomRightRadius;
    }

    public void setBottomRightRadius(int bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded rectangle background
        g2.setColor(getBackground());
        g2.fill(createRoundedRectangle(getWidth(), getHeight()));

        // Draw the button text
        FontMetrics fm = g2.getFontMetrics();
        Rectangle r = getBounds();
        int x = (r.width - fm.stringWidth(getText())) / 2;
        int y = (r.height - fm.getHeight()) / 2 + fm.getAscent();
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);

        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundedRectangle(int width, int height) {
        int[] radii = {topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius};

        int[] xPoints = {0, width - radii[1], width - radii[2], radii[3]};
        int[] yPoints = {radii[0], radii[1], height - radii[2], height - radii[3]};

        RoundRectangle2D.Float roundedRect = new RoundRectangle2D.Float();
        roundedRect.setRoundRect(0, 0, width, height, radii[0] * 2, radii[1] * 2);

        Polygon p = new Polygon();
        for (int i = 0; i < 4; i++) {
            p.addPoint(xPoints[i], yPoints[i]);
        }
        return roundedRect;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Rounded Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        CustomRoundedButton button = new CustomRoundedButton("Click Me!");
        button.setTopLeftRadius(30);
        button.setTopRightRadius(15);
        button.setBottomLeftRadius(15);
        button.setBottomRightRadius(30);
        button.setBackground(Color.CYAN);
        button.setForeground(Color.BLACK);

        frame.add(button);
        frame.setVisible(true);
    }
}
