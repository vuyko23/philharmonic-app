## Philharmonic App
RESTful application that represents work of Philharmonic website. Application has 3 main levels - DAO, Controller and Service. Based on your role you can buy tickets or manage the website. By default only 2 roles - ADMIN and USER. Also implemented user registration, authorization, email, and password validation.

## Everyone can:
- Register
- Get a list of available performances
- Get a list of all stages
- Get a list of all concert

## User can:
- Add tickets to shopping cart
- Get list of tickets in shopping cart
- Complete order
- Get list of order history

## Admin can:
- Add new stage
- Add new concert
- Add new performance
- Delete performance
- Update performance
- Find user by email

## Technologies
- Spring(Core, Web, Security, MVC)
- Tomcat
- Lombok
- RDBMS(MySQL)
- Jackson
- Logger
- Maven

## Configuration Steps
- Install Tomcat
- Install MySQL database
- Configure DB properties in resources folder
- Configure Tomcat with deployment - war_exploded and context adress "/"
- Run application
  ADMIN account - admin@email.com, 1234
  USER account - user@email.com, 1234
