CREATE DATABASE itemService;
use itemService;

CREATE TABLE product_details (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 name VARCHAR(255),
                                 expiration_date DATE,
                                 manufacturer VARCHAR(255),
                                 price DOUBLE,
                                 available TINYINT(1)
);

CREATE TABLE product (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         product_details_id INT,
                         FOREIGN KEY (product_details_id)
                             REFERENCES product_details(id)
                             ON DELETE CASCADE
);