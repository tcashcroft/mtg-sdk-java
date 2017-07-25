package io.magicthegathering.javasdk.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.Legality;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CardAPITest extends MTGAPITest {

	@Test
	public void testGetCardByMultiverseId() {
		Card testCard = new Card();
		testCard.setMultiverseId(1);
		testCard.setName("Ankh of Mishra");
		testCard.setManaCost("{2}");
		assertEquals(testCard, CardService.getCard(1));
		assertFalse(testCard.equals(CardService.getCard(10)));
	}

  @Test
  public void testGetCardById() {
    Card testCard = new Card();
    testCard.setMultiverseId(1);
    testCard.setName("Ankh of Mishra");
    testCard.setManaCost("{2}");
    assertEquals(testCard, CardService.getCard("8a5d85644f546525433c4472b76c3b0ebb495b33"));
    assertFalse(testCard.equals(CardService.getCard("926234c2fe8863f49220a878346c4c5ca79b6046")));
  }

	@Test
	public void testBadCardId() throws Exception {
		assertNull(CardService.getCard(-1));
	}

	@Test
	public void testGetAll() throws Exception {
		List<Card> testCardList = CardService.getAllCards();
		Card testCard = new Card();
		testCard.setMultiverseId(94);
		testCard.setName("Air Elemental");
		testCard.setManaCost("{3}{U}{U}");
		assertEquals(testCardList.get(0), testCard);
	}

	@Test
	public void testDeserializePictureUrl() throws Exception {
		List<Card> testCardList = CardService.getAllCards();
		assertEquals("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=94&type=card", testCardList.get(0).getImageUrl());
	}

	@Test
	public void testGetAllCardTypes() throws Exception {
		List<String> types = CardService.getAllCardTypes();
		assertTrue(types.contains("Artifact"));
		assertTrue(types.contains("Creature"));
		assertTrue(types.contains("Planeswalker"));
	}

	@Test
	public void testGetAllCardSupertypes() throws Exception {
		List<String> superTypes = CardService.getAllCardSupertypes();
		assertTrue(superTypes.contains("Legendary"));
		assertTrue(superTypes.contains("Basic"));
		assertTrue(superTypes.contains("Snow"));
	}

	@Test
	public void testGetAllCardSubtypes() throws Exception {
		List<String> superTypes = CardService.getAllCardSubtypes();
		assertTrue(superTypes.contains("Ape"));
		assertTrue(superTypes.contains("Elf"));
		assertTrue(superTypes.contains("Squid"));
	}

	@Test
	public void testCardFilter(){
		ArrayList<String> filter = new ArrayList<>();
		filter.add("name=Air");

		Card testCard = new Card();
		testCard.setMultiverseId(94);
		testCard.setName("Air Elemental");
		testCard.setManaCost("{3}{U}{U}");
		assertTrue(CardService.getAllCards(filter).contains(testCard));
	}

	@Test
	public void testLegality() {
		Legality testLegality = new Legality();
		testLegality.setFormat("Commander");
		testLegality.setLegality("Legal");
		assertEquals(testLegality, CardService.getCard(1).getLegalities()[0]);
	}
}
