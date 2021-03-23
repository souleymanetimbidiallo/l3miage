
DROP TABLE IF EXISTS SERVi;
CREATE TABLE SERVi (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100),
  PRIMARY KEY (id)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS PERSi;
CREATE TABLE PERSi (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  service INT,
  PRIMARY KEY (id),
  FOREIGN KEY (service) REFERENCES SERVi(id)
) ENGINE = InnoDB;


INSERT INTO SERVi (name) VALUES("Accountant");
INSERT INTO SERVi (name) VALUES("Manager HR");
INSERT INTO SERVi (name) VALUES("Executive chief");
INSERT INTO SERVi (name) VALUES("Computer Engineer");
INSERT INTO SERVi (name) VALUES("Doctor");

INSERT INTO PERSi (name, service) VALUES("Pierre", 2);
INSERT INTO PERSi (name, service) VALUES("Nadia", 5);
INSERT INTO PERSi (name, service) VALUES("Mohamed", 4);
INSERT INTO PERSi (name, service) VALUES("Souleymane", 3);
INSERT INTO PERSi (name, service) VALUES("Jean", 1);
INSERT INTO PERSi (name, service) VALUES("Eric", 3);


SELECT * FROM PERSi;
SELECT * FROM SERVi;