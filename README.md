# BankingApplication

A Java RESTful API for fetching Customer Accounts and Account Transactions

### Technologies
- REST API
- Spring Boot
- H2 in memory database
- Spring Data JPA
- Junit
- MapStruct
- Lombok


### How to run
```sh
gradle run

```

Application starts a jetty server on localhost port 8080 An H2 in memory database initialized with sample Customer,Account and Transactions

- http://localhost:8080/customers/100/accounts
- http://localhost:8080/accounts/1000/transactions


### Available Services

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /customers/{customerId}/accounts | get Accounts by CustomerId| 
| GET | /accounts/{accountId}/transactions | get Account Transactions by AccountId | 


### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server 
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition 

