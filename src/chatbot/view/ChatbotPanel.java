package chatbot.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;

import chatbot.controller.ChatController;

public class ChatbotPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextField typingField;
	private JLabel promptLabel;
	private JTextArea chatArea;
	
	
	public ChatbotPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		submitButton = new JButton("Please don't click me!");
		typingField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		chatArea = new JTextArea(10,30);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
		
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot.");
		chatArea.setEnabled(false);
	}
	
	public void changeRandomColor()
	{
		
	}
	
	public void setupListeners()
	{
		
	}
	
	public JTextField getJTextField()
	{
		return typingField;
	}
	
	
	
}
