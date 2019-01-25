CREATE TABLE "TRADIA"."PRICES_HISTORY"("PRICES_ID" NUMBER NOT 
    NULL, "ISIN_CODE_ID" VARCHAR2(20) NOT NULL, "MARKET_ID" VARCHAR2(
    2) NOT NULL, "DATE" DATE NOT NULL, "OPEN" NUMBER(6, 2) NOT NULL, 
    "HIGHEST" NUMBER(6, 2) NOT NULL, "LOWEST" NUMBER(6, 2) NOT NULL, 
    "CLOSE" NUMBER(6, 2) NOT NULL, "VOLUMME" NUMBER NOT NULL, 
    CONSTRAINT "PK_PRICES" PRIMARY KEY("PRICES_ID"), 
    CONSTRAINT "UQ_PRICES" UNIQUE("PRICES_ID"), 
    CONSTRAINT "FK_ISIN_PRICES" FOREIGN KEY("ISIN_CODE_ID") 
    REFERENCES "TRADIA"."ISIN_CODES"("ISIN_CODE_ID"),
    CONSTRAINT "FK_MARKETS_PRICES" FOREIGN KEY("MARKET_ID") 
    REFERENCES "TRADIA"."MARKETS"("MARKET_ID")) 
    TABLESPACE "TRADIA" 