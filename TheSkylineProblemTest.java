package com.leetcode.bear;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TheSkylineProblemTest {

	TheSkylineProblem obj;
	@Before
	public void setUp() throws Exception {
		obj = new TheSkylineProblem();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		int[][] buildings = { {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} } ;
		List<List<Integer>> result = obj.getSkyline(buildings);
		int[][] expected = { {2,10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0} };
		
	}

}
