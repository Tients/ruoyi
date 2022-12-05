package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysForwarder;

/**
 * 货代运营商Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-01
 */
public interface SysForwarderMapper
{
    /**
     * 查询货代运营商
     * 
     * @param forwarderId 货代运营商主键
     * @return 货代运营商
     */
    public SysForwarder selectSysForwarderByforwarderId(Long forwarderId);

    /**
     * 查询货代运营商列表
     * 
     * @param sysForwarder 货代运营商
     * @return 货代运营商集合
     */
    public List<SysForwarder> selectSysForwarderList(SysForwarder sysForwarder);

    /**
     * 新增货代运营商
     * 
     * @param sysForwarder 货代运营商
     * @return 结果
     */
    public int insertSysForwarder(SysForwarder sysForwarder);

    /**
     * 修改货代运营商
     * 
     * @param sysForwarder 货代运营商
     * @return 结果
     */
    public int updateSysForwarder(SysForwarder sysForwarder);

    /**
     * 删除货代运营商
     * 
     * @param forwarderIds 货代运营商主键
     * @return 结果
     */
    public int deleteSysForwarderByforwarderIds(Long[] forwarderIds);



}
