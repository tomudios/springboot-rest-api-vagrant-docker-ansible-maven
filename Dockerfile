# Version 1.0.0
FROM ubuntu:16.04

MAINTAINER tomlia <tomas.liaudanskis@gmail.com>

RUN DEBIAN_FRONTEND=noninteractive apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y aptitude sudo openssh-server python

RUN mkdir /var/run/sshd
RUN echo 'root:root' | chpasswd
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# SSH login fix. Otherwise user is kicked off after login
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd

ADD /apps/virtustream_restful /apps/virtustream_restful
WORKDIR /apps/virtustream_restful

EXPOSE 22 9090
CMD ["/usr/sbin/sshd", "-D"]
