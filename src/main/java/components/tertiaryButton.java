package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class tertiaryButton extends JButton {

    public tertiaryButton() {
        
        // Initial definitions:
        setFocusable(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Colors:
        Color DefaultColor = new Color(34, 68, 17);
        Color HoverColor = new Color(57, 114, 29);
        Color PressedColor = new Color(74, 146, 38);

        // Colors definitions:
        setForeground(DefaultColor);

        // Mouse Events:
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(HoverColor);
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(DefaultColor);
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(PressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               if(over){
                   setForeground(HoverColor);
               } else {
                   setForeground(DefaultColor);
               }
            }
        });
    }
    
    private boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }
}
