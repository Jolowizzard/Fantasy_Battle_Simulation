package gui;

import javax.swing.*;
import java.awt.*;

public class LogWindow extends JFrame {
    private JTextArea textArea;

    public LogWindow() {
        setTitle("Simulation Log");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendLog(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength()); // Scroll to the bottom
    }
}