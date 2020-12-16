package com.leetcode.bear;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergeIntervalsTest {
	MergeIntervals test;
	@Before
	public void setUp() throws Exception {
		test = new MergeIntervals();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test1() {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = test.merge(intervals);
		int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public final void test2() {
		int[][] intervals = {{1,4},{4,5}};
		int[][] result = test.merge(intervals);
		int[][] expected = {{1, 5}};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public final void test3() {
		int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] result = test.merge(intervals);
		int[][] expected = {{1, 10}};
		assertArrayEquals(expected, result);
	}


}
