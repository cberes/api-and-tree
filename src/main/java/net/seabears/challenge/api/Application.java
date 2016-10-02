package net.seabears.challenge.api;

import com.sun.jersey.api.client.Client;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import net.seabears.challenge.api.hackernews.HackerNewsResource;
import net.seabears.challenge.api.reddit.RedditResource;

public class Application extends io.dropwizard.Application<ApiConfig> {
    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    @Override
    public String getName() {
        return "challenge-app";
    }

    @Override
    public void initialize(Bootstrap<ApiConfig> bootstrap) {}

    @Override
    public void run(ApiConfig configuration, Environment environment) {
        final Client client = new JerseyClientBuilder(environment)
                .using(configuration.getJerseyClientConfiguration())
                .build(getName());
        final ApiResource resource = new ApiResource(
                new HackerNewsResource(client, configuration.getHackerNewsUriBase()),
                new RedditResource(client, configuration.getRedditUriBase()));
        environment.jersey().register(resource);
    }
}
