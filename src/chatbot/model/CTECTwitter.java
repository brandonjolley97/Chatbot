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
			chatbotTwitter.updateStatus(tweet + "@ChatbotCTEC");
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
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!;:\"(){}^[]<>-";
		
		String scrubbedString = "";
		
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		
		return scrubbedString;
		
	}
	
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			if(wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--;
			}
		}
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
			
		}
		
		removeTwitterUsernamesFromList(wordList);
		
		return wordList;
	}
	
	
	
	
	
	
	
	
}
