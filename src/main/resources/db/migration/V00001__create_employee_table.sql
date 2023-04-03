CREATE TABLE employee
(
    id    int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name  varchar(100),
    email varchar(100)
)