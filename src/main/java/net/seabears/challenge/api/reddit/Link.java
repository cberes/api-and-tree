package net.seabears.challenge.api.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Reddit submitted link
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    /** Link ID */
    public String id;
    /** Link URL as submitted by the user */
    public String url;
    /** Link title */
    public String title;
}
