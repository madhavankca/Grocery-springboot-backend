create table item(
    id bigint generated by default as identity,
    name varchar(255) not null,
    price float not null
);
