import request from '@/utils/request'

// 查询货代物流报价列表
export function listQuotation(query) {
  return request({
    url: '/system/quotation/list',
    method: 'get',
    params: query
  })
}

// 查询货代物流报价详细
export function getQuotation(id) {
  return request({
    url: '/system/quotation/' + id,
    method: 'get'
  })
}

// 新增货代物流报价
export function addQuotation(data) {
  return request({
    url: '/system/quotation',
    method: 'post',
    data: data
  })
}

// 修改货代物流报价
export function updateQuotation(data) {
  return request({
    url: '/system/quotation',
    method: 'put',
    data: data
  })
}

// 删除货代物流报价
export function delQuotation(id) {
  return request({
    url: '/system/quotation/' + id,
    method: 'delete'
  })
}
