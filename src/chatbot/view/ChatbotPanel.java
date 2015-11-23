package chatbot.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatController;

public class ChatbotPanel extends JPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
	public ChatbotPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		firstButton = new JButton("Please don't click me!");
		firstTextField = new JTextField("I have words....");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
		
	}
	
	public void setupPanel()
	{
		
	}
	
	public void setupLayout()
	{
		
	}
	
	public void changeRandomColor()
	{
		
	}
	
	public void setupListeners()
	{
		
	}
	
	
	
	
}
