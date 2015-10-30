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
		String user = display.collectUserText("What is your name?");
		simpleBot =  new Chatbot(user);
	}
	
	
	public void start()
	{
		display.displayText("Hello " + simpleBot.getUserName());
		chat();
	}
	
	public void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		while(simpleBot.lengthChecker(conversation))
		{
			if(simpleBot.contentChecker(conversation))
			{
				display.displayText("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			else if(simpleBot.memeChecker(conversation))
			{
				display.displayText("what a lame meme :(");
			}
			
			conversation = display.collectUserText(conversation);
		}
	}
	
	private void shutDown()
	{
		
		

		
		
		
		
	} 
	
	
	
	
	
	
}
