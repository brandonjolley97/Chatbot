package chatbot.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

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
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 23, SpringLayout.SOUTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 38, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -132, SpringLayout.EAST, this);
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
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
					String userText = typingField.getText(); //Grab user typed answer.
					chatArea.append("\nUser: " + userText); //Display typed answer.
					typingField.setText(""); 
					String response = baseController.userToChatbot(userText); //Send the text to chatbot. Chatbot will process.
					chatArea.append("\nChatbot: " + response); //Display the response.
			}
		});
	}
	
	public JTextField getJTextField()
	{
		return typingField;
	}
	
	
	
}
