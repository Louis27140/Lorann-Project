package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockLevelTest {

	private Level level;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.level = new Level(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWidth() {
		final int expected = 20;
		assertEquals(expected,this.level.getWidth());
	}

	@Test
	public void testGetHeight() {
		final int expected = 12;
		assertEquals(expected,this.level.getHeight());
	}

}
