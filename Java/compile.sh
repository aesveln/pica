cd toures-b2c.users
mvn clean 
mvn package
#docker build -t toures-b2c.users .
#docker run -p 8081:8081 --name toures-b2c.users -d toures-b2c.users
cd ..
cd toures-b2c.products
mvn clean 
mvn package
#docker build -t toures-b2c.products .
#docker run -p 8081:8081 --name toures-b2c.products -d toures-b2c.products