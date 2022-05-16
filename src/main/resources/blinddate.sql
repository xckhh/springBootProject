/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : blinddate

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 12/05/2022 20:48:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `accont_id` int NOT NULL AUTO_INCREMENT COMMENT '帐号id',
  `nickname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `register_time` date NULL DEFAULT NULL COMMENT '注册时间',
  `login_time` date NULL DEFAULT NULL COMMENT '上次登录时间',
  `login_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上次登录地址',
  `head_path` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '（外键用户id）',
  PRIMARY KEY (`accont_id`) USING BTREE,
  INDEX `aid`(`id`) USING BTREE,
  CONSTRAINT `aid` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帐号信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (10, '海琴烟', '2022-05-05', '2022-05-12', '140.75.146.20', NULL, '277250386455302144');
INSERT INTO `account` VALUES (14, '风铃', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277276629967966208');
INSERT INTO `account` VALUES (15, '新一', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277279415149400064');
INSERT INTO `account` VALUES (17, '路飞', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277283520655790080');
INSERT INTO `account` VALUES (18, '娜美', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277284121166876672');
INSERT INTO `account` VALUES (20, '涂山苏苏', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277285486094061568');
INSERT INTO `account` VALUES (21, '王权富贵', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277287156576292864');
INSERT INTO `account` VALUES (22, '小哀', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277288070842290176');
INSERT INTO `account` VALUES (24, '小兰', '2022-05-05', '2022-05-05', '140.75.146.20', NULL, '277289214905815040');

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`  (
  `album_id` int NOT NULL AUTO_INCREMENT COMMENT '相册id',
  `album_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相册名称',
  `album_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相册描述',
  `photo_time` date NULL DEFAULT NULL COMMENT '照片时间',
  `jurisdiction` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查看权限',
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '（外键用户id）',
  `cover` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  PRIMARY KEY (`album_id`) USING BTREE,
  INDEX `alid`(`id`) USING BTREE,
  CONSTRAINT `alid` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '相册表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES (36, '生活', NULL, '2022-05-09', '所有人可见', '277250386455302144', '1c752d952745474c99017862bd56ac6f.jpg');
INSERT INTO `album` VALUES (37, '日常', NULL, '2022-05-02', '所有人可见', '277250386455302144', '3b26c7319e3c46e68bb49c398dfbc07f.jpg');
INSERT INTO `album` VALUES (39, '平时', NULL, '2022-05-03', '所有人可见', '277250386455302144', 'ba8ecf264cd24f309e955fd5db128af8.jpg');
INSERT INTO `album` VALUES (50, '生活', NULL, '2022-05-02', '所有人可见', '277276629967966208', 'e7bbd7daa7504c298639b53f0dbf263b.jpg');
INSERT INTO `album` VALUES (51, '日常', NULL, '2022-05-10', '所有人可见', '277276629967966208', 'c6030693f91d44d6b26742fea6d4d95a.jpg');
INSERT INTO `album` VALUES (52, '平时', NULL, '2022-05-11', '所有人可见', '277276629967966208', 'bf3d469e574f4236bd9ffa90d902363b.jpg');
INSERT INTO `album` VALUES (53, '生活', NULL, '2022-05-10', '所有人可见', '277279415149400064', 'fc831db2a119429986c2a62a3bb38078.jpg');
INSERT INTO `album` VALUES (54, '日常', NULL, '2022-05-10', '所有人可见', '277279415149400064', '2fa10b2d531e4294843dbde608d2d96b.jpg');
INSERT INTO `album` VALUES (55, '平时', NULL, '2022-05-10', '所有人可见', '277279415149400064', '52ed57369d2644d2a1613ec99ec8e80e.jpg');
INSERT INTO `album` VALUES (57, '生活', NULL, '2022-05-11', '仅好友可见', '277283520655790080', '097958bac3134264a16825a56c94338a.jpg');
INSERT INTO `album` VALUES (58, '平时', NULL, '2022-04-28', '仅自己可见', '277283520655790080', '0ac5db3a587f4f2d85990735d0d3f65f.jpg');
INSERT INTO `album` VALUES (59, '生活', NULL, '2022-05-17', '所有人可见', '277284121166876672', '543010070c5641a6b58f6566c1ee2d1b.jpg');
INSERT INTO `album` VALUES (60, '平时', NULL, '2022-05-11', '所有人可见', '277284121166876672', '74cb4b3ddd7541a5ad2c9a5fb487b0b2.jpg');
INSERT INTO `album` VALUES (63, '日常', NULL, '2022-05-03', '所有人可见', '277285486094061568', 'e9472ced11ab4890ac9ef07b3f61087b.jpg');
INSERT INTO `album` VALUES (64, '平时', NULL, '2022-04-27', '所有人可见', '277285486094061568', '9d1819cfe22c4bbe8362cd127f24e267.jpg');
INSERT INTO `album` VALUES (65, '生活', NULL, '2022-05-13', '所有人可见', '277285486094061568', '64cf2edb9a024ef8a618dc206adb2b91.jpg');
INSERT INTO `album` VALUES (66, '平常', NULL, '2022-05-17', '所有人可见', '277285486094061568', 'fc812caa9a3c45909ec93b2698d20c57.jpg');
INSERT INTO `album` VALUES (67, '生活', NULL, '2022-05-04', '所有人可见', '277287156576292864', 'cbca9069ca514e61adb3b7d71b0cda87.jpg');
INSERT INTO `album` VALUES (68, '平常', NULL, '2022-05-18', '所有人可见', '277287156576292864', 'b3c36ebbd7fe42078fc11a47f8ede8b1.jpg');
INSERT INTO `album` VALUES (69, '日常', NULL, '2022-05-03', '仅好友可见', '277287156576292864', '341a307aa5eb4b35b2ce39bf191e6b56.jpg');
INSERT INTO `album` VALUES (70, '生活', NULL, '2022-05-17', '所有人可见', '277288070842290176', 'ee3de612b18649509fd9b47f49f16e8d.jpg');
INSERT INTO `album` VALUES (71, '日常', NULL, '2022-05-11', '所有人可见', '277288070842290176', '83cf5c2fca6d421cbc6f4e3353fb63c1.jpg');
INSERT INTO `album` VALUES (72, '平时', NULL, '2022-05-02', '所有人可见', '277288070842290176', 'ee4db624476e4597b2232c4e190c339d.jpg');
INSERT INTO `album` VALUES (73, '平常', NULL, '2022-05-03', '所有人可见', '277288070842290176', '1e799bcb92b6445abe8f17fde53581a4.jpg');
INSERT INTO `album` VALUES (74, '生活', NULL, '2022-04-27', '仅好友可见', '277289214905815040', '62bbd55d284f4d9ca0033ab695bd0af0.jpg');
INSERT INTO `album` VALUES (75, '平常', NULL, '2022-05-03', '所有人可见', '277289214905815040', '36a9b1c1b0bc4e078eb15632437e2888.jpg');
INSERT INTO `album` VALUES (76, '日常', NULL, '2022-05-10', '所有人可见', '277289214905815040', 'ee5df981bb1b429c95097ed5c041f048.jpg');
INSERT INTO `album` VALUES (78, '发', NULL, '2022-05-09', '仅好友可见', '277250386455302144', '8b39bd1b42084c00b0deedd191513ed6.jpg');

-- ----------------------------
-- Table structure for conditions
-- ----------------------------
DROP TABLE IF EXISTS `conditions`;
CREATE TABLE `conditions`  (
  `condition_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `car_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买车情况',
  `house_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买房情况',
  `work_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业类别',
  `marital_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `hobby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `requirement` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对另一半的要求',
  `personal_signature` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '外键用户id',
  `monthly_income` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月收入',
  PRIMARY KEY (`condition_id`) USING BTREE,
  INDEX `cid`(`id`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户条件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of conditions
-- ----------------------------
INSERT INTO `conditions` VALUES (11, '未买', '未买', '其他', '未婚', '画画 唱歌 跳舞', '暂无', '暂无', '277250386455302144', '5万以上');
INSERT INTO `conditions` VALUES (15, '未买', '未买', '其他', '未婚', '唱歌 跳舞', '暂无', '暂无', '277276629967966208', '2万-5万');
INSERT INTO `conditions` VALUES (16, '未买', '未买', '其他', '未婚', '唱歌 跳舞', '暂无', '暂无', '277279415149400064', '5万以上');
INSERT INTO `conditions` VALUES (18, '未买', '未买', '其他', '未婚', '冒险 航海', '暂无', '暂无', '277283520655790080', '1万-2万');
INSERT INTO `conditions` VALUES (19, '未买', '未买', '其他', '未婚', '航海 冒险', '暂无', '暂无', '277284121166876672', '2万-5万');
INSERT INTO `conditions` VALUES (21, '未买', '未买', '其他', '未婚', '唱歌 跳舞', '暂无', '暂无', '277285486094061568', '5万以上');
INSERT INTO `conditions` VALUES (22, '未买', '未买', '其他', '未婚', '唱歌 跳舞', '暂无', '暂无', '277287156576292864', '1万-2万');
INSERT INTO `conditions` VALUES (23, '未买', '未买', '其他', '未婚', '唱歌 跳舞', '暂无', '暂无', '277288070842290176', '1万-2万');
INSERT INTO `conditions` VALUES (25, '未买', '未买', '其他', '未婚', '跆拳道 唱歌', '暂无', '暂无', '277289214905815040', '5千-1万');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `photo_id` int NOT NULL AUTO_INCREMENT COMMENT '照片id',
  `photo_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片路径',
  `album_id` int NOT NULL COMMENT '（外键相册id）',
  PRIMARY KEY (`photo_id`) USING BTREE,
  INDEX `plid`(`album_id`) USING BTREE,
  CONSTRAINT `plid` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 276 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '照片表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES (22, '3b5837be4f4948d8bd8adf343bbded82.jpg', 36);
INSERT INTO `photo` VALUES (23, '8c78406f586d4de9815f5d5c204d676e.jpg', 36);
INSERT INTO `photo` VALUES (24, '92a68bd1fb06472a87b686cce993fdb8.jpg', 36);
INSERT INTO `photo` VALUES (25, '7c19fcce6f174045babaa8da81daac73.jpg', 36);
INSERT INTO `photo` VALUES (26, 'c9ede1782fb14ce9ad61e3dbfc0bf03f.jpg', 36);
INSERT INTO `photo` VALUES (28, '265fecd7fa4b4aac8c0ba74343c89af4.jpg', 37);
INSERT INTO `photo` VALUES (29, 'b24f93246c704bc6aa18b2c1c424822b.jpg', 37);
INSERT INTO `photo` VALUES (32, '11a34cf184494295b86f4f6f7e15f0e0.jpg', 39);
INSERT INTO `photo` VALUES (33, 'c378fabe73b54624801b36f0fa0bf2fa.jpg', 39);
INSERT INTO `photo` VALUES (34, 'fd6c4e1501394ea594d78df260fff4b8.jpg', 39);
INSERT INTO `photo` VALUES (35, '0e73d4f3f31f49e8941ba3d254bd487e.jpg', 39);
INSERT INTO `photo` VALUES (36, '5fcf29839ee94e818e3f6ed41867561e.jpg', 39);
INSERT INTO `photo` VALUES (93, '06187b1330ea4062ad475c56b7396fbb.jpg', 50);
INSERT INTO `photo` VALUES (94, 'b9382bb67b5749798bfd1b7c9ecdbf88.jpg', 50);
INSERT INTO `photo` VALUES (95, '702dc976f1a0461e9782748377311825.jpg', 50);
INSERT INTO `photo` VALUES (96, '86d2d26d9e1743edaeb02aac53116949.jpg', 50);
INSERT INTO `photo` VALUES (97, '4f3e67fdbd3c4c04bb161fc336c21cf5.jpg', 50);
INSERT INTO `photo` VALUES (98, '3a6313bf2e984095bfb7b1178dad0994.jpg', 51);
INSERT INTO `photo` VALUES (99, 'c6591411fe764810b7de4bbbb6e770e9.jpg', 51);
INSERT INTO `photo` VALUES (100, 'df1fd54d97c049c19a3dc57676767839.jpg', 51);
INSERT INTO `photo` VALUES (101, '8762b5d9904a451886e809b899379e74.jpg', 51);
INSERT INTO `photo` VALUES (102, '55613843961544379a7cedb47e780dd9.jpg', 51);
INSERT INTO `photo` VALUES (103, '661c310ca2c84f209d89b8020b61466b.jpg', 51);
INSERT INTO `photo` VALUES (104, '517a53495f694a2c910435cd6495a5fe.jpg', 52);
INSERT INTO `photo` VALUES (105, '7c62ea4bb91347ae9f9838ec20524fb5.jpg', 52);
INSERT INTO `photo` VALUES (106, '9dfffacc8e3d4f108e0657d42ed08966.jpg', 52);
INSERT INTO `photo` VALUES (107, '6cf2a797d90444e581442ff51c12ab85.jpg', 52);
INSERT INTO `photo` VALUES (108, 'ebf0a7a256014733af562c097a14314e.jpg', 52);
INSERT INTO `photo` VALUES (109, 'd2e683ee931c4efebb1de4bd82ddda0d.jpg', 52);
INSERT INTO `photo` VALUES (110, 'c2b86e920dd34bdaac8a902e731ada10.jpg', 53);
INSERT INTO `photo` VALUES (111, '68ee980cac054dd4ad5d8dce9684ab7f.jpg', 53);
INSERT INTO `photo` VALUES (112, 'dae87ba089e444b5b1ee4cbd42476748.jpg', 53);
INSERT INTO `photo` VALUES (113, '88610f1c776a4538a90f1c2bdf93dcaf.jpg', 53);
INSERT INTO `photo` VALUES (114, 'b6ffedc716bd43cda87ce9d529346226.jpg', 53);
INSERT INTO `photo` VALUES (115, 'c2b92534951841dda50bd36d5f9b579a.jpg', 54);
INSERT INTO `photo` VALUES (116, 'de262b460ffc47859d386b0858bb240f.jpg', 54);
INSERT INTO `photo` VALUES (117, '292d4a9422c947b5afcd92954ac232e5.jpg', 54);
INSERT INTO `photo` VALUES (118, '014404349076480e824b4723f42e14e9.jpg', 54);
INSERT INTO `photo` VALUES (119, 'a2389aad8fd140ef9e8b584b8719bc88.jpg', 54);
INSERT INTO `photo` VALUES (120, '0845b8c1b2f54e97b22d98d5a2e1581e.jpg', 54);
INSERT INTO `photo` VALUES (121, '76d3d44418244b3fa71061e7d999e218.jpg', 54);
INSERT INTO `photo` VALUES (122, '226f0bc3617c4a32a5bc018b1b287134.jpg', 55);
INSERT INTO `photo` VALUES (123, '538b61451cde4f5f9093c04b009d4817.jpg', 55);
INSERT INTO `photo` VALUES (124, '8a3dcb8ecac2435bbe9c8d33d723cb66.jpg', 55);
INSERT INTO `photo` VALUES (125, '8b4fd0747cd6484e8d5261c44790b4b0.jpg', 55);
INSERT INTO `photo` VALUES (126, 'eea2bce741fc4c959faf3631af8ffa05.jpg', 55);
INSERT INTO `photo` VALUES (127, 'ece67f006bea43269748116b3c3ea543.jpg', 55);
INSERT INTO `photo` VALUES (135, '70012a15692d438ab7ed128e2092d583.jpg', 57);
INSERT INTO `photo` VALUES (136, '91864529ed0048d58457265ecc0f7a03.jpg', 57);
INSERT INTO `photo` VALUES (137, 'a052a049b0c4409394fc2be5ec76d4ae.jpg', 57);
INSERT INTO `photo` VALUES (138, '05ebd3666ad64a27b0657c10cfb2feba.jpg', 57);
INSERT INTO `photo` VALUES (139, 'b7ad86fce1c040df9838253eb94a3518.jpg', 57);
INSERT INTO `photo` VALUES (140, '13b4cff003554c2f901b385afb51f75b.jpg', 58);
INSERT INTO `photo` VALUES (141, 'd6174eedb1c34004825b2e9da3ab9c7a.jpg', 58);
INSERT INTO `photo` VALUES (142, '8fecb4e6c3524fe6adcd4d2a2b683dab.jpg', 58);
INSERT INTO `photo` VALUES (143, '27eb4dba3f7b4e608bfffa19f333603a.jpg', 58);
INSERT INTO `photo` VALUES (144, '5b028e07f0b3417a879e0ad1ba78e212.jpg', 58);
INSERT INTO `photo` VALUES (145, '1cb4f3c3f65c453382134ca370f7ba2a.jpg', 59);
INSERT INTO `photo` VALUES (146, '188cf41419554492b3292ce6ce8d2fa5.jpg', 59);
INSERT INTO `photo` VALUES (147, 'b3ff5ddcf8354d2ab41d69f769f70e57.jpg', 59);
INSERT INTO `photo` VALUES (148, '7dbf7e58775047c8928c8ed10987d734.jpg', 59);
INSERT INTO `photo` VALUES (149, 'a9d44525518d48f6aa81d6b45409ce4c.jpg', 59);
INSERT INTO `photo` VALUES (150, '5ddd3b6ded0a499bb013a60a78d546ac.jpg', 60);
INSERT INTO `photo` VALUES (151, '608c25d3b2d646c586464861f39c9ea0.jpg', 60);
INSERT INTO `photo` VALUES (152, '645befe2882348fb9704869cc17bc554.jpg', 60);
INSERT INTO `photo` VALUES (153, '90d2837bb2ea419092311dd5cdf08d97.jpg', 60);
INSERT INTO `photo` VALUES (154, '1c06274cca524d488c8fb5c814c540fb.jpg', 60);
INSERT INTO `photo` VALUES (174, 'b50660b52d1e4bc19adbb01f3c780df1.jpg', 63);
INSERT INTO `photo` VALUES (175, 'fb6eee5838cf400bbf111b13e47e0936.jpg', 63);
INSERT INTO `photo` VALUES (176, '29be37afc6784b4da2edb4a6d67129b8.jpg', 63);
INSERT INTO `photo` VALUES (177, 'df30973a2d504e4cb898ae6704b5ed88.jpg', 63);
INSERT INTO `photo` VALUES (178, '2137cd573b87443b837916d9bf149de6.jpg', 63);
INSERT INTO `photo` VALUES (179, '66e99fe4c33b4fb1be669e0e0aa5c21d.jpg', 63);
INSERT INTO `photo` VALUES (180, 'c77c68170d2b40bda9eb0188d6e6da8d.jpg', 64);
INSERT INTO `photo` VALUES (181, 'b03e2965de364d66b420e01d7c62b71e.jpg', 64);
INSERT INTO `photo` VALUES (182, '4176345c4dbb4abe85506267ba2608d1.jpg', 64);
INSERT INTO `photo` VALUES (183, 'd80a2d850eb546d59bf9626ba5f2e0f5.jpg', 64);
INSERT INTO `photo` VALUES (184, '670b2eb0b50a4553823eaba02230b135.jpg', 64);
INSERT INTO `photo` VALUES (185, '63fd1995e3fe4340b19accdc5111f384.jpg', 64);
INSERT INTO `photo` VALUES (186, '42196868878c405a87fd0d43f5b9ed11.jpg', 65);
INSERT INTO `photo` VALUES (187, '6d58b29dbbd34f3cadc0f7e46e01f702.jpg', 65);
INSERT INTO `photo` VALUES (188, 'a5c4824d4d1f4e4c9075ca03000af768.jpg', 65);
INSERT INTO `photo` VALUES (189, 'f119e33b6f6449bbb06540e342c5d1a0.jpg', 65);
INSERT INTO `photo` VALUES (190, '565946731b4c4663905405f90b8bb1b9.jpg', 65);
INSERT INTO `photo` VALUES (191, '1f37840b76064d3e98ab88b506bd6fbb.jpg', 65);
INSERT INTO `photo` VALUES (192, '5a08c5e37307451fa671b0e41adf6d63.jpg', 66);
INSERT INTO `photo` VALUES (193, '9bda2f3b1f6c465db4c6842da38b6175.jpg', 66);
INSERT INTO `photo` VALUES (194, '71351d6da2404c5b80787679dbb80baf.jpg', 66);
INSERT INTO `photo` VALUES (195, '86c6f386afe444c9b9d7bf95634e1bfc.jpg', 66);
INSERT INTO `photo` VALUES (196, 'ccf0d4ca688d462c8991137f1a173c1a.jpg', 66);
INSERT INTO `photo` VALUES (197, '2f39ed1984284f2eabdbc78d8ec61c62.jpg', 66);
INSERT INTO `photo` VALUES (198, '00b490b94dda403383d13cb0f9e8840f.jpg', 67);
INSERT INTO `photo` VALUES (199, '982b441a352d49c2ba0720f76704878a.jpg', 67);
INSERT INTO `photo` VALUES (200, 'a1a054114e4740ed81543554100f2ba4.jpg', 67);
INSERT INTO `photo` VALUES (201, '9bae7555cf1f4507ac83487adc21c19f.jpg', 67);
INSERT INTO `photo` VALUES (202, 'af4163b059df4869b666b313c7b4031e.jpg', 67);
INSERT INTO `photo` VALUES (203, '7dc7d02f29174b2fb1274ebafcb22d29.jpg', 68);
INSERT INTO `photo` VALUES (204, 'b022e7a2f5a94300ad57f64637b90ccd.jpg', 68);
INSERT INTO `photo` VALUES (205, '795899cdb0254753a8e5db168a112d6f.jpg', 68);
INSERT INTO `photo` VALUES (206, 'e4b34044d74844b093a4eaba3cf90e05.jpg', 68);
INSERT INTO `photo` VALUES (207, '7756c75a805c4069b8a8f5e49886c9c8.jpg', 68);
INSERT INTO `photo` VALUES (208, 'ebd6f0eb7594407583e51baef5be559d.jpg', 68);
INSERT INTO `photo` VALUES (209, '4489c314868a4619a2c7da899588838b.jpg', 69);
INSERT INTO `photo` VALUES (210, '72b73c04154c4f6e83e86efcc11e1cbe.jpg', 69);
INSERT INTO `photo` VALUES (211, 'c720c0b751244c79a7a72c6192bffe38.jpg', 69);
INSERT INTO `photo` VALUES (212, 'bab43605bd104221a0f6b11ecbeb2df8.jpg', 69);
INSERT INTO `photo` VALUES (213, '7dbcb60e42c3435db648adc859cb36c3.jpg', 69);
INSERT INTO `photo` VALUES (214, 'af79016344cb423f9ce85ea2bc8f0d4b.jpg', 69);
INSERT INTO `photo` VALUES (215, '0f1c3bda641c406898e7756b90f4386c.jpg', 69);
INSERT INTO `photo` VALUES (216, 'c7242b5378f14aadace785d5e5f4af71.jpg', 70);
INSERT INTO `photo` VALUES (217, '0f9c7c3deced43c6a6fb52e6772fc2b4.jpg', 70);
INSERT INTO `photo` VALUES (218, '4d0930d2e65942a48f082cdf940c3ce2.jpg', 70);
INSERT INTO `photo` VALUES (219, 'ec6f0afece2548178096c71ab9b1b544.jpg', 70);
INSERT INTO `photo` VALUES (220, '5aed4941cdef47cfa0ec478aad8bfe3f.jpg', 70);
INSERT INTO `photo` VALUES (221, '60f6269617084d38b27da75a2ecf6c36.jpg', 70);
INSERT INTO `photo` VALUES (222, '0e1365f69e554c4ea897b3ed1360188f.jpg', 70);
INSERT INTO `photo` VALUES (223, 'c6888f2540774c1c8a1a67ed04287651.jpg', 70);
INSERT INTO `photo` VALUES (224, '59a9608d4fb9436ea03f0616d2ce8c4b.jpg', 71);
INSERT INTO `photo` VALUES (225, 'd1ea665ccc4d4259a111b93ba5974dfd.jpg', 71);
INSERT INTO `photo` VALUES (226, 'd509a380c6d9490985f4cedfc9ab6126.jpg', 71);
INSERT INTO `photo` VALUES (227, 'bc34219c340949bfb2f3dae32d3005eb.jpg', 71);
INSERT INTO `photo` VALUES (228, '36cf198feee24e39b3864532b62bfb74.jpg', 71);
INSERT INTO `photo` VALUES (229, 'b3e8ebad75b74f67add6d03e251b29b4.jpg', 72);
INSERT INTO `photo` VALUES (230, 'b546158104954d40b80cfa26b419a072.jpg', 72);
INSERT INTO `photo` VALUES (231, '60b91e85c69c42a196eb4c689a17e244.jpg', 72);
INSERT INTO `photo` VALUES (232, '435563bb531e46a2bbb5ac95f8654266.jpg', 72);
INSERT INTO `photo` VALUES (233, '039ca8362bfd42248d8da8c610f19420.jpg', 72);
INSERT INTO `photo` VALUES (234, '2b598880c3a54eeaad4218532303f1b4.jpg', 72);
INSERT INTO `photo` VALUES (235, '8f49174ac7ac40858729981efbb5e4d5.jpg', 73);
INSERT INTO `photo` VALUES (236, 'd305119698c6445bb4eacd4ff7f0bbb1.jpg', 73);
INSERT INTO `photo` VALUES (237, '7bb8547e913e43f6b8dbf0b77684662a.jpg', 73);
INSERT INTO `photo` VALUES (238, '877d16997d7f489fa1b9c72f126887f1.jpg', 73);
INSERT INTO `photo` VALUES (239, '9f6797fe89c543e38b5b449c686e278f.jpg', 73);
INSERT INTO `photo` VALUES (240, 'd45276b6a9a848a3bf6b38b1f038ff02.jpg', 73);
INSERT INTO `photo` VALUES (241, 'b6c3df68fad64177aa20f142653ff350.jpg', 74);
INSERT INTO `photo` VALUES (242, 'd03d9de0df404d2e9fa2bcae02b8dbc6.jpg', 74);
INSERT INTO `photo` VALUES (243, '5ebac0b2151b4652b73526de6608ef9c.jpg', 74);
INSERT INTO `photo` VALUES (244, 'eac91e9c6fac442da277641515e83c84.jpg', 74);
INSERT INTO `photo` VALUES (245, 'd86a377e9f73484fb8562c076bedeb87.jpg', 74);
INSERT INTO `photo` VALUES (246, '298e6a33d6c942d6ae382f3602180cf8.jpg', 75);
INSERT INTO `photo` VALUES (247, 'de2459aa6d374dbd9b8d397e52f195fb.jpg', 75);
INSERT INTO `photo` VALUES (248, '1492a29c26e54ae79bfec5bfc0a9bfa1.jpg', 75);
INSERT INTO `photo` VALUES (249, 'eeb3bc80e7344cceb75eb640b85a745c.jpg', 75);
INSERT INTO `photo` VALUES (250, 'b8d3c409a97e45208930cee61c8ce049.jpg', 75);
INSERT INTO `photo` VALUES (251, 'c071ad6c86d04410b4945938fa555b43.jpg', 76);
INSERT INTO `photo` VALUES (252, '743e89a2ce8543418dd80216ec013cfb.jpg', 76);
INSERT INTO `photo` VALUES (253, '9cbcf7699f454b08b068b50961e5ffad.jpg', 76);
INSERT INTO `photo` VALUES (254, 'ef4171d728594a5a945c83106f7f3f19.jpg', 76);
INSERT INTO `photo` VALUES (255, '635eba402dec407a9023992281a97249.jpg', 76);
INSERT INTO `photo` VALUES (256, '105bf060a0e14da58be6a374f7046f24.jpg', 76);
INSERT INTO `photo` VALUES (264, '36b8616e72df45d39677c7a7680ccb97.jpg', 37);
INSERT INTO `photo` VALUES (273, 'd5eab24db22b47578629ac5f6800ec43.jpg', 37);
INSERT INTO `photo` VALUES (274, '853cb0d83c3340929f31d377beaf67ee.jpg', 37);
INSERT INTO `photo` VALUES (275, 'a3074852ab824385a0587709df06de05.jpg', 37);
INSERT INTO `photo` VALUES (276, 'd0cda5a438aa4a7e842ed3f31348ef2c.jpg', 37);

-- ----------------------------
-- Table structure for recovery
-- ----------------------------
DROP TABLE IF EXISTS `recovery`;
CREATE TABLE `recovery`  (
  `recovery_id` int NOT NULL AUTO_INCREMENT,
  `photo_id` int NOT NULL,
  `album_id` int NOT NULL,
  `photo_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`recovery_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recovery
-- ----------------------------
INSERT INTO `recovery` VALUES (2, 269, 37, '61a4dc15557e4df3852a7d3560dc6df7.jpg');
INSERT INTO `recovery` VALUES (10, 271, 78, '281d9b4aff834eef8fff2a498b4f10b2.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男' COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `height` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身高',
  `weight` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体重',
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('277250386455302144', 'xckhh', '9634ec47344a48e23c69ebff34784079701b8f06', '海琴烟', 21, '18276580766', '女', '2000-12-26', '山东省临沂市兰山区', '1259390385@qq.com', '173厘米', '48公斤', 'b974997173404a0c90ca508fe72e4e8c.jpg');
INSERT INTO `user` VALUES ('277276629967966208', '444444', '9634ec47344a48e23c69ebff34784079701b8f06', '风铃', 21, '18276580766', '女', '2000-06-20', '安徽省蚌埠市禹会区', '12548@qq.com', '162厘米', '46公斤', '286a70c25f5243b19703573fba04fff2.jpg');
INSERT INTO `user` VALUES ('277279415149400064', '555555', '9634ec47344a48e23c69ebff34784079701b8f06', '新一', 21, '18276580766', '男', '2000-07-19', '福建省三明市清流县', '864@qq.com', '182厘米', '55公斤', 'aa9fc5bea9074e8ca6c5c83fba5d1334.jpg');
INSERT INTO `user` VALUES ('277283520655790080', '777777', '9634ec47344a48e23c69ebff34784079701b8f06', '路飞', 21, '18276580766', '男', '2000-07-18', '湖北省十堰市张湾区', 'kkfgka@qq.com', '182厘米', '55公斤', 'c6430b4f049840a3bed0db4a96c1dff9.jpg');
INSERT INTO `user` VALUES ('277284121166876672', '888888', '9634ec47344a48e23c69ebff34784079701b8f06', '娜美', 19, '18276580766', '女', '2002-07-24', '山东省淄博市张店区', 'namei@qq.com', '173厘米', '47公斤', 'ad85518509ab422dba6de0ec1f85e8a3.jpg');
INSERT INTO `user` VALUES ('277285486094061568', '101010', '9634ec47344a48e23c69ebff34784079701b8f06', '涂山苏苏', 21, '18276580766', '女', '2000-11-16', '湖南省湘潭市湘潭县', 'tushansusu@qq.com', '156厘米', '41公斤', 'bf25ba04653d415db772462d51c73f79.jpg');
INSERT INTO `user` VALUES ('277287156576292864', 'aaaaaa', '9634ec47344a48e23c69ebff34784079701b8f06', '王权富贵', 21, '18276580766', '男', '2000-07-12', '河北省唐山市古冶区', 'wangquanfugui@qq.com', '186厘米', '52公斤', 'dd33a4ecfb5b4925bde5d716b1845f7e.jpg');
INSERT INTO `user` VALUES ('277288070842290176', 'bbbbbb', '9634ec47344a48e23c69ebff34784079701b8f06', '小哀', 21, '18276580766', '女', '2000-06-22', '黑龙江省鹤岗市工农区', 'xiaoai@qq.ocm', '164厘米', '45公斤', 'c1b69f4a70a44d329dbe8d811e9461f8.jpg');
INSERT INTO `user` VALUES ('277289214905815040', 'cccccc', '9634ec47344a48e23c69ebff34784079701b8f06', '小兰', 20, '18276580766', '女', '2001-06-13', '江苏省徐州市贾汪区', 'xaiolan@qq.com', '173厘米', '51公斤', '83fc0715509c43fa8d3100142f24c2c0.jpg');

SET FOREIGN_KEY_CHECKS = 1;
