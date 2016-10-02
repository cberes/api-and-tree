# hn-reddit-api

This is a REST API that queries Hacker News and Reddit and returns articles that are present on both. It's my work for one take-home programming challenge for a job interview. I replaced the files that I did not create originally.

There are 2 query parameters: `subreddit` and `max`. The `max` parameter controls the number of Hacker News stories to search through (because a request needs to be made to the HN API for every story). The `subreddit` parameter picks the subreddit on Reddit. You can omit it to use the main page. Otherwise I recommend `programming` as the subreddit (because so many of the links in Reddit's programming subreddit are also posted to Hacker News).

There is a config in `server.yaml` to raise the timeout for the JerseyClient.

## Usage

Build the uber jar:

    ./gradlew shadowJar

The run the uber jar:

    java -jar build/libs/hn-reddit-api-1.0.0-all.jar server server.yaml

