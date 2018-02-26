create table user(
    id varchar(32) primary key,
    user_name varchar(64),
    password varchar(200),
    token varchar(200),
    last_ip varchar(200),
    last_visit date)
;

create table loginLog(

)