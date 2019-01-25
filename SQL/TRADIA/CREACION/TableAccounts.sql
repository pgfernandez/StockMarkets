CREATE TABLE "TRADIA"."ACCOUNTS"("ACCOUNT_ID" VARCHAR2(
    20) NOT NULL, "ACCOUNT_TYPE_ID" VARCHAR2(3) NOT NULL, 
    "FREE_BALANCE" NUMBER(15, 2) NOT NULL, "LOCK_BALANCE" NUMBER(15, 
    2) NOT NULL, "INTEREST_RATE" NUMBER(4, 2) NOT NULL, 
    "DATE_OPENED" DATE NOT NULL, 
    CONSTRAINT "PK_ACCOUNT" PRIMARY KEY("ACCOUNT_ID"), 
    CONSTRAINT "UQ_ACCOUNT" UNIQUE("ACCOUNT_ID")) 
    TABLESPACE "TRADIA"