
DROP TABLE IF EXISTS serv;
create table serv(
    id INT AUTO_INCREMENT NOT NULL,
    nom VARCHAR(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS pers ;
create table pers(
    id INT AUTO_INCREMENT NOT NULL,,
    nom VARCHAR(100),
    service INT,
    PRIMARY KEY (id),
    CONSTRAINT FK_serv_pers 
    FOREIGN KEY (service) REFERENCES serv(id)
);

INSERT INTO serv(nom) VALUES ("Commercant");
INSERT INTO serv(nom) VALUES ("Enseignant");
INSERT INTO serv(nom) VALUES ("Mecanicien");
INSERT INTO serv(nom) VALUES ("Tailleur");

INSERT INTO pers(nom, service) VALUES ("Diallo",1);
INSERT INTO pers(nom, service) VALUES ("Mugisha",2);
INSERT INTO pers(nom, service) VALUES ("Sylla",4);
INSERT INTO pers(nom, service) VALUES ("Fofana", 3);
INSERT INTO pers(nom, service) VALUES ("Iradukunda", 4);