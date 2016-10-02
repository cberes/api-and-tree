package net.seabears.challenge.api;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApiConfig extends Configuration {
    @NotEmpty
    private String hackerNewsUriBase = "https://hacker-news.firebaseio.com/v0";

    @NotEmpty
    private String redditUriBase = "https://www.reddit.com";

    @Valid
    @NotNull
    @JsonProperty
    private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

    @JsonProperty
    public String getHackerNewsUriBase() {
        return hackerNewsUriBase;
    }

    @JsonProperty
    public void setHackerNewsUriBase(String hackerNewsUriBase) {
        this.hackerNewsUriBase = hackerNewsUriBase;
    }

    @JsonProperty
    public String getRedditUriBase() {
        return redditUriBase;
    }

    @JsonProperty
    public void setRedditUriBase(String redditUriBase) {
        this.redditUriBase = redditUriBase;
    }

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return httpClient;
    }
}
