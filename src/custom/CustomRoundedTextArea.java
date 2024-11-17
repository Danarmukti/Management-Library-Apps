package custom;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.text.Document;

public class CustomRoundedTextArea extends JTextArea {

    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;
    private Color backgroundColor;
    private Color borderColor;
    private Color focusedBorderColor;

    public CustomRoundedTextArea(int rows, int columns) {
        super(rows, columns);
        initTextArea();
    }

    public CustomRoundedTextArea() {
        super();
        initTextArea();
    }

    private void initTextArea() {
        // Inisialisasi nilai default
        topLeftRadius = 0;
        topRightRadius = 0;
        bottomLeftRadius = 0;
        bottomRightRadius = 0;
        backgroundColor = Color.WHITE;
        borderColor = Color.GRAY;
        focusedBorderColor = Color.BLUE;

        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Tambahkan event listener
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Mouse clicked on text area");
//            }
//        });

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                borderColor = focusedBorderColor;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                borderColor = Color.GRAY;
                repaint();
            }
        });

//        getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                onTextChange();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                onTextChange();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                onTextChange();
//            }
//        });
    }

//    private void onTextChange() {
//        System.out.println("Text changed to: " + getText());
//    }

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

    public Color getFocusedBorderColor() {
        return focusedBorderColor;
    }

    public void setFocusedBorderColor(Color focusedBorderColor) {
        this.focusedBorderColor = focusedBorderColor;
    }
    


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded rectangle background
        g2.setColor(backgroundColor);
        g2.fill(createRoundedRectangle(1, 1, getWidth() - 2, getHeight() - 2));

        // Draw the border
        g2.setColor(borderColor);
        g2.draw(createRoundedRectangle(1, 1, getWidth() - 2, getHeight() - 2));

        g2.dispose();
        // Draw text after the custom painting
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Override to do nothing to avoid double border painting
    }

    private Shape createRoundedRectangle(int x, int y, int width, int height) {
        Path2D path = new Path2D.Float();
        path.moveTo(x + topLeftRadius, y);
        path.lineTo(x + width - topRightRadius, y);
        path.quadTo(x + width, y, x + width, y + topRightRadius);
        path.lineTo(x + width, y + height - bottomRightRadius);
        path.quadTo(x + width, y + height, x + width - bottomRightRadius, y + height);
        path.lineTo(x + bottomLeftRadius, y + height);
        path.quadTo(x, y + height, x, y + height - bottomLeftRadius);
        path.lineTo(x, y + topLeftRadius);
        path.quadTo(x, y, x + topLeftRadius, y);
        path.closePath();
        return path;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Rounded TextArea Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        CustomRoundedTextArea textArea = new CustomRoundedTextArea(10, 30);
        textArea.setTopLeftRadius(15);
        textArea.setTopRightRadius(15);
        textArea.setBottomLeftRadius(15);
        textArea.setBottomRightRadius(15);
        textArea.setBackgroundColor(Color.CYAN);
        textArea.setBorderColor(Color.GRAY);
        textArea.setFocusedBorderColor(Color.BLUE);

        frame.add(new JTextArea((Document) textArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
