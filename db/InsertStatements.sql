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


#Travel Class
INSERT INTO TRAVEL_CLASS (TravelClassID, Class)
VALUES (1001, "Economy ");

INSERT INTO TRAVEL_CLASS (TravelClassID, Class)
VALUES (1002, "Business");

#Flight Schedules
INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2001, "Atlanta", "Charleston") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2002, "Atlanta", "Charlotte") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2003, "Atlanta", "D.C.") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2004, "Atlanta", "Nashville") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2005, "Atlanta", "New York") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2006, "Atlanta", "Lexington") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2007, "Charleston", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2008, "Charlotte", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2009, "D.C.", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2010, "Nashville", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2011, "New York", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2012,  "Lexington", "Atlanta") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2013, "Charlotte", "New York") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2014, "New York", "Charlotte") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2015,  "Lexington", "D.C.") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2016, "Nashville", "Lexington") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2017, "New York", "D.C.") ;

INSERT INTO FLIGHT_SCHEDULE ( ScheduleID, origin, destination)
VALUES (2018,  "Lexington", "Atlanta") ;


#FLIGHTS
INSERT INTO Flights ( ScheduleID, DepartDate )
VALUES ( 2018, DATE '2018-12-02' );

INSERT INTO FLIGHT_SEATS (FlightID, TravelClassID, SeatNumber)
VALUES ( 3, 1001, 1);


