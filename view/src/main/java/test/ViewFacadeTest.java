package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.IOrderPerformer;
import model.ILevel;
import model.IMobile;
import view.ViewFacade;

public class ViewFacadeTest {
	
	private ILevel level;
	private IMobile myCharacter;
	private ViewFacade view;
	private Rectangle fullView;
	
	@Before
	public void setUp() throws Exception {
		level = new LevelMock();
		myCharacter = new MobileMock();
		view = new ViewFacade(level, myCharacter);
		fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLevel() {
		assertEquals(this.level, this.view.getLevel());
	}

	@Test
	public void testSetLevel() throws IOException {
		final ILevel expected = new LevelMock();
		this.view.setLevel(expected);
		assertEquals(expected, this.view.getLevel());
	}

	@Test
	public void testGetMyCharacter() {
		assertEquals(this.myCharacter, this.view.getMyCharacter());
	}

	@Test
	public void testSetMyCharacter() {
		final IMobile expected = new MobileMock();
		this.view.setMyCharacter(expected);
		assertEquals(expected, this.view.getMyCharacter());
	}
	
	@Test
	public void testSetOrderPerformer() {
		IOrderPerformer orderPerformer = new ControllerFacadeMock();
		this.view.setOrderPerformer(orderPerformer);
		assertEquals(orderPerformer, this.view.getOrderPerformer());
	}

	@Test
	public void testGetFullView() {
		assertEquals(this.fullView, this.view.getFullView());
	}

	@Test
	public void testSetFullView() {
		final Rectangle expected = new Rectangle(0, 0, level.getWidth(), level.getHeight());
		this.view.setFullView(expected);
		assertEquals(expected, this.view.getFullView());
	}

}
