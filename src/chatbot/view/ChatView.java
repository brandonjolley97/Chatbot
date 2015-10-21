package chatbot.view;

import javax.swing.JOptionPane;

public class ChatView
{
	public void showResponse(String otherChatWords)
	{
		JOptionPane.showMessageDialog(null, otherChatWords);
	}
	
	public String grabInput(String displayText)
	{
		String returnText = "";
		returnText = JOptionPane.showInputDialog(null, displayText);
		return returnText;
	}
}
