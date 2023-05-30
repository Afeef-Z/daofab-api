INSERT INTO PARENT(id, sender, receiver, total_amount) VALUES
                                                                       (1, 'sender1', 'receiver1', 30.0),
                                                                       (2, 'sender2', 'receiver2', 70.0),
                                                                       (3, 'sender3', 'receiver3', 110.0);

INSERT INTO CHILD(id, parent_id, paid_amount) VALUES
                                                              (1, 1, 10.0),
                                                              (2, 1, 20.0),
                                                              (3, 2, 30.0),
                                                              (4, 2, 40.0),
                                                              (5, 3, 50.0),
                                                              (6, 3, 60.0);
