# springboot-rest-api-vagrant-docker-ansible-maven

Simple example to demonstrate how you can easily build and deploy REST API using Spring Boot, Vagrant, Docker, Ansbile and Maven.

This piece of software was built and tested on Ubuntu 18.04.2 OS. Technically it can be run on every OS containing pre-requisites listed below, however it was not tested.

### Pre-requisites

* [Vagrant 2.2.4](https://www.vagrantup.com/docs/installation/) is installed
* [Docker version 18.09.4](https://runnable.com/docker/install-docker-on-linux) is installed
* [Ansible 2.7.9](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html) is installed

### How to Use

* Clone/Download the project
* Go to the root directory and run `sudo vagrant up`
* Open`http://localhost:7123/fibonacci/getFirst/<number>` in your favourite web browser. "number" - amount of first Fibonacci numbers to return, e.g. http://localhost:7123/fibonacci/getFirst/10



