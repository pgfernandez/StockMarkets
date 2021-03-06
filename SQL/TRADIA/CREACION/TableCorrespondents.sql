CREATE TABLE "TRADIA"."CORRESPONDENTS"("CORRESP_ID" VARCHAR2(2) 
    NOT NULL, "CORRESP_NAME" VARCHAR2(30) NOT NULL, "COUNTRY_ID" 
    VARCHAR2(3) NOT NULL, 
    CONSTRAINT "PK_CORRESP" PRIMARY KEY("CORRESP_ID"), 
    CONSTRAINT "UQ_CORRESP" UNIQUE("CORRESP_ID"), 
    CONSTRAINT "FK_C_COUNTRY" FOREIGN KEY("COUNTRY_ID") 
    REFERENCES "TRADIA"."COUNTRIES"("COUNTRY_ID")) 
    TABLESPACE "TRADIA"