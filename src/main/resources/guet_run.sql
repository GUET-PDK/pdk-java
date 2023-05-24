/*
 Navicat Premium Data Transfer

 Source Server         : PDK数据库
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : 117.50.177.54:3306
 Source Schema         : guet_run

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 23/05/2023 14:58:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for back_user_login
-- ----------------------------
DROP TABLE IF EXISTS `back_user_login`;
CREATE TABLE `back_user_login`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `login_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of back_user_login
-- ----------------------------
INSERT INTO `back_user_login` VALUES (1, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 09:38:38');
INSERT INTO `back_user_login` VALUES (2, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 09:46:21');
INSERT INTO `back_user_login` VALUES (3, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 10:03:38');
INSERT INTO `back_user_login` VALUES (4, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-22 10:25:13');
INSERT INTO `back_user_login` VALUES (5, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 10:32:01');
INSERT INTO `back_user_login` VALUES (6, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-22 10:33:54');
INSERT INTO `back_user_login` VALUES (7, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 10:34:47');
INSERT INTO `back_user_login` VALUES (8, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 10:36:55');
INSERT INTO `back_user_login` VALUES (9, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-22 10:38:58');
INSERT INTO `back_user_login` VALUES (10, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-22 10:41:41');
INSERT INTO `back_user_login` VALUES (11, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 11:02:53');
INSERT INTO `back_user_login` VALUES (12, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 13:37:38');
INSERT INTO `back_user_login` VALUES (14, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 13:42:35');
INSERT INTO `back_user_login` VALUES (15, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 13:43:49');
INSERT INTO `back_user_login` VALUES (16, 'c2348078-398b-4978-af65-8bb6579993e7', '2023-05-22 16:20:31');
INSERT INTO `back_user_login` VALUES (17, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 01:36:58');
INSERT INTO `back_user_login` VALUES (18, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 02:28:24');
INSERT INTO `back_user_login` VALUES (19, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 02:45:25');
INSERT INTO `back_user_login` VALUES (20, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 04:46:01');
INSERT INTO `back_user_login` VALUES (21, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 05:00:16');
INSERT INTO `back_user_login` VALUES (22, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 06:52:45');

-- ----------------------------
-- Table structure for middle_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `middle_role_permission`;
CREATE TABLE `middle_role_permission`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `role_id` int NOT NULL COMMENT '角色id',
  `permission_id` int NOT NULL COMMENT '权限id',
  `creatime_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最新修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态，默认0可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_roleId`(`role_id` ASC) USING BTREE COMMENT '角色id索引',
  INDEX `idx_permissionId`(`permission_id` ASC) USING BTREE COMMENT '权限id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of middle_role_permission
-- ----------------------------
INSERT INTO `middle_role_permission` VALUES (1, 1, 1, '2023-04-12 17:15:06', '2023-04-14 17:15:09', 0);
INSERT INTO `middle_role_permission` VALUES (2, 1, 2, '2023-04-22 17:17:01', '2023-04-22 17:17:05', 0);
INSERT INTO `middle_role_permission` VALUES (3, 3, 4, '2023-04-20 17:32:18', '2023-04-20 17:32:23', 0);
INSERT INTO `middle_role_permission` VALUES (4, 2, 3, '2023-04-20 17:33:57', '2023-04-20 17:34:00', 0);

-- ----------------------------
-- Table structure for middle_user_role
-- ----------------------------
DROP TABLE IF EXISTS `middle_user_role`;
CREATE TABLE `middle_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最新修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_roleId`(`role_id` ASC) USING BTREE COMMENT '角色id索引',
  INDEX `idx_userId`(`user_id` ASC) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of middle_user_role
-- ----------------------------
INSERT INTO `middle_user_role` VALUES (8, 'c2348078-398b-4978-af65-8bb6579993e7', 2, '2023-05-21 07:46:02', '2023-05-21 07:46:02');
INSERT INTO `middle_user_role` VALUES (10, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 2, '2023-05-21 07:48:55', '2023-05-21 07:48:55');
INSERT INTO `middle_user_role` VALUES (11, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 07:50:37', '2023-05-21 07:50:37');
INSERT INTO `middle_user_role` VALUES (12, 'c2348078-398b-4978-af65-8bb6579993e7', 1, '2023-05-21 10:02:52', '2023-05-21 10:02:52');
INSERT INTO `middle_user_role` VALUES (13, 'ctfliar', 1, '2023-05-22 18:12:06', '2023-05-22 18:12:06');
INSERT INTO `middle_user_role` VALUES (14, 'ctfliar', 2, '2023-05-22 18:12:13', '2023-05-22 18:12:13');
INSERT INTO `middle_user_role` VALUES (15, 'ctfliar', 3, '2023-05-22 18:12:17', '2023-05-22 18:12:17');
INSERT INTO `middle_user_role` VALUES (16, 'c2348078-398b-4978-af65-8bb6579993e7', 3, '2023-05-22 11:39:59', '2023-05-22 11:39:59');
INSERT INTO `middle_user_role` VALUES (17, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 1, '2023-05-22 11:40:18', '2023-05-22 11:40:18');
INSERT INTO `middle_user_role` VALUES (18, 'hhhhhhhh', 1, '2023-05-22 11:58:21', '2023-05-22 11:58:21');
INSERT INTO `middle_user_role` VALUES (19, 'hhhhhhhh', 2, '2023-05-22 11:58:34', '2023-05-22 11:58:34');
INSERT INTO `middle_user_role` VALUES (20, 'hhhhhhhh', 3, '2023-05-22 11:58:47', '2023-05-22 11:58:47');
INSERT INTO `middle_user_role` VALUES (21, 'bbbbbbbb', 1, '2023-05-22 11:59:04', '2023-05-22 11:59:04');
INSERT INTO `middle_user_role` VALUES (22, 'bbbbbbbb', 2, '2023-05-22 11:59:40', '2023-05-22 11:59:40');
INSERT INTO `middle_user_role` VALUES (23, 'bbbbbbbb', 3, '2023-05-22 11:59:51', '2023-05-22 11:59:51');

-- ----------------------------
-- Table structure for sys_apply_runner
-- ----------------------------
DROP TABLE IF EXISTS `sys_apply_runner`;
CREATE TABLE `sys_apply_runner`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `card_number` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `card_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apply_time` datetime NULL DEFAULT NULL,
  `status` int NOT NULL DEFAULT 0 COMMENT '是否同意，0表示未处理，1表示同意，2表示不同意',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_apply_runner
-- ----------------------------
INSERT INTO `sys_apply_runner` VALUES (1, 'ctfliar', '20003154', '4505511564481651', 'http://43.138.225.254:83/images/1684754834033.jpg', 'http://43.138.225.254:83/images/1684754834034.jpg', '2023-05-22 22:26:38', 2);
INSERT INTO `sys_apply_runner` VALUES (2, 'ctfliar', '4505212001110588854', '2000301617', 'http://43.138.225.254:83/images/1684809753734.jpg', 'http://43.138.225.254:83/images/1684809753734.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (3, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684810483772.JPG', 'http://43.138.225.254:83/images/1684810483772.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (4, 'ctfliar', '4505212001110588854', '2000301617', 'http://43.138.225.254:83/images/1684813477786.jpg', 'http://43.138.225.254:83/images/1684813477787.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (5, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684816272184.JPG', 'http://43.138.225.254:83/images/1684816272184.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (6, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684816284859.JPG', 'http://43.138.225.254:83/images/1684816284859.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (7, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301111', 'http://43.138.225.254:83/images/1684816296103.JPG', 'http://43.138.225.254:83/images/1684816296103.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (8, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452121199909091223', '2000301111', 'http://43.138.225.254:83/images/1684817298638.JPG', 'http://43.138.225.254:83/images/1684817298638.JPG', NULL, 0);

-- ----------------------------
-- Table structure for sys_appraise
-- ----------------------------
DROP TABLE IF EXISTS `sys_appraise`;
CREATE TABLE `sys_appraise`  (
  `appraise_id` int NOT NULL AUTO_INCREMENT COMMENT '评价id，自动递增',
  `appraise_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `appraise_fraction` int NOT NULL DEFAULT 8 COMMENT '评价分数，默认8分',
  `order_id` int NOT NULL COMMENT '订单id',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id,表示这个评价是谁评的',
  PRIMARY KEY (`appraise_id`) USING BTREE,
  INDEX `idx_userId`(`user_id` ASC) USING BTREE COMMENT '用户id索引',
  INDEX `idx_orderId`(`order_id` ASC) USING BTREE COMMENT '订单id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_appraise
-- ----------------------------
INSERT INTO `sys_appraise` VALUES (1, '订单评价描述', 3, 1, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单id，默认递增',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '下单的人的用户id',
  `take_user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接单的人的用户id',
  `order_type` int NOT NULL COMMENT '这是订单的类型，后续可以用来数字来表示类型',
  `order_status` int NOT NULL DEFAULT 0 COMMENT '订单状态，表示订单在哪一步，这里面也包含了已经取消的订单和删除的订单',
  `create_time` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '订单最新修改时间，包括什么状态的改变',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c2348078-398b-4978-af65-8bb6579993e7', 0, 2, '2023-05-21 15:51:35', '2023-05-21 15:51:37');
INSERT INTO `sys_order` VALUES (2, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c2348078-398b-4978-af65-8bb6579993e7', 1, 1, '2023-05-21 16:45:32', '2023-05-22 18:12:45');
INSERT INTO `sys_order` VALUES (3, 'c2348078-398b-4978-af65-8bb6579993e7', NULL, 2, 0, '2023-05-21 16:47:59', '2023-05-21 16:48:01');
INSERT INTO `sys_order` VALUES (4, 'c2348078-398b-4978-af65-8bb6579993e7', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-21 16:49:08', '2023-05-21 16:49:11');
INSERT INTO `sys_order` VALUES (5, 'c2348078-398b-4978-af65-8bb6579993e7', NULL, 1, 0, '2023-05-21 16:50:44', '2023-05-21 16:50:46');
INSERT INTO `sys_order` VALUES (6, 'c2348078-398b-4978-af65-8bb6579993e7', NULL, 3, 0, '2023-05-23 02:06:37', '2023-05-23 02:06:39');
INSERT INTO `sys_order` VALUES (31, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:37:36', '2023-05-23 09:37:36');
INSERT INTO `sys_order` VALUES (32, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:38:43', '2023-05-23 09:38:43');
INSERT INTO `sys_order` VALUES (33, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:41:35', '2023-05-23 09:41:35');
INSERT INTO `sys_order` VALUES (34, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:45:36', '2023-05-23 09:45:36');
INSERT INTO `sys_order` VALUES (35, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:47:33', '2023-05-23 09:47:33');
INSERT INTO `sys_order` VALUES (36, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:47:49', '2023-05-23 09:47:49');
INSERT INTO `sys_order` VALUES (37, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:48:35', '2023-05-23 09:48:35');
INSERT INTO `sys_order` VALUES (38, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:49:50', '2023-05-23 09:49:50');
INSERT INTO `sys_order` VALUES (39, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:51:20', '2023-05-23 09:51:20');
INSERT INTO `sys_order` VALUES (40, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:51:59', '2023-05-23 09:51:59');
INSERT INTO `sys_order` VALUES (41, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:52:56', '2023-05-23 09:52:56');
INSERT INTO `sys_order` VALUES (42, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:54:00', '2023-05-23 09:54:00');
INSERT INTO `sys_order` VALUES (43, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 09:55:51', '2023-05-23 09:55:51');
INSERT INTO `sys_order` VALUES (44, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:32:52', '2023-05-23 12:32:52');
INSERT INTO `sys_order` VALUES (45, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:45:48', '2023-05-23 12:45:48');
INSERT INTO `sys_order` VALUES (46, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:55:33', '2023-05-23 12:55:33');
INSERT INTO `sys_order` VALUES (47, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:56:17', '2023-05-23 12:56:17');
INSERT INTO `sys_order` VALUES (48, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:57:33', '2023-05-23 12:57:33');
INSERT INTO `sys_order` VALUES (49, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:59:09', '2023-05-23 12:59:09');
INSERT INTO `sys_order` VALUES (50, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 12:59:54', '2023-05-23 12:59:54');
INSERT INTO `sys_order` VALUES (51, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:00:29', '2023-05-23 13:00:29');
INSERT INTO `sys_order` VALUES (52, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:00:54', '2023-05-23 13:00:54');
INSERT INTO `sys_order` VALUES (53, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:03:43', '2023-05-23 13:03:43');
INSERT INTO `sys_order` VALUES (54, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:06:26', '2023-05-23 13:06:26');
INSERT INTO `sys_order` VALUES (55, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:06:30', '2023-05-23 13:06:30');
INSERT INTO `sys_order` VALUES (56, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:06:37', '2023-05-23 13:06:37');
INSERT INTO `sys_order` VALUES (57, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:06:56', '2023-05-23 13:06:56');
INSERT INTO `sys_order` VALUES (58, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:07:42', '2023-05-23 13:07:42');
INSERT INTO `sys_order` VALUES (59, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:45:20', '2023-05-23 13:45:20');
INSERT INTO `sys_order` VALUES (60, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:48:31', '2023-05-23 13:48:31');
INSERT INTO `sys_order` VALUES (61, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:48:40', '2023-05-23 13:48:40');
INSERT INTO `sys_order` VALUES (62, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:49:20', '2023-05-23 13:49:20');
INSERT INTO `sys_order` VALUES (63, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 13:50:13', '2023-05-23 13:50:13');
INSERT INTO `sys_order` VALUES (64, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 14:01:42', '2023-05-23 14:01:42');
INSERT INTO `sys_order` VALUES (65, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 14:52:51', '2023-05-23 14:52:51');

-- ----------------------------
-- Table structure for sys_order_sent
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_sent`;
CREATE TABLE `sys_order_sent`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `order_id` int NOT NULL COMMENT '订单id',
  `shipping_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送地址',
  `recipient_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收件人地址',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '要用什么寄，比如圆通等等',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `courier_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递大小',
  `price` int NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代寄送的订单的详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_sent
-- ----------------------------
INSERT INTO `sys_order_sent` VALUES (1, 2, '地址哈哈哈哈哈', '地址凯撒好的杀菌', '中通', '这是备注', '小件', 3);
INSERT INTO `sys_order_sent` VALUES (2, 5, '这里是地址', '地址', '圆通', '备注', '中件', 4);
INSERT INTO `sys_order_sent` VALUES (5, 34, NULL, '广西桂林市灵川县花江村', '圆通', '急急急', '大', 12);
INSERT INTO `sys_order_sent` VALUES (6, 39, NULL, '广西桂林市灵川县花江村', '圆通', '急急急', '中', 12);
INSERT INTO `sys_order_sent` VALUES (7, 44, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 10);
INSERT INTO `sys_order_sent` VALUES (8, 45, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 10);
INSERT INTO `sys_order_sent` VALUES (9, 47, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 10);
INSERT INTO `sys_order_sent` VALUES (10, 52, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 10);
INSERT INTO `sys_order_sent` VALUES (11, 56, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 10);
INSERT INTO `sys_order_sent` VALUES (12, 63, 'F区36栋211室', 'C区25栋108室', '圆通', '急件', '中', 100);

-- ----------------------------
-- Table structure for sys_order_substitution
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_substitution`;
CREATE TABLE `sys_order_substitution`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shipping_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送地址',
  `order_id` int NOT NULL COMMENT '订单id',
  `delivery_time_1` datetime NULL DEFAULT NULL COMMENT '配送时间1',
  `delivery_time_2` datetime NULL DEFAULT NULL COMMENT '配送时间2',
  `pickup_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '取件码截图，为了方便用;隔开每个取件码截图路径',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `courier_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递大小',
  `price` int NULL DEFAULT NULL COMMENT '这个订单的价格，为了方便都用整数吧',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代取快递的表，有代取快递的详细数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_substitution
-- ----------------------------
INSERT INTO `sys_order_substitution` VALUES (1, '地址地址', 1, '2023-05-21 16:36:22', '2023-05-21 16:36:25', '图片路径1;图片路径2;', '备注备注', '大件', 2);
INSERT INTO `sys_order_substitution` VALUES (2, '地址地址', 4, '2023-05-21 16:49:47', '2023-05-21 16:49:52', '图片路径', '备注备注', '小件', 5);

-- ----------------------------
-- Table structure for sys_order_takeaway
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_takeaway`;
CREATE TABLE `sys_order_takeaway`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `shipping_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pick_up_position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_takeaway
-- ----------------------------
INSERT INTO `sys_order_takeaway` VALUES (1, 3, '地址地址', '拿外卖位置', '备注备注5', 2);

-- ----------------------------
-- Table structure for sys_order_type_table_name
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_type_table_name`;
CREATE TABLE `sys_order_type_table_name`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_type` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_type_table_name
-- ----------------------------
INSERT INTO `sys_order_type_table_name` VALUES (1, 'sys_order_sent', '1');
INSERT INTO `sys_order_type_table_name` VALUES (2, 'sys_order_takeaway', '2');
INSERT INTO `sys_order_type_table_name` VALUES (3, 'sys_order_substitution', '0');
INSERT INTO `sys_order_type_table_name` VALUES (4, 'sys_order_universal_service', '3');

-- ----------------------------
-- Table structure for sys_order_universal_service
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_universal_service`;
CREATE TABLE `sys_order_universal_service`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` int NULL DEFAULT NULL COMMENT '订单id',
  `service_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '万能服务描述',
  `price` int NULL DEFAULT NULL COMMENT '价格',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `shipping_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '万能服务详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_universal_service
-- ----------------------------
INSERT INTO `sys_order_universal_service` VALUES (1, 6, '万能服务描述', 2, '需要吃饭', '地址位置');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permission_id` int NOT NULL AUTO_INCREMENT COMMENT 'id，默认递增',
  `permission_name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '权限名字',
  `permission_description` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限详细描述',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '管理用户', '管理用户');
INSERT INTO `sys_permission` VALUES (2, '管理订单', '管理订单');
INSERT INTO `sys_permission` VALUES (3, '下订单', '可以下订单');
INSERT INTO `sys_permission` VALUES (4, '接单', '接单权限');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '角色名字',
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id，默认递增',
  `role_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '角色的详细描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('管理员', 1, '这是管理员');
INSERT INTO `sys_role` VALUES ('普通用户', 2, '这是普通用户');
INSERT INTO `sys_role` VALUES ('骑手', 3, '这是骑手');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_phone` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `user_avatar` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `status` int NOT NULL DEFAULT 0 COMMENT '用户的状态，比如正常，冻结，删除',
  `create_time` datetime NOT NULL COMMENT '用户创建时间',
  `update_time` datetime NOT NULL COMMENT '最新修改时间',
  `open_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'openid',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('测试号', '15197904101', 'bbbbbbbb', '头像路径', 0, '2023-05-22 19:56:36', '2023-05-22 19:56:38', 'sdsjadh');
INSERT INTO `sys_user` VALUES ('蔡小斌测试号', '17878977300', 'c2348078-398b-4978-af65-8bb6579993e7', '头像路径', 0, '2023-05-21 15:46:02', '2023-05-21 15:46:02', 'ozGE75agYA3oh8xtBm4CjAXoCZNQ');
INSERT INTO `sys_user` VALUES ('梁通达测试号', '19580782631', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '头像路径', 0, '2023-05-21 15:48:55', '2023-05-21 15:48:55', 'ozGE75U7iKPop0b9jjwV0ZaxEvbc');
INSERT INTO `sys_user` VALUES ('ctfliar', '13367596017', 'ctfliar', '111', 0, '2023-05-22 17:15:05', '2023-05-22 17:15:07', 'jsfdfjksdbgfjhhds');
INSERT INTO `sys_user` VALUES ('黄潇如测试号', '13481683166', 'hhhhhhhh', '头像路径', 0, '2023-05-22 19:57:03', '2023-05-22 19:57:05', 'jadsgassad');

-- ----------------------------
-- Table structure for sys_user_address
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_address`;
CREATE TABLE `sys_user_address`  (
  `address_id` int NOT NULL AUTO_INCREMENT COMMENT '用户常用地址id，默认递增',
  `address_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户输入的各种地址，比如收货地址，目标地址',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所属的用户id',
  `address_phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '填写的电话',
  `address_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '填写的名字',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `idx_userId`(`user_id` ASC) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_address
-- ----------------------------
INSERT INTO `sys_user_address` VALUES (1, '个人地址描述', 'ctfliar', '地址电话', '地址名字');

-- ----------------------------
-- Table structure for sys_user_image
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_image`;
CREATE TABLE `sys_user_image`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_image
-- ----------------------------
INSERT INTO `sys_user_image` VALUES (1, 'ctfliar', 'http://43.138.225.254:83/images/1684814979369.jpg');

SET FOREIGN_KEY_CHECKS = 1;
