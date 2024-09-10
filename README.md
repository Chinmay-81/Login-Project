# Login Project
 This is a simple project of login and resgister,it will store data in database.

## How to run
### First create a DataBase (userdb) and table (uinfo) using the below reference:
create database userdb;<br>
use userdb;<br>
create table uinfo(
fname varchar(30),
lname varchar(30),
uname varchar(30) ,
pword varchar(30)
);

Then clone the whole repository...<br>
Ensure that you have installed latest version of Apache Tomcat(Tomcat v10.1) <br> and set path of servlet-api.jar(available in lib) in classpath of system variables in Environment variables.

### All set 👍

