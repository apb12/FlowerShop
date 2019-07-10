CREATE SEQUENCE ORDERS_SEQ;

CREATE TABLE ORDERS(
ID NUMBER PRIMARY KEY,
USER_ID NUMBER NOT NULL,
TOTAL_PRICE DECIMAL,
ORDER_DATE DATE NOT NULL,
STATUS VARCHAR CHECK (STATUS IN ('DRAFT', 'PAID', 'CLOSED')),
--FOREIGN KEY(ID) REFERENCES BUCKET(ORDERS_ID)
FOREIGN KEY(USER_ID) REFERENCES USERS(ID)

);