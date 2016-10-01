package net.seabears.challenge.api.hackernews;

import com.sun.jersey.api.client.Client;

import java.util.List;

/**
 * Resource to query Hacker News
 */
public class HackerNewsResource {
    private final Client client;
    private final String uriBase;

    /**
     * Creates a new Hacker News resource
     *
     * @param client API client
     * @param uriBase base of URI for endpoints
     */
    public HackerNewsResource(Client client, String uriBase) {
        this.client = client;
        this.uriBase = uriBase;
    }

    /**
     * Returns IDs of top stories on Hacker News.
     * These are the stories displayed on the home page.
     *
     * @return top story IDs
     */
    public List<Integer> topStories() {
        return client.resource(uriBase + "/topstories.json").get(ItemIdList.class);
    }

    /**
     * Returns IDs of best stories on Hacker News.
     * These are somehow different from top stories.
     *
     * @return best story IDs
     */
    public List<Integer> bestStories() {
        return client.resource(uriBase + "/beststories.json").get(ItemIdList.class);
    }

    /**
     * Returns the item with the specified ID
     *
     * @param id item's ID
     * @return item
     */
    public Item item(int id) {
        return client.resource(uriBase + "/item/" + id + ".json").get(Item.class);
    }
}
