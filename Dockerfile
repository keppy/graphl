# Building secret fucking empires.
# VERSION 0.0.1

FROM ubuntu
MAINTAINER James A. Espanosa-Dominguez "keppy.rb@gmail.com"

# Get an up-to-date package repo:
RUN echo "deb http://archive.ubuntu.com/ubuntu precise main universe" > /etc/apt/sources.list
RUN apt-get update

# Download titan-cassandra
RUN wget http://s3.thinkaurelius.com/downloads/titan/titan-cassandra-0.3.2.zip 

RUN unzip titan-cassandra-0.3.2.zip

RUN cp cassandra.yaml titan-cassandra-0.3.2/config/cassandra.yaml