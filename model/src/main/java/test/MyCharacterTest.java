package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ILevel;
import model.element.mobile.Lorann;

public class MyCharacterTest {
	private Lorann character;
	private ILevel level;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.character = new Lorann(10, 10, level);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveLeft() {
		this.character.moveLeft();
		assertEquals(9, this.character.getX());
	}

}
