
Use sys;
CREATE DATABASE students;
USE students;
CREATE TABLE department (Code_spec INT, Speciality_name VARCHAR(30), Speciality_description VARCHAR (50), PRIMARY KEY(Code_spec));
CREATE TABLE subject (Code_subj INT, Subject_name VARCHAR(30), Subject_description VARCHAR (50), PRIMARY KEY(Code_subj));
CREATE TABLE student (Code_stud INT, Student_name VARCHAR(15), Student_surname VARCHAR(15), Student_middlename VARCHAR(15), PRIMARY KEY(Code_stud));
CREATE TABLE student_info(Code_stud INT, Gender VARCHAR(6), Birthdate DATE, Parents VARCHAR(90), Adress VARCHAR(30), Phone_number INT, FOREIGN KEY(Code_stud) REFERENCES student(Code_stud) ON DELETE CASCADE);
CREATE TABLE student_learn(Code_stud INT, Gradebook_no INT, Addmission_date DATE, group_no VARCHAR(6), Code_spec INT, Learning_form VARCHAR(6),FOREIGN KEY(Code_stud) REFERENCES student(Code_stud) ON DELETE CASCADE);
CREATE TABLE Exam_rating (exam_date DATE, Code_stud INT, Code_subj INT, Rate INT, FOREIGN KEY(Code_stud) REFERENCES student(Code_stud) ON DELETE CASCADE, FOREIGN KEY(Code_subj) REFERENCES subject(Code_subj) ON DELETE CASCADE);

INSERT INTO student(Code_stud, Student_name, Student_surname,Student_middlename)
VALUES(1, 'Andrew', 'Stasiuk', 'Petrovich'),
(2,'Boris','Antoniv','Semenovych'),
(3,'Stepan','Halvin','Andrievych');

INSERT INTO student_info (Code_stud , Gender , Birthdate , Parents , Adress , Phone_number  )
VALUES (1, 'male','1993-07-15', 'Petro Stasiuk Danylovych', 'Lviv , st. Symonenka',0935876897),
(2, 'male','1992-02-14', 'Semen Antoniv Petrovich', 'Ternopil , st. Shevchenka',0975876897),
(3, 'male','1991-05-12', 'Andrii Halavin Dmytrovych', 'Kyiv , st. Volynska',0965876897);

INSERT INTO student_learn (Code_stud, Gradebook_no , Addmission_date , group_no , Code_spec , Learning_form )
VALUES(1, 11, '2007-09-01', 'TE-11', 01, 'day'),
(2, 21, '2007-09-01', 'KH-12', 021, 'day'),
(3, 31, '2007-09-01', 'KI-11', 023, 'day');

INSERT INTO department (Code_spec , Speciality_name , Speciality_description )
VALUES (01,'Energy Systems','Supplie energy'),
(021,'Computer sciense','Programming something new'),
(023, 'Computer Engineering', 'Creating new computers');


 INSERT INTO subject (Code_subj , Subject_name  ,Subject_description )
VALUES (11, 'TOE','Theoretical electricity'),
(12, 'KB','Cyber security'),
(13, 'IT','Innovative technologies');


 INSERT INTO Exam_rating (exam_date, Code_stud, Code_subj , Rate )
 VALUES ('2008-01-18', 1, 11,88),
 ('2008-01-19', 2, 12,76),
 ('2008-03-13', 3, 13,99);






