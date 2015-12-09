package chatbot.controller;

import chatbot.view.ChatView;


import chatbot.view.ChatbotFrame;
import chatbot.model.ChatModel;

/**
 * Application Controller for the Chatbot Project
 * @author bjol7457
 * @version 1.11 10/21/15 fixed error
 */

public class ChatController
{
	//declaring variables
	private ChatView display;
	private ChatbotFrame baseFrame;
	private ChatModel simpleBot;
	
	//assigning values to variables
	public ChatController()
	{
		display = new ChatView();
		String user = display.grabInput("What is your name?");
		simpleBot =  new ChatModel(user);
		baseFrame = new ChatbotFrame(this);
	}
	
	//start method which initializes conversation with user after user inputs name
	public void start()
	{
		display.showResponse("Hello " + simpleBot.getUserName());
		//chat();
	}
	
	//prompts response from user to check for conversation topics in array lists
	public void chat()
	{
		String nextConversation = display.grabInput("What would you like to talk about today?");
		while(simpleBot.lengthChecker(nextConversation))
		{
			nextConversation = simpleBot.processConversation(nextConversation);
			nextConversation = display.grabInput(nextConversation);
		}
	
	}
	
	//boolean quitChecker to see if the program quits.  if it does, it calls the shutDown method
	public String userToChatbot(String nextConversation)
	{
		String response = "";
		
		if(simpleBot.quitChecker(nextConversation))
		{
			shutDown();
		}
		
		response = simpleBot.processConversation(nextConversation);
		
		return response;
	}
	
	//displays a message if program quits
	private void shutDown()
	{
		display.showResponse("Goodbye, " + simpleBot.getUserName() + " it has been my pleasure to talk with you!");
		System.exit(0);
	}
	
	//getter for chatView
	public ChatView getChatView()
	{
		return display;
	}
	
	//getter for chatModel
	public ChatModel getChatModel()
	{
		return simpleBot;
	}
	
	//getter for baseFrame
	public ChatbotFrame getBaseFrame()
	{
		return baseFrame;
	}
	
}
