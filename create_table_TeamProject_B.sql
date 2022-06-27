<<<<<<< HEAD
-- 팀프로젝트 
-- 상품 테이블
-- PRODUCT_IMAGE_METADATA : 없음
-- PRODUCT_NUMBER: 시퀀스 없음
CREATE TABLE PRODUCT_B
(
    PRODUCT_NUMBER NUMBER(*, 0) NOT NULL
  , PRODUCT_NAME VARCHAR2(100 BYTE) NOT NULL 
  , PRODUCT_DESCRIPTION VARCHAR2(100 BYTE) NOT NULL 
  , PRODUCT_PRICE NUMBER 
  , PRODUCT_REGISTER_USER NUMBER(*, 0) 
  , PRODUCT_REGISTER_DATE DATE NOT NULL 
  , CONSTRAINT PRODUCT_PK PRIMARY KEY 
    (
      PRODUCT_NUMBER 
    )
);

INSERT INTO PRODUCT_B VALUES (1, '01_theMonaLisa', 'The MonaLisa', null, 01, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (2, '02_theLastSupper', 'the Last Supper', null, 01, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (3, '03_theStarryNight', 'The Starry Night', null, 02, TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (4, '04_theScream', 'The Scream', null, 02, TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (5, '05_guernica', 'Guernica', null, 03, TO_DATE('2022-06-04', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (6, '06_theKiss', 'The Kiss', null, 03, TO_DATE('2022-06-04', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (7, '07_theGirlWithaPearlEarring', 'The Girl With a Pearl Earring', null, 03, TO_DATE('2022-06-05', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (8, '08_theBirth0fVenus', 'The Birth 0f Venus', null, 04, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (9, '09_LasMeninas', 'Las Meninas', null, 04, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (10, '10_theCreationOfAdam', 'The Creation Of Adam', null, 05, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (11, '11_americanGothic', 'American Gothic', null, 05, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (12, '12_LeMatinAuxSaules', 'Le Matin Aux Saules', null, 06, TO_DATE('2022-06-07', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (13, '13_thePersistenceOfMemory', 'The Persistence Of Memory', null, 07, TO_DATE('2022-06-10', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (14, '14_theNightwatch', 'The Nightwatch', null, 07, TO_DATE('2022-06-10', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (15, '15_theGardenOfEarthlyDelights', 'The Garden Of Earthly Delights', null, 07, TO_DATE('2022-06-11', 'YYYY/MM/DD'));

SELECT * FROM PRODUCT_B;
DESC PRODUCT_B;

SELECT PRODUCT_NUMBER, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_REGISTER_USER, 
					PRODUCT_REGISTER_DATE
					FROM PRODUCT_B;
=======
-- 팀프로젝트 
-- 상품 테이블
-- PRODUCT_IMAGE_METADATA : 없음
-- PRODUCT_NUMBER: 시퀀스 없음
CREATE TABLE PRODUCT_B
(
    PRODUCT_NUMBER NUMBER(*, 0) NOT NULL
  , PRODUCT_NAME VARCHAR2(100 BYTE) NOT NULL 
  , PRODUCT_DESCRIPTION VARCHAR2(100 BYTE) NOT NULL 
  , PRODUCT_PRICE NUMBER 
  , PRODUCT_REGISTER_USER NUMBER(*, 0) 
  , PRODUCT_REGISTER_DATE DATE NOT NULL 
  , CONSTRAINT PRODUCT_PK PRIMARY KEY 
    (
      PRODUCT_NUMBER 
    )
);

INSERT INTO PRODUCT_B VALUES (1, '01_theMonaLisa', 'The MonaLisa', null, 01, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (2, '02_theLastSupper', 'the Last Supper', null, 01, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (3, '03_theStarryNight', 'The Starry Night', null, 02, TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (4, '04_theScream', 'The Scream', null, 02, TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (5, '05_guernica', 'Guernica', null, 03, TO_DATE('2022-06-04', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (6, '06_theKiss', 'The Kiss', null, 03, TO_DATE('2022-06-04', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (7, '07_theGirlWithaPearlEarring', 'The Girl With a Pearl Earring', null, 03, TO_DATE('2022-06-05', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (8, '08_theBirth0fVenus', 'The Birth 0f Venus', null, 04, TO_DATE('2022-06-01', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (9, '09_LasMeninas', 'Las Meninas', null, 04, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (10, '10_theCreationOfAdam', 'The Creation Of Adam', null, 05, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (11, '11_americanGothic', 'American Gothic', null, 05, TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (12, '12_LeMatinAuxSaules', 'Le Matin Aux Saules', null, 06, TO_DATE('2022-06-07', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (13, '13_thePersistenceOfMemory', 'The Persistence Of Memory', null, 07, TO_DATE('2022-06-10', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (14, '14_theNightwatch', 'The Nightwatch', null, 07, TO_DATE('2022-06-10', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_B VALUES (15, '15_theGardenOfEarthlyDelights', 'The Garden Of Earthly Delights', null, 07, TO_DATE('2022-06-11', 'YYYY/MM/DD'));

SELECT * FROM PRODUCT_B;
DESC PRODUCT_B;

SELECT PRODUCT_NUMBER, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_REGISTER_USER,
					PRODUCT_REGISTER_DATE FROM PRODUCT_B;
>>>>>>> branch 'kbm31' of https://github.com/syasil/NFTAuctionTeamProject
