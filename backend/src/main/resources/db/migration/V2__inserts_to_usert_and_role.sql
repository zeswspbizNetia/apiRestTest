
INSERT INTO role VALUES (1, 'ROLE_ADMIN');
INSERT INTO role VALUES (2, 'ROLE_USER');
INSERT INTO role VALUES (3, 'ROLE_MODERATOR');

INSERT INTO user(id, username, password, email) VALUES (1, 'admin', '$2a$10$3PxK.dnO7N3HNyGC.IQE7O1cMfduoBCt3NeDF8dGq1BCzGRrm5Tpe', 'admin@netia.pl');
INSERT INTO user(id, username, password, email) VALUES (2, 'user1', '$2a$10$3PxK.dnO7N3HNyGC.IQE7O1cMfduoBCt3NeDF8dGq1BCzGRrm5Tpe', 'user1@netia.pl');
INSERT INTO user(id, username, password, email) VALUES (3, 'user2', '$2a$10$3PxK.dnO7N3HNyGC.IQE7O1cMfduoBCt3NeDF8dGq1BCzGRrm5Tpe', 'user2@netia.pl');

INSERT INTO user_roles(user_id, role_id) VALUES ((SELECT id from user where username = 'admin'), (SELECT id from role where name = 'ROLE_ADMIN'));
INSERT INTO user_roles(user_id, role_id) VALUES ((SELECT id from user where username = 'user1'), (SELECT id from role where name = 'ROLE_USER'));
INSERT INTO user_roles(user_id, role_id) VALUES ((SELECT id from user where username = 'user2'), (SELECT id from role where name = 'ROLE_MODERATOR'));

