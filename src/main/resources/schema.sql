CREATE TABLE `User` (
  `userId` int PRIMARY KEY,
  `phoneNumber` varchar(255),
  `activePlan` varchar(255),
  `pastPlan` varchar(255),
  `planExpiry` varchar(255),
  `email` varchar(255)
);

CREATE TABLE `Plan` (
  `planId` int PRIMARY KEY,
  `planName` varchar(255),
  `price` int,
  `planDuration` varchar(255)
);

CREATE TABLE `PlanDetails` (
  `planId` int PRIMARY KEY,
  `planName` varchar(255),
  `price` int,
  `planDuration` varchar(255),
  `benefits` varchar(255)
);

CREATE TABLE `ActivePlan` (
  `activeId` int PRIMARY KEY,
  `planId` int,
  `userId` int,
  `createdDate` date,
  `expiryDate` date
);

CREATE TABLE `PastPlan` (
  `pastId` int PRIMARY KEY,
  `planId` int,
  `userId` int,
  `createdDate` date,
  `expiryDate` date
);

CREATE TABLE `Bill` (
  `planId` int PRIMARY KEY,
  `planName` varchar(255),
  `cardHolderName` varchar(255),
  `expiryDate` date,
  `cvv` int,
  `price` int,
  `planDuration` varchar(255),
  `benefits` varchar(255)
);

ALTER TABLE `PlanDetails` ADD FOREIGN KEY (`planId`) REFERENCES `Plan` (`planId`);

ALTER TABLE `Bill` ADD FOREIGN KEY (`planId`) REFERENCES `PlanDetails` (`planId`);

ALTER TABLE `ActivePlan` ADD FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

ALTER TABLE `PastPlan` ADD FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

ALTER TABLE `PastPlan` ADD FOREIGN KEY (`planId`) REFERENCES `PlanDetails` (`planId`);

ALTER TABLE `ActivePlan` ADD FOREIGN KEY (`planId`) REFERENCES `PlanDetails` (`planId`);
