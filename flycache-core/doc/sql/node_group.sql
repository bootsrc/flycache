/*
Navicat PGSQL Data Transfer

Source Server         : local-postgres
Source Server Version : 100100
Source Host           : localhost:5432
Source Database       : flycache
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 100100
File Encoding         : 65001

Date: 2018-01-23 18:30:55
*/


-- ----------------------------
-- Table structure for node_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."node_group";
CREATE TABLE "public"."node_group" (
"id" varchar(60) COLLATE "default" NOT NULL,
"creater" varchar(60) COLLATE "default",
"node" varchar COLLATE "default",
"time" varchar(60) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of node_group
-- ----------------------------
INSERT INTO "public"."node_group" VALUES ('999', 'lsm', '[{"host": "localhost", "port": "6379", "remark": ""}, {"host": "localhost", "port": "6380", "remark": ""}, {"host": "localhost", "port": "6381", "remark": ""}]', '2018-01-23 00:00:01');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table node_group
-- ----------------------------
ALTER TABLE "public"."node_group" ADD PRIMARY KEY ("id");
