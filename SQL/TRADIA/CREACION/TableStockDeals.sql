CREATE TABLE "TRADIA"."STOCK_DEALS"("STOCK_DEAL_ID" VARCHAR2(20) 
    NOT NULL, "DATE_DEAL" DATE NOT NULL, "STOCKS_AMOUNT" VARCHAR2(
    15) NOT NULL, "PRICE" NUMBER(6, 2) NOT NULL, 
    CONSTRAINT "PK_STOCK_DEAL" PRIMARY KEY("STOCK_DEAL_ID"), 
    CONSTRAINT "UQ_STOCK_DEAL" UNIQUE("STOCK_DEAL_ID")) 
    TABLESPACE "TRADIA"