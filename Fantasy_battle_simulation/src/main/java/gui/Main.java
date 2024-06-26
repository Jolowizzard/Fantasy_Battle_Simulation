package gui;

import gui.GamePanel;

import javax.swing.JFrame;

/**
 * Creates Simulation Window
 */

public class Main{
    /**
     * Creates Simulation Window
     * @param args
     */
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Fantasy Battle Simulator");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
