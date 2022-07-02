SET SERVEROUTPUT ON;
-- 팀프로젝트 
-- 상품 테이블

-- 회원 고유번호 증가 시퀀스
CREATE SEQUENCE SEQ_INCREASE_USER_NO
  INCREMENT BY 1
  START WITH 1
  MINVALUE 0
  NOCYCLE
  CACHE 2;

-- 회원테이블  
-- 고유번호,아이디,비번,생일,닉네임,가입일,아이콘
CREATE TABLE USER_T (
  USER_NO NUMBER NOT NULL,
  USER_ID VARCHAR2(100),
  USER_PASS VARCHAR2(20),
  USER_BIR date,
  USER_NICK VARCHAR2(20),
  USER_CREDAY DATE,
  USER_ICON BLOB
);

-- DROP SEQUENCE SEQ_INCREASE_NO;

INSERT INTO USER_T VALUES (SEQ_INCREASE_USER_NO.NEXTVAL, 'TESTuser', '1234', TO_DATE('1972-06-29', 'YYYY/MM/DD'), '테스트유저', TO_DATE('2022-06-01', 'YYYY/MM/DD'), NULL);
INSERT INTO USER_T VALUES (SEQ_INCREASE_USER_NO.NEXTVAL, 'TESTuser2', '2234', TO_DATE('1970-02-15', 'YYYY/MM/DD'), '테스트유저2', TO_DATE('2022-06-05', 'YYYY/MM/DD'), NULL);
INSERT INTO USER_T VALUES (SEQ_INCREASE_USER_NO.NEXTVAL, 'ASD', '3234', TO_DATE('1987-01-25', 'YYYY/MM/DD'), '임시유저', TO_DATE('2022-06-06', 'YYYY/MM/DD'), NULL);


-- 그림 상품 테이블
-- 기존 수업 테이블과 중복으로 PRODUCT_T 로 작업함
-- 가격은 NULL 값으로 기본

-- 상품 고유번호 증가 시퀀스
CREATE SEQUENCE SEQ_INCREASE_PRO_NO
  INCREMENT BY 1
  START WITH 1
  MINVALUE 0
  NOCYCLE
  CACHE 2;
  
-- 그림 상품테이블
-- 상품고유번호, 회원고유번호, 상품명, 상품가격, 상품설명, 등록일  
CREATE TABLE PRODUCT_T(
  PRO_NO NUMBER NOT NULL,
  USER_NO NUMBER,
  PRO_NAME VARCHAR2(100),
  PRO_PRICE NUMBER,
  PRO_EXP VARCHAR2(100),
  PRO_REGDAY DATE
);
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 1, 'theMonaLisa', NULL, 
                                'The MonaLisa', TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 1, 'theLastSupper', NULL, 
                                'the Last Supper', TO_DATE('2022-06-03', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 2, 'theStarryNight', NULL, 
                                'The Starry Night', TO_DATE('2022-06-06', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 3, 'theScream', NULL, 
                                 'The Scream', TO_DATE('2022-09-09', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 3, 'guernica',  NULL, 
                                'Guernica', TO_DATE('2022-05-09', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 2, 'theKiss',  NULL, 
                                'The Kiss', TO_DATE('2022-09-10', 'YYYY/MM/DD'));
INSERT INTO PRODUCT_T VALUES (SEQ_INCREASE_PRO_NO.NEXTVAL, 2, 'theGirlWithaPearlEarring', NULL, 
                                'The Girl With a Pearl Earring', TO_DATE('2022-09-09', 'YYYY/MM/DD'));
SELECT * FROM PRODUCT_T;


-- 경매 고유번호 증가 시퀀스
CREATE SEQUENCE SEQ_INCREASE_AUC_NO
  INCREMENT BY 1
  START WITH 1
  MINVALUE 0
  NOCYCLE
  CACHE 2;
  
-- 경매내역 테이블
-- 경매 고유번호, 상품 고유번호, 최초가격,
-- 낙찰가, 등록일, 경매 시작시간, 경매 종료시간, 관리자 아이디, 낙찰받은 회원 고유번호
CREATE TABLE AUCTION (
  AUC_NO NUMBER NOT NULL,
  PRO_NO NUMBER,
  AUC_FPRICE NUMBER,
  AUC_LPRICE NUMBER,
  PRO_REGDAY DATE,
  AUC_START DATE,
  AUC_END DATE,
  USER_NO NUMBER
);

INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 1, 1000, 250000, TO_DATE('2022-06-03', 'YYYY/MM/DD'), 
    TO_DATE('2022-06-03 09:00:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-03 09:30:00', 'YYYY/MM/DD HH24:MI:SS'), 1);
INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 2, 1000, 5760000, TO_DATE('2022-06-06', 'YYYY/MM/DD'), 
    TO_DATE('2022-06-06 12:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-06 15:00:00', 'YYYY/MM/DD HH24:MI:SS'), 2);
INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 99, 1000, 9990000, TO_DATE('2022-09-09', 'YYYY/MM/DD'), 
    TO_DATE('2022-09-10 12:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-29 15:00:00', 'YYYY/MM/DD HH24:MI:SS'), 2);
INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 999, 1000, 9990000, TO_DATE('2022-09-09', 'YYYY/MM/DD'), 
    TO_DATE('2022-09-10 16:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-09-10 17:00:00', 'YYYY/MM/DD HH24:MI:SS'), 2);
INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 98, 2000, 5200000, TO_DATE('2022-09-09', 'YYYY/MM/DD'), 
    TO_DATE('2022-06-30 16:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-30 12:00:00', 'YYYY/MM/DD HH24:MI:SS'), 3);
INSERT INTO AUCTION VALUES (SEQ_INCREASE_AUC_NO.NEXTVAL, 97, 2000, 9200000, TO_DATE('2022-05-09', 'YYYY/MM/DD'), 
    TO_DATE('2022-06-30 16:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-30 18:00:00', 'YYYY/MM/DD HH24:MI:SS'), 3);

SELECT * FROM AUCTION;
--update auction set AUC_END = sysdate where PRO_NO = 99;
update auction set AUC_END = sysdate where auc_NO = 6;
update auction set AUC_END = sysdate where auc_NO = 5;
update auction set AUC_END = sysdate where auc_NO = 4;

-- 오늘날짜의 경매건수 검색
SELECT COUNT(*) FROM AUCTION WHERE SUBSTR(TO_CHAR(AUC_START), 1, 10) = TO_CHAR(SYSDATE);

-- 오늘날짜의 경매금액 합계
SELECT sum(AUC_LPRICE) FROM AUCTION WHERE SUBSTR(TO_CHAR(AUC_END), 1, 10) = TO_CHAR(SYSDATE);



-- 낙찰경매 리스트 가져오기
-- 경매번호, 상품번호, 낙찰자 닉네임(A)
SELECT A.AUC_NO, A.PRO_NO, P.PRO_NAME, U.USER_ID FROM AUCTION A, USER_T U, PRODUCT_T P WHERE A.USER_NO = U.USER_NO AND A.PRO_NO = P.PRO_NO;



CREATE TABLE WALLET(
  WAL_NO NUMBER CONSTRAINT WAL_NO_PK PRIMARY KEY,
  WAL_NAME VARCHAR(20)
);
select*from point;
insert into wallet values(1,'정의영'); --테스트
insert into wallet values(2,'모승범'); --테스트

create table point(
  pnt_no number,
  user_id varchar2(100),      --변경함
  pnt_total number,
  pnt_in  number,
  pnt_out  number,
  pnt_day date
);

insert into point values(1,2,3,4,5,sysdate);  --테스트












-- 기존 작업용 임시 테이블과 쿼리

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

