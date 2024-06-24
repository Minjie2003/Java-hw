<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="id" width="100" />
        <el-table-column prop="loginName" label="登录名" width="100" />
        <el-table-column prop="password" label="密码" width="100" />
        <el-table-column prop="lastLoginTime" label="上次登录时间" width="100" />
        <el-table-column prop="remark" label="评论" width="100" />
    </el-table>
  </template>
  
  <script>
  export default {
    name: 'AdminTable',
    props: {
      tableData: {
        type: Array,
        default: () => []
      }
    }
  }
  </script>
  