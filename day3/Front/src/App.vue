<template>
  <div id="app" >
    <span>
      <h1>数据查询</h1>
      <adminquery></adminquery>
    </span>   
  </div>
</template>


<script>
import adminquery from './components/adminquery.vue';
export default{
  name: 'App',
  components:{
    adminquery,
  }
}
</script>
<style>
#app {
  font-family:  Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  background-color: #f0f0f0; /* 设置背景颜色 */
  color: #333; /* 设置文字颜色 */
  padding: 20px; /* 设置内边距 */
  border-radius: 10px; /* 设置边框圆角 */
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 设置阴影效果 */
  transition: all 0.3s ease; /* 添加过渡效果 */
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center;    /* 垂直居中 */
  height: 100vh;          /* 使 div 高度为视口高度 */
  text-align: center;     /* 使文本内容居中 */
}
</style>