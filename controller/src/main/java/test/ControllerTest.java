package test;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ControllerTest {
	private ControllerMock controller;
	private ViewMock view = new ViewMock();
	private ModelMock model = new ModelMock();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controller = new ControllerMock(view, model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetView() {
		assertEquals(this.view, this.controller.getView());
	}
	
	@Test
	public void testGetModel() {
		assertEquals(this.model, this.controller.getModel());

	}
	
	@Test
	public void testPerformOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.performOrder(keyEvent);
		assertEquals(keyEvent, controller.getStackOrder());
	}
	
	@Test
	public void testGetOrderPerformer() {
		assertEquals(this.controller, this.controller.getOrderPerformer());
	}
	
	@Test
	public void testGetStackOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.setStackOrder(keyEvent);
		assertEquals(keyEvent, this.controller.getStackOrder());
	}
	
	@Test
	public void testSetStackOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.setStackOrder(keyEvent);
		assertEquals(keyEvent, this.controller.getStackOrder());
	}
	

}
