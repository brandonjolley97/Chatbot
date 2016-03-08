package chatbot.view;

import javax.swing.JPanel;
import javax.swing.*;
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
	
	//declaring variables
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextField typingField;
	private JLabel promptLabel;
	private JTextArea chatArea;
	private JScrollPane textPane;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton loadButton;
	
	
	public ChatbotPanel(ChatController baseController)
	{
		//giving value to the variables
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		submitButton =new JButton("Please don't click me!");
		typingField = new JTextField(30);
		promptLabel = new JLabel("I am not a robot!");
		chatArea = new JTextArea(10,30);
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		tweetButton = new JButton("Tweet");
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
	}
	
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
	}
	
	//dumping area for all the code generated from the design editor
	public void setupLayout()
	{	
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 275, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -250, SpringLayout.EAST, this);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 210, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 275, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -102, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -75, SpringLayout.EAST, this);
	}
	
	//initializes all components into the panel
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(textPane);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		this.add(tweetButton);
		typingField.setToolTipText("Type here for the chatbot."); //prompt for the typing field
		chatArea.setEnabled(false); //disables typing and other alterations to the chat area
	}
	
	
	public void changeRandomColor()
	{
		
	}
	
	//setup various components to react to user input
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
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});
	}
	
	//getter for typing field
	public JTextField getJTextField()
	{
		return typingField;
	}
	
	
	
}
