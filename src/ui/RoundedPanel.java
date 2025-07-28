/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;


public class RoundedPanel extends JPanel {
    private int cornerRadius = 30;

    public RoundedPanel() {
        setOpaque(false); // Important for transparency
    }

    public RoundedPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color transparentDark = new Color(0, 0, 0, 120); // Match your existing overlay
        g2.setColor(transparentDark);
        g2.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
    }
}
