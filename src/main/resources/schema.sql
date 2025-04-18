CREATE TABLE IF NOT EXISTS USER(
    ID INT AUTO_INCREMENT NOT NULL,
    USERNAME VARCHAR(50) NOT NULL,
    NOM VARCHAR(50) NOT NULL,
    PRENOM VARCHAR(50) NOT NULL,
    REGION VARCHAR(50) NOT NULL,
    VILLE VARCHAR(50) NOT NULL,
    ADRESSE VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    CONSTRAINT USER_PK PRIMARY KEY (ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS PRODUIT(
    ID INT AUTO_INCREMENT NOT NULL,
    NOM VARCHAR(50) NOT NULL,
    DESCRIB VARCHAR(250) NOT NULL,
    PRIX INT NOT NULL,
    ETAT VARCHAR(250) NOT NULL,
    CATEGORIE VARCHAR(20) NOT NULL,
    DATE DATETIME NOT NULL,
    CONSTRAINT PRODUIT_PK PRIMARY KEY (ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS TRANSACTION(
    ID INT AUTO_INCREMENT NOT NULL,
    PRIX_FINAL INT NOT NULL,
    STATUT VARCHAR(50) NOT NULL,
    DATE DATE NOT NULL,
    CONSTRAINT TRANSACTION_PK PRIMARY KEY (ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS COMMENTS(
    ID INT AUTO_INCREMENT NOT NULL,
    NOTE INT NOT NULL,
    CONSTRAINT COMMENTS_PK PRIMARY KEY (ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS VENDRE_ACHETER(
    ID INT NOT NULL,
    ID_USER INT NOT NULL,
    CONSTRAINT VENDRE_ACHETER_PK PRIMARY KEY (ID, ID_USER),
    CONSTRAINT VENDRE_ACHETER_PRODUIT_FK FOREIGN KEY (ID) REFERENCES TRANSACTION(ID),
    CONSTRAINT VENDRE_ACHETER_USER_FK FOREIGN KEY (ID_USER) REFERENCES USER(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS PARTICIPE(
    ID INT NOT NULL,
    ID_USER INT NOT NULL,
    CONSTRAINT PARTICIPE_PK PRIMARY KEY (ID, ID_USER),
    CONSTRAINT PARTICIPE_TRANSACTION_FK FOREIGN KEY (ID) REFERENCES TRANSACTION(ID),
    CONSTRAINT PARTICIPE_USER_FK FOREIGN KEY (ID_USER) REFERENCES USER(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS COMMENTER(
    ID INT NOT NULL,
    ID_USER INT NOT NULL,
    CONSTRAINT COMMENTER_PK PRIMARY KEY (ID, ID_USER),
    CONSTRAINT COMMENTER_COMMENTS_FK FOREIGN KEY (ID) REFERENCES COMMENTS(ID),
    CONSTRAINT COMMENTER_USER_FK FOREIGN KEY (ID_USER) REFERENCES USER(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS CONTENIR(
    ID INT NOT NULL,
    ID_PRODUIT INT NOT NULL,
    CONSTRAINT CONTENIR_PK PRIMARY KEY (ID, ID_PRODUIT),
    CONSTRAINT CONTENIR_COMMENTS_FK FOREIGN KEY (ID) REFERENCES COMMENTS(ID),
    CONSTRAINT CONTENIR_PRODUIT_FK FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS IMPLIQUER(
    ID INT NOT NULL,
    ID_PRODUIT INT NOT NULL,
    CONSTRAINT IMPLIQUER_PK PRIMARY KEY (ID, ID_PRODUIT),
    CONSTRAINT IMPLIQUER_TRANSACTION_FK FOREIGN KEY (ID) REFERENCES TRANSACTION(ID),
    CONSTRAINT IMPLIQUER_PRODUIT_FK FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS DISCUSSION (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TITRE VARCHAR(20) NOT NULL,
    AUTEUR_ID INT NOT NULL,
    DATE_DERNIER_MESSAGE DATETIME,
    CONSTRAINT DISCUSSION_USER_FK FOREIGN KEY (AUTEUR_ID) REFERENCES USER(ID)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS MESSAGE (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CONTENU TEXT NOT NULL,
    DATE_ENVOI DATETIME NOT NULL,
    AUTEUR_ID INT NOT NULL,
    DISCUSSION_ID INT NOT NULL,
    CONSTRAINT MESSAGE_USER_FK FOREIGN KEY (AUTEUR_ID) REFERENCES USER(ID),
    CONSTRAINT MESSAGE_DISCUSSION_FK FOREIGN KEY (DISCUSSION_ID) REFERENCES DISCUSSION(ID)
) ENGINE=INNODB;
