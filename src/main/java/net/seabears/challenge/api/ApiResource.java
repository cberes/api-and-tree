package net.seabears.challenge.api;

import net.seabears.challenge.api.hackernews.HackerNewsResource;
import net.seabears.challenge.api.hackernews.Item;
import net.seabears.challenge.api.reddit.Link;
import net.seabears.challenge.api.reddit.RedditResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {
    @NotNull
    private final HackerNewsResource hackerNews;

    @NotNull
    private final RedditResource reddit;

    /**
     * Creates a new API resource
     *
     * @param hackerNews Hacker News client
     * @param reddit Reddit client
     */
    public ApiResource(@NotNull HackerNewsResource hackerNews, @NotNull RedditResource reddit) {
        this.hackerNews = hackerNews;
        this.reddit = reddit;
    }

    /**
     * Returns the list of articles are present in both Hacker News and a Reddit subreddit.
     * If there are no matches between the two sources, then an empty list is returned.
     *
     * @param subreddit subreddit (can be null or empty; default is "")
     * @param max maximum number of Hacker News items to get (default is 25)
     * @return articles that are present in both sources
     */
    @GET
    public List<Article> articles(@QueryParam("subreddit") @DefaultValue("") String subreddit,
                                  @QueryParam("max") @DefaultValue("25") int max) {
        final Map<String, Item> hnItems = hackerNewsItemsByUrl(max);
        final List<Link> redditLinks = reddit.hotLinks(subreddit);
        return redditLinks.stream()
                .filter(link -> hnItems.containsKey(link.url))
                .map(link -> buildArticle(hnItems.get(link.url), link))
                .collect(toList());
    }

    private Map<String, Item> hackerNewsItemsByUrl(int max) {
        return hackerNews.topStories().stream()
                .limit(max)
                .map(hackerNews::item)
                .collect(toMap(item -> item.url, Function.identity(), (a, b) -> a));
    }

    private Article buildArticle(Item hnItem, Link redditLink) {
        final Article article = new Article();
        article.hnId = Integer.toString(hnItem.id);
        article.redditId = redditLink.id;
        article.hnTitle = hnItem.title;
        article.redditTitle = redditLink.title;
        article.url = hnItem.url;
        return article;
    }
}
