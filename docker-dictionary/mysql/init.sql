USE dictionary_builder;
CREATE TABLE dictionaries
(
    dictionary_id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dictionary_name             VARCHAR(30) NOT NULL,
    dictionary_created          DATETIME,
    dictionary_description      VARCHAR(1000),
    parent_dictionary_id        INT,
    CONSTRAINT fk_parent_dictionary FOREIGN KEY (parent_dictionary_id)
        REFERENCES dictionaries (dictionary_id)
);

CREATE TABLE positions
(
    position_id                 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pos_dictionary_id           INT NOT NULL,
    position_name               VARCHAR(50) NOT NULL,
    position_value              VARCHAR(1000),
    dependent_position_id       INT,
    CONSTRAINT fk_dependent_position FOREIGN KEY (dependent_position_id)
        REFERENCES positions (position_id),
    CONSTRAINT fk_position_dictionary FOREIGN KEY (pos_dictionary_id)
        REFERENCES dictionaries (dictionary_id)
);

INSERT INTO dictionaries(dictionary_id, dictionary_name, dictionary_created, dictionary_description, parent_dictionary_id)
VALUES ('1', 'MIASTA', '2023-09-10T10:14:10', 'Miasta województwa dolnośląskiego', null);
INSERT INTO dictionaries(dictionary_id, dictionary_name, dictionary_created, dictionary_description, parent_dictionary_id)
VALUES ('2', 'ULICE', '2023-12-15T12:15:23', 'Ulice miast woj. dolnośl.', '1');

INSERT INTO positions(position_id, pos_dictionary_id, position_name, position_value)
VALUES ('3', '1', 'nazwa miasta', 'Polkowice');
INSERT INTO positions(position_id, pos_dictionary_id, position_name, position_value)
VALUES ('4', '1', 'nazwa miasta', 'Lubin');
INSERT INTO positions(position_id, pos_dictionary_id, position_name, position_value, dependent_position_id)
VALUES ('1', '2', 'nazwa ulicy', 'Malinowa', '3');
INSERT INTO positions(position_id, pos_dictionary_id, position_name, position_value, dependent_position_id)
VALUES ('2', '2', 'nazwa ulicy', 'Szeroka', '4');