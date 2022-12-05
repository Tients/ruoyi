DROP TABLE
IF
	EXISTS `sys_forwarder`;
CREATE TABLE `sys_forwarder` (
  `forwarderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `forwarderCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '货代编码',
  `forwarderName` varchar(50) DEFAULT NULL COMMENT '货代名称',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用状态（0正常 1停用）',
  `delFlg` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`forwarderId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='货代运营商';

DROP TABLE
IF
	EXISTS `forwarder_logistics_track`;

CREATE TABLE `forwarder_logistics_track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门',
  `platform` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '平台',
  `out_date` date DEFAULT NULL COMMENT '出货日期',
  `shipment_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '货件',
  `apply_order` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'PI',
  `sale_order` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品',
  `pcs_qty` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'PCS数',
  `set_qty` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '套数',
  `ship_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '渠道',
  `county` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家',
  `warehouse_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '仓库代码',
  `is_merge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否合并',
  `eno_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `total` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总件数',
  `weight` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生产重量',
  `forwarder` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '货代',
  `transhipment_number` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '转运单号码',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状况',
  `sail_time` date DEFAULT NULL COMMENT '起航时间',
  `arrival_time` date DEFAULT NULL COMMENT '到岗时间',
  `sign_time` date DEFAULT NULL COMMENT '签收时间',
  `actual_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实际时效',
  `intransit_situation` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物流在途情况',
  `attachment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附件名称',
  `attachment_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附件链接',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `is_send` int(5) DEFAULT '0' COMMENT '发送消息',
  `booking` varchar(10) DEFAULT NULL COMMENT '是否报关',
  `box_no` int(10) DEFAULT NULL COMMENT '总箱数',
  `gross_weight` double(10,4) DEFAULT NULL COMMENT '毛重',
  `vol` double(10,4) DEFAULT NULL COMMENT '总体积',
  `area` varchar(255) DEFAULT NULL COMMENT '区域',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_pi` (`apply_order`) USING BTREE,
  KEY `idx_shipmentId` (`shipment_id`) USING BTREE,
  KEY `idx_sale_order` (`sale_order`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='货代物流跟踪表';

DROP TABLE
IF
	EXISTS `forwarder_logistics_track_approve`;
CREATE TABLE `forwarder_logistics_track_approve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `approve_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审批工单编号',
  `approve_status` tinyint(1) DEFAULT '0' COMMENT '工单状态（0：未提交，1：待审核，2：已通过，-1：已拒绝）',
  `change_num` int(8) DEFAULT NULL COMMENT '变更条数',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审批备注',
  `create_by_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `is_sync` tinyint(1) DEFAULT '0' COMMENT '是否已同步',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_approve_no` (`approve_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='货代物流审批表';

DROP TABLE
IF
	EXISTS `track_approve_mapping`;
CREATE TABLE `track_approve_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `track_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物流跟踪ID',
  `approve_id` tinyint(1) DEFAULT '0' COMMENT '审批ID',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='货代物流审批表';


DROP TABLE
IF
	EXISTS `forwarder_logistics_quotation`;
CREATE TABLE `forwarder_logistics_quotation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ship_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '运输类型',
  `destination_country` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目的国',
  `destination` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目的仓',
  `zip_code_head` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮编开头',
  `price` double(9,2) DEFAULT NULL COMMENT '价格',
  `currency` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '币种',
  `begin_value` double(9,2) DEFAULT NULL COMMENT '起始值',
  `unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位',
  `min_aging` double(9,2) DEFAULT NULL COMMENT '参考时效 - 小值',
  `max_aging` double(9,2) DEFAULT NULL COMMENT '参考时效 - 大值',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `have_battery` tinyint(1) DEFAULT NULL COMMENT '是否带电池',
  `forwarder` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '货代运营商',
  `create_by_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='货代物流报价表';