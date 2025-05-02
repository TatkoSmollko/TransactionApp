DELETE FROM transaction;
DELETE FROM fee;
DELETE FROM transaction_type;

INSERT INTO transaction_type (id, name) VALUES
                                            (1, 'STANDARD'),
                                            (2, 'PERCENTAGE'),
                                            (3, 'COMBINED');

INSERT INTO fee (id, transaction_type_id, fixed_fee, percent_fee) VALUES
                                                                      (1, 1, 5.00, NULL),
                                                                      (2, 1, 10.00, NULL),
                                                                      (3, 2, NULL, 3.5),
                                                                      (4, 2, NULL, 2.0),
                                                                      (5, 3, 2.50, 1.0),
                                                                      (6, 3, 7.50, 4.0);

INSERT INTO transaction (id, amount, currency, transaction_type_id) VALUES
                                                                        (1, 100.00, 'EUR', 1),
                                                                        (2, 200.00, 'EUR', 1),
                                                                        (3, 300.00, 'EUR', 2),
                                                                        (4, 400.00, 'EUR', 2),
                                                                        (5, 500.00, 'EUR', 2),
                                                                        (6, 600.00, 'EUR', 3),
                                                                        (7, 700.00, 'EUR', 3),
                                                                        (8, 800.00, 'EUR', 3),
                                                                        (9, 900.00, 'EUR', 1),
                                                                        (10, 1000.00, 'EUR', 2);
