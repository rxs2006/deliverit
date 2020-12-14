FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/deliver-it*.jar deliver-it.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8090

CMD java ${ADITIONAL_OPTS} -jar deliver-it.jar --spring.profiles.active=${PROFILE}

