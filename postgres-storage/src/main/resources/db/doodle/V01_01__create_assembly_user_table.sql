CREATE TABLE assembly_user
(
    id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 5) PRIMARY KEY,
    role VARCHAR(20) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255)
);