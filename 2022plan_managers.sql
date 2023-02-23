/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : 2022plan_managers

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 03/07/2022 13:36:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '自我简介',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('3f06bc95352646b0a0b996a07e1d4e4d', 'root', 'dbb1c112a931eeb16299d9de1f30161d', '王泽华', '0', '19812122211', '2', '高级工程师', '\\upload\\demo-jdbc-ks\\67e6dabf623f495cac2f294758e6e77f.jpg');
INSERT INTO `db_user` VALUES ('62e01b0c753f4e618bc68245c93f7c80', 'admin', 'a66abb5684c45962d887564f08346e8d', '管理员', '0', '18012121212', '1', '', '\\upload\\demo-jdbc-ks\\8ba2315be99743139419649573d3744b.jpg');
INSERT INTO `db_user` VALUES ('fa61a3d645d2427da0acf4cdb5e2feac', 'test', '47ec2dd791e31e2ef2076caf64ed9b3d', '张翠山', '1', '19812122211', '3', '', '\\upload\\demo-jdbc-ks\\b3563fcfd59f47c3a940aee6f14e8fb5.jpg');

-- ----------------------------
-- Table structure for plan_audit_records
-- ----------------------------
DROP TABLE IF EXISTS `plan_audit_records`;
CREATE TABLE `plan_audit_records`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `scheme_no` bigint(25) NOT NULL COMMENT '方案编号',
  `scheme_audit_date` datetime(0) NOT NULL COMMENT '审核日期',
  `ccheme_review_comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审核意见',
  `scheme_reviewer` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审核人',
  `audit_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审批结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_audit_records
-- ----------------------------
INSERT INTO `plan_audit_records` VALUES ('1543423555206676480', 1543225946420576256, '2022-07-03 00:00:00', '方案不行，修改吧', 'admin', '0');
INSERT INTO `plan_audit_records` VALUES ('1543424526460682240', 1543225946420576256, '2022-07-03 00:00:00', '行吧，先测试一下', 'admin', '1');
INSERT INTO `plan_audit_records` VALUES ('1543430361299582976', 1543429518118649856, '2022-07-03 00:00:00', '小白鼠死了怎么办！', 'admin', '0');
INSERT INTO `plan_audit_records` VALUES ('1543430893128941568', 1543429518118649856, '2022-07-03 00:00:00', '同意！', 'admin', '1');
INSERT INTO `plan_audit_records` VALUES ('1543437823578767360', 1543436211179257856, '2022-07-03 00:00:00', '重来', 'admin', '0');

-- ----------------------------
-- Table structure for plan_book_makes
-- ----------------------------
DROP TABLE IF EXISTS `plan_book_makes`;
CREATE TABLE `plan_book_makes`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `scheme_no` bigint(25) NOT NULL COMMENT '方案编号',
  `scheme_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案描述',
  `scheme_program_rules` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案细则',
  `scheme_formulator` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '制定员',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '制定日期',
  `requirement_item_no` bigint(25) NOT NULL COMMENT '需求编号',
  `plan_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '方案状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_book_makes
-- ----------------------------
INSERT INTO `plan_book_makes` VALUES ('1543225946420576256', 1543225946420576256, '测试\r\n', '1.安装环境\r\n2。下载demo程序并运行\r\n3。修改demo程序\r\n4. 运行程序。', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-03 00:00:00', 1543153583318401024, '4');
INSERT INTO `plan_book_makes` VALUES ('1543406710625959936', 1543406710625959936, 'asdasd', 'sadasdasd\r\nad\r\nas\r\ndsa\r\ndas\r\nuuuu', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-03 00:00:00', 1543153583318401024, '0');
INSERT INTO `plan_book_makes` VALUES ('1543429518118649856', 1543429518118649856, '小白鼠存活实验', '1.准备一个密闭的空间\r\n2.准备三只小白鼠；\r\n3.分别给小白鼠注入药物，保证小白鼠不死亡；\r\n3.将小白鼠放入密闭空间\r\n5.观察小白鼠\r\n6.记录小白鼠的每日变化\r\n7.撰写报告', 'fa61a3d645d2427da0acf4cdb5e2feac', '2022-07-03 00:00:00', 1543153583318401024, '4');
INSERT INTO `plan_book_makes` VALUES ('1543436211179257856', 1543436211179257856, '测试方案', '1.安装软件环境，配置jdk环境遍历\r\n2.新建一个普通的web工程，\r\n3.引入数据库驱动包\r\n4.完成数据库链接jdbc代码编写\r\n5.完成jdbc操作数据增删改查操作\r\n6.测试软件功能\r\n7.打包上传', 'fa61a3d645d2427da0acf4cdb5e2feac', '2022-07-03 00:00:00', 1543433099538366464, '2');

-- ----------------------------
-- Table structure for plan_demand_info
-- ----------------------------
DROP TABLE IF EXISTS `plan_demand_info`;
CREATE TABLE `plan_demand_info`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `requirement_item_no` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '需求项编号',
  `experiment_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实验名',
  `experimental_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实验描述',
  `date_of_preliminary_review` datetime(0) NULL DEFAULT NULL COMMENT '初审日期',
  `preliminary_examiner` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '初审员',
  `applicant_department` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申请人部门',
  `name_of_applicant` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申请人姓名',
  `application_date` datetime(0) NULL DEFAULT NULL COMMENT '申请日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_demand_info
-- ----------------------------
INSERT INTO `plan_demand_info` VALUES ('1543153583318401024', '1543153583318401024', '小白鼠试验', '实验描述杀杀杀', '2022-07-02 00:00:00', '李老师', 'f36f86948ac94773b1eb5b00fe112491', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-02 00:00:00');
INSERT INTO `plan_demand_info` VALUES ('1543433099538366464', '1543433099538366464', 'javaweb上机实验', '使用jsp,servlet,jdbc完成用户的增删改查操作；\r\n要求：\r\n1.不得使用第三方任何框架，如spring，springboot等\r\n2.不得抄袭，抄袭按零分处理。', '2022-07-03 00:00:00', '李老师', 'f36f86948ac94773b1eb5b00fe112491', '3f06bc95352646b0a0b996a07e1d4e4d', '2022-07-03 00:00:00');

-- ----------------------------
-- Table structure for plan_fix_records
-- ----------------------------
DROP TABLE IF EXISTS `plan_fix_records`;
CREATE TABLE `plan_fix_records`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `scheme_no` bigint(25) NOT NULL COMMENT '方案编号',
  `scheme_modification_record` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案修改记录',
  `scheme_repairer` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '返修人',
  `scheme_repair_date` datetime(0) NULL DEFAULT NULL COMMENT '返修日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_fix_records
-- ----------------------------
INSERT INTO `plan_fix_records` VALUES ('1543225948442230785', 1543225946420576256, 'sdsd', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-02 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543226771956072449', 1543225946420576256, 'dsfsdfsdfsdf', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-02 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543226934611181569', 1543225946420576256, '1.安装环境\r\n2。下载demo程序并运行\r\n3。修改demo程序', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-02 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543226974905860097', 1543225946420576256, '1.安装环境\r\n2。下载demo程序并运行\r\n3。修改demo程序', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-02 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543406713364840449', 1543406710625959936, 'sadasdasd\r\nad\r\nas\r\ndsa\r\ndas\r\nd\r\nsdsd', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-03 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543406763558076417', 1543406710625959936, 'sadasdasd\r\nad\r\nas\r\ndsa\r\ndas\r\nuuuu', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-03 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543424366334738433', 1543225946420576256, '1.安装环境\r\n2。下载demo程序并运行\r\n3。修改demo程序\r\n4. 运行程序。', '62e01b0c753f4e618bc68245c93f7c80', '2022-07-03 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543429518168981505', 1543429518118649856, '1.准备一个密闭的空间\r\n2.准备三只小白鼠；\r\n3.分别给小白鼠注入药物\r\n3.将小白鼠放入密闭空间\r\n5.观察小白鼠\r\n6.记录小白鼠的每日变化\r\n7.撰写报告', 'fa61a3d645d2427da0acf4cdb5e2feac', '2022-07-03 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543430618704019456', 1543429518118649856, '1.准备一个密闭的空间\r\n2.准备三只小白鼠；\r\n3.分别给小白鼠注入药物，保证小白鼠不死亡；\r\n3.将小白鼠放入密闭空间\r\n5.观察小白鼠\r\n6.记录小白鼠的每日变化\r\n7.撰写报告', 'fa61a3d645d2427da0acf4cdb5e2feac', '2022-07-03 00:00:00');
INSERT INTO `plan_fix_records` VALUES ('1543436224051576833', 1543436211179257856, '1.安装软件环境，配置jdk环境遍历\r\n2.新建一个普通的web工程，\r\n3.引入数据库驱动包\r\n4.完成数据库链接jdbc代码编写\r\n5.完成jdbc操作数据增删改查操作\r\n6.测试软件功能\r\n7.打包上传', 'fa61a3d645d2427da0acf4cdb5e2feac', '2022-07-03 00:00:00');

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `dept_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  `dept_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept_info
-- ----------------------------
INSERT INTO `sys_dept_info` VALUES ('f36f86948ac94773b1eb5b00fe112491', '接收部', '接收部门改改改');

SET FOREIGN_KEY_CHECKS = 1;
