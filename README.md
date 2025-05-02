# TransactionService
Transaction Fee Service This application is responsible for calculating transaction fees based on various transaction types. It leverages modern technologies including Kafka, REST, Docker, Spring Boot, Hibernate, MySQL, Spring Security, and more.


How to Run

Build the project using Maven:

in root of project run : mvn clean install -DskipTests

Then you need to have docker installed and run the services using this command : 

docker-compose up --build


Once the services are up and running, you can test the application using the available endpoints:
GET request to get transactionFee for the given id of transaction. ( there are existing testing ids in DB from 1 to 10 )
curl --location 'localhost:8080/api/transaction/3' \
--header 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=D525B44548222B3FABA87E0764EC42FA'

 

POST request to send a kafka message about new transaction and to calculate a fee of this transaction. Final result is sent to another topic in kafka. 
curl --location 'localhost:8080/api/transactionsKafka/send' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=D525B44548222B3FABA87E0764EC42FA' \
--data '{
  "transactionId": 1,
  "amount": 100.50,
  "transactionTypeId": 2,
  "transactionDate": "2025-04-29"
}'

