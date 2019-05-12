#!/usr/bin/env bash
curl -v -X PUT localhost:8080/api/movies/6 -H 'Content-type:application/json' -d '{"name": "Terminator", "genre": "sci-fi", "yearRelease": 1984, "rating": "FIVE_STAR"}'
