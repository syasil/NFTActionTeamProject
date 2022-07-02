-- 회원별 경매내역 보기 프로시저
-- 경매번호, 회원아이디, p.그림명, 낙찰가, 경매종료시간
-- auction 테이블의 회원아이디로 검색
CREATE OR REPLACE PROCEDURE PRO_USER_AUC_LIST
(
  presult out sys_refcursor,
  in_userId IN VARCHAR2
)
IS
BEGIN
  open presult for

  SELECT A.AUC_NO, U.USER_ID, P.PRO_NAME, A.AUC_LPRICE, TO_CHAR(A.AUC_END)
         FROM T_AUCTION A, USER_T  U, PRODUCT_T  P
      WHERE A.USER_NO = U.USER_NO
        AND A.PRO_NO = P.PRO_NO
        AND U.USER_ID like in_userId;
END PRO_USER_AUC_LIST;
/

-- 프로시저 실행
variable rc refcursor;
variable uid varchar2;
execute PRO_USER_AUC_LIST(:rc, 'TESTus%');
print rc;

