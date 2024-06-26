<template>
    <el-form :model="form" label-width="auto" style="max-width: 600px">
      <el-form-item label="请输入ID查询">
        <el-input v-model="form.id" />
      </el-form-item>
      <el-form-item style="display: flex; justify-content: space-between;">
        <el-button type="primary" @click="onSubmit">确认</el-button>
        <el-button @click="onCancel">取消</el-button>
        <el-button type="primary" @click="onQueryAll" style="margin-left: auto;">查询全部</el-button>
      </el-form-item>
    </el-form>
    <admintable :data="tableData"></admintable>
  </template>
  
  <script>
  import { reactive } from 'vue'
  import admintable from './admintable.vue'
  import axios from 'axios'
  export default {
    name: 'AdminQuery',
    data() {
      return {
        form: reactive({
          id: ''
        }),
        tableData: []
      }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:8080/api/admin/'+this.form.id)
            .then(response => {
                this.tableData = [response.data.data] // 假设响应数据是数组类型      
            })
            .catch(error => {
                console.error('There was an error fetching the data:', error)
            })
            },
      onCancel() {
        this.form.id = ''
      },
      onQueryAll() {
        axios.get('http://localhost:8080/api/admin/all')
            .then(response => {
                this.tableData = response.data.data // 假设响应数据是数组类型
            })
            .catch(error => {
                console.error('There was an error fetching the data:', error)
            })
        }
    },
    components: {
      admintable
    }
  }
  </script>


