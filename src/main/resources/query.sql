use code;
drop table Feedback;

CREATE TABLE Feedback (
feedbackID integer auto_increment primary key,
feedback smallint not null,
comments text not null,
dateOfFeedback datetime not null,
chatbotName varchar(100),
givenBy varchar(40) not null
);

INSERT INTO `code`.`feedback` (`feedbackID`,`feedback`,`comments`,`dateOfFeedback`,`chatbotName`) VALUES (1,5,'Good',sysdate(),null);
INSERT INTO `code`.`feedback` (`feedbackID`,`feedback`,`comments`,`dateOfFeedback`,`chatbotName`) VALUES (2,1,'Bad',sysdate(),null);
select * from feedback;

CREATE TABLE Policy (
policyID integer auto_increment primary key,
pName varchar(100) not null,
pDescription text not null
);

drop table Policy;
insert into Policy values (1,'Health Insurance Policy','Health Insurance Policy');
insert into Policy values (2,'Children Education Policy','Children Education Policy');
insert into Policy values (3,'Car Insurance Policy','Car Insurance Policy');
insert into Policy values (4,'Life Insurance Policy','Life Insurance Policy');

select * from policy;

CREATE TABLE userDetails (
userID integer auto_increment primary key,
username varchar(40) not null,
address text not null,
dateOfBirth date not null,
phonenumber numeric(10)
);

drop table userDetails;

INSERT INTO `code`.`userdetails`(`userID`,`username`,`address`,`dateOfBirth`,`phonenumber`) VALUES 
(1,'Debjyoti','Asansol','1996-10-09',8436476635);
INSERT INTO `code`.`userdetails`(`userID`,`username`,`address`,`dateOfBirth`,`phonenumber`) VALUES 
(2,'Jagdish','Chandil','1995-01-05',8436476635);

CREATE TABLE policyTakenDetails (
policyTakenID integer auto_increment primary key,
policyID int not null,
policyAmount int not null,
premiumType tinyint not null,
premiumAmount int not null,
premiumDate date not null,
startDate date not null,
endDate date not null,
tenure smallint,
FOREIGN KEY fkPol(policyID)
   REFERENCES Policy(policyID)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

INSERT INTO `code`.`policytakendetails` (`policyTakenID`,`policyID`,`policyAmount`,`premiumType`,`premiumAmount`,`premiumDate`,
`startDate`,`endDate`,`tenure`) VALUES (1,1,8400000,1,20000,'2019-07-15','2019-06-15','2054-06-15',420);
INSERT INTO `code`.`policytakendetails` (`policyTakenID`,`policyID`,`policyAmount`,`premiumType`,`premiumAmount`,`premiumDate`,
`startDate`,`endDate`,`tenure`) VALUES (2,1,8400000,1,20000,'2019-07-15','2019-06-15','2054-06-15',420);
INSERT INTO `code`.`policytakendetails` (`policyTakenID`,`policyID`,`policyAmount`,`premiumType`,`premiumAmount`,`premiumDate`,
`startDate`,`endDate`,`tenure`) VALUES (3,2,8400000,1,20000,'2019-07-15','2019-06-15','2054-06-15',420);
INSERT INTO `code`.`policytakendetails` (`policyTakenID`,`policyID`,`policyAmount`,`premiumType`,`premiumAmount`,`premiumDate`,
`startDate`,`endDate`,`tenure`) VALUES (4,4,8400000,1,20000,'2019-07-15','2019-06-15','2054-06-15',420);
INSERT INTO `code`.`policytakendetails` (`policyTakenID`,`policyID`,`policyAmount`,`premiumType`,`premiumAmount`,`premiumDate`,
`startDate`,`endDate`,`tenure`) VALUES (5,3,8400000,1,20000,'2019-07-15','2019-06-15','2054-06-15',420);

select * from policytakendetails;

CREATE TABLE userPolicyMapping (
  `userID` int NOT NULL,
  `policyTakenID` int NOT NULL,
  PRIMARY KEY (`userID`,`policyTakenID`),
  CONSTRAINT `fk1` 
   FOREIGN KEY (`userID`) REFERENCES `userDetails` (`userID`),
  CONSTRAINT `fk2` 
   FOREIGN KEY (`policyTakenID`) REFERENCES `policyTakenDetails` (`policyTakenID`)
);

INSERT INTO `code`.`userpolicymapping` (`userID`,`policyTakenID`) VALUES (1,1);
INSERT INTO `code`.`userpolicymapping` (`userID`,`policyTakenID`) VALUES (1,2);
INSERT INTO `code`.`userpolicymapping` (`userID`,`policyTakenID`) VALUES (1,3);
INSERT INTO `code`.`userpolicymapping` (`userID`,`policyTakenID`) VALUES (2,4);
INSERT INTO `code`.`userpolicymapping` (`userID`,`policyTakenID`) VALUES (2,1);

drop table transactionDetails;
CREATE TABLE transactionDetails (
transactionID integer auto_increment primary key,
policyTakenID int not null,
userID int not null,
transactionDate date not null,
transactionAmount int not null,
FOREIGN KEY fkPolTaken(policyTakenID)
   REFERENCES policyTakenDetails(policyTakenID)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,
FOREIGN KEY fkUser(userID)
   REFERENCES userDetails(userID)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

INSERT INTO `code`.`transactiondetails`(`transactionID`,`policyTakenID`,`userID`,`transactionDate`,`transactionAmount`) VALUES
(1,1,1,'2019-07-07',20000);
