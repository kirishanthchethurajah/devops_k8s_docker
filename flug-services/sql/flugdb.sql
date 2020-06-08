USE reservierung;

CREATE TABLE flug
(
  ID INT  NOT NULL AUTO_INCREMENT,
  FLUG_NUMMER VARCHAR(20)  NOT NULL,
  FLUG_BETREIBER VARCHAR(20)  NOT NULL,
  ABREISE_STADT VARCHAR(20)  NOT NULL,
  ANKUNFT_STADT VARCHAR(20)  NOT NULL,
  ABREISE_DATUM DATE  NOT NULL,
  VORAUSSICHTLICHE_FAHRZEIT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
);

CREATE TABLE passagier
(
  ID         INT NOT NULL AUTO_INCREMENT,
  VOR_NAME       VARCHAR(256),
  NACH_NAME    VARCHAR(256),
  ZWEITER_VOR_NAME   VARCHAR(256),
  EMAIL VARCHAR(50),
  TELEFON VARCHAR(10),
  PRIMARY KEY (ID)
);

CREATE TABLE reservierung
(
  ID INT NOT NULL AUTO_INCREMENT,
  CHECKED_IN TINYINT(1),
  ANZAHL_DER_TASCHEN INT,
  PASSAGIER_ID INT,
  FLUG_ID INT,
  CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  FOREIGN KEY (PASSAGIER_ID) REFERENCES passagier(ID) ON DELETE CASCADE,
  FOREIGN KEY (FLUG_ID) REFERENCES reservierung(ID)
);


insert into flug values(1,'AA1','American Airlines','AUS',
'NYC',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 03:14:07');

insert into flug values(2,'AA2','American Airlines','AUS',
'NYC',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 05:14:07');

insert into flug values(3,'AA3','American Airlines','AUS',
'NYC',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 06:14:07');

insert into flug values(4,'SW1','South West','AUS',
'NYC',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 07:14:07');

insert into flug values(5,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 10:14:07');

insert into flug values(6,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('02-05-2020', '%m-%d-%Y'),'2020-02-05 10:14:07');

insert into flug values(7,'SW1','South West','AUS',
'NYC',STR_TO_DATE('02-06-2020', '%m-%d-%Y'),'2020-02-06 07:14:07');

insert into flug values(8,'SW2','South West','AUS',
'NYC',STR_TO_DATE('02-06-2020', '%m-%d-%Y'),'2020-02-06 08:14:07');

insert into flug values(9,'SW3','South West','NYC',
'DAL',STR_TO_DATE('02-06-2020', '%m-%d-%Y'),'2020-02-06 10:14:07');

insert into flug values(10,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('02-06-2020', '%m-%d-%Y'),'2020-02-06 10:14:07');
