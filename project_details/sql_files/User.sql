use ngodonation;

select * from user;
SET SQL_SAFE_UPDATES = 0;

create table User (
	userId INT NOT NULL auto_increment, 
    name varchar(30) default null, 
    email varchar(50) NOT NULL, 
    password varchar(256) NOT NULL,
    phoneNumber varchar(12),
    address varchar(200) default null,
    role varchar(5) default 'donor',
    primary key (userId)
);

insert into User(name, email, password) values ("Krishna", "Krishna@yash.com", "Krishna@12345");

insert into User(name, email, password, role) values ("Shreyash", "Shreyash@yash.com", "Shreyash@123", "admin");
insert into User(name, email, password) values ("Kiran", "Kiran@yash.com", "Kiran@12345");

delete from User where name="Shreyash";
/*
	getting all users
*/
select * from user;
delete from user;

/*
	getting user by name and password
*/
select * from user where name="Krishna" and password="Krishna@123";