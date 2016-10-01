# api-and-tree

This is my work for one take-home programming challenge for a job interview. The projects do not build, because I removed files that I did not create.

There are two parts:

0. a REST API that queries Hacker News and Reddit and returns articles that are present on both
0. a searchable tree implementation

## API

There are 2 query parameters: subreddit and max. The max parameter controls the number of Hacker News stories to search through (because a request needs to be made to the HN API for every story). The subreddit parameter picks the subreddit on Reddit. You can omit it to use the main page. Otherwise I recommend "programming" as the subreddit (because so many of the links in Reddit's programming subreddit are also posted to Hacker News).

There is a config in server.yaml to raise the timeout for the JerseyClient.

## Tree

A CSV file needs to be added that contains a representation of the tree.

