-----------------------------------------------------------------------------
-- ȸ�� ������ȣ ���� ������
CREATE SEQUENCE SEQ_T_USER_NO;

-- ȸ�����̺�  
-- ������ȣ,���̵�,���,����,�г���,������,������
CREATE TABLE T_USER (
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(100),
  USER_PASS VARCHAR2(20),
  USER_BIR date,
  USER_NICK VARCHAR2(20),
  USER_CREDAY DATE,
  USER_ICON BLOB
);

INSERT INTO T_USER VALUES (SEQ_T_USER_NO.NEXTVAL, 'test1', '1234', TO_DATE('1972-06-29', 'YYYY/MM/DD'), '�׽�Ʈ����', TO_DATE('2022-06-01', 'YYYY/MM/DD'), NULL);
INSERT INTO T_USER VALUES (SEQ_T_USER_NO.NEXTVAL, 'test2', '2234', TO_DATE('1970-02-15', 'YYYY/MM/DD'), '�׽�Ʈ����2', TO_DATE('2022-06-05', 'YYYY/MM/DD'), NULL);

-----------------------------------------------------------------------------
-- �׸� ��ǰ ���̺�
-- ���� ���� ���̺�� �ߺ����� PRODUCT_T �� �۾���
-- ������ NULL ������ �⺻
-- ��ǰ ������ȣ ���� ������
CREATE SEQUENCE SEQ_T_PRO_NO;
  
-- �׸� ��ǰ���̺�
-- ��ǰ������ȣ, ȸ��������ȣ, ��ǰ��, ��ǰ����, ��ǰ����, �����  
-- PRO_IMG BLOB ��ǰ �̹��� �߰�

CREATE TABLE T_PRODUCT (
  PRO_NO NUMBER PRIMARY KEY,
  USER_NO NUMBER,
  PRO_NAME VARCHAR2(100),
  PRO_PRICE NUMBER,
  PRO_EXP VARCHAR2(100),
  PRO_REGDAY DATE,
  PRO_IMG BLOB,
  PRO_IMG_SIGNED BLOB
);

INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '01_theMonaLisa', 100, 'The MonaLisa', TO_DATE('2022-06-01', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '02_theLastSupper', 100, 'the Last Supper', TO_DATE('2022-06-01', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '03_theStarryNight', 100, 'The Starry Night', TO_DATE('2022-06-03', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '04_theScream', 100, 'The Scream',TO_DATE('2022-06-03', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '05_guernica', 100, 'Guernica',TO_DATE('2022-06-04', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '06_theKiss', 100, 'The Kiss', TO_DATE('2022-06-04', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '07_theGirlWithaPearlEarring', 100, 'The Girl With a Pearl Earring', TO_DATE('2022-06-05', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '08_theBirth0fVenus', 100, 'The Birth 0f Venus', TO_DATE('2022-06-01', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '09_LasMeninas', 100, 'Las Meninas', TO_DATE('2022-06-06', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '10_theCreationOfAdam', 100, 'The Creation Of Adam', TO_DATE('2022-06-06', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '11_americanGothic', 100, 'American Gothic', TO_DATE('2022-06-06', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '12_LeMatinAuxSaules', 100, 'Le Matin Aux Saules', TO_DATE('2022-06-07', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1,'13_thePersistenceOfMemory', 100, 'The Persistence Of Memory', TO_DATE('2022-06-10', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '14_theNightwatch', 100, 'The Nightwatch', TO_DATE('2022-06-10', 'YYYY/MM/DD'), NULL, NULL);
INSERT INTO T_PRODUCT VALUES (SEQ_T_PRO_NO.NEXTVAL, 1, '15_theGardenOfEarthlyDelights', 100, 'The Garden Of Earthly Delights', TO_DATE('2022-06-11', 'YYYY/MM/DD'), NULL, NULL);

-----------------------------------------------------------------------------
-- ��� ������ȣ ���� ������
CREATE SEQUENCE SEQ_T_AUC_NO;
  
-- ��ų��� ���̺�
-- ��� ������ȣ, ��ǰ ������ȣ, ���ʰ���, ������, �����, ��� ���۽ð�, ��� ����ð�, �������� ȸ�� ������ȣ
CREATE TABLE T_AUCTION (
  AUC_NO NUMBER PRIMARY KEY,
  PRO_NO NUMBER,
  AUC_FPRICE NUMBER,
  AUC_LPRICE NUMBER,
  PRO_REGDAY DATE,
  AUC_START DATE,
  AUC_END DATE,
  USER_NO NUMBER
);

INSERT INTO T_AUCTION VALUES (SEQ_T_AUC_NO.NEXTVAL, 1, 1000, 250000, TO_DATE('2022-06-03', 'YYYY/MM/DD'), TO_DATE('2022-06-03 09:00:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-03 09:30:00', 'YYYY/MM/DD HH24:MI:SS'), 1);
INSERT INTO T_AUCTION VALUES (SEQ_T_AUC_NO.NEXTVAL, 2, 1000, 5760000, TO_DATE('2022-06-06', 'YYYY/MM/DD'), TO_DATE('2022-06-06 12:30:00', 'YYYY/MM/DD HH24:MI:SS'), TO_DATE('2022-06-06 15:00:00', 'YYYY/MM/DD HH24:MI:SS'), 2);

-----------------------------------------------------------------------------
-- ��� ������ȣ ���� ������
CREATE SEQUENCE SEQ_T_AUC_LOG_NO;

CREATE TABLE T_AUCTION_LOG (
  AUG_LOG_NO NUMBER PRIMARY KEY,
  AUC_NO NUMBER,
  USER_NO NUMBER,
  AUC_AMOUNT NUMBER,
  AUC_SUCCESS_YN CHAR(1),
  AUC_LOG_DATE DATE
);

INSERT INTO T_AUCTION_LOG VALUES (SEQ_T_AUC_LOG_NO.NEXTVAL, 1, 1, 100, 'Y', SYSDATE);
INSERT INTO T_AUCTION_LOG VALUES (SEQ_T_AUC_LOG_NO.NEXTVAL, 1, 2, 90, 'N', SYSDATE);



-----------------------------------------------------------------------------
-- ���� ���� ���� ���̺�
-- VFT �� ������ ���̵��̴�.
CREATE TABLE T_WALLET(
    WAL_NO NUMBER PRIMARY KEY,
    WAL_NAME VARCHAR(20), 
    WAL_AMOUNT NUMBER
);

insert into t_wallet values(1111, '���ǿ�', 100000);
insert into t_wallet values(2222, '��¹�', 100000);
insert into t_wallet values(3333, '�躸��', 100000);
insert into t_wallet values(4444, '���¿�', 100000);
insert into t_wallet values(5555, '������', 100000);
insert into t_wallet values(7777, '�ż���', 100000);
insert into t_wallet values(9999, 'VFT', 100000);

CREATE SEQUENCE SEQ_T_WAL_LOG_NO;
-- �������� ����� �α�
create table T_WALLET_LOG(
    WAL_LOG_NO number PRIMARY KEY,
    FROM_WAL_NO number,
    TO_WAL_NO number,
    AMOUNT number,
    LOG_TIME date
);

insert into T_WALLET_LOG values(SEQ_T_WAL_LOG_NO.NEXTVAL, 1111, 2222, 10, sysdate);
insert into T_WALLET_LOG values(SEQ_T_WAL_LOG_NO.NEXTVAL, 1111, 2222, 30, sysdate);

-----------------------------------------------------------------------------


SELECT * FROM T_USER;
SELECT * FROM T_PRODUCT;
SELECT * FROM T_AUCTION;
SELECT * FROM T_AUCTION_LOG;
SELECT * FROM T_WALLET;
SELECT * FROM T_WALLET_LOG;

