create database feedback_system;
use feedback_system;


CREATE TABLE users (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
user_name VARCHAR(20) NOT NULL,
email VARCHAR(50) unique NOT NULL,
user_password VARCHAR(30) NOT NULL,
created_at datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
is_active boolean DEFAULT false NOT NULL
 );
 
 
 CREATE TABLE user_feedbacks (
 id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 user_id INT NOT NULL,
 customer_name VARCHAR(20) UNIQUE NOT NULL,
 customer_email VARCHAR(50) UNIQUE NOT NULL,
 feedback_text varchar(250) NOT NULL,
 is_deleted boolean NOT NULL,
 created_at datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
 updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
 FOREIGN KEY (user_id)REFERENCES users(id)
);

-- insert into users (user_name,email,user_password,is_active) values ('vicky','vishal@gmail.com','123456',true);
