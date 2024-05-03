package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IconTextField extends JTextField {

    private boolean over;

    public IconTextField() throws HeadlessException {
        setBorder(new EmptyBorder(10, 7, 10, 3));
        setSelectionColor(new Color(90, 178, 46));
        setSelectedTextColor(new Color(255, 255, 255));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                over = true;
                repaint();

                setForeground(new Color(34, 34, 34));
                setBackground(new Color(243, 243, 243));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                over = false;
                repaint();

                setForeground(new Color(104, 104, 104));
                setBackground(new Color(247, 247, 247));
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);

        if (over) {
            g2.setColor(new Color(34, 68, 17));
        } else {
            g2.setColor(new Color(154, 154, 154));
        }

        g2.fillRect(0, getHeight() - 1, getWidth(), 1);
        g2.dispose();
    }

    // Icon code:
    private Icon sufixIcon;

    /**
     * @return the sufixIcon
     */
    public Icon getSufixIcon() {
        return sufixIcon;
    }

    /**
     * @param sufixIcon the sufixIcon to set
     */
    public void setSufixIcon(Icon sufixIcon) {
        this.sufixIcon = sufixIcon;
        initBorder();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (sufixIcon != null) {
            Image sufix = ((ImageIcon) sufixIcon).getImage();
            int y = (getHeight() - sufixIcon.getIconHeight()) / 2;
            g2.drawImage(sufix, getWidth() - sufixIcon.getIconWidth() - 10, y, this);
        }
    }

    private void initBorder() {
        int left = 7;
        int right = 3;

        if (sufixIcon != null) {
            right = sufixIcon.getIconWidth() + 3;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, left, 10, right));
    }

}
