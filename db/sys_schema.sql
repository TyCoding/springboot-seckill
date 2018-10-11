/*
 *  mysql-v: 5.7.22
 */

-- 创建数据库
-- CREATE DATABASE seckill DEFAULT CHARACTER SET utf8;


DROP TABLE IF EXISTS `seckill`;
DROP TABLE IF EXISTS `seckill_order`;

-- 创建秒杀商品表
CREATE TABLE `seckill`(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `title` varchar (1000) DEFAULT NULL COMMENT '商品标题',
  `image` varchar (1000) DEFAULT NULL COMMENT '商品图片',
  `price` decimal (10,2) DEFAULT NULL COMMENT '商品原价格',
  `cost_price` decimal (10,2) DEFAULT NULL COMMENT '商品秒杀价格',
  `stock_count` bigint DEFAULT NULL COMMENT '剩余库存数量',
  `start_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '秒杀开始时间',
  `end_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`end_time`)
) CHARSET=utf8 ENGINE=InnoDB COMMENT '秒杀商品表';

-- 创建秒杀订单表
CREATE TABLE `seckill_order`(
  `seckill_id` bigint NOT NULL COMMENT '秒杀商品ID',
  `money` decimal (10, 2) DEFAULT NULL COMMENT '支付金额',
  `user_phone` bigint NOT NULL COMMENT '用户手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态：-1无效 0成功 1已付款',
  PRIMARY KEY (`seckill_id`, `user_phone`) /*联合主键，保证一个用户只能秒杀一件商品*/
) CHARSET=utf8 ENGINE=InnoDB COMMENT '秒杀订单表';


