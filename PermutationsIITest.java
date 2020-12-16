package com.leetcode.bear;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PermutationsIITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test1() {
		int[] nums = {1, 1, 2};
		var test = new PermutationsII();
		List<List<Integer>> lists = test.permuteUnique(nums);
		
	}

}
