import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import store from './store'  
import '../node_modules/font-awesome/css/font-awesome.css'
import axios from 'axios'
import { createRouter } from 'vue-router'
axios.defaults.baseURL = "https://localhost:8080"

const app = createApp(App)
app.config.globalProperties.$http = axios
app.use(store)     //此时任意的组件里面就可以去取vuex的数据了
app.use(ElementPlus)
app.mount('#app')
