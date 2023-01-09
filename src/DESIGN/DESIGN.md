# Emilio Piraino Design Document

# OweMe Design
## 1. Problem Statement:

   To create an application that allows people to track loans given out to friends and to rate the lender based on 
   paying back on time, creating a social credit score.

## 2. Top Questions to Resolve in Review:

* How will users be able to add loans and view their loan history?
  * How will the rating system work and how will it affect a user's social credit score?
  * How will users be able to search for other users and view their ratings?
  * How will the application handle disputes or errors in ratings or loan information?
  * What measures will be in place to protect user privacy?

## 3. Use Cases:

   * U1. As a user, I want to be able to add a new loan, including the amount, borrower, and due date.
   * U2. As a user, I want to be able to view my loan history, including completed and outstanding loans.
   * U3. As a user, I want to be able to rate a borrower based on their punctuality in paying back a loan.
   * U4. As a user, I want to be able to view the ratings and social credit score of other users.
   * U5. As a user, I want to be able to dispute a rating or report an error in loan information.

## 4. Project Scope:

The scope of the project is to create an application that allows users to track loans given to friends, rate borrowers 
based on their punctuality, and view the ratings and social credit scores of other users. Users will also be able to 
search for other users and view their ratings. The application will handle disputes and errors in ratings and loan 
information. Measures will be in place to protect user privacy.

### 4.1 In Scope:

This design will cover U1-U5 and the project scope.

### 4.2. Out of Scope:

The ability to request loans from other users.
Integration with financial institutions or credit agencies.
Proposed Architecture Overview:

* The Oweme application will have a front-end client built with a JavaScript framework (such as React) and a 
  back-end API built with a server-side language (java). The API will be responsible for handling requests from the 
  client, interacting with the database, and performing authentication and authorization using Auth0.

* The API will have a number of endpoints for creating and retrieving loans, ratings, and user information. The database
will store user profiles, loans, and ratings.

* The client will make requests to the API to retrieve and manipulate data, and will display the data to the user in a 
user-friendly interface. The client will also handle the login flow and obtain access tokens using the Auth0 SDK.

## API:

### 6.1. Public Models:

#### User Model:

* user_id: The ID of the user (string)
* name: The name of the user (string)
* email: The email address of the user (string)
* social_credit_score: The user's social credit score (integer)
* loans: An array of the user's loans (Loan model)

#### Loan Model:
* loan_id: The ID of the loan (string)
* borrower_id: The ID of the borrower (string)
* borrower_name: The name of the borrower (string)
* amount: The loan amount (integer)
* due_date: The due date of the loan (string)
* paid: A boolean indicating whether the loan has been paid (boolean)
* ratings: An array of ratings for the loan (Rating model)

#### Rating Model:
* loan_id: The ID of the loan (string)
* user_id: The ID of the user who left the rating (string)
* user_name: The name of the user who left the rating (string)
* rating: The rating (integer)
* comment: An optional comment (string)

These models represent the data that will be returned by the API when a user retrieves their profile information or 
views the details of a loan. The User model includes an array of the user's loans, each represented by a Loan model. 
The Loan model includes an array of ratings, each represented by a Rating model.

### 6.2 Endpoint 1: /users/me

* Method: GET
  * Description: Retrieves the authenticated user's profile information and loan history.
  * Request Body: None
  * Response:
  * 200: Returns the user's profile information and loan history.
  * 401: Unauthorized. The user is not authenticated.

### 6.3 Endpoint 2: /loans

* Method: POST
  * Description: Creates a new loan for the authenticated user.
  * Request Body:
  * borrower_id: The ID of the borrower (string)
  * amount: The loan amount (integer)
  * due_date: The due date of the loan (string)
  * Response:
  * 201: The loan was created successfully.
  * 400: Bad request. The request body is missing required parameters or contains invalid values.
  * 401: Unauthorized. The user is not authenticated.

### 6.4 Endpoint 3: /loans/{loan_id}

* Method: PUT
  * Description: Updates the status of a loan (paid or unpaid).
  * Request Body:
  * paid: The status of the loan (boolean)
  * Response:
  * 200: The loan was updated successfully.
  * 401: Unauthorized. The user is not authenticated.
  * 404: Not found. The loan with the specified ID does not exist.

### 6.5 Endpoint 4: /ratings

* Method: POST
  * Description: Creates a new rating for a loan.
  * Request Body:
  * loan_id: The ID of the loan (string)
  * rating: The rating (integer)
  * comment: An optional comment (string)
  * Response:
  * 201: The rating was created successfully.
  * 400: Bad request. The request body is missing required parameters or contains invalid values.
  * 401: Unauthorized. The user is not authenticated.
  * 404: Not found. The loan with the specified ID does not exist.

## 7. Tables:

### Users Table:
Primary Key: user_id (string)
Other Attributes: name (string), email (string), password (string), social_credit_score (integer)

### Loans Table:
Primary Key: loan_id (string)
Sort Key: user_id (string)
Other Attributes: borrower_id (string), amount (integer), due_date (string), paid (boolean)

### Ratings Table:
Primary Key: loan_id (string)
Sort Key: user_id (string)
Other Attributes: rating (integer), comment (string)
This table structure allows you to store all the loans for a particular user by using the user_id as the sort key for 
the Loans table. The Ratings table is linked to the Loans table using the loan_id as the primary key. This allows you to
store multiple ratings for a single loan and retrieve them easily using the loan_id.

## Pages:
[Insert mockups of the web pages, including any descriptions of behaviors and interactions]

## TODO

1. Create an Auth0 account and set up a new application. This will give you a domain, client ID, and client secret.
2. Integrate the Auth0 SDK into your application. You can use the SDK to handle the login flow and obtain access tokens for making authenticated requests to your API.
3. Set up rules in Auth0 to customize the behavior of the authentication flow. For example, you can create a rule that automatically creates a new user in your application's database when they log in for the first time.
4. Use the access tokens obtained from Auth0 to authenticate requests to your API. You can validate the tokens using the Auth0 SDK or by calling the Auth0 API to verify the token's signature and claim set.
5. Store user-specific information (such as their loan history and ratings) in your own database, rather than in Auth0. You can link this information to the user's Auth0 user ID, which is included in the access token.


## Monetization
1. Charge a subscription fee: You could offer a basic version of the app for free and charge a monthly or annual subscription fee for premium features, such as the ability to see detailed loan history or access to credit ratings of other users.
2. Offer in-app purchases: You could allow users to purchase additional credits or features within the app, such as the ability to request a higher loan amount or see detailed credit ratings of other users.
3. Sell advertising space: You could allow businesses to advertise their products or services on your app, either through banner ads or sponsored content.
4. Offer data to third parties: If you are able to collect a large amount of data on user loan behavior, you could potentially sell this data to third parties, such as financial institutions or credit rating agencies.
5. Offer a credit score improvement service: You could offer a service to help users improve their credit score by offering tips and tools for paying off loans and improving creditworthiness.
