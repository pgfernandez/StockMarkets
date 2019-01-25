# MySQL-Front Dump 2.5
#
# Host: localhost   Database: tradiabroker
# --------------------------------------------------------
# Server version 4.0.13-nt


#
# Table structure for table 'account'
#

CREATE TABLE account (
  account_id varchar(20) NOT NULL default '',
  account_type_id decimal(15,2) default NULL,
  free_balance decimal(15,2) default NULL,
  lock_balance date default NULL,
  interest_rate_special decimal(4,2) default NULL,
  date_opened date default NULL,
  date_closed date default NULL,
  PRIMARY KEY  (account_id),
  UNIQUE KEY account_id (account_id),
  KEY account_id_2 (account_id)
) TYPE=MyISAM;



#
# Table structure for table 'account_types'
#

CREATE TABLE account_types (
  account_type_id char(2) NOT NULL default '',
  account_description varchar(30) NOT NULL default '',
  PRIMARY KEY  (account_type_id),
  UNIQUE KEY account_type_id (account_type_id),
  KEY account_type_id_2 (account_type_id)
) TYPE=MyISAM COMMENT='Tipos de cuentas de clientes';



#
# Table structure for table 'broker_deals'
#

CREATE TABLE broker_deals (
  broker_deal_id varchar(10) NOT NULL default '',
  broker_id char(3) NOT NULL default '',
  amount char(1) default NULL,
  side char(1) default NULL,
  cleared char(1) default NULL,
  PRIMARY KEY  (broker_deal_id),
  UNIQUE KEY broker_deal_id (broker_deal_id),
  KEY broker_deal_id_2 (broker_deal_id)
) TYPE=MyISAM COMMENT='Recoge el estado de una orden';



#
# Table structure for table 'brokers'
#

CREATE TABLE brokers (
  broker_id char(3) NOT NULL default '',
  broker_name varchar(30) NOT NULL default '',
  PRIMARY KEY  (broker_id),
  UNIQUE KEY broker_id (broker_id),
  KEY broker_id_2 (broker_id)
) TYPE=MyISAM COMMENT='Relacion de brokers con los que interactúa el sistema';



#
# Table structure for table 'correspondents'
#

CREATE TABLE correspondents (
  corresp_id char(2) NOT NULL default '',
  corresp_name varchar(30) NOT NULL default '',
  country_id char(3) default NULL,
  PRIMARY KEY  (corresp_id),
  UNIQUE KEY corresp_id (corresp_id),
  KEY corresp_id_2 (corresp_id)
) TYPE=MyISAM COMMENT='Corresponsales que actúan con Tradia';



#
# Table structure for table 'countries'
#

CREATE TABLE countries (
  country_id char(3) NOT NULL default '',
  country_name varchar(25) NOT NULL default '',
  PRIMARY KEY  (country_id),
  UNIQUE KEY country_id (country_id),
  KEY country_id_2 (country_id)
) TYPE=MyISAM COMMENT='Listado de paises';



#
# Table structure for table 'currencies'
#

CREATE TABLE currencies (
  currency_id char(3) NOT NULL default '',
  currency_name varchar(25) NOT NULL default '',
  PRIMARY KEY  (currency_id),
  UNIQUE KEY currency_id (currency_id),
  KEY currency_id_2 (currency_id)
) TYPE=MyISAM COMMENT='Tabla con el listado de monedas';



#
# Table structure for table 'customers'
#

CREATE TABLE customers (
  customer_id varchar(10) NOT NULL default '',
  name varchar(25) NOT NULL default '',
  middle char(1) default NULL,
  surname varchar(50) default NULL,
  address varchar(50) default NULL,
  po_box varchar(5) default NULL,
  home_phone varchar(9) default NULL,
  mobile_phone varchar(9) default '0',
  job_phone varchar(9) default NULL,
  email varchar(255) default '0',
  city varchar(20) default '0',
  country_id char(3) default NULL,
  PRIMARY KEY  (customer_id),
  UNIQUE KEY customer_id (customer_id),
  KEY customer_id_2 (customer_id)
) TYPE=MyISAM COMMENT='Tabla de clientes';



#
# Table structure for table 'customers_accounts'
#

CREATE TABLE customers_accounts (
  customer_id varchar(10) NOT NULL default '',
  account_id varchar(20) NOT NULL default '',
  PRIMARY KEY  (customer_id,account_id),
  KEY customer_id (customer_id,account_id)
) TYPE=MyISAM COMMENT='Cuentas por cliente';



#
# Table structure for table 'customers_stock_deals'
#

CREATE TABLE customers_stock_deals (
  account_id varchar(20) NOT NULL default '',
  stock_deal_id varchar(20) NOT NULL default '',
  PRIMARY KEY  (account_id,stock_deal_id),
  KEY account_id (account_id,stock_deal_id)
) TYPE=MyISAM COMMENT='Operaciones por cliente';



#
# Table structure for table 'deal_settlements'
#

CREATE TABLE deal_settlements (
  payment_order_id varchar(15) NOT NULL default '',
  broker_deal_id varchar(10) NOT NULL default '',
  date_paid date default NULL,
  currency_id char(3) default NULL,
  ordering_institution varchar(11) default NULL,
  beneficiary_institution varchar(11) default NULL,
  corresp_id char(2) default NULL,
  document blob,
  PRIMARY KEY  (payment_order_id),
  UNIQUE KEY payment_order_id (payment_order_id),
  KEY payment_order_id_2 (payment_order_id)
) TYPE=MyISAM COMMENT='Tabla que representa la liquidación de una orden';



#
# Table structure for table 'isin_codes'
#

CREATE TABLE isin_codes (
  isin_code_id varchar(20) NOT NULL default '0',
  instrument_name varchar(50) default NULL,
  PRIMARY KEY  (isin_code_id),
  UNIQUE KEY isin_code_id (isin_code_id),
  KEY isin_code_id_2 (isin_code_id)
) TYPE=MyISAM COMMENT='Tabla de códigos ISIN';



#
# Table structure for table 'markets'
#

CREATE TABLE markets (
  market_id char(2) NOT NULL default '',
  market_name varchar(30) NOT NULL default '',
  PRIMARY KEY  (market_id),
  UNIQUE KEY market_id (market_id),
  KEY market_id_2 (market_id)
) TYPE=MyISAM COMMENT='Mercados disponibles';



#
# Table structure for table 'message_types'
#

CREATE TABLE message_types (
  message_type_id char(2) NOT NULL default '',
  message_shortname char(2) default NULL,
  message_description varchar(30) default NULL,
  PRIMARY KEY  (message_type_id),
  UNIQUE KEY message_type_id (message_type_id),
  KEY message_type_id_2 (message_type_id)
) TYPE=MyISAM COMMENT='Tipos de mensajes en una orden';



#
# Table structure for table 'order_types'
#

CREATE TABLE order_types (
  order_type_id char(1) NOT NULL default '0',
  type_description varchar(20) NOT NULL default '0',
  PRIMARY KEY  (order_type_id),
  UNIQUE KEY order_type_id (order_type_id),
  KEY order_type_id_2 (order_type_id)
) TYPE=MyISAM COMMENT='Tipos de órdenes';



#
# Table structure for table 'prices_history'
#

CREATE TABLE prices_history (
  prices_id bigint(20) unsigned NOT NULL auto_increment,
  isin_code_id varchar(20) NOT NULL default '',
  market_id char(3) default NULL,
  date date default NULL,
  open decimal(6,2) default NULL,
  close decimal(6,2) default '0.00',
  highest decimal(6,2) default '0.00',
  lowest bigint(20) default NULL,
  PRIMARY KEY  (prices_id),
  KEY prices_id (prices_id)
) TYPE=MyISAM COMMENT='Hsitórico de precios';



#
# Table structure for table 'stock_deals'
#

CREATE TABLE stock_deals (
  stock_deal_id varchar(20) NOT NULL default '',
  date_deal date default NULL,
  stocks_amount bigint(20) default NULL,
  price decimal(6,2) default NULL,
  PRIMARY KEY  (stock_deal_id),
  UNIQUE KEY stock_deal_id (stock_deal_id),
  KEY stock_deal_id_2 (stock_deal_id)
) TYPE=MyISAM COMMENT='Operaciones';



#
# Table structure for table 'stock_order_status'
#

CREATE TABLE stock_order_status (
  order_status_id char(2) NOT NULL default '',
  status_description varchar(20) NOT NULL default '',
  PRIMARY KEY  (order_status_id),
  UNIQUE KEY order_status_id (order_status_id),
  KEY order_status_id_2 (order_status_id)
) TYPE=MyISAM COMMENT='Tabla con los tipos de estado de operación';



#
# Table structure for table 'stocks_orders'
#

CREATE TABLE stocks_orders (
  order_id varchar(20) NOT NULL default '',
  message_type_id char(2) NOT NULL default '',
  broker_id char(3) default NULL,
  isin_code_id varchar(20) default NULL,
  buy_sell_index char(1) default NULL,
  market_id char(2) default NULL,
  account_id varchar(20) default NULL,
  date_limit date default NULL,
  price_limit decimal(15,2) default NULL,
  order_type_id char(1) default NULL,
  currency_id char(3) default NULL,
  time_in_force_id char(2) default NULL,
  text varchar(255) default NULL,
  PRIMARY KEY  (order_id,message_type_id),
  UNIQUE KEY order_id (order_id),
  KEY order_id_2 (order_id,message_type_id)
) TYPE=MyISAM COMMENT='Historico de operaciones';



#
# Table structure for table 'time_in_forces'
#

CREATE TABLE time_in_forces (
  time_in_force_id char(2) NOT NULL default '',
  time_description varchar(20) default NULL,
  PRIMARY KEY  (time_in_force_id),
  UNIQUE KEY time_in_force_id (time_in_force_id),
  KEY time_in_force_id_2 (time_in_force_id)
) TYPE=MyISAM COMMENT='Descripción de time in forces';



#
# Table structure for table 'transfer_deals'
#

CREATE TABLE transfer_deals (
  transfer_id varchar(20) NOT NULL default '',
  source_account varchar(20) default NULL,
  dest_account varchar(20) default NULL,
  date_deal date default NULL,
  amount decimal(15,2) default NULL,
  currency_id char(3) default NULL,
  comments varchar(30) default NULL,
  commision_fee decimal(8,2) default NULL,
  PRIMARY KEY  (transfer_id),
  UNIQUE KEY transfer_id (transfer_id),
  KEY transfer_id_2 (transfer_id)
) TYPE=MyISAM COMMENT='Operaciones de transferencia';

