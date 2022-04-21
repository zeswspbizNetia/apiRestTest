CREATE TABLE user (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       username varchar(100) NOT NULL,
                       password varchar(100) NOT NULL,
                       email varchar(50) DEFAULT NULL,
                       PRIMARY KEY (id),
                       UNIQUE KEY UK_username (username)
);

CREATE TABLE role (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      name varchar(100) NOT NULL,
                      PRIMARY KEY (id)
);

CREATE TABLE user_roles(
                                     user_id bigint(20) NOT NULL,
                                     role_id bigint(20) NOT NULL,
                                     FOREIGN KEY (user_id) REFERENCES user(id),
                                     FOREIGN KEY (role_id) REFERENCES role(id)
);