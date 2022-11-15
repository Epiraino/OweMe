Emilio Piraino Design Document

OweMe Design
1. Problem Statement
   People who want to borrow or lend money but want to know the personal lending history of the user that wants to borrow

2. Top Questions to Resolve in Review
    What would the user profile look like?
    How would we calculate the social credit score?

3. Use Cases

U1. As a [product] customer, I want to have a profile that displays my Social Credit Score.

U2. As a [product] customer, I want to know the Social Credit Score of the user that is requesting a loan.

U3. As a [product] customer, I want to know if the Lendee has not repaid a previous loan or has late payments.

U4. As a [product] customer, I want to be able to look up another user, in case the person is verbally requesting a loan



4. Project Scope

4.1. In Scope

- Creating, retrieving, updating, and deleting an account.
- Requesting Loan

4.2. Out of Scope
- In App monetary transactions.
- Social vs Traditional Credit Score comparator

5. Proposed Architecture Overview
   Describe broadly how you are proposing to solve for the requirements you described in Section 3.

This may include class diagram(s) showing what components you are planning to build.

You should argue why this architecture (organization of components) is reasonable. That is, why it represents a good data flow and a good separation of concerns. Where applicable, argue why this architecture satisfies the stated requirements.

6. API
   6.1. Public Models

   // User
   String userId;
   String username;
   String hashedPassword;
   String salt;
   String email;
   String phoneNumber;
   String birthDate;
   Boolean isEmailVerified;
   Boolean isPhoneVerified;
   int SocialCreditScore;
   int latePayments;
   int numberOfLoans;
   List< Transaction > transactionList;

   
6.2. First Endpoint
Describe the behavior of the first endpoint you will build into your service API. This should include what data it requires, what data it returns, and how it will handle any known failure cases. You should also include a sequence diagram showing how a user interaction goes from user to website to service to database, and back. This first endpoint can serve as a template for subsequent endpoints. (If there is a significant difference on a subsequent endpoint, review that with your team before building it!)

(You should have a separate section for each of the endpoints you are expecting to build...)

6.3 Second Endpoint
(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)

7. Tables
   userId // partition key, string
   userName // string
   hashedPassword // string
   salt // string
   email // string
   phoneNumber // string
   birthData // string
   isEmailVerified // boolean
   isNumberVerified // boolean
   SocialCreditScore // int
   latePayments // int
   numberOfLoans // int
   transactionList // List< Transaction >

8. Pages
   Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)