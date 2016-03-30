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

import chatbot.controller.IOController;
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
	private JButton analyzeTwitterButton;
	
	
	public ChatbotPanel(ChatController baseController)
	{
		//giving value to the variables
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		submitButton =new JButton("Submit");
		typingField = new JTextField(30);
		promptLabel = new JLabel("I am not a robot!");
		chatArea = new JTextArea(10,30);
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		tweetButton = new JButton("Tweet");
		analyzeTwitterButton = new JButton("Analyze");
		
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
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 6, SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 0, SpringLayout.WEST, textPane);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, textPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, analyzeTwitterButton, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, 0, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 85, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, this);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -102, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -75, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 186, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -6, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -89, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -6, SpringLayout.NORTH, loadButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -6, SpringLayout.NORTH, saveButton);
	}
	
	//initializes all components into the panel
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(textPane);
		this.add(typingField);
		this.add(saveButton);
		this.add(loadButton);
		this.add(analyzeTwitterButton);
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
		
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = typingField.getText();
				String results = baseController.analyze(user);
				chatArea.setText(results);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(chatArea.getText());
				promptLabel.setText(file);
					
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
					String loadedText = IOController.readTextFromFile(promptLabel.getText());
					chatArea.setText(loadedText);
					
			}
		});
	}
	
	//getter for typing field
	public JTextField getJTextField()
	{
		return typingField;
	}
	
	
	
}
