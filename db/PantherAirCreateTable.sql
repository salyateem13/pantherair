CREATE TABLE TRAVEL_CLASS (		
TravelClassID	    numeric (4)	        PRIMARY KEY,
Class	            varchar(10)	        NOT NULL
);	

CREATE TABLE FLIGHTS (		
FlightID	        numeric (4) 	    PRIMARY KEY,
AirlineID	        numeric (4) 	    NOT NULL,
ScheduleID	        numeric (4) 	    NOT NULL,
DepartTime	        DATE	            NOT NULL,
ArriveTime 	        DATE 	            NOT NULL
		
);	

CREATE TABLE FLIGHT_SEATS (		
FlightSeatID 	    numeric (4)	    PRIMARY KEY,
FlightID	        numeric (4) 	NOT NULL,
TravelClassID	    numeric (4) 	NOT NULL,
SeatNumber	        numeric (4) 	NOT NULL,
FOREIGN KEY(TravelClassID) REFERENCES TRAVEL_CLASS(TravelClassID),
FOREIGN KEY(FlightID) REFERENCES FLIGHTS(FlightID)
);
		
CREATE TABLE SECURITY_QUESTION (		
SecurityQuestionID	numeric(4)	        PRIMARY KEY,
SecurityQuestion	char(50)	NOT NULL
);	
		
CREATE TABLE USER_TABLE (		
UserID	            numeric (4) 	PRIMARY KEY,
Password  		varchar(20) 	NOT NULL,
UserName	        varchar(20) 	NOT NULL,
FirstName	        varchar(20)	    NOT NULL,
LastName	        varchar(20)	    NOT NULL,
AdddressLine1	    varchar(50)	    ,
City	            varchar (15) 	,
State	            varchar(10)	   ,
ZipCode	            int 	        ,
Email	            char(30)	    NOT NULL,
SecurityQuestionID	numeric(4)		        NOT NULL,
SecurityQuestionAnswer	char(50)	NOT NULL,
SSN             	int 	          NOT NULL,
isAdmin	            boolean	        NOT NULL,
FOREIGN KEY (SecurityQuestionID) REFERENCES SECURITY_QUESTION (SecurityQuestionID)
);	

CREATE TABLE TICKETS (		
FlightSeatID 	    numeric (4) 	NOT NULL,
UserID	            numeric (4)	    NOT NULL,
CONSTRAINT      ticket_id           PRIMARY KEY(FlightSeatID, UserID),		

 FOREIGN KEY(flightSeatID) REFERENCES FLIGHT_SEATS(flightSeatID),		

FOREIGN KEY(UserID) REFERENCES USER_TABLE(userID) );