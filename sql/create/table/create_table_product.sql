
CREATE TABLE PRODUCT 
(
  PRODUCT_NUMBER NUMBER(*, 0) NOT NULL 
, PRODUCT_NAME VARCHAR2(20 BYTE) NOT NULL 
, PRODUCT_DESCRIPTION VARCHAR2(100 BYTE) NOT NULL 
, PRODUCT_PRICE NUMBER 
, PRODUCT_REGISTER_USER NUMBER(*, 0) 
, PRODUCT_IMAGE_METADATA VARCHAR2(20 BYTE) NOT NULL 
, PRODUCT_REGISTER_DATE DATE NOT NULL 
, CONSTRAINT PRODUCT_PK PRIMARY KEY 
  (
    PRODUCT_NUMBER 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX PRODUCT_PK ON PRODUCT (PRODUCT_NUMBER ASC) 
      LOGGING 
      TABLESPACE USERS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE USERS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOCOMPRESS 
NO INMEMORY 
NOPARALLEL;

ALTER TABLE PRODUCT
ADD CONSTRAINT PRODUCT_UK1 UNIQUE 
(
  PRODUCT_IMAGE_METADATA 
)
USING INDEX 
(
    CREATE UNIQUE INDEX PRODUCT_UK1 ON PRODUCT (PRODUCT_IMAGE_METADATA ASC) 
    LOGGING 
    TABLESPACE USERS 
    PCTFREE 10 
    INITRANS 2 
    STORAGE 
    ( 
      INITIAL 65536 
      NEXT 1048576 
      MINEXTENTS 1 
      MAXEXTENTS UNLIMITED 
      BUFFER_POOL DEFAULT 
    ) 
    NOPARALLEL 
)
 ENABLE;

COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE_METADATA IS '상품이미지의 메타데이터';

CREATE SEQUENCE product_number_seq START WITH 1 INCREMENT BY 1 MAXVALUE 999999 NOCYCLE NOCACHE;    

