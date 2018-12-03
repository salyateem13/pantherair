CREATE TABLE TRAVEL_CLASS (		
TravelClassID	    numeric (4)	        PRIMARY KEY,
Class	            varchar(10)	        NOT NULL
);	


CREATE TABLE FLIGHT_SCHEDULE (
ScheduleID	    numeric (4) 		PRIMARY KEY,
origin 			varchar(20)			NOT NULL,
destination	varchar(20) 			NOT NULL

);

CREATE TABLE FLIGHTS (		
FlightID	       int	    NOT NULL AUTO_INCREMENT,
ScheduleID	        numeric (4) 	    NOT NULL,
DepartDate        DATE	            NOT NULL,

PRIMARY KEY (FlightID),
FOREIGN KEY(ScheduleID) REFERENCES FLIGHT_SCHEDULE(ScheduleID)
		
);	

CREATE TABLE FLIGHT_SEATS (		
FlightSeatID 	    int	    NOT NULL AUTO_INCREMENT,
FlightID	        int 	NOT NULL,
TravelClassID	    numeric (4) 	NOT NULL,
SeatNumber	        numeric (4) 	,

PRIMARY KEY(FlightSeatID),
FOREIGN KEY(TravelClassID) REFERENCES TRAVEL_CLASS(TravelClassID),
FOREIGN KEY(FlightID) REFERENCES FLIGHTS(FlightID)
);
		
CREATE TABLE SECURITY_QUESTION (		
SecurityQuestionID	numeric(4)	        PRIMARY KEY,
SecurityQuestion	char(50)	NOT NULL
);	
		
CREATE TABLE USER_TABLE (		
UserID	            int 	NOT NULL AUTO_INCREMENT,
Password  			varchar(20) 	NOT NULL,
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
PRIMARY KEY (UserID),
UNIQUE(UserName),
FOREIGN KEY (SecurityQuestionID) REFERENCES SECURITY_QUESTION (SecurityQuestionID)
);	

CREATE TABLE TICKETS (		
FlightSeatID 	    int	NOT NULL,
UserID	            int	    NOT NULL,
CONSTRAINT      ticket_id           PRIMARY KEY(FlightSeatID, UserID),		

FOREIGN KEY(FlightSeatID) REFERENCES FLIGHT_SEATS(FlightSeatID) ON DELETE CASCADE,		

FOREIGN KEY(UserID) REFERENCES USER_TABLE(UserID) ON DELETE CASCADE
);
