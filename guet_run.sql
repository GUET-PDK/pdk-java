/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3307
 Source Schema         : guet_run

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/04/2023 18:27:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for middle_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `middle_role_permission`;
CREATE TABLE `middle_role_permission`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `permission_id` int(0) NOT NULL COMMENT '权限id',
  `creatime_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '最新修改时间',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '状态，默认0可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_roleId`(`role_id`) USING BTREE COMMENT '角色id索引',
  INDEX `idx_permissionId`(`permission_id`) USING BTREE COMMENT '权限id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for middle_user_role
-- ----------------------------
DROP TABLE IF EXISTS `middle_user_role`;
CREATE TABLE `middle_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `creat_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '最新修改时间',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '状态，默认0表示可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_userId`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `idx_roleId`(`role_id`) USING BTREE COMMENT '角色id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_appraise
-- ----------------------------
DROP TABLE IF EXISTS `sys_appraise`;
CREATE TABLE `sys_appraise`  (
  `appraise_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评价id，自动递增',
  `appraise_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `appraise_fraction` int(0) NOT NULL DEFAULT 8 COMMENT '评价分数，默认8分',
  `order_id` int(0) NOT NULL COMMENT '订单id',
  `user_id` int(0) NOT NULL COMMENT '用户id,表示这个评价是谁评的',
  PRIMARY KEY (`appraise_id`) USING BTREE,
  INDEX `idx_userId`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `idx_orderId`(`order_id`) USING BTREE COMMENT '订单id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单id，默认递增',
  `user_id` int(0) NOT NULL COMMENT '下单的人的用户id',
  `take_user_id` int(0) NOT NULL COMMENT '接单的人的用户id',
  `order_type` int(0) NOT NULL COMMENT '这是订单的类型，后续可以用来数字来表示类型',
  `order_status` int(0) NOT NULL COMMENT '订单状态，表示订单在哪一步，这里面也包含了已经取消的订单和删除的订单',
  `create_time` datetime(0) NOT NULL COMMENT '订单创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '订单最新修改时间，包括什么状态的改变',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '订单要求的最早完成时间',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '订单要求的最晚完成时间',
  `address_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址1',
  `address_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址2',
  `order_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单的任务描述',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permission_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id，默认递增',
  `permission_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名字',
  `permission_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限详细描述',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名字',
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id，默认递增',
  `role_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色的详细描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_name` varchar(25) CHARACTER SET ujis COLLATE ujis_japanese_ci NOT NULL COMMENT '用户昵称',
  `user_phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户电话',
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id，默认递增',
  `user_avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `status` int(0) NOT NULL COMMENT '用户的状态，比如正常，冻结，删除',
  `create_time` datetime(0) NOT NULL COMMENT '用户创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '最新修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_address
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_address`;
CREATE TABLE `sys_user_address`  (
  `address_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户常用地址id，默认递增',
  `address_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户输入的各种地址，比如收货地址，目标地址',
  `address_num` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '用户每次下订单所填写的地址如果是这个，数量加1，后续可以用来排序热门常用地址和数据分析',
  `user_id` int(0) NOT NULL COMMENT '所属的用户id',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `idx_userId`(`user_id`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
