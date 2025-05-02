-- 1. Tabuľka transaction_type
CREATE TABLE transaction_type (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  name VARCHAR(255) NOT NULL UNIQUE,
                                  description TEXT
);

-- 2. Tabuľka fee
CREATE TABLE fee (
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     transaction_type_id BIGINT NOT NULL,
                     fixed_fee DECIMAL(10,2),
                     percent_fee DECIMAL(5,2),
                     valid_from DATE DEFAULT  NULL,
                     valid_to DATE DEFAULT NULL,
                     CONSTRAINT fk_fee_transaction_type FOREIGN KEY (transaction_type_id)
                         REFERENCES transaction_type(id)
                         ON DELETE CASCADE
                         ON UPDATE CASCADE
);

-- 3. Tabuľka transaction
CREATE TABLE transaction (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             amount DECIMAL(15,2) NOT NULL,
                             currency VARCHAR(10) NOT NULL,
                             description TEXT,
                             transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             transaction_type_id BIGINT NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             CONSTRAINT fk_transaction_transaction_type FOREIGN KEY (transaction_type_id)
                                 REFERENCES transaction_type(id)
                                 ON DELETE RESTRICT
                                 ON UPDATE CASCADE
);
