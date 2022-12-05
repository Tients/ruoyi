package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.ForwarderLogisticsQuotation;

/**
 * 货代物流报价Service接口
 * 
 * @author ruoyi
 * @date 2022-12-04
 */
public interface IForwarderLogisticsQuotationService 
{
    /**
     * 查询货代物流报价
     * 
     * @param id 货代物流报价主键
     * @return 货代物流报价
     */
    public ForwarderLogisticsQuotation selectForwarderLogisticsQuotationById(Long id);

    /**
     * 查询货代物流报价列表
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 货代物流报价集合
     */
    public List<ForwarderLogisticsQuotation> selectForwarderLogisticsQuotationList(ForwarderLogisticsQuotation forwarderLogisticsQuotation);

    /**
     * 新增货代物流报价
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 结果
     */
    public int insertForwarderLogisticsQuotation(ForwarderLogisticsQuotation forwarderLogisticsQuotation);

    /**
     * 修改货代物流报价
     * 
     * @param forwarderLogisticsQuotation 货代物流报价
     * @return 结果
     */
    public int updateForwarderLogisticsQuotation(ForwarderLogisticsQuotation forwarderLogisticsQuotation);

    /**
     * 批量删除货代物流报价
     * 
     * @param ids 需要删除的货代物流报价主键集合
     * @return 结果
     */
    public int deleteForwarderLogisticsQuotationByIds(Long[] ids);

    /**
     * 删除货代物流报价信息
     * 
     * @param id 货代物流报价主键
     * @return 结果
     */
    public int deleteForwarderLogisticsQuotationById(Long id);
}
