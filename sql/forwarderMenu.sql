-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商', '3', '1', 'forwarder', 'system/forwarder/index', 1, 0, 'C', '0', '0', 'system:forwarder:list', '#', 'admin', sysdate(), '', null, '货代运营商菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:forwarder:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:forwarder:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:forwarder:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:forwarder:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货代运营商导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:forwarder:export',       '#', 'admin', sysdate(), '', null, '');