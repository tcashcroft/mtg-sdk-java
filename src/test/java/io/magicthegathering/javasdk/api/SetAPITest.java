package io.magicthegathering.javasdk.api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SetAPITest extends MTGAPITest {
	@Test
	public void testGetSet() {
		Set testSet = new Set();
		testSet.setGatherercode("1E");
		assertEquals(testSet, SetAPI.getSet("LEA"));
		assertFalse(testSet.equals(SetAPI.getSet("LEB")));
	}

	@Test
	public void testBadSetId() {
		assertNull(SetAPI.getSet("666"));
	}

	@Test
	public void testGetAllSets() {
		List<Set> testSetList = SetAPI.getAllSets();
		Set testSet = new Set();
		testSet.setGatherercode("1E");
		assertEquals(testSetList.get(0), testSet);
	}

	@Test
	public void testGetBoosterFromSet() {
		String setCode = "KLD";
		List<Card> booster = SetAPI.getBooster(setCode);
		assertEquals(15, booster.size());
	}

	@Test
	public void testSetFilter(){
		ArrayList<String> filter = new ArrayList<>();
		filter.add("name=Alpha");

		Set alpha = SetAPI.getSet("LEA");

		assertTrue(SetAPI.getAllSets(filter).contains(alpha));
	}
}
