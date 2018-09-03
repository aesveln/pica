# Base de datos de Porductos

Imagen base : docker pull wnameless/oracle-xe-11g


Para correr:


docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true -e ORACLE_DISABLE_ASYNCH_IO=true --name sqlOracle -d  aesveln/sqloracle:latest

 mvn install:install-file -Dfile=lib/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.3.0 -Dpackaging=jar  -DgeneratePom=true