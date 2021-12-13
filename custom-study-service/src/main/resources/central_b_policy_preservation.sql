/*
 Navicat Premium Data Transfer

 Source Server         : bzn_user_dev
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 172.16.11.177:3306
 Source Schema         : bzn_central

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 10/12/2021 09:52:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_policy_preservation
-- ----------------------------
DROP TABLE IF EXISTS `b_policy_preservation`;
CREATE TABLE `b_policy_preservation`  (
  `id` bigint(64) NOT NULL,
  `policy_no` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保准牛保单号',
  `preservation_type` tinyint(1) NOT NULL COMMENT '保全类型【1增减员、2续投，3增员，4减员，5正常退保，6生效前退保】',
  `inc_dec_order_no` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增减员订单号',
  `inc_revise_no` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增员批单号',
  `dec_revise_no` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '减员批单号',
  `business_type` tinyint(2) NOT NULL COMMENT '业务类型【1企补,2雇主,3留学,4体育,5旅行,6TMT,7人力资源,8教育,9孵化,0其他】',
  `product_code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品代码',
  `product_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `plan_code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案代码',
  `plan_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案名称',
  `pay_type` tinyint(1) NULL DEFAULT NULL COMMENT '支付方式【1在线支付、2线下支付】',
  `pay_status` tinyint(1) NULL DEFAULT NULL COMMENT '支付状态【1-未支付、2-已支付】',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '订单完成支付时间',
  `inc_revise_sum` int(11) NULL DEFAULT NULL COMMENT '增员人数',
  `inc_revise_premium` double(13, 2) NULL DEFAULT NULL COMMENT '增员保费',
  `dec_revise_sum` int(11) NULL DEFAULT NULL COMMENT '减员人数',
  `dec_revise_premium` double(13, 2) NULL DEFAULT NULL COMMENT '减员保费',
  `inc_revise_slave_sum` int(11) NULL DEFAULT NULL COMMENT '附属被保险人增员人数',
  `inc_revise_slave_premium` double(13, 2) NULL DEFAULT NULL COMMENT '附属增员保费',
  `dec_revise_slave_sum` int(11) NULL DEFAULT NULL COMMENT '附属减员人数',
  `dec_revise_slave_premium` double(13, 2) NULL DEFAULT NULL COMMENT '附属减员保费',
  `inc_dec_premium` double(13, 2) NOT NULL COMMENT '增减员保费',
  `effective_date` datetime(0) NULL DEFAULT NULL COMMENT '生效时间',
  `invalid_date` datetime(0) NULL DEFAULT NULL COMMENT '失效时间',
  `business_belong_user_code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员代码',
  `business_belong_user_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员名称',
  `master_performance_attribution_person_code` int(11) NULL DEFAULT NULL COMMENT '主业绩归属人code',
  `master_performance_attribution_person_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主业绩归属人名称',
  `slave_performance_attribution_person_code` int(11) NULL DEFAULT NULL COMMENT '次业绩归属人code',
  `slave_performance_attribution_person_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '次业绩归属人名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `start_date` datetime(0) NULL DEFAULT NULL COMMENT '保险起期',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '保险止期',
  `cancle_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核未通过原因',
  `coinsurance_is` tinyint(1) NULL DEFAULT 0 COMMENT '是否共保保单 1是、0否',
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '保全状态（1，已生效）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `revise_source` tinyint(1) NULL DEFAULT NULL COMMENT '批单来源  1线上 2线下',
  `take_over_receive_is` tinyint(1) NULL DEFAULT NULL COMMENT '是否代收代付 1是、0否',
  `operator` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operator_code` int(11) NULL DEFAULT NULL COMMENT '操作人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `POLICY_NO_INDEX`(`policy_no`) USING BTREE,
  INDEX `INC_DEC_ORDER_NO`(`inc_dec_order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保全，保单基本信息' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
