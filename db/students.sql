create table students (
  id serial primary key,
  first_name varchar(50) not null,
  last_name varchar(100) not null
 );
 
insert into students (first_name, last_name) values ('Marija', 'Timovska');
insert into students (first_name, last_name) values ('Petar', 'Popovski');