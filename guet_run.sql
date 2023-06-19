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

 Date: 19/06/2023 16:46:12
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
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `back_user_login` VALUES (23, 'f46ad848-9c7d-4552-95bf-4e7c6aab8255', '2023-05-23 07:14:28');
INSERT INTO `back_user_login` VALUES (24, 'f46ad848-9c7d-4552-95bf-4e7c6aab8255', '2023-05-23 07:14:37');
INSERT INTO `back_user_login` VALUES (25, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 12:47:05');
INSERT INTO `back_user_login` VALUES (26, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 23:25:17');
INSERT INTO `back_user_login` VALUES (27, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 23:28:13');
INSERT INTO `back_user_login` VALUES (28, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 23:37:00');
INSERT INTO `back_user_login` VALUES (29, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 23:39:22');
INSERT INTO `back_user_login` VALUES (30, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-23 23:40:30');
INSERT INTO `back_user_login` VALUES (31, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 02:59:39');
INSERT INTO `back_user_login` VALUES (32, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 03:13:25');
INSERT INTO `back_user_login` VALUES (33, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 10:11:10');
INSERT INTO `back_user_login` VALUES (34, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 16:10:41');
INSERT INTO `back_user_login` VALUES (35, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 16:25:55');
INSERT INTO `back_user_login` VALUES (36, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-24 18:44:30');
INSERT INTO `back_user_login` VALUES (37, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 04:19:04');
INSERT INTO `back_user_login` VALUES (38, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 04:41:37');
INSERT INTO `back_user_login` VALUES (39, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 05:18:51');
INSERT INTO `back_user_login` VALUES (40, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 06:10:54');
INSERT INTO `back_user_login` VALUES (41, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 15:27:05');
INSERT INTO `back_user_login` VALUES (42, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 17:54:34');
INSERT INTO `back_user_login` VALUES (43, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 17:57:00');
INSERT INTO `back_user_login` VALUES (44, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-25 23:58:58');
INSERT INTO `back_user_login` VALUES (45, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '2023-05-26 04:49:43');
INSERT INTO `back_user_login` VALUES (46, 'ec2798be-31d8-447f-8621-47e57012758d', '2023-06-07 03:42:27');

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
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

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
INSERT INTO `middle_user_role` VALUES (24, 'f46ad848-9c7d-4552-95bf-4e7c6aab8255', 2, '2023-05-23 07:14:28', '2023-05-23 07:14:28');
INSERT INTO `middle_user_role` VALUES (25, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-23 00:00:00');
INSERT INTO `middle_user_role` VALUES (26, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (27, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (28, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (29, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (30, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (31, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (32, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (33, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (34, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (35, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (36, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-25 00:00:00');
INSERT INTO `middle_user_role` VALUES (37, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (38, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (39, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (40, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (41, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (42, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (43, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (44, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (45, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (46, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (47, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (48, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (49, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (50, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (51, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (52, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (53, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (54, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (55, 'ctfliar', 3, '2023-05-22 17:15:05', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (56, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 3, '2023-05-21 15:48:55', '2023-05-26 00:00:00');
INSERT INTO `middle_user_role` VALUES (57, 'ec2798be-31d8-447f-8621-47e57012758d', 2, '2023-06-07 03:42:27', '2023-06-07 03:42:27');

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
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_apply_runner
-- ----------------------------
INSERT INTO `sys_apply_runner` VALUES (1, 'ctfliar', '20003154', '4505511564481651', 'http://43.138.225.254:83/images/1684754834033.jpg', 'http://43.138.225.254:83/images/1684754834034.jpg', '2023-05-22 22:26:38', 1);
INSERT INTO `sys_apply_runner` VALUES (2, 'ctfliar', '4505212001110588854', '2000301617', 'http://43.138.225.254:83/images/1684809753734.jpg', 'http://43.138.225.254:83/images/1684809753734.jpg', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (3, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684810483772.JPG', 'http://43.138.225.254:83/images/1684810483772.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (4, 'ctfliar', '4505212001110588854', '2000301617', 'http://43.138.225.254:83/images/1684813477786.jpg', 'http://43.138.225.254:83/images/1684813477787.jpg', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (5, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684816272184.JPG', 'http://43.138.225.254:83/images/1684816272184.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (6, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301417', 'http://43.138.225.254:83/images/1684816284859.JPG', 'http://43.138.225.254:83/images/1684816284859.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (7, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452126200003012113', '2000301111', 'http://43.138.225.254:83/images/1684816296103.JPG', 'http://43.138.225.254:83/images/1684816296103.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (8, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '452121199909091223', '2000301111', 'http://43.138.225.254:83/images/1684817298638.JPG', 'http://43.138.225.254:83/images/1684817298638.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (9, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684837083649.jpg', 'http://43.138.225.254:83/images/1684837083650.jpg', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (10, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684843771811.jpg', 'http://43.138.225.254:83/images/1684843771811.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (11, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684849445826.jpg', 'http://43.138.225.254:83/images/1684849445826.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (12, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684849951312.jpg', 'http://43.138.225.254:83/images/1684849951312.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (13, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684849988736.jpg', 'http://43.138.225.254:83/images/1684849988737.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (14, 'ctfliar', '222', '44444', 'http://43.138.225.254:83/images/1684850035411.jpg', 'http://43.138.225.254:83/images/1684850035415.jpg', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (15, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '123123', '123123', 'http://43.138.225.254:83/images/1684850192448.JPG', 'http://43.138.225.254:83/images/1684850192448.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (16, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '231231', '32131', 'http://43.138.225.254:83/images/1684853756928.JPG', 'http://43.138.225.254:83/images/1684853756928.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (17, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900301919', '322323199909091999', 'http://43.138.225.254:83/images/1684862683448.JPG', 'http://43.138.225.254:83/images/1684862683448.JPG', NULL, 1);
INSERT INTO `sys_apply_runner` VALUES (18, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300314', '452123199909091992', 'http://43.138.225.254:83/images/1684936032928.JPG', 'http://43.138.225.254:83/images/1684936032928.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (19, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900900312', '452126200003012113', 'http://43.138.225.254:83/images/1684936417705.JPG', 'http://43.138.225.254:83/images/1684936417705.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (20, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900301417', '452326199909211122', 'http://43.138.225.254:83/images/1684936684211.JPG', 'http://43.138.225.254:83/images/1684936684213.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (21, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900201313', '452126200003012113', 'http://43.138.225.254:83/images/1684937362407.JPG', 'http://43.138.225.254:83/images/1684937362408.JPG', NULL, 2);
INSERT INTO `sys_apply_runner` VALUES (22, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300312', '452126199909091999', 'http://43.138.225.254:83/images/1684937561500.JPG', 'http://43.138.225.254:83/images/1684937561500.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (23, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300312', '342126199909091999', 'http://43.138.225.254:83/images/1684937720840.JPG', 'http://43.138.225.254:83/images/1684937720840.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (24, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300312', '342126200009091999', 'http://43.138.225.254:83/images/1684937848982.JPG', 'http://43.138.225.254:83/images/1684937848982.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (25, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300312', '342126199909091999', 'http://43.138.225.254:83/images/1684938173567.JPG', 'http://43.138.225.254:83/images/1684938173568.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (26, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900900312', '342125200009091999', 'http://43.138.225.254:83/images/1684938255366.JPG', 'http://43.138.225.254:83/images/1684938255366.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (27, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900300312', '342126199909091999', 'http://43.138.225.254:83/images/1684938420763.JPG', 'http://43.138.225.254:83/images/1684938420763.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (28, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900900312', '342125199909091999', 'http://43.138.225.254:83/images/1684938475728.JPG', 'http://43.138.225.254:83/images/1684938475728.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (29, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '1900301417', '342125199909091221', 'http://43.138.225.254:83/images/1685041819637.JPG', 'http://43.138.225.254:83/images/1685041819637.JPG', NULL, 0);
INSERT INTO `sys_apply_runner` VALUES (30, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '嘿嘿', '\'嘿嘿', 'http://43.138.225.254:83/images/1685065232375.jpg', 'http://43.138.225.254:83/images/1685065232375.jpg', NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_appraise
-- ----------------------------
INSERT INTO `sys_appraise` VALUES (1, '订单评价描述', 3, 1, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (2, '2', 2, 2, 'ctfliar');
INSERT INTO `sys_appraise` VALUES (3, '2', 2, 2, 'ctfliar');
INSERT INTO `sys_appraise` VALUES (4, '真不错', 7, 137, 'ctfliar');
INSERT INTO `sys_appraise` VALUES (5, '真不错', 7, 136, 'ctfliar');
INSERT INTO `sys_appraise` VALUES (6, '真不错', 7, 139, 'ctfliar');
INSERT INTO `sys_appraise` VALUES (7, '', 8, 123, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (8, '', 0, 127, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (9, '', 0, 127, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (10, '', 0, 103, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (11, '', 0, 102, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (12, '', 8, 129, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');
INSERT INTO `sys_appraise` VALUES (13, '', 0, 131, 'c67b0757-6386-4b7b-bc4c-f282ed0db580');

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
) ENGINE = InnoDB AUTO_INCREMENT = 198 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (118, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 20:13:09', '2023-05-23 20:13:09');
INSERT INTO `sys_order` VALUES (125, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 20:34:29', '2023-05-23 20:34:29');
INSERT INTO `sys_order` VALUES (126, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-23 22:59:50', '2023-05-23 22:59:50');
INSERT INTO `sys_order` VALUES (127, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 08:21:49', '2023-05-25 20:49:29');
INSERT INTO `sys_order` VALUES (128, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 08:25:59', '2023-05-25 21:05:59');
INSERT INTO `sys_order` VALUES (129, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 08:28:05', '2023-05-25 21:06:24');
INSERT INTO `sys_order` VALUES (131, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 08:48:33', '2023-05-25 21:15:07');
INSERT INTO `sys_order` VALUES (132, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 08:49:19', '2023-05-25 21:14:54');
INSERT INTO `sys_order` VALUES (133, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 08:50:26', '2023-05-25 21:20:31');
INSERT INTO `sys_order` VALUES (134, 'ctfliar', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 09:21:42', '2023-05-25 21:38:06');
INSERT INTO `sys_order` VALUES (135, 'ctfliar', 'ctfliar', 1, 1, '2023-05-24 09:22:27', '2023-05-24 10:02:54');
INSERT INTO `sys_order` VALUES (136, 'ctfliar', NULL, 2, 2, '2023-05-24 09:23:05', '2023-05-24 09:23:05');
INSERT INTO `sys_order` VALUES (137, 'ctfliar', NULL, 3, 2, '2023-05-24 09:23:43', '2023-05-24 09:23:43');
INSERT INTO `sys_order` VALUES (138, 'ctfliar', NULL, 1, 0, '2023-05-24 10:13:21', '2023-05-24 10:13:21');
INSERT INTO `sys_order` VALUES (139, 'ctfliar', NULL, 1, 2, '2023-05-24 10:13:42', '2023-05-24 10:13:42');
INSERT INTO `sys_order` VALUES (140, 'ctfliar', 'ctfliar', 1, 1, '2023-05-24 10:13:57', '2023-05-24 10:14:24');
INSERT INTO `sys_order` VALUES (143, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 12:07:44', '2023-05-25 21:15:46');
INSERT INTO `sys_order` VALUES (144, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-24 12:09:00', '2023-05-24 12:09:00');
INSERT INTO `sys_order` VALUES (145, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-24 13:00:11', '2023-05-24 13:00:11');
INSERT INTO `sys_order` VALUES (146, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 13:13:04', '2023-05-25 23:11:17');
INSERT INTO `sys_order` VALUES (147, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 13:23:24', '2023-05-25 21:08:32');
INSERT INTO `sys_order` VALUES (148, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 14:54:11', '2023-05-25 23:12:11');
INSERT INTO `sys_order` VALUES (149, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 2, '2023-05-24 15:57:50', '2023-05-25 21:10:39');
INSERT INTO `sys_order` VALUES (151, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-24 16:05:43', '2023-05-24 16:05:43');
INSERT INTO `sys_order` VALUES (153, 'ctfliar', NULL, 1, 0, '2023-05-24 16:45:50', '2023-05-24 16:45:50');
INSERT INTO `sys_order` VALUES (154, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-24 16:51:33', '2023-05-25 20:50:56');
INSERT INTO `sys_order` VALUES (155, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-24 17:04:06', '2023-05-24 17:04:06');
INSERT INTO `sys_order` VALUES (156, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 2, 1, '2023-05-24 17:09:49', '2023-05-26 12:53:05');
INSERT INTO `sys_order` VALUES (157, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-24 17:21:56', '2023-05-24 17:21:56');
INSERT INTO `sys_order` VALUES (158, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-24 17:42:18', '2023-05-24 17:42:18');
INSERT INTO `sys_order` VALUES (159, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-24 18:12:26', '2023-05-24 18:12:26');
INSERT INTO `sys_order` VALUES (160, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-24 18:12:40', '2023-05-24 18:12:40');
INSERT INTO `sys_order` VALUES (161, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-24 18:17:03', '2023-05-24 18:17:03');
INSERT INTO `sys_order` VALUES (162, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-24 21:04:13', '2023-05-24 21:04:13');
INSERT INTO `sys_order` VALUES (163, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 03:50:19', '2023-05-25 03:50:19');
INSERT INTO `sys_order` VALUES (164, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 10:20:06', '2023-05-25 10:20:06');
INSERT INTO `sys_order` VALUES (165, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 10:46:52', '2023-05-25 10:46:52');
INSERT INTO `sys_order` VALUES (166, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 10:51:17', '2023-05-25 10:51:17');
INSERT INTO `sys_order` VALUES (167, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:00:59', '2023-05-25 11:00:59');
INSERT INTO `sys_order` VALUES (168, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:05:51', '2023-05-25 11:05:51');
INSERT INTO `sys_order` VALUES (169, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:06:40', '2023-05-25 11:06:40');
INSERT INTO `sys_order` VALUES (170, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:12:49', '2023-05-25 11:12:49');
INSERT INTO `sys_order` VALUES (171, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:13:59', '2023-05-25 11:13:59');
INSERT INTO `sys_order` VALUES (172, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:14:36', '2023-05-25 11:14:36');
INSERT INTO `sys_order` VALUES (173, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:18:45', '2023-05-25 11:18:45');
INSERT INTO `sys_order` VALUES (174, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-25 11:25:56', '2023-05-25 11:25:56');
INSERT INTO `sys_order` VALUES (175, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-26 00:55:09', '2023-05-26 00:55:09');
INSERT INTO `sys_order` VALUES (176, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-26 00:57:09', '2023-05-26 00:57:09');
INSERT INTO `sys_order` VALUES (182, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-26 05:27:42', '2023-05-26 05:27:42');
INSERT INTO `sys_order` VALUES (185, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 0, 1, '2023-05-26 05:31:58', '2023-05-26 12:51:33');
INSERT INTO `sys_order` VALUES (190, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-26 05:33:30', '2023-05-26 05:33:30');
INSERT INTO `sys_order` VALUES (191, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 1, 0, '2023-05-26 05:33:44', '2023-05-26 05:33:44');
INSERT INTO `sys_order` VALUES (192, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-26 05:36:09', '2023-05-26 05:36:09');
INSERT INTO `sys_order` VALUES (193, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-26 05:37:25', '2023-05-26 05:37:25');
INSERT INTO `sys_order` VALUES (194, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-26 05:38:13', '2023-05-26 05:38:13');
INSERT INTO `sys_order` VALUES (195, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-26 05:41:09', '2023-05-26 05:41:09');
INSERT INTO `sys_order` VALUES (196, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 3, 0, '2023-05-26 05:42:25', '2023-05-26 05:42:25');
INSERT INTO `sys_order` VALUES (197, 'c67b0757-6386-4b7b-bc4c-f282ed0db580', NULL, 0, 0, '2023-05-26 05:44:04', '2023-05-26 05:44:04');

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
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代寄送的订单的详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_sent
-- ----------------------------
INSERT INTO `sys_order_sent` VALUES (17, 92, '2', '2', '圆通', '2', '2', 2);
INSERT INTO `sys_order_sent` VALUES (18, 93, '2', '2', '圆通', '2', '2', 2);
INSERT INTO `sys_order_sent` VALUES (19, 94, '2', '2', '圆通', '2', '2', 2);
INSERT INTO `sys_order_sent` VALUES (20, 96, '2', '2', '圆通', '2', '2', 2);
INSERT INTO `sys_order_sent` VALUES (26, 105, '2', '2', '圆通', '2', '2', 2);
INSERT INTO `sys_order_sent` VALUES (27, 118, '16教', '17教', '圆通', '急件', '小', 50);
INSERT INTO `sys_order_sent` VALUES (28, 125, '16教', '17教', '圆通', '急件', '小', 50);
INSERT INTO `sys_order_sent` VALUES (29, 126, '16教', '17教', '圆通', '急件', '小', 50);
INSERT INTO `sys_order_sent` VALUES (30, 135, '这里', '那里', '圆通', '哈哈哈', '大', 2);
INSERT INTO `sys_order_sent` VALUES (31, 138, 'hhhh', 'hhhh', '圆通', 'hhhh', 'hhhhh', 2);
INSERT INTO `sys_order_sent` VALUES (32, 139, 'ttttt', 'tttttt', '圆通', 'ttt', 'tttt', 8);
INSERT INTO `sys_order_sent` VALUES (33, 140, 'aaaaaa', 'aaaaaa', '圆通', 'aaaaaa', 'aaaaaa', 8);
INSERT INTO `sys_order_sent` VALUES (34, 144, '(姓名+电话+宿舍号)', '17教', '圆通', NULL, '小', 50);
INSERT INTO `sys_order_sent` VALUES (35, 145, '(姓名+电话+宿舍号)', '17教', '圆通', NULL, '小', 50);
INSERT INTO `sys_order_sent` VALUES (36, 151, '测试', '测试', '圆通', '', '大', 5);
INSERT INTO `sys_order_sent` VALUES (37, 153, 'aaaaaa', 'aaaaaa', '圆通', 'aaaaaa', NULL, 8);
INSERT INTO `sys_order_sent` VALUES (38, 155, NULL, NULL, NULL, NULL, NULL, 5);
INSERT INTO `sys_order_sent` VALUES (39, 159, '(姓名+电话+宿舍号)', '测试', '中通', '', NULL, 3);
INSERT INTO `sys_order_sent` VALUES (40, 191, '花江校区F区36栋211,1990', '', NULL, '', NULL, 3);

-- ----------------------------
-- Table structure for sys_order_substitution
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_substitution`;
CREATE TABLE `sys_order_substitution`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shipping_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送地址',
  `order_id` int NOT NULL COMMENT '订单id',
  `delivery_time_1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送时间1',
  `delivery_time_2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送时间2',
  `pickup_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '取件码截图，为了方便用;隔开每个取件码截图路径',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `courier_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递大小',
  `price` int NULL DEFAULT NULL COMMENT '这个订单的价格，为了方便都用整数吧',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代取快递的表，有代取快递的详细数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_substitution
-- ----------------------------
INSERT INTO `sys_order_substitution` VALUES (5, '1', 113, '2020', '20221', 'http://43.138.225.254:83/images/1684838277457.jpg', '1', '1', 1);
INSERT INTO `sys_order_substitution` VALUES (6, '1', 114, '2020', '20221', 'http://43.138.225.254:83/images/1684838353329.jpg', '1', '1', 1);
INSERT INTO `sys_order_substitution` VALUES (7, 'F区', 127, '12:00', '14:00', 'http://43.138.225.254:83/images/1684887708765.JPG', '', '大', 3);
INSERT INTO `sys_order_substitution` VALUES (8, '花江校区C区20栋202,2341', 128, '19:00', '22:00', 'http://43.138.225.254:83/images/1684887959526.JPG', '', '中', 2);
INSERT INTO `sys_order_substitution` VALUES (9, '花江校区C区20栋202,2341', 129, '12:00', '14:00', 'http://43.138.225.254:83/images/1684888084878.JPG', '', '小', 1);
INSERT INTO `sys_order_substitution` VALUES (10, '花江校区C区20栋202,2341', 131, '19:00', '22:00', 'http://43.138.225.254:83/images/1684889313373.JPG', '123', '中', 2);
INSERT INTO `sys_order_substitution` VALUES (11, '花江校区C区20栋202,2341', 132, '19:00', '22:00', 'http://43.138.225.254:83/images/1684889359577.JPG', NULL, '中', 2);
INSERT INTO `sys_order_substitution` VALUES (12, '花江校区C区20栋202,2341', 133, '19:00', '22:00', 'http://43.138.225.254:83/images/1684889426157.JPG', NULL, '中', 2);
INSERT INTO `sys_order_substitution` VALUES (13, 'f区', 134, '2022', '2023', 'http://43.138.225.254:83/images/1684891302596.jpg', '随便', '大', 2);
INSERT INTO `sys_order_substitution` VALUES (14, '花江校区F区36栋211,1990', 143, '19:00', '22:00', 'http://43.138.225.254:83/images/1684901264448.JPG', NULL, '中', 2);
INSERT INTO `sys_order_substitution` VALUES (15, '花江校区F区36栋211,1990', 146, '19:00', '22:00', 'http://43.138.225.254:83/images/1684905184236.JPG', NULL, '中', 2);
INSERT INTO `sys_order_substitution` VALUES (16, '花江校区F区36栋211,1990', 147, '19:00', '22:00', 'http://43.138.225.254:83/images/1684905804435.JPG', NULL, '中', 2);
INSERT INTO `sys_order_substitution` VALUES (17, '花江校区F区36栋211,1990', 148, '12:00', '14:00', 'http://43.138.225.254:83/images/1684911251004.JPG', NULL, '小', 1);
INSERT INTO `sys_order_substitution` VALUES (18, '花江校区F区36栋211,1990', 149, '19:00', '22:00', 'http://43.138.225.254:83/images/1684915070361.JPG', '', '大', 3);
INSERT INTO `sys_order_substitution` VALUES (19, '花江校区F区36栋211,1990', 154, '19:00', '22:00', 'http://43.138.225.254:83/images/1684918293570.JPG', '', NULL, 2);
INSERT INTO `sys_order_substitution` VALUES (20, '(姓名+电话+宿舍号)', 162, '19:00', '22:00', 'http://43.138.225.254:83/images/1684933453282.JPG', '', NULL, 2);
INSERT INTO `sys_order_substitution` VALUES (21, '花江校区F区36栋211,1990', 163, '12:00', '14:00', 'http://43.138.225.254:83/images/1684957819233.JPG', '', NULL, 3);
INSERT INTO `sys_order_substitution` VALUES (22, '22', 164, '22', '22', 'http://43.138.225.254:83/images/1684981206294.jpg', '22', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (23, '花江校区F区36栋211,1990', 165, '12:00', '14:00', 'http://43.138.225.254:83/images/1684982811778.JPG', '', NULL, 3);
INSERT INTO `sys_order_substitution` VALUES (24, '123', 166, '12,', '14', 'http://43.138.225.254:83/images/1684983077476.JPG', '无', NULL, 3);
INSERT INTO `sys_order_substitution` VALUES (25, '22', 167, '22', '22', NULL, '22', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (26, '22', 168, '22', '22', NULL, '22', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (27, 'hh', 169, 'hh', 'hh', NULL, 'hh', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (28, 'hh', 170, 'hh', 'hh', NULL, 'hh', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (29, 'hh', 171, 'hh', 'hh', NULL, 'hh', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (30, 'hh', 172, 'hh', 'hh', 'http://43.138.225.254:83/images/1684984476619.jpg', 'hh', NULL, 22);
INSERT INTO `sys_order_substitution` VALUES (31, 'hh', 173, 'hh', 'hh', NULL, 'hh', '大', 22);
INSERT INTO `sys_order_substitution` VALUES (32, 'hh', 174, 'hh', 'hh', NULL, 'hh', '大', 22);
INSERT INTO `sys_order_substitution` VALUES (33, '这里', 175, '2020', '2023', 'http://43.138.225.254:83/images/1685033709526.jpg', '快一点', '大', 2);
INSERT INTO `sys_order_substitution` VALUES (34, '这里', 176, '2020', '2023', 'http://43.138.225.254:83/images/1685033828771.jpg', '快一点', '大', 2);
INSERT INTO `sys_order_substitution` VALUES (35, '(姓名+电话+宿舍号)', 182, '12:00', '14:00', 'http://43.138.225.254:83/images/1685050062221.JPG', '', '中', 2);
INSERT INTO `sys_order_substitution` VALUES (36, '(姓名+电话+宿舍号)', 185, '19:00', '22:00', 'http://43.138.225.254:83/images/1685050318046.JPG', '', '中', 2);
INSERT INTO `sys_order_substitution` VALUES (37, '花江校区F区36栋211,1990', 190, '19:00', '22:00', 'http://43.138.225.254:83/images/1685050409822.JPG', '', '中', 3);
INSERT INTO `sys_order_substitution` VALUES (38, '花江校区F区36栋211,1990', 197, '19:00', '22:00', 'http://43.138.225.254:83/images/1685051044547.JPG', '', '中', 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_takeaway
-- ----------------------------
INSERT INTO `sys_order_takeaway` VALUES (1, 3, '地址地址', '拿外卖位置', '备注备注5', 2);
INSERT INTO `sys_order_takeaway` VALUES (4, 99, 'A区', 'B区', '测试', 20);
INSERT INTO `sys_order_takeaway` VALUES (5, 106, '2', '2', '2', 2);
INSERT INTO `sys_order_takeaway` VALUES (6, 136, '这里', '拿', '嘿嘿', 2);
INSERT INTO `sys_order_takeaway` VALUES (7, 156, NULL, NULL, NULL, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '万能服务详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_universal_service
-- ----------------------------
INSERT INTO `sys_order_universal_service` VALUES (1, 6, '万能服务描述', 2, '需要吃饭', '地址位置');
INSERT INTO `sys_order_universal_service` VALUES (2, 107, '2', 2, '2', NULL);
INSERT INTO `sys_order_universal_service` VALUES (3, 137, '嘿嘿', 3, '嘿嘿', NULL);
INSERT INTO `sys_order_universal_service` VALUES (4, 157, NULL, 2, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (5, 158, NULL, 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (6, 160, '帮俺甘愿神', 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (7, 161, '包租婆，没水啦', 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (8, 192, NULL, 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (9, 193, NULL, 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (10, 194, '123', 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (11, 195, NULL, 3, NULL, NULL);
INSERT INTO `sys_order_universal_service` VALUES (12, 196, '12313212', 2, NULL, NULL);

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
  `user_avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `status` int NOT NULL DEFAULT 0 COMMENT '用户的状态，比如正常，冻结，删除',
  `create_time` datetime NOT NULL COMMENT '用户创建时间',
  `update_time` datetime NOT NULL COMMENT '最新修改时间',
  `open_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'openid',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('测试号', '15197904101', 'bbbbbbbb', '头像路径', 0, '2023-05-22 19:56:36', '2023-05-22 19:56:38', 'sdsjadh');
INSERT INTO `sys_user` VALUES ('蔡小斌测试号', '17878977300', 'c2348078-398b-4978-af65-8bb6579993e7', '头像路径', 0, '2023-05-21 15:46:02', '2023-05-21 15:46:02', 'ozGE75agYA3oh8xtBm4CjAXoCZNQ');
INSERT INTO `sys_user` VALUES ('hh', '12333333', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', 'http://43.138.225.254:83/images/1685034183083.jpg', 0, '2023-05-21 15:48:55', '2023-05-21 15:48:55', 'ozGE75U7iKPop0b9jjwV0ZaxEvbc');
INSERT INTO `sys_user` VALUES ('lsx', '1333333333', 'ctfliar', 'http://43.138.225.254:83/images/1684934651877.jpg', 0, '2023-05-22 17:15:05', '2023-05-22 17:15:07', 'jsfdfjksdbgfjhhds');
INSERT INTO `sys_user` VALUES (NULL, NULL, 'ec2798be-31d8-447f-8621-47e57012758d', NULL, 0, '2023-06-07 11:42:27', '2023-06-07 11:42:27', 'ozGE75cBb_j3go39TQiFalwpnSHk');
INSERT INTO `sys_user` VALUES (NULL, NULL, 'f46ad848-9c7d-4552-95bf-4e7c6aab8255', NULL, 0, '2023-05-23 15:14:28', '2023-05-23 15:14:28', 'ozGE75U_mOta4RqkTrQhO9adbHNg');
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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_address
-- ----------------------------
INSERT INTO `sys_user_address` VALUES (1, '2', 'ctfliar', '2', '2');
INSERT INTO `sys_user_address` VALUES (2, '1', 'ctfliar', '2', '2');
INSERT INTO `sys_user_address` VALUES (3, '4', 'ctfliar', '4', '4');
INSERT INTO `sys_user_address` VALUES (6, 'iii', 'ctfliar', 'eeee', '4444');
INSERT INTO `sys_user_address` VALUES (13, '花江校区F区36栋211', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '19114711990', '蛋白质');
INSERT INTO `sys_user_address` VALUES (14, '花江校区F区36栋211', 'c67b0757-6386-4b7b-bc4c-f282ed0db580', '19117701990', '蛋白质');

-- ----------------------------
-- Table structure for sys_user_image
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_image`;
CREATE TABLE `sys_user_image`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_image
-- ----------------------------
INSERT INTO `sys_user_image` VALUES (2, 'ctfliar', NULL);
INSERT INTO `sys_user_image` VALUES (3, 'ctfliar', NULL);
INSERT INTO `sys_user_image` VALUES (4, 'ctfliar', NULL);

SET FOREIGN_KEY_CHECKS = 1;
