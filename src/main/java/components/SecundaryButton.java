package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class SecundaryButton extends JButton {

    /**
     * @return the over
     */
    public boolean isOver() {
        return over;
    }

    /**
     * @param over the over to set
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * @return the borderSize
     */
    public int getBorderSize() {
        return borderSize;
    }

    /**
     * @param borderSize the borderSize to set
     */
    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    /**
     * @return the borderRadius
     */
    public int getBorderRadius() {
        return borderRadius;
    }

    /**
     * @param borderRadius the borderRadius to set
     */
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    /**
     * @return the backgroundColor
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the borderColor
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor the borderColor to set
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * @return the borderHover
     */
    public Color getBorderHover() {
        return borderHover;
    }

    /**
     * @param borderHover the borderHover to set
     */
    public void setBorderHover(Color borderHover) {
        this.borderHover = borderHover;
    }

    public SecundaryButton() {
        
        Color backgroundColor = new Color(255, 255, 255);
        setBackground(backgroundColor);
        Color color = new Color(34, 68, 17);
        borderHover = new Color(57, 114, 29);
        setForeground(borderColor);


        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusable(false);
        setBorderPainted(false);

        // Mouse Events:
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorderColor(borderHover);
                setForeground(borderColor);
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorderColor(color);
                setForeground(borderColor);
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(245,245,245));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(backgroundColor);
            }
        });
    }
    
    private boolean over;
    private int borderSize = 2;
    private int borderRadius = 8;
    private Color backgroundColor;
    private Color borderColor;
    private Color borderHover;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBorderColor());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getBorderRadius(), getBorderRadius());
        g2.setColor(getBackground());

        g2.fillRoundRect(getBorderSize(), getBorderSize(), getWidth() - getBorderSize() * 2, getHeight() - getBorderSize() * 2, getBorderRadius(), getBorderRadius());

        super.paintComponent(g);
    }

}
