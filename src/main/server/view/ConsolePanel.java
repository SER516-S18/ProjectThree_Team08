package main.server.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Class for creating controls for console panel.
 * @author Akash Sharma
 * @author Aayushi Shah
 * @version 1.0
 */

public class ConsolePanel extends JPanel{

    JButton btnClearLog;
    private final static Logger LOGGER = Logger.getLogger(
            ConsolePanel.class.getName());
    private static JTextPane consoleTextPane = null;

    /**
	 * Sets the layout of messages
     *
	 * @param message message to be set on the console
	 */
	public static void setMessage(String message) {

		try
		{
			consoleTextPane.setContentType("text/html");
			StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
			SimpleAttributeSet keyWord = new SimpleAttributeSet();
			StyleConstants.setForeground(keyWord, Color.RED);
			StyleConstants.setFontFamily(keyWord, "Times New Roman");
			StyleConstants.setFontSize(keyWord, 13);

			doc.insertString(0,new Date()+"Message: "+message +"\n",keyWord );
		}
		catch(Exception ex) 
		{ 
			LOGGER.log(Level.SEVERE,"Exception while adding Error Message.", ex); 
		}

	}
    
    public ConsolePanel() {
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "EmoEngine Log",
                TitledBorder.LEADING,
                        TitledBorder.TOP, new Font("Tahoma", Font.BOLD,
                12), Color.BLACK));
        this.setBounds(11, 408, 474, 152);
        this.setLayout(null);
        
        
        btnClearLog = new JButton("Clear Log");
        btnClearLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                consoleTextPane.setText("");
            }
        });
        btnClearLog.setBounds(140, 119, 171, 25);
        btnClearLog.setForeground(Color.WHITE);
        btnClearLog.setBackground(Color.BLACK);
        btnClearLog.setContentAreaFilled(false);
        btnClearLog.setOpaque(true);
        this.add(btnClearLog);
        
        consoleTextPane = new JTextPane();
        consoleTextPane.setEditable(false);
        consoleTextPane.setForeground(Color.WHITE);
        consoleTextPane.setBackground(Color.DARK_GRAY);
        consoleTextPane.setBounds(10, 26, 454, 86);
        this.add(consoleTextPane);
    }
}
