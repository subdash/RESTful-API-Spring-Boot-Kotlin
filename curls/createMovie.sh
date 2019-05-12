#!/usr/bin/env bash
curl -v localhost:8080/api/movies -H 'Content-Type:application/json' -d '{"name": "Terminator", "genre": "sci-fi", "yearRelease": 1984, "rating": "FIVE_STAR"}'
