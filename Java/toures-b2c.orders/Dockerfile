FROM aesveln/mavenaes:latest

EXPOSE 8080

COPY . /app/toures-users
WORKDIR /app/toures-users
RUN  mvn install:install-file -Dfile=lib/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.3.0 -Dpackaging=jar  -DgeneratePom=true
ENTRYPOINT ["mvn", "spring-boot:run"]


