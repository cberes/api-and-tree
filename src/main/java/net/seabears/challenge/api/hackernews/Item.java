package net.seabears.challenge.api.hackernews;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Hacker News item (story, poll, etc.)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    /** Item ID */
    public int id;
    /** Item URL (as submitted by as user) */
    public String url;
    /** Item title */
    public String title;
}
