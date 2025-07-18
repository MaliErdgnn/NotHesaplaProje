//import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store';


const app = createApp(App)
app.use(router)
app.use(store) // Use the store plugin
app.mount('#app')