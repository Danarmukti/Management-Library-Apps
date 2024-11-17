package custom;
import javax.swing.*;
import java.awt.*;
import java.beans.*;

public class RoundedPanel extends JPanel implements java.io.Serializable {

    private Color backgroundColor;
    private Color borderColor;
    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;
    private int borderThickness;

    public RoundedPanel() {
        this.topLeftRadius = 15;
        this.topRightRadius = 15;
        this.bottomLeftRadius = 15;
        this.bottomRightRadius = 15;
        this.borderThickness = 1;
        this.backgroundColor = Color.WHITE;
        this.borderColor = Color.BLACK;
        setOpaque(false); // Untuk memastikan background diatur oleh paintComponent
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
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

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;

        // Antialiasing untuk tepi yang lebih halus
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Menggambar background
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, topLeftRadius, topLeftRadius);
        
        // Menggambar border
        if (borderThickness > 0 && borderColor != null) {
            graphics.setColor(borderColor);
            graphics.setStroke(new BasicStroke(borderThickness));
            graphics.drawRoundRect(0, 0, width - 1, height - 1, topLeftRadius, topLeftRadius);
        }
    }

    // Property descriptors untuk properti JavaBeans
    public static class RoundedPanelBeanInfo extends SimpleBeanInfo {
        @Override
        public PropertyDescriptor[] getPropertyDescriptors() {
            try {
                PropertyDescriptor backgroundColor = new PropertyDescriptor("backgroundColor", RoundedPanel.class);
                PropertyDescriptor borderColor = new PropertyDescriptor("borderColor", RoundedPanel.class);
                PropertyDescriptor topLeftRadius = new PropertyDescriptor("topLeftRadius", RoundedPanel.class);
                PropertyDescriptor topRightRadius = new PropertyDescriptor("topRightRadius", RoundedPanel.class);
                PropertyDescriptor bottomLeftRadius = new PropertyDescriptor("bottomLeftRadius", RoundedPanel.class);
                PropertyDescriptor bottomRightRadius = new PropertyDescriptor("bottomRightRadius", RoundedPanel.class);
                PropertyDescriptor borderThickness = new PropertyDescriptor("borderThickness", RoundedPanel.class);
                return new PropertyDescriptor[]{backgroundColor, borderColor, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius, borderThickness};
            } catch (IntrospectionException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Custom Rounded Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Membuat custom rounded panel
        RoundedPanel customPanel = new RoundedPanel();
        customPanel.setTopLeftRadius(30);
        customPanel.setTopRightRadius(10);
        customPanel.setBottomLeftRadius(20);
        customPanel.setBottomRightRadius(40);
        customPanel.setBorderThickness(5);
        customPanel.setBackgroundColor(Color.CYAN);
        customPanel.setBorderColor(Color.BLUE);
        customPanel.setLayout(new FlowLayout());

        // Menambahkan komponen ke dalam custom panel
        customPanel.add(new JLabel("This is a custom rounded panel"));
        customPanel.add(new JButton("Button"));

        // Menambahkan custom panel ke dalam frame
        frame.add(customPanel);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
