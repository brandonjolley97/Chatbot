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
	private ChatView display;
	private ChatbotFrame baseFrame;
	private ChatModel simpleBot;
	
	public ChatController()
	{
		display = new ChatView();
		baseFrame = new ChatbotFrame(this);
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
		String nextConversation = display.grabInput("What would you like to talk about today?");
		while(simpleBot.lengthChecker(nextConversation))
		{
			nextConversation = simpleBot.processConversation(nextConversation);
			nextConversation = display.grabInput(nextConversation);
		}
	
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatModel getChatModel()
	{
		return simpleBot;
	}
	
	public ChatbotFrame getChatbotFrame()
	{
		return baseFrame;
	}
	
}
