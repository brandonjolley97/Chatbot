package chatbot.model;

import java.util.ArrayList;



/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Brandon Jolley
 * @version 1.0 10/21/15
 */
public class ChatModel
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private int topic;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public ChatModel(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Mexican";
		topic = 0;
		
		buildMemesList();
		buildPoliticalTopicsList();
		
	}
	
	//builds an array list of meme topics
	private void buildMemesList()
	{
		
		this.memesList.add("doge");
		this.memesList.add("Y U NO!");
		this.memesList.add("Bad luck Brian");
		this.memesList.add("cute animals");
		this.memesList.add("hashtag");
		this.memesList.add("deez");
		this.memesList.add("Do it!");
		this.memesList.add("U Mad Bro");
		this.memesList.add("Shia Lebouf");
		this.memesList.add("John Cena!");
		
	}
	
	//builds an array list of political topics
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("election");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		//Alternate method if statement: compound if that utilizes &&
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content))
		{
			hasContent = true;
		}
		return hasContent;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean mashTyping = false;
		
		if(currentInput.equals("sdf") || currentInput.equals("dfg") || currentInput.equals("cvb") || currentInput.equals(",./"))
		{
			mashTyping = true;
		}
		
		return mashTyping;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean didQuit = false;
		
		if(currentInput.equals("quit"))
		{
			didQuit = true;
		}
		
		return didQuit;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopic = false;
		
		for(int politicalCount = 0; politicalCount < politicalTopicList.size(); politicalCount++)
		{
			if(currentInput.toLowerCase().contains(politicalTopicList.get(politicalCount).toLowerCase()))
			{
				hasPoliticalTopic = true;
			}
		
		}
		
		return hasPoliticalTopic;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	
	//checks for keywords in various array lists in order to return conversation
	public String processConversation(String currentInput)
	{
		String nextConversation = "";
		
		if(keyboardMashChecker(currentInput))
		{
			return "stop mashing the keyboard!!!";
		}
		
		switch (topic)
		{
			case 0:
				if(memeChecker(currentInput))
				{
					nextConversation = "That is a very popular meme this year.  What else are you wanting to talk about?";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = "Trump is an interesting candidate, and so is Hillary Clinton....  But I'm not human, so I can't vote.";
				}
				else
				{
					nextConversation = "No Politics?";
				}
				break;
			case 2:
				if(contentChecker(currentInput))
				{
					nextConversation = "I love Mexican food too!  Let's go get some sometime.  What else would you like to talk about?";
				}
				break;
			case 3:
				if(currentInput.length() > 20)
				{
					nextConversation = "What do you mean by that?  Try to simplify your question or statement.";
				}
				break;
			case 4:
				nextConversation = "Why don't we go to a different topic?  I feel uncomfortable discussing that...";
				break;
			default:
				nextConversation = "The universe just collapsed.....";
				topic = 0;
				break;
		}			
		
		topic++;
		return nextConversation;
	}
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	//updates the memesList for this Chatbot instance
	public void setMemesList(ArrayList <String> memesList)
	{
		this.memesList = memesList;
	}
	
	//updates the politicalTopicList for this Chatbot instance
	public void setPoliticalTopicList(ArrayList <String> politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}
	
	//updates the userName for this Chatbot instance
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
	
	
	
	
	
	
	
	
}