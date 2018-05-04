DROP TABLE employee IF EXISTS;

CREATE TABLE employee (
  id INTEGER IDENTITY PRIMARY KEY,
  first_name varchar(45) ,
  last_name varchar(45)  ,
  company varchar(45)  
) ;

