package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysForwarder;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysForwarderMapper;
import com.ruoyi.system.service.ISysForwarderService;

import javax.annotation.Resource;

/**
 * 货代运营商Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-01
 */
@Service
public class SysForwarderServiceImpl implements ISysForwarderService 
{
    @Resource
    private SysForwarderMapper sysForwarderMapper;

    /**
     * 查询货代运营商
     * 
     * @param forwarderId 货代运营商主键
     * @return 货代运营商
     */
    @Override
    public SysForwarder selectSysForwarderByforwarderId(Long forwarderId)
    {
        return sysForwarderMapper.selectSysForwarderByforwarderId(forwarderId);
    }

    /**
     * 查询货代运营商列表
     * 
     * @param sysForwarder 货代运营商
     * @return 货代运营商
     */
    @Override
    public List<SysForwarder> selectSysForwarderList(SysForwarder sysForwarder)
    {
        return sysForwarderMapper.selectSysForwarderList(sysForwarder);
    }

    /**
     * 新增货代运营商
     * 
     * @param sysForwarder 货代运营商
     * @return 结果
     */
    @Override
    public int insertSysForwarder(SysForwarder sysForwarder)
    {
        sysForwarder.setCreateTime(DateUtils.getNowDate());
        return sysForwarderMapper.insertSysForwarder(sysForwarder);
    }

    /**
     * 修改货代运营商
     * 
     * @param sysForwarder 货代运营商
     * @return 结果
     */
    @Override
    public int updateSysForwarder(SysForwarder sysForwarder)
    {
        sysForwarder.setUpdateTime(DateUtils.getNowDate());
        return sysForwarderMapper.updateSysForwarder(sysForwarder);
    }

    /**
     * 批量删除货代运营商
     * 
     * @param forwarderIds 需要删除的货代运营商主键
     * @return 结果
     */
    @Override
    public int deleteSysForwarderByforwarderIds(Long[] forwarderIds)
    {
        return sysForwarderMapper.deleteSysForwarderByforwarderIds(forwarderIds);
    }



}
