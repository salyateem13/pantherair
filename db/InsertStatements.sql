#Insert Security Questions
INSERT INTO SECURITY_QUESTION (SecurityQuestionID, SecurityQuestion)
VALUES (5001, "What is your favorite book?");

INSERT INTO SECURITY_QUESTION (SecurityQuestionID, SecurityQuestion)
VALUES (5002, "What is the name of your pet");

INSERT INTO SECURITY_QUESTION (SecurityQuestionID, SecurityQuestion)
VALUES (5003, "What is the name of yout elementary school?");

#Insert users
INSERT INTO USER_TABLE(UserID, Password, UserName, FirstName, LastName, Email, SecurityQuestionID,SecurityQuestionAnswer, SSN, isAdmin)
VALUES (0001,  "password", "root", "Root", "User", "salyateem@icloud.com", 5001,  "the bird", "274883849", TRUE);

INSERT INTO USER_TABLE(UserID, Password, UserName, FirstName, LastName, Email, SecurityQuestionID,SecurityQuestionAnswer, SSN, isAdmin)
VALUES (0002,  "1234", "samir", "Samir", "Alyateem", "dfwefwef@icloud.com", 5002,  "the worm", "465882374", FALSE);


