#!bash
# Disable the swap for cassandra:
sudo swapoff --all

# Download titan-cassandra
sudo wget http://s3.thinkaurelius.com/downloads/titan/titan-cassandra-0.3.2.zip 

sudo unzip titan-cassandra-0.3.2.zip

sudo cp cassandra.yaml titan-cassandra-0.3.2/config/cassandra.yaml

#install
sudo titan-cassandra-0.3.2/bin/titan.sh titan-cassandra-0.3.2/config/titan-server-rexster.xml titan-cassandra-0.3.2/config/titan-server-cassandra.properties
