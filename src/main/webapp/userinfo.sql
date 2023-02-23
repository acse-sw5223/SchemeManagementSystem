/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-03-23 10:32:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `phone` varchar(64) DEFAULT NULL COMMENT '联系方式',
  `role` varchar(255) DEFAULT NULL,
  `content` text COMMENT '自我简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('110ca5cfdcf04ef68e9e985b66567f3b', 'admin', 'a66abb5684c45962d887564f08346e8d', '系统管理员', '男', '15088888888', '1', '');
INSERT INTO `db_user` VALUES ('973ba4cc4e81455c8bc5f212b978878c', 'root', 'dbb1c112a931eeb16299d9de1f30161d', '测试用户', '男', '15088888666', '2', '');
INSERT INTO `db_user` VALUES ('9c7392c792124f19aeda57945f3c9d22', 'admin1', 'd552c872517b2066e7f3a30db05cdf1c', '张三', '男', '15088888888', null, null);

-- ----------------------------
-- Table structure for sys_article
-- ----------------------------
DROP TABLE IF EXISTS `sys_article`;
CREATE TABLE `sys_article` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `type` varchar(100) NOT NULL COMMENT '文章类型',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `small_content` varchar(1000) DEFAULT NULL COMMENT '简介',
  `content` longtext COMMENT '内容',
  `publisher` varchar(40) DEFAULT NULL COMMENT '发布者',
  `publish_time` varchar(40) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article
-- ----------------------------
INSERT INTO `sys_article` VALUES ('F0906C1A62D347CBAF80EBDEFC8955CA', '1', '布洛陀经诗：壮族创世史诗简介', '本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。', '<p><span style=\"color: rgb(76, 76, 76); font-family: arial, \" microsoft=\"\" yahei=\"\" font-size:=\"\" 14px=\"\" background-color:=\"\" rgb=\"\" 255=\"\" 250=\"\">本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。</span></p><p><span style=\"color: rgb(76, 76, 76); font-family: arial, \" microsoft=\"\" yahei=\"\" font-size:=\"\" 14px=\"\" background-color:=\"\" rgb=\"\" 255=\"\" 250=\"\"><span style=\"color: rgb(76, 76, 76);\">本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。</span><br /></span></p><p><span style=\"color: rgb(76, 76, 76); font-family: arial, \" microsoft=\"\" yahei=\"\" font-size:=\"\" 14px=\"\" background-color:=\"\" rgb=\"\" 255=\"\" 250=\"\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\">本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。</span><br /></span></span></p><p><span style=\"color: rgb(76, 76, 76); font-family: arial, \" microsoft=\"\" yahei=\"\" font-size:=\"\" 14px=\"\" background-color:=\"\" rgb=\"\" 255=\"\" 250=\"\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\">本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。</span><br /></span></span></span></p><p><span style=\"color: rgb(76, 76, 76); font-family: arial, \" microsoft=\"\" yahei=\"\" font-size:=\"\" 14px=\"\" background-color:=\"\" rgb=\"\" 255=\"\" 250=\"\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\"><span style=\"color: rgb(76, 76, 76);\">本书是中国壮族民间古籍之一。一般认为成书于明代。它共有八篇，序歌、造天地、造人、造万物、造土官皇帝、造文字历书、伦理道德、祈祷还愿等。它唱诵壮族祖神布洛陀创造天地万物，规范人间伦理道德，启迪人们祈祷还愿消灾祛邪，追求幸福生活。这部经诗贯穿着自然崇拜、祖先崇拜的原始宗教意识。《布洛陀经诗》各篇都可独立成篇。</span><img alt=\"吐舌头\" src=\"static/editor/xheditor_emot/default/tongue.gif\" /><br /></span></span></span></span></p>', 'admin', '2019-03-23 09:21:22');

-- ----------------------------
-- Table structure for user_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `user_comment_info`;
CREATE TABLE `user_comment_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `comment_user` varchar(40) DEFAULT NULL COMMENT '评论者',
  `comment_time` varchar(40) DEFAULT NULL COMMENT '评论时间',
  `comment_content` text NOT NULL COMMENT '评论内容',
  `table_name` varchar(40) DEFAULT NULL COMMENT '表名',
  `table_id` varchar(40) DEFAULT NULL COMMENT '表ID',
  `last_id` varchar(40) DEFAULT NULL COMMENT '上级评论ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comment_info
-- ----------------------------
INSERT INTO `user_comment_info` VALUES ('1D269F0C9FCB4FEF908F01D4177BD82C', 'admin', '2019-03-23 10:27:42', '哈哈哈\n', 'sys_article', 'F0906C1A62D347CBAF80EBDEFC8955CA', null);
INSERT INTO `user_comment_info` VALUES ('3A8E9F1C4CEE4AE087D21194BC3C5445', 'admin', '2019-03-23 10:22:19', '分公司答复', 'sys_article', 'F0906C1A62D347CBAF80EBDEFC8955CA', null);
