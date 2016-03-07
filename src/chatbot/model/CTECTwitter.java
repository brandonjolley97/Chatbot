package chatbot.model;

/**
 * @version 0.3
 * @author brandon jolley
 *
 */

import twitter4j.*;
import java.util.ArrayList;
import chatbot.controller.ChatController;

public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
		this.baseController = baseController;
	}
	
	public void sendTweet(String tweet)
	{
		
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}	
	
	public String topResults(ArrayList<String> wordList)
	{
		String top = "top";
		return top;
	}
}
