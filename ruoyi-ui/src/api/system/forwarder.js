import request from '@/utils/request'

// 查询货代运营商列表
export function listForwarder(query) {
  return request({
    url: '/system/forwarder/list',
    method: 'get',
    params: query
  })
}

// 查询货代运营商详细
export function getForwarder(forwarderId) {
  return request({
    url: '/system/forwarder/' + forwarderId,
    method: 'get'
  })
}

// 新增货代运营商
export function addForwarder(data) {
  return request({
    url: '/system/forwarder',
    method: 'post',
    data: data
  })
}

// 修改货代运营商
export function updateForwarder(data) {
  return request({
    url: '/system/forwarder',
    method: 'put',
    data: data
  })
}

// 删除货代运营商
export function delForwarder(forwarderId) {
  return request({
    url: '/system/forwarder/' + forwarderId,
    method: 'delete'
  })
}
