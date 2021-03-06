DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS GROUPS;
DROP TABLE IF EXISTS APPLICATIONS;
DROP TABLE IF EXISTS TASKS;

CREATE TABLE EMPLOYEE(
    EMP_ID INTEGER,
    CID VARCHAR(255) ,
    EMP_NAME VARCHAR(255) ,
    ACCESS VARCHAR DEFAULT 'A',
    GROUP_ID VARCHAR(255),
    MAINT_ID INTEGER ,
    MAINT_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),

    PRIMARY KEY (EMP_ID)

);

CREATE TABLE GROUPS(
   GROUP_ID VARCHAR(255) NOT NULL,
   GROUP_NAME VARCHAR(255) NOT NULL,
   MAINT_ID INTEGER NOT NULL,
   MAINT_TS TIMESTAMP NOT NULL,

   PRIMARY KEY (GROUP_ID)

);

CREATE TABLE APPLICATIONS(
     APP_NAME VARCHAR(255) NULL,
     MANAGER_NAME VARCHAR NOT NULL ,
     AREA VARCHAR NOT NULL ,
     MAINT_ID INTEGER NOT NULL ,
     MAINT_TS TIMESTAMP NOT NULL ,

     PRIMARY KEY (APP_NAME)
);

CREATE TABLE TASKS(
      APP_NAME VARCHAR NOT NULL,
      GROUP_ID VARCHAR NOT NULL,
      INCIDENT_ID VARCHAR  NOT NULL,
      INCIDENT_TYPE varchar CHECK (INCIDENT_TYPE = 'L2' OR INCIDENT_TYPE = 'L3' OR INCIDENT_TYPE = 'Maint' OR INCIDENT_TYPE = 'SR' OR INCIDENT_TYPE = 'Enhancement-Minor' OR INCIDENT_TYPE = 'Enhancement-Major' OR INCIDENT_TYPE = 'Project Management' OR INCIDENT_TYPE = 'NA'),
      SUMMARY VARCHAR NULL,
      EMP_ID INTEGER NOT NULL,
      SUBMIT_DATE TIMESTAMP NOT NULL,
      CLOSED_DATE TIMESTAMP NOT NULL,
      IMPACT VARCHAR(100) CHECK (impact = 'LOW' OR impact = 'MEDIUM' OR impact = 'HIGH'),
      RESOLUTION VARCHAR NOT NULL,
      RES_CATE_TIER_1 VARCHAR(100) DEFAULT 'Application Sustainment',
      STATUS VARCHAR(100) NOT NULL,
      RESPONDED_DATE TIMESTAMP NOT NULL,
      RES_CATE_TIER_3 VARCHAR(255) CHECK( RES_CATE_TIER_3 = 'Testing Support' OR RES_CATE_TIER_3 = 'Data Fix' OR RES_CATE_TIER_3 = 'Code Change' OR RES_CATE_TIER_3 = 'Analysis'),
      TARGET_DATE TIMESTAMP NOT NULL,
      MAINT_ID INTEGER NOT NULL,
      MAINT_TS TIMESTAMP NOT NULL,

      PRIMARY KEY (INCIDENT_ID)
);
//ALTER TABLE EMPLOYEE ADD FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID);
//ALTER TABLE TASKS ADD CONSTRAINT FK_TASKS_APPLICATIONS FOREIGN KEY (appName) REFERENCES APPLICATIONS(appName);
//ALTER TABLE TASKS ADD CONSTRAINT FK_TASKS_GROUPS FOREIGN KEY (groupId) REFERENCES GROUPS(groupId);
//ALTER TABLE TASKS ADD CONSTRAINT FK_TASKS_EMPLOYEE FOREIGN KEY (groupId) REFERENCES EMPLOYEE(empId)

