package net.seabears.challenge.api.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Wrapper for a list of data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatumParent<T> {
    public List<RedditDatum<T>> children;
}
