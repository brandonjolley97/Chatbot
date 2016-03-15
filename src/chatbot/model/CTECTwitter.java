package chatbot.model;

/**
 * @version 0.3
 * @author brandon jolley
 *
 */

import twitter4j.*;
import java.io.*;
import java.util.*;

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
	
	/**
	 * Reads the commonWords.txt file and imports the supplied words to a String
	 * @return
	 */
	private String[] importWordsToArray()
	{
		
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		}
		catch(FileNotFoundException e)
		{
			baseController.handleErrors(e.getMessage());
			return new String[0];
		}
		return boringWords;
		
		
	}
	
	private void removeTwitterUsernamesFromList(List<String> wordList)
	{
		
	}
	
	/**
	 * Creates the statistics about tweets
	 * @return
	 */
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for( int spot = index + 1; spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(spot)))
				{
					wordUseCount++;
				}
				
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweets was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times!";
		return tweetResults;
	}
	
	
	
	
}
