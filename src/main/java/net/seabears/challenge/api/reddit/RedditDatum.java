package net.seabears.challenge.api.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Wrapper for Reddit data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedditDatum<T> {
    public String kind;
    public T data;
}
