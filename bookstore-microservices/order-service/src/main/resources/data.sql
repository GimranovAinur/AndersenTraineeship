INSERT INTO order_items(id, book_id, name, price) VALUES (1, 1, 'Spring in Action', 1000.0);

INSERT INTO order_items(id, book_id, name, price) VALUES (2, 1, 'Война и Мир', 1000.0);

INSERT INTO orders(id, total_price, user_id) VALUES (1, 2000.0, 1);

INSERT INTO orders_books(order_id, books_id) VALUES (1, 1);

INSERT INTO orders_books(order_id, books_id) VALUES (1, 2);