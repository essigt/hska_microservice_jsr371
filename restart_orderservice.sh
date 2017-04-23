#!/bin/bash
docker kill orderservice
docker rm orderservice
docker run -d -p 8080:8080 --link pizzaservice:pizzaservice  --name orderservice essigt/ms_orderservice

