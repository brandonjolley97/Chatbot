package chatbot.controller;

import chatbot.view.ChatView;
import chatbot.model.CTECTwitter;
import chatbot.view.ChatbotFrame;
import chatbot.model.ChatModel;

/**
 * Application Controller for the Chatbot Project
 * @author bjol7457
 * @version 1.11 10/21/15 fixed error
 */

public class ChatController
{
	private CTECTwitter chatTwitter;
	private ChatView display;
	private ChatbotFrame baseFrame;
	private ChatModel simpleBot;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.grabInput("What is your name?");
		simpleBot =  new ChatModel(user);
		baseFrame = new ChatbotFrame(this);
		chatTwitter = new CTECTwitter(this);
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
	
	private void shutDown()
	{
		display.showResponse("Goodbye, " + simpleBot.getUserName() + " it has been my pleasure to talk with you!");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	
	public void handleErrors(String errorMessage)
	{
		display.showResponse(errorMessage);
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatModel getChatModel()
	{
		return simpleBot;
	}
	
	public ChatbotFrame getBaseFrame()
	{
		return baseFrame;
	}
	
}
