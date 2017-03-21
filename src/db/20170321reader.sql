-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.11-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 reader 的数据库结构
CREATE DATABASE IF NOT EXISTS `reader` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reader`;


-- 导出  表 reader.cms_attachment 结构
CREATE TABLE IF NOT EXISTS `cms_attachment` (
  `id` varchar(50) NOT NULL,
  `siteId` varchar(50) NOT NULL COMMENT '站点Id',
  `businessId` varchar(50) NOT NULL COMMENT '业务Id',
  `propertyCode` varchar(50) DEFAULT NULL COMMENT '扩展属性code',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `filepath` varchar(1000) NOT NULL COMMENT '文件物理路径',
  `filesuffix` varchar(50) DEFAULT NULL COMMENT '文件后缀',
  `fileurl` varchar(1000) NOT NULL COMMENT '文件路径',
  `thumbnail` varchar(1000) DEFAULT NULL COMMENT '缩略图',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `modelType` int(11) NOT NULL DEFAULT '0' COMMENT '0site,1channel,2content,3投票(以后可能扩展更多系统功能,例如 注册 登陆 订单 购物车)',
  `sortno` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `lookcount` int(11) DEFAULT NULL COMMENT '打开次数',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_channel 结构
CREATE TABLE IF NOT EXISTS `cms_channel` (
  `id` varchar(50) NOT NULL,
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `pid` varchar(50) DEFAULT NULL COMMENT '父类ID',
  `comcode` varchar(1000) NOT NULL COMMENT '编号 通过 ,, 间隔',
  `siteId` varchar(50) NOT NULL COMMENT '网站ID',
  `positionLevel` int(11) NOT NULL DEFAULT '0' COMMENT '0导航,1-10个级别',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `keywords` varchar(1000) DEFAULT NULL COMMENT '关键字',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `lookcount` int(11) DEFAULT NULL COMMENT '打开次数',
  `sortno` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='栏目表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_channel_content 结构
CREATE TABLE IF NOT EXISTS `cms_channel_content` (
  `id` varchar(50) NOT NULL,
  `siteId` varchar(50) NOT NULL,
  `channelId` varchar(50) NOT NULL,
  `contentId` varchar(50) NOT NULL,
  `sortno` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='栏目内容中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_comment 结构
CREATE TABLE IF NOT EXISTS `cms_comment` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) DEFAULT NULL COMMENT '评论用户ID',
  `businessId` varchar(50) NOT NULL COMMENT '业务Id',
  `pcommentId` varchar(50) NOT NULL COMMENT '父级评论Id',
  `siteId` int(11) NOT NULL COMMENT '站点ID',
  `createDate` datetime NOT NULL COMMENT '评论时间',
  `ip` varchar(50) DEFAULT NULL COMMENT 'IP地址',
  `content` longtext COMMENT '评论内容',
  `ups` smallint(6) NOT NULL DEFAULT '0' COMMENT '支持数',
  `downs` smallint(6) NOT NULL DEFAULT '0' COMMENT '反对数',
  `checked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否审核',
  `score` int(11) DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CMS评论表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_content 结构
CREATE TABLE IF NOT EXISTS `cms_content` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `title` varchar(500) DEFAULT NULL,
  `keywords` varchar(1000) DEFAULT NULL COMMENT '关键字',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `mintitle` varchar(200) DEFAULT NULL COMMENT '小标题',
  `lookcount` int(11) DEFAULT NULL COMMENT '打开次数',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `content` text NOT NULL COMMENT '内容',
  `source` varchar(1000) DEFAULT NULL COMMENT '来源',
  `sourceurl` varchar(1000) DEFAULT NULL COMMENT '来源地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='内容表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_friend_site 结构
CREATE TABLE IF NOT EXISTS `cms_friend_site` (
  `id` varchar(50) NOT NULL,
  `siteId` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `linkType` varchar(50) NOT NULL COMMENT '跳出类型,_blank',
  `url` varchar(1000) NOT NULL COMMENT '网站地址',
  `logo` varchar(2000) NOT NULL COMMENT '网站logo',
  `sortno` int(11) DEFAULT NULL COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='友情链接';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_link 结构
CREATE TABLE IF NOT EXISTS `cms_link` (
  `id` varchar(50) NOT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `defaultLink` varchar(1000) NOT NULL COMMENT '默认URL地址',
  `link` varchar(1000) NOT NULL COMMENT '使用的URL',
  `siteId` varchar(50) NOT NULL COMMENT '网站ID',
  `businessId` varchar(50) NOT NULL COMMENT '业务Id',
  `lookcount` int(11) DEFAULT NULL COMMENT '打开次数',
  `modelType` int(11) NOT NULL DEFAULT '0' COMMENT '0site,1channel,2content,3投票(以后可能扩展更多系统功能,例如 注册 登陆 订单 购物车)',
  `ftlfile` varchar(1000) NOT NULL COMMENT '当前渲染使用的模板路径',
  `nodeftlfile` varchar(1000) DEFAULT NULL COMMENT '子内容使用的ftl模板文件',
  `statichtml` int(11) NOT NULL DEFAULT '0' COMMENT '是否静态化 0否,1是',
  `sortno` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务链接表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_property 结构
CREATE TABLE IF NOT EXISTS `cms_property` (
  `id` varchar(100) NOT NULL COMMENT 'siteId_code,保证一个站点下code唯一',
  `siteId` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL COMMENT '系统级别的编码,一个站点不可重复',
  `inputType` int(11) NOT NULL DEFAULT '0' COMMENT '0text,1date,2datatime,3int,4float,5select,6file,7img,8imgs',
  `businessId` varchar(50) NOT NULL COMMENT '业务Id',
  `modelType` int(11) NOT NULL DEFAULT '0' COMMENT '0site,1channel,2content,3投票(以后可能扩展更多系统功能,例如 注册 登陆 订单 购物车)',
  `createPerson` varchar(50) NOT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `defaultValue` varchar(100) DEFAULT NULL COMMENT '默认值',
  `style` varchar(500) DEFAULT NULL COMMENT '样式',
  `sortno` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='自定义属性表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_propertyvalue 结构
CREATE TABLE IF NOT EXISTS `cms_propertyvalue` (
  `id` varchar(50) NOT NULL,
  `propertyId` int(11) DEFAULT NULL,
  `pvalue` text,
  `siteId` varchar(50) NOT NULL,
  `businessId` varchar(50) NOT NULL COMMENT '业务Id',
  `sortno` int(11) DEFAULT NULL COMMENT '排序',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='自定义属性对应值表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_site 结构
CREATE TABLE IF NOT EXISTS `cms_site` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL COMMENT '用户Id',
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `title` varchar(500) DEFAULT NULL,
  `domainurl` varchar(2000) DEFAULT NULL COMMENT '网站域名',
  `logo` varchar(2000) NOT NULL COMMENT '网站logo',
  `footer` varchar(2000) NOT NULL COMMENT '页脚',
  `qq` varchar(50) NOT NULL COMMENT 'QQ',
  `phone` varchar(50) NOT NULL COMMENT '电话',
  `contacts` varchar(50) NOT NULL COMMENT '联系人',
  `keywords` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `themeId` varchar(50) DEFAULT NULL COMMENT '主题Id',
  `lookcount` int(11) DEFAULT NULL COMMENT '打开次数',
  `siteType` int(11) NOT NULL DEFAULT '0' COMMENT '0微信订阅服务号,1wap,2网站   ',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='站点表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_site_wxconfig 结构
CREATE TABLE IF NOT EXISTS `cms_site_wxconfig` (
  `id` varchar(50) NOT NULL,
  `siteId` varchar(50) NOT NULL COMMENT '站点Id',
  `appId` varchar(500) DEFAULT NULL COMMENT '开发者Id',
  `appSecret` varchar(500) DEFAULT NULL COMMENT '应用密钥',
  `token` varchar(500) DEFAULT NULL COMMENT '开发者Id',
  `encodingAESKey` varchar(500) DEFAULT NULL COMMENT '消息加解密密钥',
  `wxId` varchar(500) DEFAULT NULL COMMENT '原始ID',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信号需要的配置信息';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_template 结构
CREATE TABLE IF NOT EXISTS `cms_template` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(500) NOT NULL COMMENT '名称',
  `description` varchar(2000) DEFAULT NULL COMMENT '备注',
  `ftlfile` varchar(1000) DEFAULT NULL COMMENT '渲染使用的模板路径',
  `imgfile` varchar(1000) DEFAULT NULL COMMENT '缩略图路径路径',
  `modelType` int(11) NOT NULL DEFAULT '0' COMMENT '0site,1channel,2content,3投票(以后可能扩展更多系统功能,例如 注册 登陆 订单 购物车)',
  `usecount` int(11) DEFAULT NULL COMMENT '使用次数',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0不可用,1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板表';

-- 数据导出被取消选择。


-- 导出  表 reader.cms_theme_template 结构
CREATE TABLE IF NOT EXISTS `cms_theme_template` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `themeId` varchar(50) NOT NULL COMMENT '主题Id',
  `templateId` varchar(50) NOT NULL COMMENT '模板Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主题和模板中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.t_auditlog_history_2014 结构
CREATE TABLE IF NOT EXISTS `t_auditlog_history_2014` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `operationType` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operatorName` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `preValue` text COMMENT '旧值',
  `curValue` text COMMENT '新值',
  `operationTime` datetime DEFAULT NULL COMMENT '操作时间',
  `operationClass` varchar(500) DEFAULT NULL COMMENT '操作类',
  `operationClassID` varchar(50) DEFAULT NULL COMMENT '记录ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作记录';

-- 数据导出被取消选择。


-- 导出  表 reader.t_auditlog_history_2015 结构
CREATE TABLE IF NOT EXISTS `t_auditlog_history_2015` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `operationType` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operatorName` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `preValue` text COMMENT '旧值',
  `curValue` text COMMENT '新值',
  `operationTime` datetime DEFAULT NULL COMMENT '操作时间',
  `operationClass` varchar(500) DEFAULT NULL COMMENT '操作类',
  `operationClassID` varchar(50) DEFAULT NULL COMMENT '记录ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作记录';

-- 数据导出被取消选择。


-- 导出  表 reader.t_auditlog_history_2016 结构
CREATE TABLE IF NOT EXISTS `t_auditlog_history_2016` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `operationType` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operatorName` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `preValue` text COMMENT '旧值',
  `curValue` text COMMENT '新值',
  `operationTime` datetime DEFAULT NULL COMMENT '操作时间',
  `operationClass` varchar(500) DEFAULT NULL COMMENT '操作类',
  `operationClassID` varchar(50) DEFAULT NULL COMMENT '记录ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作记录';

-- 数据导出被取消选择。


-- 导出  表 reader.t_auditlog_history_2017 结构
CREATE TABLE IF NOT EXISTS `t_auditlog_history_2017` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `operationType` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operatorName` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `preValue` text COMMENT '旧值',
  `curValue` text COMMENT '新值',
  `operationTime` datetime DEFAULT NULL COMMENT '操作时间',
  `operationClass` varchar(500) DEFAULT NULL COMMENT '操作类',
  `operationClassID` varchar(50) DEFAULT NULL COMMENT '记录ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作记录';

-- 数据导出被取消选择。


-- 导出  表 reader.t_dic_data 结构
CREATE TABLE IF NOT EXISTS `t_dic_data` (
  `id` varchar(50) NOT NULL,
  `name` varchar(60) NOT NULL COMMENT '名称',
  `code` varchar(60) DEFAULT NULL COMMENT '编码',
  `pid` varchar(50) DEFAULT NULL COMMENT '父ID',
  `sortno` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(2000) DEFAULT NULL COMMENT '描述',
  `active` int(11) DEFAULT '1' COMMENT '是否有效(0否,1是)',
  `typekey` varchar(20) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公共字典';

-- 数据导出被取消选择。


-- 导出  表 reader.t_fwlog_history_2014 结构
CREATE TABLE IF NOT EXISTS `t_fwlog_history_2014` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `startDate` datetime DEFAULT NULL COMMENT '访问时间',
  `strDate` varchar(100) DEFAULT NULL COMMENT '访问时间(毫秒)',
  `tomcat` varchar(50) DEFAULT NULL COMMENT 'Tomcat',
  `userCode` varchar(300) DEFAULT NULL COMMENT '登陆账号',
  `userName` varchar(200) DEFAULT NULL COMMENT '姓名',
  `sessionId` varchar(300) DEFAULT NULL COMMENT 'sessionId',
  `ip` varchar(200) DEFAULT NULL COMMENT 'IP',
  `fwUrl` varchar(3000) DEFAULT NULL COMMENT '访问菜单',
  `menuName` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `isqx` varchar(2) DEFAULT NULL COMMENT '是否有权限访问',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问日志';

-- 数据导出被取消选择。


-- 导出  表 reader.t_fwlog_history_2015 结构
CREATE TABLE IF NOT EXISTS `t_fwlog_history_2015` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `startDate` datetime DEFAULT NULL COMMENT '访问时间',
  `strDate` varchar(100) DEFAULT NULL COMMENT '访问时间(毫秒)',
  `tomcat` varchar(50) DEFAULT NULL COMMENT 'Tomcat',
  `userCode` varchar(300) DEFAULT NULL COMMENT '登陆账号',
  `userName` varchar(200) DEFAULT NULL COMMENT '姓名',
  `sessionId` varchar(300) DEFAULT NULL COMMENT 'sessionId',
  `ip` varchar(200) DEFAULT NULL COMMENT 'IP',
  `fwUrl` varchar(3000) DEFAULT NULL COMMENT '访问菜单',
  `menuName` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `isqx` varchar(2) DEFAULT NULL COMMENT '是否有权限访问',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问日志';

-- 数据导出被取消选择。


-- 导出  表 reader.t_fwlog_history_2016 结构
CREATE TABLE IF NOT EXISTS `t_fwlog_history_2016` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `startDate` datetime DEFAULT NULL COMMENT '访问时间',
  `strDate` varchar(100) DEFAULT NULL COMMENT '访问时间(毫秒)',
  `tomcat` varchar(50) DEFAULT NULL COMMENT 'Tomcat',
  `userCode` varchar(300) DEFAULT NULL COMMENT '登陆账号',
  `userName` varchar(200) DEFAULT NULL COMMENT '姓名',
  `sessionId` varchar(300) DEFAULT NULL COMMENT 'sessionId',
  `ip` varchar(200) DEFAULT NULL COMMENT 'IP',
  `fwUrl` varchar(3000) DEFAULT NULL COMMENT '访问菜单',
  `menuName` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `isqx` varchar(2) DEFAULT NULL COMMENT '是否有权限访问',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='访问日志';

-- 数据导出被取消选择。


-- 导出  表 reader.t_fwlog_history_2017 结构
CREATE TABLE IF NOT EXISTS `t_fwlog_history_2017` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `startDate` datetime DEFAULT NULL COMMENT '访问时间',
  `strDate` varchar(100) DEFAULT NULL COMMENT '访问时间(毫秒)',
  `tomcat` varchar(50) DEFAULT NULL COMMENT 'Tomcat',
  `userCode` varchar(300) DEFAULT NULL COMMENT '登陆账号',
  `userName` varchar(200) DEFAULT NULL COMMENT '姓名',
  `sessionId` varchar(300) DEFAULT NULL COMMENT 'sessionId',
  `ip` varchar(200) DEFAULT NULL COMMENT 'IP',
  `fwUrl` varchar(3000) DEFAULT NULL COMMENT '访问菜单',
  `menuName` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `isqx` varchar(2) DEFAULT NULL COMMENT '是否有权限访问',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='访问日志';

-- 数据导出被取消选择。


-- 导出  表 reader.t_menu 结构
CREATE TABLE IF NOT EXISTS `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `pageurl` varchar(3000) DEFAULT NULL,
  `menuType` int(11) DEFAULT NULL COMMENT '0.功能按钮,1.导航菜单',
  `active` int(11) DEFAULT '1' COMMENT '是否有效(0否,1是)',
  `sortno` int(11) DEFAULT NULL,
  `menuIcon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- 数据导出被取消选择。


-- 导出  表 reader.t_org 结构
CREATE TABLE IF NOT EXISTS `t_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `comcode` varchar(1000) DEFAULT NULL COMMENT '代码',
  `pid` varchar(50) DEFAULT NULL COMMENT '上级部门ID',
  `managerRoleId` varchar(100) DEFAULT NULL COMMENT '对应的角色Id',
  `sysid` varchar(50) DEFAULT NULL COMMENT '子系统ID',
  `orgType` int(11) DEFAULT NULL COMMENT '0组织机构 ,1.部门,2.虚拟权限组',
  `leaf` int(11) DEFAULT NULL COMMENT '叶子节点(0:树枝节点;1:叶子节点)',
  `sortno` int(11) DEFAULT NULL COMMENT '排序号',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `active` int(11) DEFAULT '1' COMMENT '是否有效(0否,1是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

-- 数据导出被取消选择。


-- 导出  表 reader.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(60) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(255) DEFAULT NULL COMMENT '权限编码',
  `pid` varchar(50) DEFAULT NULL COMMENT '上级角色ID,暂时不实现',
  `roleType` int(11) NOT NULL DEFAULT '0' COMMENT '0系统角色,1部门主管,2业务岗位',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `active` int(11) DEFAULT '1' COMMENT '是否有效(0否,1是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- 数据导出被取消选择。


-- 导出  表 reader.t_role_menu 结构
CREATE TABLE IF NOT EXISTS `t_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  `menuId` varchar(50) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.t_role_org 结构
CREATE TABLE IF NOT EXISTS `t_role_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  `orgId` varchar(50) NOT NULL COMMENT '部门编号',
  `orgType` int(11) DEFAULT NULL COMMENT '0组织机构 ,1.部门,2.虚拟权限组',
  `hasLeaf` int(11) NOT NULL DEFAULT '0' COMMENT '是否包含子部门,0不包含,1包含',
  `active` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用,0不可用,1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色部门中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.t_tableindex 结构
CREATE TABLE IF NOT EXISTS `t_tableindex` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tableName` varchar(50) NOT NULL DEFAULT '0' COMMENT '表名',
  `maxIndex` int(11) NOT NULL DEFAULT '1' COMMENT '表记录最大的行,一直累加',
  `prefix` varchar(50) NOT NULL COMMENT '前缀 单个字母加 _',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='记录表最大的行记录';

-- 数据导出被取消选择。


-- 导出  表 reader.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) DEFAULT '男' COMMENT '性别',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `weixinId` varchar(200) DEFAULT NULL COMMENT '微信Id',
  `userType` int(11) DEFAULT NULL COMMENT '0后台管理员|/system/,1会员用户|/front/,2cms管理员|/cms/houtai/|cms_siteManager,3活动管理员|/huodong/houtai',
  `active` int(11) DEFAULT '1' COMMENT '是否有效(0否,1是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- 数据导出被取消选择。


-- 导出  表 reader.t_user_org 结构
CREATE TABLE IF NOT EXISTS `t_user_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `orgId` varchar(50) NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户部门中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色中间表';

-- 数据导出被取消选择。


-- 导出  表 reader.weixin_menu 结构
CREATE TABLE IF NOT EXISTS `weixin_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `weixinId` varchar(200) NOT NULL COMMENT '微信Id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `pid` varchar(50) NOT NULL COMMENT '上级Id',
  `linkType` varchar(200) NOT NULL COMMENT '跳转方式',
  `linkId` varchar(2000) NOT NULL COMMENT '跳转业务Id',
  `href` varchar(2000) NOT NULL COMMENT '跳转地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
