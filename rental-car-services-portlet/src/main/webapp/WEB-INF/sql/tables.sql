create table RC_Car (
	uuid_ VARCHAR(75) null,
	carId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	brand VARCHAR(75) null,
	model VARCHAR(75) null,
	manufacturingYear DATE null,
	fuelType VARCHAR(75) null,
	passengers INTEGER
);