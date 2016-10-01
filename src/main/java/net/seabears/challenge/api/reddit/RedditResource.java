package net.seabears.challenge.api.reddit;

import com.google.common.base.Strings;
import com.sun.jersey.api.client.Client;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Resource to query Reddit
 */
public class RedditResource {
    private final Client client;
    private final String uriBase;

    /**
     * Creates a new Reddit resource
     *
     * @param client API client
     * @param uriBase base of URI for endpoints
     */
    public RedditResource(Client client, String uriBase) {
        this.client = client;
        this.uriBase = uriBase;
    }

    /**
     * Returns list of "hot" links on the specified subreddit.
     * Subreddit can be null or empty, in which case the main page's hot links are returned.
     * Also, note that the Reddit API returns an empty list if the subreddit is not found.
     *
     * @param subreddit subreddit (or null for all subreddits)
     * @return list of hot links
     */
    public List<Link> hotLinks(String subreddit) {
        final String endpoint = (Strings.isNullOrEmpty(subreddit) ? "" : "/r/" + subreddit) + "/hot.json";
        return client.resource(uriBase + endpoint)
                .get(SubredditListing.class)
                .data.children.stream()
                .map(child -> child.data)
                .collect(toList());
    }
}
