CREATE TABLE hotel.address
(
    id           SERIAL PRIMARY KEY,
    house_number INT,
    street       VARCHAR(255),
    city         VARCHAR(100),
    country      VARCHAR(100),
    post_code    VARCHAR(20)
);

CREATE TABLE hotel.contacts
(
    id    SERIAL PRIMARY KEY,
    phone VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE hotel.arrival_time
(
    id        SERIAL PRIMARY KEY,
    check_in  VARCHAR(10),
    check_out VARCHAR(10)
);

CREATE TABLE hotel.hotel
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255),
    description     TEXT,
    brand           VARCHAR(100),
    address_id      INT REFERENCES address (id) ON DELETE CASCADE,
    contacts_id     INT REFERENCES contacts (id) ON DELETE CASCADE,
    arrival_time_id INT REFERENCES arrival_time (id) ON DELETE CASCADE
);
