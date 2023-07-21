CREATE TABLE IF NOT EXISTS patient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    room_number VARCHAR(50) NOT NULL,
    doctor_name VARCHAR(255) NOT NULL,
    expenses Integer NOT NULL,
    addhar_number VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    admitted_date DATE NOT NULL,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
);


CREATE TABLE IF NOT EXISTS staff_user (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
);