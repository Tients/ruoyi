package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货代运营商对象 sys_forwarder
 *
 * @author ruoyi
 * @date 2022-12-01
 */
public class SysForwarder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */

    private Long forwarderId;

    /** 货代编码 */
    @Excel(name = "货代编码")
    private String forwarderCode;

    /** 货代名称 */
    @Excel(name = "货代名称")
    private String forwarderName;

    /** 使用状态（0正常 1停用） */
    @Excel(name = "使用状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,2=代表删除")
    private String delFlg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getforwarderId() {
        return forwarderId;
    }

    public void setforwarderId(Long forwarderId) {
        this.forwarderId = forwarderId;
    }

    public String getforwarderCode() {
        return forwarderCode;
    }

    public void setforwarderCode(String forwarderCode) {
        this.forwarderCode = forwarderCode;
    }

    public String getforwarderName() {
        return forwarderName;
    }

    public void setforwarderName(String forwarderName) {
        this.forwarderName = forwarderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getdelFlg() {
        return delFlg;
    }

    public void setdelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("forwarderId", getforwarderId())
                .append("forwarderCode", getforwarderCode())
                .append("forwarderName", getforwarderName())
                .append("status", getStatus())
                .append("delFlg", getdelFlg())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}