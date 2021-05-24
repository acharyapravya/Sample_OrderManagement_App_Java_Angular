# Sample Order Management App

"Sample Order Management App" is a java and angular based web application that can be used to : 
Manage an order
Check the Status Of an Order
Cancel an Order
View the Order Summary 

* Angular Router has been used to make this SPA (Single Page Application) for better performance.
* Latest Angular Material components has been used in the application for better user experience. For example sidebar, card, table, and dialog, components etc.  

=======================================================================
  
## Pre-requisites:

Install following before running the app:

* 1. jdk (8.0 used)
* 2. maven (3.3 used)
* 3. mysql server (8 used)
* 4. NodeJs (10.16.0 LTS used)
* 5. Angular CLI (8.0.0 LTS used)

=======================================================================

## Steps to run the API application server:

* 1. start MySQL server
* 2. change mysql root credential in "carbooking/api/src/main/resources/application.yml"
* 3. create database "carbooking" in MySQL
* 4. mvn clean install the app
* 5. java -jar <above_created_jar>


## Note:  if u want to run this jar as docker then follow below instructions:

* 1. docker build -f Dockerfile -t <image_name>
* 2. docker run <image_name>


=======================================================================

## Steps to run the UI application server:

* 1. Open cmd
* 2. Go to <project directory>
* 3. npm install
* 4. ng serve --open

## Note: application will execute on http://localhost:4200/