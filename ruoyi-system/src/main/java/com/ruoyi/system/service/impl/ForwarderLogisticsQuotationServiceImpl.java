package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.ForwarderLogisticsQuotation;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ForwarderLogisticsQuotationMapper;
import com.ruoyi.system.service.IForwarderLogisticsQuotationService;

import javax.annotation.Resource;

/**
 * 货代物流报价Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-04
 */
@Service
public class ForwarderLogisticsQuotationServiceImpl implements IForwarderLogisticsQuotationService 
{
    @Resource
    private ForwarderLogisticsQuotationMapper forwarderLogisticsQuotationMapper;

    /**
     * 查询货代物流报价
     * 
     * @param id 货代物流报价主键
     * @return 货代物流报价
     */
    @Override
    public ForwarderLogisticsQuotation selectForwarderLogisticsQuotationById(Long id)
    {
        return forwarderLogisticsQuotationMapper.selectForwarderLogisticsQuotationById(id);
    }

    /**
     * 查询货代物流报价列表
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 货代物流报价
     */
    @Override
    public List<ForwarderLogisticsQuotation> selectForwarderLogisticsQuotationList(ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        return forwarderLogisticsQuotationMapper.selectForwarderLogisticsQuotationList(forwarderLogisticsQuotation);
    }

    /**
     * 新增货代物流报价
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 结果
     */
    @Override
    public int insertForwarderLogisticsQuotation(ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        forwarderLogisticsQuotation.setCreateTime(DateUtils.getNowDate());
        return forwarderLogisticsQuotationMapper.insertForwarderLogisticsQuotation(forwarderLogisticsQuotation);
    }

    /**
     * 修改货代物流报价
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 结果
     */
    @Override
    public int updateForwarderLogisticsQuotation(ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        forwarderLogisticsQuotation.setUpdateTime(DateUtils.getNowDate());
        return forwarderLogisticsQuotationMapper.updateForwarderLogisticsQuotation(forwarderLogisticsQuotation);
    }

    /**
     * 批量删除货代物流报价
     * 
     * @param ids 需要删除的货代物流报价主键
     * @return 结果
     */
    @Override
    public int deleteForwarderLogisticsQuotationByIds(Long[] ids)
    {
        return forwarderLogisticsQuotationMapper.deleteForwarderLogisticsQuotationByIds(ids);
    }

    /**
     * 删除货代物流报价信息
     * 
     * @param id 货代物流报价主键
     * @return 结果
     */
    @Override
    public int deleteForwarderLogisticsQuotationById(Long id)
    {
        return forwarderLogisticsQuotationMapper.deleteForwarderLogisticsQuotationById(id);
    }
}
