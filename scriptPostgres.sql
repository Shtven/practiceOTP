CREATE DATABASE optproject;

USE optproject;

CREATE TABLE user_account (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE INDEX idx_user_email ON user_account(email);

CREATE TABLE otp_code (
    id_otp SERIAL PRIMARY KEY,
    code INT NOT NULL CHECK (code BETWEEN 100000 AND 999999),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP NOT NULL,
    user_id INT NOT NULL REFERENCES user_account(id) ON DELETE CASCADE,
    device VARCHAR(100),
    used BOOLEAN DEFAULT FALSE
);

CREATE INDEX idx_otp_active ON otp_code (used, expires_at);
