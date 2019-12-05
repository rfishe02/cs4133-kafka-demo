#!/bin/bash

zkServer.sh start
kafka-server-start.sh $KAFKA_HOME/config/server.properties
