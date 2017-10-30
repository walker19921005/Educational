CREATE TABLE T_USER (
  USER_ID NUMBER NOT NULL,
  USERNAME VARCHAR2(50) NOT NULL,
  PASSWORD VARCHAR2(200) NOT NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  EMAIL VARCHAR2(200) NOT NULL,
  DEPTID NUMBER NULL,
  SALT VARCHAR2(255) NULL,
  LOCKED NUMBER(1) NULL,
  PRIMARY KEY (USER_ID)
);

CREATE TABLE USER_STUDENT (
  STU_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  STU_NAME VARCHAR2(50) NULL,
  SEX NUMBER(1) NULL,
  STU_IPHONE VARCHAR2(20) NULL,
  STU_PHONE VARCHAR2(20) NULL,
  STU_ADDRESS VARCHAR2(200) NULL,
  STU_BIRTHDAY DATE NULL,
  ENROLDATE DATE NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  LINKMAN VARCHAR2(50) NULL,
  LINKMAN_IPHONE VARCHAR2(20) NULL,
  GRADUATEDATE DATE NULL,
  ICON VARCHAR2(255) NULL,
  CLASSID NUMBER NULL,
  PRIMARY KEY (STU_ID)
);

CREATE TABLE T_EXAMINE (
  EX_ID NUMBER NOT NULL,
  EX_COURSE VARCHAR2(50) NULL,
  CONID NUMBER NULL,
  EX_SCORE NUMBER(4) NULL,
  TEACHID NUMBER NULL,
  REGITNAME VARCHAR2(255) NULL,
  REGITDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  DEL_FLAG NUMBER(1) NULL,
  STUID NUMBER NULL,
  REMARK VARCHAR2(500) NULL,
  PRIMARY KEY (EX_ID)
);

CREATE TABLE EXAMINE_CONTENT (
  CON_ID NUMBER NOT NULL,
  CON_TYPE VARCHAR2(50) NULL,
  CON_SCORE NUMBER NULL,
  TOTALSCORE NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  REMARK VARCHAR2(500) NULL,
  PRIMARY KEY (CON_ID)
);

CREATE TABLE T_PROGRAMME (
  PRO_ID NUMBER NOT NULL,
  PRO_NAME VARCHAR2(50) NULL,
  PRO_STARTTIME DATE NULL,
  PRO_ENDTIME DATE NULL,
  USERID NUMBER NULL,
  PRO_CHARGE NUMBER NULL,
  PRO_STATUS NUMBER(1) NULL,
  PRO_CONTENT VARCHAR2(500) NULL,
  PRO_TYPEID NUMBER(2) NULL,
  PRO_PUBLISHERID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (PRO_ID)
);

CREATE TABLE T_PROGRAMME_TYPE (
  TYPE_ID NUMBER NOT NULL,
  PROTYPE_NAME VARCHAR2(100) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NOT NULL,
  PRIMARY KEY (TYPE_ID)
);

CREATE TABLE USER_TEACHER (
  TEACH_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  TEACH_NAME VARCHAR2(50) NULL,
  TEACH_AGE NUMBER(3) NULL,
  SEX NUMBER(1) NULL,
  TEACH_ADDRESS VARCHAR2(200) NULL,
  TEACH_IPHONE VARCHAR2(100) NULL,
  TEACH_DESC VARCHAR2(200) NULL,
  ENTRYDATE DATE NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  TEACH_BIRTHDAY DATE NULL,
  ICON VARCHAR2(255) NULL,
  PRIMARY KEY (TEACH_ID)
);

CREATE TABLE T_TEACHER_STAGE (
  ID NUMBER NOT NULL,
  TEACHID NUMBER NULL,
  STAGEID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE T_CLASSES (
  CLASS_ID NUMBER NOT NULL,
  CLASS_NAME VARCHAR2(50) NULL,
  STAGEID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (CLASS_ID)
);

CREATE TABLE T_TEACHER_CLASSES (
  ID NUMBER NOT NULL,
  TEACHID NUMBER NULL,
  CLASSID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE T_DICTIONARY (
  DIC_ID NUMBER NOT NULL,
  DIC_TYPE VARCHAR2(100) NULL,
  DIC_NAME VARCHAR2(100) NULL,
  DIC_REF VARCHAR2(100) NULL,
  DIC_VALUE VARCHAR2(100) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (DIC_ID)
);

CREATE TABLE STAGE_COURSE (
  COURSE_ID NUMBER NOT NULL,
  COURSE_NAME VARCHAR2(50) NULL,
  STAGEID NUMBER NULL,
  COURSE_DAYS NUMBER(3) NULL,
  COURSE_DESC VARCHAR2(100) NULL,
  TEACHID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (COURSE_ID)
);

CREATE TABLE T_STAGE (
  STAGE_ID NUMBER NOT NULL,
  STAGE_NAME VARCHAR2(50) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (STAGE_ID)
);

CREATE TABLE USER_TIME_CARD (
  TCARD_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  STARTTIME DATE NULL,
  ENDTIME DATE NULL,
  TCARD_STATUS NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (TCARD_ID)
);

CREATE TABLE T_WORK_TIME (
  WORK_ID NUMBER NOT NULL,
  STARTTIME_AM DATE NULL,
  ENDTIME_AM DATE NULL,
  STARTTIME_PM DATE NULL,
  ENDTIME_PM DATE NULL,
  MONTH NUMBER(1) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (WORK_ID)
);

CREATE TABLE USER_LEAVE (
  LEAVE_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  STARTTIME DATE NULL,
  ENDTIME DATE NULL,
  TOTALTIME NVARCHAR2(20) NULL,
  CAUSE VARCHAR2(200) NULL,
  STATUS NUMBER(1) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (LEAVE_ID)
);

CREATE TABLE USER_OVER_TIME (
  OVER_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  STARTTIME DATE NULL,
  ENDTIME DATE NULL,
  TOTALTIME NVARCHAR2(20) NULL,
  CAUSE VARCHAR2(200) NULL,
  STATUS NUMBER(1) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (OVER_ID)
);

CREATE TABLE STU_JOB (
  JOB_ID NUMBER NOT NULL,
  STUID NUMBER NULL,
  ENTRY DATE NULL,
  GRADUATE_SCORE NUMBER(5,2) NULL,
  COMPANY VARCHAR2(50) NULL,
  SALARY NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (JOB_ID)
);

CREATE TABLE USER_WORK_DAILY (
  DAILY_ID NUMBER NOT NULL,
  USERID NUMBER NULL,
  DAILY_NAME VARCHAR2(20) NULL,
  DAILY_CONTENT VARCHAR2(1000) NULL,
  DAILY_DATE DATE NULL,
  DAILY_TYPE NUMBER(1) NULL,
  DAILY_FILE VARCHAR2(255) NULL,
  CREATENAME VARCHAR2(255) NULL,
  CREATEDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (DAILY_ID)
);

CREATE TABLE T_ROLE (
  ROLE_ID NUMBER NOT NULL,
  ROLE_NAME VARCHAR2(50) NULL,
  ROLE_DESC VARCHAR2(200) NULL,
  PARENTID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  ENABLE NUMBER(1) NULL,
  PRIMARY KEY (ROLE_ID)
);

CREATE TABLE USER_DEPARTMENT (
  DEPT_ID NUMBER NOT NULL,
  DEPT_NAME VARCHAR2(50) NULL,
  DEPT_DESC VARCHAR2(100) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYNAME NVARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (DEPT_ID)
);

CREATE TABLE T_ROLE_USER (
  ID NUMBER NOT NULL,
  ROLEID NUMBER NULL,
  USERID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE T_MENU (
  MENU_ID NUMBER NOT NULL,
  MENU_NAME VARCHAR2(50) NULL,
  PARENTID NUMBER NULL,
  SEQUENCES NUMBER NULL,
  MENU_ICON VARCHAR2(100) NULL,
  MENU_URL VARCHAR2(200) NULL,
  ENABLE NUMBER(1) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (MENU_ID)
);

CREATE TABLE T_ROLE_MENU (
  ID NUMBER NOT NULL,
  ROLEID NUMBER NULL,
  MENUID NUMBER NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE CLASS_STAGE (
  ID NUMBER NOT NULL,
  STAGEID NUMBER NULL,
  CLASSID NUMBER NULL,
  STARTTIME DATE NULL,
  ENDTIME DATE NULL,
  DAYS NUMBER(3) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE T_NOTICE (
  NOTICE_ID NUMBER NOT NULL,
  NOTICE_TITLE VARCHAR2(100) NULL,
  NOTICE_CONTENT VARCHAR2(500) NULL,
  CREATEDATE DATE NULL,
  CREATENAME VARCHAR2(255) NULL,
  MODIFYDATE DATE NULL,
  MODIFYNAME VARCHAR2(255) NULL,
  DEL_FLAG NUMBER(1) NULL,
  NOTICE_TYPE NUMBER(1) NULL,
  USERID NUMBER NULL,
  PRIMARY KEY (NOTICE_ID)
);


ALTER TABLE USER_TIME_CARD ADD CONSTRAINT FK_USER_TIME_CARD_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE USER_WORK_DAILY ADD CONSTRAINT FK_USER_WORK_DAILY_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE T_NOTICE ADD CONSTRAINT FK_T_NOTICE_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE USER_OVER_TIME ADD CONSTRAINT FK_USER_OVER_TIME_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE T_PROGRAMME ADD CONSTRAINT FK_T_PROGRAMME_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE T_PROGRAMME ADD CONSTRAINT FK_T_PROGRAMME_T_USER_2 FOREIGN KEY (PRO_PUBLISHERID) REFERENCES T_USER (USER_ID);
ALTER TABLE USER_LEAVE ADD CONSTRAINT FK_USER_LEAVE_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE USER_STUDENT ADD CONSTRAINT FK_USER_STUDENT_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE USER_TEACHER ADD CONSTRAINT FK_USER_TEACHER_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE STU_JOB ADD CONSTRAINT FK_STU_JOB_USER_STUDENT_1 FOREIGN KEY (STUID) REFERENCES USER_STUDENT (STU_ID);
ALTER TABLE USER_STUDENT ADD CONSTRAINT FK_USER_STUDENT_T_CLASSES_1 FOREIGN KEY (CLASSID) REFERENCES T_CLASSES (CLASS_ID);
ALTER TABLE T_USER ADD CONSTRAINT FK_T_USER_USER_DEPARTMENT_1 FOREIGN KEY (DEPTID) REFERENCES USER_DEPARTMENT (DEPT_ID);
ALTER TABLE T_ROLE_USER ADD CONSTRAINT FK_T_ROLE_USER_T_USER_1 FOREIGN KEY (USERID) REFERENCES T_USER (USER_ID);
ALTER TABLE T_ROLE_MENU ADD CONSTRAINT FK_T_ROLE_MENU_T_MENU_1 FOREIGN KEY (MENUID) REFERENCES T_MENU (MENU_ID);
ALTER TABLE T_PROGRAMME ADD CONSTRAINT FK_PROGRA_PROGRA_TYPE_1 FOREIGN KEY (PRO_TYPEID) REFERENCES T_PROGRAMME_TYPE (TYPE_ID);
ALTER TABLE T_EXAMINE ADD CONSTRAINT FK_T_EXAMINE_EXAMINE_CONTENT_1 FOREIGN KEY (CONID) REFERENCES EXAMINE_CONTENT (CON_ID);
ALTER TABLE T_TEACHER_STAGE ADD CONSTRAINT FK_T_TEACHER_STAGE_T_STAGE_1 FOREIGN KEY (STAGEID) REFERENCES T_STAGE (STAGE_ID);
ALTER TABLE CLASS_STAGE ADD CONSTRAINT FK_CLASS_STAGE_T_STAGE_1 FOREIGN KEY (STAGEID) REFERENCES T_STAGE (STAGE_ID);
ALTER TABLE STAGE_COURSE ADD CONSTRAINT FK_STAGE_COURSE_T_STAGE_1 FOREIGN KEY (STAGEID) REFERENCES T_STAGE (STAGE_ID);
ALTER TABLE T_ROLE_MENU ADD CONSTRAINT FK_T_ROLE_MENU_T_ROLE_1 FOREIGN KEY (ROLEID) REFERENCES T_ROLE (ROLE_ID);
ALTER TABLE T_ROLE_USER ADD CONSTRAINT FK_T_ROLE_USER_T_ROLE_1 FOREIGN KEY (ROLEID) REFERENCES T_ROLE (ROLE_ID);
ALTER TABLE T_EXAMINE ADD CONSTRAINT FK_T_EXAMINE_USER_STUDENT_1 FOREIGN KEY (STUID) REFERENCES USER_STUDENT (STU_ID);
ALTER TABLE CLASS_STAGE ADD CONSTRAINT FK_CLASS_STAGE_T_CLASSES_1 FOREIGN KEY (CLASSID) REFERENCES T_CLASSES (CLASS_ID);
ALTER TABLE T_CLASSES ADD CONSTRAINT FK_T_CLASSES_T_STAGE_1 FOREIGN KEY (STAGEID) REFERENCES T_STAGE (STAGE_ID);
ALTER TABLE T_TEACHER_CLASSES ADD CONSTRAINT FK_TEAC_CLAS_USER_TEAC_1 FOREIGN KEY (TEACHID) REFERENCES USER_TEACHER (TEACH_ID);
ALTER TABLE T_TEACHER_CLASSES ADD CONSTRAINT FK_TEAC_CLAS_CLAS_1 FOREIGN KEY (CLASSID) REFERENCES T_CLASSES (CLASS_ID);
ALTER TABLE T_EXAMINE ADD CONSTRAINT FK_T_EXAMINE_USER_TEACHER_1 FOREIGN KEY (TEACHID) REFERENCES USER_TEACHER (TEACH_ID);
ALTER TABLE T_TEACHER_STAGE ADD CONSTRAINT FK_TEAC_STAGE_USER_TEAC_1 FOREIGN KEY (TEACHID) REFERENCES USER_TEACHER (TEACH_ID);
ALTER TABLE T_PROGRAMME ADD CONSTRAINT FK_T_PROGRAMME_T_USER_3 FOREIGN KEY (PRO_CHARGE) REFERENCES T_USER (USER_ID);

CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE ROLE_USER_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE ROLE_MENU_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE role_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE teacher_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;
CREATE SEQUENCE dept_seq START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE NOMAXVALUE ;

INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (1, '人员管理', 0, 1, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (11, '教师管理', 1, 11, null, '/user/teacher', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (12, '学生管理', 1, 12, null, '/user/student', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (2, '教学管理', 0, 2, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (21, '班级管理', 2, 21, null, '/edu/class', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (22, '成绩管理', 2, 22, null, '/edu/score', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (23, '课程管理', 2, 23, null, '/edu/course', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (3, '就业管理', 0, 3, null, '/job/job', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (4, '个人管理', 0, 4, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (41, '日程安排', 4, 41, null, '/plan/schedule', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (42, '任务管理', 4, 42, null, '/plan/task', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (43, '报告管理', 4, 43, null, '/plan/report', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (5, '流程管理', 0, 5, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (6, '报表管理', 0, 6, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (61, '考核报表', 6, 61, null, '/state/examine', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (62, '考勤报表', 6, 62, null, '/state/atten', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (7, '系统设置', 0, 7, null, null, 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (71, '公告管理', 7, 71, null, '/sys/notice', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (72, '角色管理', 7, 72, null, '/sys/role', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (73, '菜单管理', 7, 73, null, '/sys/menu', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (74, '字典管理', 7, 74, null, '/sys/dict', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (51, '加班流程', 5, 51, null, '/flow/overtime', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (52, '请假流程', 5, 52, null, '/flow/leave', 1, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_MENU (MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (53, '考勤管理', 5, 53, null, '/flow/atten', 1, null, null, null, null, null);

INSERT INTO EDUMANAGER.T_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, ENABLE) VALUES (1, 'admin', '超级管理员', 0, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO EDUMANAGER.T_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, ENABLE) VALUES (2, 'normal', '普通管理员', 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO EDUMANAGER.T_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, ENABLE) VALUES (3, 'teacher', '教师', 2, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO EDUMANAGER.T_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, ENABLE) VALUES (4, 'student', '学生', 3, NULL, NULL, NULL, NULL, NULL, 1);

INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (1, 1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (2, 1, 11, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (3, 1, 12, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (4, 1, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (5, 1, 21, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (6, 1, 22, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (7, 1, 23, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (8, 1, 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (9, 1, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (10, 1, 41, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (11, 1, 42, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (12, 1, 43, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (13, 1, 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (14, 1, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (15, 1, 61, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (16, 1, 62, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (17, 1, 7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (18, 1, 71, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (19, 1, 72, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (20, 1, 73, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (21, 1, 74, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (22, 1, 51, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (23, 1, 52, null, null, null, null, null);
INSERT INTO EDUMANAGER.T_ROLE_MENU (ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG) VALUES (24, 1, 53, null, null, null, null, null);

