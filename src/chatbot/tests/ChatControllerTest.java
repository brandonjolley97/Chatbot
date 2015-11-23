package chatbot.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chatbot.controller.ChatController;
import chatbot.view.*;;


public class ChatControllerTest
{
	private ChatController testController;

	@Before
	public void setUp() throws Exception
	{
		testController = new ChatController();
	}

	@After
	public void tearDown() throws Exception
	{
		testController = null;
	}

	@Test
	public void testChatController()
	{
		assertNotNull("Data member not initialized", testController.getChatModel());
		assertNotNull("Data member not initialized", testController.getChatView());
		assertTrue("Wrong display type", (testController.getChatView() instanceof ChatView));
		assertTrue("Wrong Frame type",(testController.getBaseFrame() instanceof ChatbotFrame));
		assertSame("wrong controller", testController, testController.getBaseFrame().getBaseController());
	}
	
	
	

}
