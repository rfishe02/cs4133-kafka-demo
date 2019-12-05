
# Start tomcat instance

sudo systemctl start tomcat

# Start apache instance

sudo systemctl start apache2

# Start zookeeper instance (make sure admin.serverPort=8081 in zoo.cfg, if you're using with Tomcat)

zkServer.sh start

# Start kafka instance

kafka-server-start.sh $KAFKA_HOME/config/server.properties
