package io.magicthegathering.javasdk.api;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.Set;

import java.util.List;

/**
 * {@link SetService} is used to fetch {@link Set}s from magicthegathering.io
 * 
 * @author nniklas, tcashcroft
 */
public class SetService extends MTGAPI {
	private static final String SETS_PATH = "sets";

	private static final String BOOSTER = "booster";

	/**
	 * Returns a {@link Set} based on the given set code.
	 * @param setCode Code to find the specific set.
	 */
	public static Set getSet(String setCode) {
		String path = String.format("%s/%s/", SETS_PATH, setCode);
		return get(path, "set", Set.class);
	}

	/**
	 * The method that returns all the {@link Set}.
	 * @return A List of all the sets.
	 */
	public static List<Set> getAllSets() {
		return getList(SETS_PATH, "sets", Set.class);
	}

	/**
	 * The method that will generate a booster for the selected {@link Set}
	 * @param setCode Code of which set you want a booster for.
	 * @return
	 */
	public static List<Card> getBooster(String setCode) {
		String path = String.format("%s/%s/%s/", SETS_PATH, setCode,
				"booster");
		return getList(path, "cards", Card.class);
	}

	/**
	 * Gets a list of {@link Set} based on the provided filters in the
	 * <a href="https://docs.magicthegathering.io/#sets">web API documentation.</a>
	 * @param filters List of string filters
	 * @return The list of {@link Set}s that was found by the filter.
	 */
	public static List<Set> getAllSets(List<String> filters){
		return getList(SETS_PATH, "sets", Set.class, filters);
	}

	private String getBoosterPath(String set) {
		return SETS_PATH + "/" + set + "/" + BOOSTER;
	}
}
