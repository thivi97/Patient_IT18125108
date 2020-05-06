CREATE TABLE `appointment` (
  `appointmentid` varchar(20) NOT NULL,
  `doctorid` varchar(25) NOT NULL,
  `doctorname` varchar(25) NOT NULL,
  `patientid` varchar(25) NOT NULL,
  `patientname` varchar(25) NOT NULL,
  `hospitalname` varchar(25) NOT NULL,
  `date` varchar(15) NOT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `patient` (
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `patient` (`firstName`, `lastName`, `age`, `gender`, `email`, `address`, `phoneNumber`, `username`, `password`) VALUES ('vinojan', 'paskaran', '24', 'Female', 'vino@gmail.com', 'dehiwala', '0771930932', 'vino', 'ranger');
INSERT INTO `patient` (`firstName`, `lastName`, `age`, `gender`, `email`, `address`, `phoneNumber`, `username`, `password`) VALUES ('vethakulan', 'aananthakumar', '24', 'Male', 'vetha@gmail.com', 'ebanazer lane', '0773401278', 'kulan', 'vijayveriyan');


INSERT INTO `appointment` (`appointmentid`, `doctorid`, `doctorname`, `patientid`, `patientname`, `hospitalname`, `date`) VALUES ('ap101', 'doc01', 'suntharesh', 'pat04', 'washington', 'nawaloka', '12-Mar-2020');
INSERT INTO `appointment` (`appointmentid`, `doctorid`, `doctorname`, `patientid`, `patientname`, `hospitalname`, `date`) VALUES ('ap102', 'doc03', 'janani', 'pat05', 'nusry', 'durdans', '12-Jul-2020');