package com.sbz.data.messages.fix.app;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.ArrayList;

public class FIXMessage {

  private ArrayList tags = null;


  private final int ACCOUNT                             =   1;
  private final int ADV_ID                   		=   2;
  private final int ADV_REF_ID               		=   3;
  private final int ADV_SIDE                 		=   4;
  private final int ADV_TRANS_TYPE           		=   5;
  private final int AVG_PX                   		=   6;
  private final int BEGIN_SEQ_NO             		=   7;
  private final int BEGIN_STRING             		=   8;
  private final int BODY_LENGTH              		=   9;
  private final int CHECKSUM                 		=  10;
  private final int CL_ORD_ID                		=  11;
  private final int COMMISSION               		=  12;
  private final int COMM_TYPE                		=  13;
  private final int CUM_QTY                  		=  14;
  private final int CURRENCY                 		=  15;
  private final int END_SEQ_NO               		=  16;
  private final int EXEC_ID                  		=  17;
  private final int EXEC_INST                		=  18;
  private final int EXEC_REF_ID              		=  19;
  private final int EXEC_TRANS_TYPE          		=  20;
  private final int HANDL_INST               		=  21;
  private final int ID_SOURCE                		=  22;
  private final int IOI_ID                   		=  23;
  private final int IOIOTH_SVE               		=  24;
  private final int IOI_QLTY_IND             		=  25;
  private final int IOI_REF_ID               		=  26;
  private final int IOI_SHARES               		=  27;
  private final int IOI_TRANS_TYPE           		=  28;
  private final int LAST_CAPACITY            		=  29;
  private final int LAST_MKT                 		=  30;
  private final int LAST_PX                  		=  31;
  private final int LAST_SHARES              		=  32;
  private final int LINES_OF_TEXT            		=  33;
  private final int MSG_SEQ_NUM              		=  34;
  private final int MSG_TYPE                 		=  35;
  private final int NEW_SEQ_NO               		=  36;
  private final int ORDER_ID                 		=  37;
  private final int ORDER_QTY                		=  38;
  private final int ORD_STATUS               		=  39;
  private final int ORD_TYPE                 		=  40;
  private final int ORIG_CL_ORD_ID           		=  41;
  private final int ORIG_TIME                		=  42;
  private final int POSS_DUP_FLAG            		=  43;
  private final int PRICE                    		=  44;
  private final int REF_SEQ_NUM              		=  45;
  private final int RELATD_SYM               		=  46;
  private final int RULE_80_A                		=  47;
  private final int SECURITY_ID              		=  48;
  private final int SENDER_COMP_ID           		=  49;
  private final int SENDER_SUB_ID            		=  50;
  private final int SENDING_DATE             		=  51;
  private final int SENDING_TIME             		=  52;
  private final int SHARES                   		=  53;
  private final int SIDE                     		=  54;
  private final int SYMBOL                   		=  55;
  private final int TARGET_COMP_ID           		=  56;
  private final int TARGET_SUB_ID            		=  57;
  private final int TEXT                     		=  58;
  private final int TIME_IN_FORCE            		=  59;
  private final int TRANSAC_TIME             		=  60;
  private final int URGENCY                  		=  61;
  private final int VALID_UNTIL_TIME         		=  62;
  private final int SETTLMNT_TYP             		=  63;
  private final int FUT_SETT_DATE            		=  64;
  private final int SYMBOL_SFX               		=  65;
  private final int LIST_ID                  		=  66;
  private final int LIST_SEQ_NO              		=  67;
  private final int LIST_NO_ORDS             		=  68;
  private final int LIST_EXEC_INST           		=  69;
  private final int ALLOC_ID                 		=  70;
  private final int ALLOC_TRANS_TYPE         		=  71;
  private final int REF_ALLOC_ID             		=  72;
  private final int NO_ORDERS                		=  73;
  private final int AVG_PRX_PRECISION        		=  74;
  private final int TRADE_DATE               		=  75;
  private final int EXEC_BROKER              		=  76;
  private final int OPEN_CLOSE               		=  77;
  private final int NO_ALLOCS                		=  78;
  private final int ALLOC_ACCOUNT            		=  79;
  private final int ALLOC_SHARES             		=  80;
  private final int PROCESS_CODE             		=  81;
  private final int NO_RPTS                  		=  82;
  private final int RPT_SEQ                  		=  83;
  private final int CXL_QTY                  		=  84;
  private final int NO_DLVY_INST             		=  85;
  private final int DLVY_INST                		=  86;
  private final int ALLOC_STATUS             		=  87;
  private final int ALLOC_REJ_CODE           		=  88;
  private final int SIGNATURE                		=  89;
  private final int SECURE_DATA_LEN          		=  90;
  private final int SECURE_DATA              		=  91;
  private final int BROKER_OF_CREDIT         		=  92;
  private final int SIGNATURE_LENGTH         		=  93;
  private final int EMAIL_TYPE               		=  94;
  private final int RAW_DATA_LENGTH          		=  95;
  private final int RAW_DATA                 		=  96;
  private final int POSS_RESEND              		=  97;
  private final int ENCRYPT_METHOD           		=  98;
  private final int STOP_PX                  		=  99;
  private final int EX_DESTINATION           		= 100;
  private final int CXL_REJ_REASON           		= 102;
  private final int ORD_REJ_REASON           		= 103;
  private final int IOI_QUALIFIER            		= 104;
  private final int WAVE_NO                  		= 105;
  private final int ISSUER                   		= 106;
  private final int SECURITY_DESC            		= 107;
  private final int HEART_BT_INT             		= 108;
  private final int CLIENT_ID                		= 109;
  private final int MIN_QTY                  		= 110;
  private final int MAX_FLOOR                		= 111;
  private final int TEST_REQ_ID              		= 112;
  private final int REPORT_TO_EXCH           		= 113;
  private final int LOCATE_REQD	           		= 114;
  private final int ON_BEHALF_OF_COMP_ID     		= 115;
  private final int ON_BEHALF_OF_SUB_ID      		= 116;
  private final int QUOTE_ID	           		= 117;
  private final int NET_MONEY                		= 118;
  private final int SETTL_CURR_AMT           		= 119;
  private final int SETTL_CURRENCY           		= 120;
  private final int FOREX_REQ                		= 121;
  private final int ORIG_SENDING_TIME        		= 122;
  private final int GAP_FILL_FLAG            		= 123;
  private final int NO_EXECS                		= 124;
  private final int CXL_TYPE                 		= 125;
  private final int EXPIRE_TIME              		= 126;
  private final int DK_REASON                		= 127;
  private final int DELIVER_TO_COMP_ID       		= 128;
  private final int DELIVER_TO_SUB_ID        		= 129;
  private final int IOI_NATURAL_FLAG         		= 130;
  private final int QUOTE_REQ_ID             		= 131;
  private final int BID_PX                   		= 132;
  private final int OFFER_PX                 		= 133;
  private final int BID_SIZE                 		= 134;
  private final int OFFER_SIZE               		= 135;
  private final int NO_MISC_FEES             		= 136;
  private final int MISC_FEE_AMT             		= 137;
  private final int MISC_FEE_CURR            		= 138;
  private final int MISC_FEE_TYPE            		= 139;
  private final int PREV_CLOSE_PX            		= 140;
  private final int RESET_SEQ_NUM_FLAG       		= 141;
  private final int SENDER_LOCATION_ID       		= 142;
  private final int TARGET_LOCATION_ID       		= 143;
  private final int ON_BEHALF_OF_LOCATION_ID 		= 144;
  private final int DELIVER_TO_LOCATION_ID   		= 145;
  private final int NO_RELATED_SYM           		= 146;
  private final int SUBJECT 		   		= 147;
  private final int HEADLINE 		   		= 148;
  private final int URL_LINK 		   		= 149;
  private final int EXEC_TYPE 		   		= 150;
  private final int LEAVES_QTY 		   		= 151;
  private final int CASH_ORDER_QTY 	   		= 152;
  private final int ALLOC_AVG_PX	   		= 153;
  private final int ALLOC_NET_MONEY 	   		= 154;
  private final int SETTL_CURR_FX_RATE 	   		= 155;
  private final int SETTL_CURR_FX_RATE_CALC  		= 156;
  private final int NUM_DAYS_INTEREST 	   		= 157;
  private final int ACCRUED_INTEREST_RATE    		= 158;
  private final int ACCRUED_INTEREST_AMT   		= 159;
  private final int SETTL_INST_MODE 	   		= 160;
  private final int ALLOC_TEXT 	   	   		= 161;
  private final int SETTL_INST_ID 	   		= 162;
  private final int SETTL_INST_TRANS_TYPE    		= 163;
  private final int EMAIL_THREAD_ID 	   		= 164;
  private final int SETT_INST_SOURCE 	   		= 165;
  private final int SETTL_LOCATION 	   		= 166;
  private final int SECURITY_TYPE 	   		= 167;
  private final int EFFECTIVE_TIME 	   		= 168;
  private final int STAND_INST_DB_TYPE 	   		= 169;
  private final int STAND_INST_DB_NAME 	   		= 170;
  private final int STAND_INST_DB_ID 	   		= 171;
  private final int SETTL_DELIVERY_TYPE	   		= 172;
  private final int SETTL_DEPOSITORY_CODE 	   	= 173;
  private final int SETTL_BRKR_CODE 	   		= 174;
  private final int SETTL_INST_CODE 	   		= 175;
  private final int SECURITY_SETTL_AGENT_NAME 		= 176;
  private final int SECURITY_SETTL_AGENT_CODE 		= 177;
  private final int SECURITY_SETTL_AGENT_ACCT_NUM 	= 178;
  private final int SECURITY_SETTL_AGENT_ACCT_NAME 	= 179;
  private final int SECURITY_SETTL_AGENT_CONTACT_NAME 	= 180;
  private final int SECURITY_SETTL_AGENT_CONTACT_PHONE 	= 181;
  private final int CASH_SETTL_AGENT_NAME 		= 182;
  private final int CASH_SETTL_AGENT_CODE 		= 183;
  private final int CASH_SETTL_AGENT_ACCT_NUM 		= 184;
  private final int CASH_SETTL_AGENT_ACCT_NAME 		= 185;
  private final int CASH_SETTL_AGENT_CONTACT_NAME 	= 186;
  private final int CASH_SETTL_AGENT_CONTACT_PHONE 	= 187;
  private final int BID_SPOT_RATE 			= 188;
  private final int BID_FORWARD_POINTS 			= 189;
  private final int OFFER_SPOT_RATE 			= 190;
  private final int OFFER_FORWARD_POINTS 		= 191;
  private final int ORDER_QTY2 				= 192;
  private final int FUT_SETT_DATE2 			= 193;
  private final int LAST_SPOT_RATE 			= 194;
  private final int LAST_FORWARD_POINTS 		= 195;
  private final int ALLOC_LINK_ID 			= 196;
  private final int ALLOC_LINK_TYPE 			= 197;
  private final int SECONDARY_ORDER_ID 			= 198;
  private final int NO_IOI_QUALIFIERS 			= 199;
  private final int MATURITY_MONTH_YEAR 		= 200;
  private final int PUT_OR_CALL				= 201;
  private final int STRIKE_PRICE 			= 202;
  private final int COVERED_OR_UNCOVERED		= 203;
  private final int CUSTOMER_OR_FIRM 			= 204;
  private final int MATURITY_DAY			= 205;
  private final int OPT_ATTRIBUTE 			= 206;
  private final int SECURITY_EXCHANGE 			= 207;
  private final int NOTIFIY_BROKER_OF_CREDIT 		= 208;
  private final int ALLOC_HANDL_INST 			= 209;
  private final int MAX_SHOW 				= 210;
  private final int PEG_DIFFERENCE 			= 211;
  private final int ORD_ACTION				= 9130;
  private final int PRICE_CHECK				= 9131;
  private final int NON19C3				= 9132;
  private final int INTERLISTED				= 9133;
  private final int PUB					= 9134;



  public FIXMessage() {

   tags = new ArrayList();


  }
}