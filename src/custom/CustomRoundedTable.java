package custom;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.geom.Path2D;
import java.beans.*;

public class CustomRoundedTable extends JTable {

    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;
    private Color borderColor;
    private Color backgroundColor;
    private Color headerBackgroundColor;
    private Color headerForegroundColor;
    private Color cellBackgroundColor;
    private Color cellForegroundColor;
    private int headerAlignment;
    private int cellAlignment;

    public CustomRoundedTable(DefaultTableModel model) {
        super(model);
        initTable();
    }

    public CustomRoundedTable() {
        super();
        initTable();
    }

    private void initTable() {
        // Initialize default values
        topLeftRadius = 0;
        topRightRadius = 0;
        bottomLeftRadius = 0;
        bottomRightRadius = 0;
        borderColor = Color.GRAY;
        backgroundColor = Color.WHITE;
        headerBackgroundColor = Color.LIGHT_GRAY;
        headerForegroundColor = Color.BLACK;
        cellBackgroundColor = Color.WHITE;
        cellForegroundColor = Color.BLACK;
        headerAlignment = SwingConstants.CENTER;
        cellAlignment = SwingConstants.LEFT;

        // Set custom header renderer
        getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());

        // Set custom cell renderer
        setDefaultRenderer(Object.class, new CustomCellRenderer());

        // Set opaque to false to handle background painting
        setOpaque(false);
        getTableHeader().setOpaque(false);
    }

    // Getter and Setter methods for properties

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

    public Color getHeaderBackgroundColor() {
        return headerBackgroundColor;
    }

    public void setHeaderBackgroundColor(Color headerBackgroundColor) {
        this.headerBackgroundColor = headerBackgroundColor;
        getTableHeader().repaint();
    }

    public Color getHeaderForegroundColor() {
        return headerForegroundColor;
    }

    public void setHeaderForegroundColor(Color headerForegroundColor) {
        this.headerForegroundColor = headerForegroundColor;
        getTableHeader().repaint();
    }

    public Color getCellBackgroundColor() {
        return cellBackgroundColor;
    }

    public void setCellBackgroundColor(Color cellBackgroundColor) {
        this.cellBackgroundColor = cellBackgroundColor;
        repaint();
    }

    public Color getCellForegroundColor() {
        return cellForegroundColor;
    }

    public void setCellForegroundColor(Color cellForegroundColor) {
        this.cellForegroundColor = cellForegroundColor;
        repaint();
    }

    public int getHeaderAlignment() {
        return headerAlignment;
    }

    public void setHeaderAlignment(int headerAlignment) {
        this.headerAlignment = headerAlignment;
        TableCellRenderer renderer = getTableHeader().getDefaultRenderer();
        if (renderer instanceof DefaultTableCellRenderer) {
            ((DefaultTableCellRenderer) renderer).setHorizontalAlignment(headerAlignment);
        }
        getTableHeader().repaint();
    }

    public int getCellAlignment() {
        return cellAlignment;
    }

    public void setCellAlignment(int cellAlignment) {
        this.cellAlignment = cellAlignment;
        setDefaultRenderer(Object.class, new CustomCellRenderer() {
            {
                setHorizontalAlignment(cellAlignment);
            }
        });
        repaint();
    }

    // Custom header renderer
    private class CustomHeaderRenderer extends DefaultTableCellRenderer {
        public CustomHeaderRenderer() {
            setHorizontalAlignment(headerAlignment); // Default to header alignment
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(headerBackgroundColor);
            c.setForeground(headerForegroundColor);
            return c;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(headerBackgroundColor);
            g2.fill(createRoundedRectangle(0, 0, getWidth(), getHeight()));

            g2.setColor(borderColor);
            g2.draw(createRoundedRectangle(0, 0, getWidth(), getHeight()));

            g2.dispose();
            super.paintComponent(g);
        }
    }

    // Custom cell renderer
    private class CustomCellRenderer extends DefaultTableCellRenderer {
        public CustomCellRenderer() {
            setHorizontalAlignment(cellAlignment); // Default to cell alignment
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            } else {
                c.setBackground(cellBackgroundColor);
                c.setForeground(cellForegroundColor);
            }
            return c;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(backgroundColor);
        g2.fill(createRoundedRectangle(0, 0, getWidth(), getHeight()));

        g2.setColor(borderColor);
        g2.draw(createRoundedRectangle(0, 0, getWidth(), getHeight()));

        g2.dispose();
        super.paintComponent(g);
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
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Rounded Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            DefaultTableModel model = new DefaultTableModel(new Object[]{"Column 1", "Column 2", "Column 3"}, 0);
            model.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
            model.addRow(new Object[]{"Data 4", "Data 5", "Data 6"});
            model.addRow(new Object[]{"Data 7", "Data 8", "Data 9"});

            CustomRoundedTable table = new CustomRoundedTable(model);

            // Set custom alignments
            table.setHeaderAlignment(SwingConstants.CENTER);
            table.setCellAlignment(SwingConstants.RIGHT);

            // Set custom colors
            table.setHeaderBackgroundColor(Color.LIGHT_GRAY);
            table.setHeaderForegroundColor(Color.BLACK);
            table.setCellBackgroundColor(Color.WHITE);
            table.setCellForegroundColor(Color.BLACK);

            // Set border radius
            table.setTopLeftRadius(15);
            table.setTopRightRadius(15);
            table.setBottomLeftRadius(15);
            table.setBottomRightRadius(15);
            table.setBorderColor(Color.GRAY);
            table.setBackgroundColor(Color.WHITE);

            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
