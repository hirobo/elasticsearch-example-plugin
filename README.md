elasticsearch-example-plugin
=============================

*   Simple example source code for developing elasticsearch plugin for elasticsearch version 1.7.2.
*   Folled basically this tutorial(changed for elasticsearch version 1.7.2): [Writing an Elasticsearch Plugin: Getting Started (WARNING: This article contains outdated information.)](https://www.elastic.co/blog/found-writing-a-plugin)
*   This is just for my learning

### Development Enviroment
*   maven2
*   elasticsearch version 1.7.2

### Building and Installing the Plugin
build
```sh
$ cd elasticsearch-example-plugin
$ mvn package
```

install
```sh
$ cd /usr/share/elasticsearch/
$ sudo bin/plugin --url file:///PATH-TO-EXAMPLE-PLUGIN/target/releases/elasticsearch-example-plugin-1.0-SNAPSHOT.zip --install elasticsearch-example-plugin-1.0-SNAPSHOT
```
restart elasticsearch
```sh
$ sudo service elasticsearch stop
$ sudo service elasticsearch start
```
check if the plugin loaded
```sh
$ curl "localhost:9200/_nodes?pretty=true&settings=true"
```
### Before use
create *hello* index(do only once)
```sh
$ curl -XPUT 'http://localhost:9200/hello/'
```
### How does it works?
This returns "Hello, world!"
```sh
$ curl -XGET http://localhost:9200/_hello
```

This returns "Hello, foo!"
```sh
$ curl -XGET http://localhost:9200/_hello?who=foo
```
