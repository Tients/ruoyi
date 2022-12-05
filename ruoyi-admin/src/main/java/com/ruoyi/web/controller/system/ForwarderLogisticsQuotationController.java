package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.ForwarderLogisticsQuotation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IForwarderLogisticsQuotationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货代物流报价Controller
 * 
 * @author ruoyi
 * @date 2022-12-04
 */
@RestController
@RequestMapping("/system/quotation")
public class ForwarderLogisticsQuotationController extends BaseController
{
    @Autowired
    private IForwarderLogisticsQuotationService forwarderLogisticsQuotationService;

    /**
     * 查询货代物流报价列表
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:list')")
    @GetMapping("/list")
    public TableDataInfo list(ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        startPage();
        List<ForwarderLogisticsQuotation> list = forwarderLogisticsQuotationService.selectForwarderLogisticsQuotationList(forwarderLogisticsQuotation);
        return getDataTable(list);
    }

    /**
     * 导出货代物流报价列表
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:export')")
    @Log(title = "货代物流报价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        List<ForwarderLogisticsQuotation> list = forwarderLogisticsQuotationService.selectForwarderLogisticsQuotationList(forwarderLogisticsQuotation);
        ExcelUtil<ForwarderLogisticsQuotation> util = new ExcelUtil<ForwarderLogisticsQuotation>(ForwarderLogisticsQuotation.class);
        util.exportExcel(response, list, "货代物流报价数据");
    }

    /**
     * 获取货代物流报价详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(forwarderLogisticsQuotationService.selectForwarderLogisticsQuotationById(id));
    }

    /**
     * 新增货代物流报价
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:add')")
    @Log(title = "货代物流报价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        return toAjax(forwarderLogisticsQuotationService.insertForwarderLogisticsQuotation(forwarderLogisticsQuotation));
    }

    /**
     * 修改货代物流报价
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:edit')")
    @Log(title = "货代物流报价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ForwarderLogisticsQuotation forwarderLogisticsQuotation)
    {
        return toAjax(forwarderLogisticsQuotationService.updateForwarderLogisticsQuotation(forwarderLogisticsQuotation));
    }

    /**
     * 删除货代物流报价
     */
    @PreAuthorize("@ss.hasPermi('system:quotation:remove')")
    @Log(title = "货代物流报价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(forwarderLogisticsQuotationService.deleteForwarderLogisticsQuotationByIds(ids));
    }
}
