package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysForwarder;
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
import com.ruoyi.system.service.ISysForwarderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货代运营商Controller
 * 
 * @author ruoyi
 * @date 2022-12-01
 */
@RestController
@RequestMapping("/system/forwarder")
public class SysForwarderController extends BaseController
{
    @Autowired
    private ISysForwarderService sysForwarderService;

    /**
     * 查询货代运营商列表
     */
    //@PreAuthorize("@ss.hasPermi('system:forwarder:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysForwarder sysForwarder)
    {
        startPage();
        List<SysForwarder> list = sysForwarderService.selectSysForwarderList(sysForwarder);
        return getDataTable(list);
    }

    /**
     * 导出货代运营商列表
     */
    @PreAuthorize("@ss.hasPermi('system:forwarder:export')")
    @Log(title = "货代运营商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysForwarder sysForwarder)
    {
        List<SysForwarder> list = sysForwarderService.selectSysForwarderList(sysForwarder);
        ExcelUtil<SysForwarder> util = new ExcelUtil<SysForwarder>(SysForwarder.class);
        util.exportExcel(response, list, "货代运营商数据");
    }

    /**
     * 获取货代运营商详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:forwarder:query')")
    @GetMapping(value = "/{forwarderId}")
    public AjaxResult getInfo(@PathVariable("forwarderId") Long forwarderId)
    {
        return success(sysForwarderService.selectSysForwarderByforwarderId(forwarderId));
    }

    /**
     * 新增货代运营商
     */
    @PreAuthorize("@ss.hasPermi('system:forwarder:add')")
    @Log(title = "货代运营商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysForwarder sysForwarder)
    {
        return toAjax(sysForwarderService.insertSysForwarder(sysForwarder));
    }

    /**
     * 修改货代运营商
     */
    @PreAuthorize("@ss.hasPermi('system:forwarder:edit')")
    @Log(title = "货代运营商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysForwarder sysForwarder)
    {
        return toAjax(sysForwarderService.updateSysForwarder(sysForwarder));
    }

    /**
     * 删除货代运营商
     */
    @PreAuthorize("@ss.hasPermi('system:forwarder:remove')")
    @Log(title = "货代运营商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{forwarderIds}")
    public AjaxResult remove(@PathVariable Long[] forwarderIds)
    {
        return toAjax(sysForwarderService.deleteSysForwarderByforwarderIds(forwarderIds));
    }

}
