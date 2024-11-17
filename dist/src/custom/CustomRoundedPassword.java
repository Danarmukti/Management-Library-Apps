package custom;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.beans.*;

public class CustomRoundedPassword extends JPasswordField {

    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;
    private Color borderColor;
    private Color backgroundColor;

    public CustomRoundedPassword() {
        super();
        initField();
    }

    private void initField() {
        topLeftRadius = 0;
        topRightRadius = 0;
        bottomLeftRadius = 0;
        bottomRightRadius = 0;
        borderColor = Color.GRAY;
        backgroundColor = Color.WHITE;

        setOpaque(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
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

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2.setColor(backgroundColor);
        g2.fill(createRoundedRectangle(0, 0, getWidth(), getHeight()));

        // Draw border
        g2.setColor(borderColor);
        g2.draw(createRoundedRectangle(0, 0, getWidth(), getHeight()));

        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundedRectangle(int x, int y, int width, int height) {
        RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double(
                x, y, width - 1, height - 1,
                Math.max(topLeftRadius, topRightRadius),
                Math.max(bottomLeftRadius, bottomRightRadius)
        );
        return roundRect;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Rounded Password Field Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            CustomRoundedPassword passwordField = new CustomRoundedPassword();
            passwordField.setTopLeftRadius(15);
            passwordField.setTopRightRadius(15);
            passwordField.setBottomLeftRadius(15);
            passwordField.setBottomRightRadius(15);
            passwordField.setBorderColor(Color.GRAY);
            passwordField.setBackgroundColor(Color.WHITE);

            frame.add(passwordField, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
