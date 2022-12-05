<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="目的国" prop="destinationCountry">
        <el-input
          v-model="queryParams.destinationCountry"
          placeholder="请输入目的国"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的仓" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的仓"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮编开头" prop="zipCodeHead">
        <el-input
          v-model="queryParams.zipCodeHead"
          placeholder="请输入邮编开头"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币种" prop="currency">
        <el-input
          v-model="queryParams.currency"
          placeholder="请输入币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="起始值" prop="beginValue">
        <el-input
          v-model="queryParams.beginValue"
          placeholder="请输入起始值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单位" prop="unit">
        <el-input
          v-model="queryParams.unit"
          placeholder="请输入单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参考时效 - 小值" prop="minAging">
        <el-input
          v-model="queryParams.minAging"
          placeholder="请输入参考时效 - 小值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参考时效 - 大值" prop="maxAging">
        <el-input
          v-model="queryParams.maxAging"
          placeholder="请输入参考时效 - 大值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否带电池" prop="haveBattery">
        <el-input
          v-model="queryParams.haveBattery"
          placeholder="请输入是否带电池"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货代运营商" prop="forwarder">
        <el-input
          v-model="queryParams.forwarder"
          placeholder="请输入货代运营商"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人ID" prop="createById">
        <el-input
          v-model="queryParams.createById"
          placeholder="请输入创建人ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除" prop="isDeleted">
        <el-input
          v-model="queryParams.isDeleted"
          placeholder="请输入是否删除"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:quotation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:quotation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:quotation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:quotation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="quotationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="运输类型" align="center" prop="shipType" />
      <el-table-column label="目的国" align="center" prop="destinationCountry" />
      <el-table-column label="目的仓" align="center" prop="destination" />
      <el-table-column label="邮编开头" align="center" prop="zipCodeHead" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="起始值" align="center" prop="beginValue" />
      <el-table-column label="单位" align="center" prop="unit" />
      <el-table-column label="参考时效 - 小值" align="center" prop="minAging" />
      <el-table-column label="参考时效 - 大值" align="center" prop="maxAging" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="是否带电池" align="center" prop="haveBattery" />
      <el-table-column label="货代运营商" align="center" prop="forwarder" />
      <el-table-column label="创建人ID" align="center" prop="createById" />
      <el-table-column label="是否删除" align="center" prop="isDeleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:quotation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:quotation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改货代物流报价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="目的国" prop="destinationCountry">
          <el-input v-model="form.destinationCountry" placeholder="请输入目的国" />
        </el-form-item>
        <el-form-item label="目的仓" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的仓" />
        </el-form-item>
        <el-form-item label="邮编开头" prop="zipCodeHead">
          <el-input v-model="form.zipCodeHead" placeholder="请输入邮编开头" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="起始值" prop="beginValue">
          <el-input v-model="form.beginValue" placeholder="请输入起始值" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="参考时效 - 小值" prop="minAging">
          <el-input v-model="form.minAging" placeholder="请输入参考时效 - 小值" />
        </el-form-item>
        <el-form-item label="参考时效 - 大值" prop="maxAging">
          <el-input v-model="form.maxAging" placeholder="请输入参考时效 - 大值" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否带电池" prop="haveBattery">
          <el-input v-model="form.haveBattery" placeholder="请输入是否带电池" />
        </el-form-item>
        <el-form-item label="货代运营商" prop="forwarder">
          <el-input v-model="form.forwarder" placeholder="请输入货代运营商" />
        </el-form-item>
        <el-form-item label="创建人ID" prop="createById">
          <el-input v-model="form.createById" placeholder="请输入创建人ID" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listQuotation, getQuotation, delQuotation, addQuotation, updateQuotation } from "@/api/system/quotation";

export default {
  name: "Quotation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 货代物流报价表格数据
      quotationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shipType: null,
        destinationCountry: null,
        destination: null,
        zipCodeHead: null,
        price: null,
        currency: null,
        beginValue: null,
        unit: null,
        minAging: null,
        maxAging: null,
        haveBattery: null,
        forwarder: null,
        createById: null,
        isDeleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询货代物流报价列表 */
    getList() {
      this.loading = true;
      listQuotation(this.queryParams).then(response => {
        this.quotationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        shipType: null,
        destinationCountry: null,
        destination: null,
        zipCodeHead: null,
        price: null,
        currency: null,
        beginValue: null,
        unit: null,
        minAging: null,
        maxAging: null,
        remark: null,
        haveBattery: null,
        forwarder: null,
        createById: null,
        createBy: null,
        updateBy: null,
        isDeleted: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加货代物流报价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getQuotation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改货代物流报价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateQuotation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addQuotation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除货代物流报价编号为"' + ids + '"的数据项？').then(function() {
        return delQuotation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/quotation/export', {
        ...this.queryParams
      }, `quotation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
