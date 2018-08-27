# Base de datos de Porductos

Imagen base : docker pull wnameless/oracle-xe-11g


Para correr:


docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true -e ORACLE_DISABLE_ASYNCH_IO=true --name sqlOracle -d  aesveln/sqlserver:latest

