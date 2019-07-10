CREATE SEQUENCE FLOWERSTOCK_SEQ;

CREATE TABLE FLOWERSTOCK
(	ID NUMBER  PRIMARY KEY,
    FLOWER_ID NUMBER NOT NULL,
	COUNT  NUMBER NOT NULL,
	FOREIGN KEY (FLOWER_ID) REFERENCES FLOWER(ID)
   );
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,100,100);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,101,150);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,102,200);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,103,250);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,104,300);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,105,40);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,106,230);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,107,100);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,108,200);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,109,300);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,110,400);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,111,50);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,112,70);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,113,140);
 INSERT INTO FLOWERSTOCK VALUES(FLOWERSTOCK_SEQ.NEXTVAL,114,200);
commit ;