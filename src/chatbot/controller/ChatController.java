package chatbot.controller;

import chatbot.view.ChatView;
import chatbot.model.ChatModel;
/**
 * Application Controller for the Chatbot Project
 * @author bjol7457
 * @version 1.11 10/21/15 fixed error
 */

public class ChatController
{
	private ChatView display;
	private ChatModel simpleBot;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.grabInput("What is your name?");
		simpleBot =  new ChatModel(user);
	}
	
	
	public void start()
	{
		display.showResponse("Hello " + simpleBot.getUserName());
		chat();
	}
	
	public void chat()
	{
		String conversation = display.grabInput("What would you like to talk about today?");
		while(simpleBot.lengthChecker(conversation))
		{
			conversation = simpleBot.processConversation(conversation);
			conversation = display.grabInput(conversation);
		}
	}
	
	
	
	
	
	
}
