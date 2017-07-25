package io.magicthegathering.javasdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.util.List;

/**
 * {@link CardService} is used to fetch {@link Card}s from magicthegathering.io
 * 
 * @author nniklas, tcashcrof
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
	public Card getCard(String cardId) {
		try {
			String listString = client.target(uri).path(CARDS_PATH).path(cardId).request().get(String.class);
			System.out.println(listString);
			Response response = mapper.readValue(listString, Response.class);
			return response.getCard();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * @return All the available {@link Card}s as a list.
	 */
	public List<Card> getAllCards() {
		try {
			String responseString = client.target(uri).path(TYPES_PATH).request().get(String.class);
			Response response = mapper.readValue(responseString, Response.class);
			return response.getCards();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 * 
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public List<String> getAllCardTypes() {
	    try {
			String responseString = client.target(uri).path(TYPES_PATH).request().get(String.class);
			Response response = mapper.readValue(responseString, Response.class);
			return response.getTypes();
		} catch (IOException e) {
	    	throw new UncheckedIOException(e);
		}
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#get-all-supertypes</a>
	 */
	public List<String> getAllCardSupertypes() {
		try {
			String responseString = client.target(uri).path(SUPERTYPES_PATH).request().get(String.class);
			Response response = mapper.readValue(responseString, Response.class);
			return response.getSupertypes();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public List<String> getAllCardSubtypes() {
		try {
			String responseString = client.target(uri).path(SUBTYPES_PATH).request().get(String.class);
			Response response = mapper.readValue(responseString, Response.class);
			return response.getSubtypes();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * Get all the {@link Card} that match a certain filter.
	 * @param filters List of filters supported by the web API
	 * @return List of all matching {@link Card}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#cards">
	 *		https://docs.magicthegathering.io/#cards</a>
	 */
	public List<Card> getAllCards(List<String> filters){
	    // TODO Fill out the filters method
//		return getList(RESOURCE_PATH, "cards", Card.class, filters);
		return null;
	}
}
