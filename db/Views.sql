#View all Users
Select *
From USER_TABLE;


SELECT Password 
FROM USER_TABLE;

SELECT UT.UserID, UserName , SQ.SecurityQuestionID, SecurityQuestion, SecurityQuestionAnswer
FROM USER_TABLE  UT INNER JOIN SECURITY_QUESTION SQ ON UT.SecurityQuestionID = SQ.SecurityQuestionID
GROUP BY UT.UserID, SQ.SecurityQuestionID, SecurityQuestion
HAVING UserName = 'Root';

SELECT Origin
From FLIGHT_SCHEDULE
group by origin;

SELECT destination
From FLIGHT_SCHEDULE
where origin = "New York"
group by destination;

SELECT *
FROM FLIGHTS;

SELECT *
FROM FLIGHT_SCHEDULE;

Select * 
From FLIGHTS
WHERE DepartDate = '2018-12-12' AND ScheduleID = '2005';

SElect *
from FLIGHT_SEATS;

 Select * 
 From FLIGHTS 
 WHERE DepartDate = '2005-11-12';
 
 
SELECT TravelClassID
from TRAVEL_CLASS
where Class LIKE  '%business%'; 

Select fs.FlightSeatID, f.FlightID, tc.TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate
From ((FLIGHT_SEATS fs  INNER JOIN  Flights f ON f.FlightID = fs.FlightID)
			INNER JOIN FLIGHT_SCHEDULE fsh ON f.ScheduleID = fsh.ScheduleID) 
				INNER JOIN TRAVEL_CLASS tc ON fs.TravelClassID= tc.TravelClassID
GROUP BY fs.FlightSeatID, f.FlightID, TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate
HAVING DepartDate = '2018-12-12'
 AND Class LIKE  '%Economy%'
AND origin = 'Atlanta';
