package com.ruoyi.common.core.domain.entity;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货代物流报价对象 forwarder_logistics_quotation
 * 
 * @author ruoyi
 * @date 2022-12-04
 */
public class ForwarderLogisticsQuotation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 运输类型 */
    @Excel(name = "运输类型")
    private String shipType;

    /** 目的国 */
    @Excel(name = "目的国")
    private String destinationCountry;

    /** 目的仓 */
    @Excel(name = "目的仓")
    private String destination;

    /** 邮编开头 */
    @Excel(name = "邮编开头")
    private String zipCodeHead;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 起始值 */
    @Excel(name = "起始值")
    private BigDecimal beginValue;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 参考时效 - 小值 */
    @Excel(name = "参考时效 - 小值")
    private BigDecimal minAging;

    /** 参考时效 - 大值 */
    @Excel(name = "参考时效 - 大值")
    private BigDecimal maxAging;

    /** 是否带电池 */
    @Excel(name = "是否带电池")
    private Integer haveBattery;

    /** 货代运营商 */
    @Excel(name = "货代运营商")
    private String forwarder;

    /** 创建人ID */
    @Excel(name = "创建人ID")
    private Long createById;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShipType(String shipType) 
    {
        this.shipType = shipType;
    }

    public String getShipType() 
    {
        return shipType;
    }
    public void setDestinationCountry(String destinationCountry) 
    {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCountry() 
    {
        return destinationCountry;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setZipCodeHead(String zipCodeHead) 
    {
        this.zipCodeHead = zipCodeHead;
    }

    public String getZipCodeHead() 
    {
        return zipCodeHead;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setBeginValue(BigDecimal beginValue) 
    {
        this.beginValue = beginValue;
    }

    public BigDecimal getBeginValue() 
    {
        return beginValue;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setMinAging(BigDecimal minAging) 
    {
        this.minAging = minAging;
    }

    public BigDecimal getMinAging() 
    {
        return minAging;
    }
    public void setMaxAging(BigDecimal maxAging) 
    {
        this.maxAging = maxAging;
    }

    public BigDecimal getMaxAging() 
    {
        return maxAging;
    }
    public void setHaveBattery(Integer haveBattery) 
    {
        this.haveBattery = haveBattery;
    }

    public Integer getHaveBattery() 
    {
        return haveBattery;
    }
    public void setForwarder(String forwarder) 
    {
        this.forwarder = forwarder;
    }

    public String getForwarder() 
    {
        return forwarder;
    }
    public void setCreateById(Long createById) 
    {
        this.createById = createById;
    }

    public Long getCreateById() 
    {
        return createById;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shipType", getShipType())
            .append("destinationCountry", getDestinationCountry())
            .append("destination", getDestination())
            .append("zipCodeHead", getZipCodeHead())
            .append("price", getPrice())
            .append("currency", getCurrency())
            .append("beginValue", getBeginValue())
            .append("unit", getUnit())
            .append("minAging", getMinAging())
            .append("maxAging", getMaxAging())
            .append("remark", getRemark())
            .append("haveBattery", getHaveBattery())
            .append("forwarder", getForwarder())
            .append("createById", getCreateById())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("isDeleted", getIsDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
