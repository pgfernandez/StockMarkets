CREATE TABLE "TRADIA"."CUSTOMER_STOCK_DEALS"("ACCOUNT_ID" 
    VARCHAR2(20) NOT NULL, "STOCK_DEAL_ID" VARCHAR2(20) NOT NULL, 
    CONSTRAINT "PK_CUST_DEAL" PRIMARY KEY("ACCOUNT_ID", 
    "STOCK_DEAL_ID"), 
    CONSTRAINT "FK_ACCOUNT_DEAL" FOREIGN KEY("ACCOUNT_ID") 
    REFERENCES "TRADIA"."ACCOUNTS"("ACCOUNT_ID"), 
    CONSTRAINT "FK_STOCK_DEAL" FOREIGN KEY("STOCK_DEAL_ID") 
    REFERENCES "TRADIA"."STOCK_DEALS"("STOCK_DEAL_ID")) 
    TABLESPACE "TRADIA"