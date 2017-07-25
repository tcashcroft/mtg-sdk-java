package io.magicthegathering.javasdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.magicthegathering.javasdk.resource.Card;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link CardService} is used to fetch {@link Card}s from magicthegathering.io
 * 
 * @author nniklas
 */
public class CardService extends MTGAPI {

	private static final String CARDS_PATH = "cards";

	private static final String TYPES_PATH = "types";

	private static final String SUPERTYPES_PATH = "supertypes";

	private static final String SUBTYPES_PATH = "subtypes";

	private static final Client client = ClientBuilder.newClient();

	private static URI uri = UriBuilder.fromUri("https://api.magicthegathering.io/v1").build();

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * @return A {@link Card} based on the given cardId
	 */
	public static Card getCard(String cardId) {
		try {
			List<Card> tempList = new ArrayList<>();
			String listString = client.target(uri).path(CARDS_PATH).path(cardId).request().get(String.class);
			tempList = mapper.readValue(listString, tempList.getClass());

			return tempList.get(0);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * @return A {@link Card} based on the given multiverseid
	 */
	public static Card getCard(int multiverseId) {
		return getCard(Integer.toString(multiverseId));
	}

	/**
	 * @return All the available {@link Card}s as a list.
	 */
	public static List<Card> getAllCards() {
		List<Card> cards = new ArrayList<>();
	    cards = client.target(uri).path(TYPES_PATH).request().get(cards.getClass());
		return cards;
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 * 
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public static List<String> getAllCardTypes() {
	    List<String> cardTypes = new ArrayList<>();
	    cardTypes = client.target(uri).path(TYPES_PATH).request().get(cardTypes.getClass());
		return cardTypes;
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#get-all-supertypes</a>
	 */
	public static List<String> getAllCardSupertypes() {
		List<String> superTypes = new ArrayList<>();
		superTypes = client.target(uri).path(SUPERTYPES_PATH).request().get(superTypes.getClass());
		return superTypes;
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public static List<String> getAllCardSubtypes() {
	    List<String> subTypes = new ArrayList<>();
	    subTypes = client.target(uri).path(SUBTYPES_PATH).request().get(subTypes.getClass());
		return subTypes;
	}

	/**
	 * Get all the {@link Card} that match a certain filter.
	 * @param filters List of filters supported by the web API
	 * @return List of all matching {@link Card}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#cards">
	 *		https://docs.magicthegathering.io/#cards</a>
	 */
	public static List<Card> getAllCards(List<String> filters){
	    // TODO Fill out the filters method
//		return getList(RESOURCE_PATH, "cards", Card.class, filters);
		return null;
	}
}
