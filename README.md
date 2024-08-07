# native-poc-mongodb-error

If you follow the steps below in order, you will encounter the error.
1. mvn clean install
2. mvn spring-boot:build-image -P native
3. docker network create db-network
4. docker run --network=db-network --name mongodb -p 27017:27017 mongo:7.0.13-rc0
5. docker run --network=db-network docker.io/library/native-poc-mongodb-solution:0.0.1-SNAPSHOT

Error :

# And Result : No errors will be seen, and the service will be running correctly. Because the relevant method was added to the hint.