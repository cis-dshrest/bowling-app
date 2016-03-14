package com.explore.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.explore.learn.model.GameScore;

public class GameScoreTest {

	private GameScore gs;
	
	@Before
	public void setUp() {
		gs = new GameScore();
		
		gs.setId(1);
		gs.setGameTitle("First game");
		gs.setData("{ game scores }");
	}
	
	@Test
	public void testGetId() {
		assertEquals(gs.getId(), 1);

	}
	
	@Test
	public void testGetGameTitle() {
		assertEquals(gs.getGameTitle(), "First game");
		
	}
	
	@Test
	public void testgetData() {
		assertEquals(gs.getData(), "{ game scores }");
	}
}
