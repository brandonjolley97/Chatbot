package chatbot.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot Project
 * @author bjol7457
 *1.3 11/05/2015 Added Icons to popup windows!
 */

public class ChatView
{
	//declaring variables
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		//assigning values to variables
		windowMessage = "I am definitely not a robot! Hello!";
		chatIcon = new ImageIcon(getClass().getResource("images/porky.png"));
		
		
	}
	

	//creates a popup for the user to input text

	public String grabInput(String displayText)
	{
		String returnText = "";
		returnText = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here").toString();
		return returnText;
	}
	
	//generates a popup to respond to user input
	public void showResponse(String otherChatWords)
	{
		JOptionPane.showMessageDialog(null, otherChatWords);
	}
	
	
}
