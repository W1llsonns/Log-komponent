/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package C3;

/**
 *
 * @author Willsonowie
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Log extends JPanel implements Serializable {
    private JTextArea logArea;
    
    private String FontStyle;
    private String FontColour;
    private String FontSize;
    private String BgColour = "red";
    

    public Log() {
        setLayout(new BorderLayout());

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        //logArea.setBackground(Color.red);

        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ===== GETTER i SETTERY =====

    public String getLogText() {
        return logArea.getText();
    }

    public void setLogText(String text) {
        logArea.setText(text);
    }

    public void appendLog(String text) {
        logArea.append(text + "\n");
    }
    
    public void setFontSize() {
        
    }
    
    public void setFontColour() {
        
    }
    
    public void setFontStyle() {
        
    }
    
    public void setBgColour () {
        
    }
    
}
    

