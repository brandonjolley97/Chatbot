package chatbot.model;

/**
 * @version 0.1
 * @author brandon jolley
 *
 */

import twitter4j.*;
import java.util.ArrayList;

public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet()
	{
		String tweet;
		
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
}
