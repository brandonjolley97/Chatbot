package chatbot.view;

import chatbot.controller.ChatController;
import chatbot.view.ChatbotPanel;

import javax.swing.JFrame;

public class ChatbotFrame extends JFrame
{
	//declaring variables
	private ChatController baseController;
	private ChatbotPanel basePanel;
	
	//giving value to the variables
	public ChatbotFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);  //Must be the first line of the setupFrame! - Installs the panel in the frame
		this.setSize(400, 400);          //Find a good size for the app
		this.setTitle("Universe");       //Sets the title of the window
		this.setResizable(false);        //Advisable not required
		this.setVisible(true);           //Must be the last line of the setupFrame!
	}
	
	//getter for baseController
	public ChatController getBaseController()
	{
		return baseController;
	}
}

