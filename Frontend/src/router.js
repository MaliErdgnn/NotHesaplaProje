import {createRouter , createWebHistory} from 'vue-router'

import Login from './components/Login.vue'
import Register from './components/Register.vue'
import Anaekran from './components/Anasayfa.vue'
import Profil from './components/Profil.vue'
import NotHesapla from './components/NotHesapla.vue'
import OrtHesapla from './components/OrtHesapla.vue'
import SifreDegistir from './components/SifreDegistir.vue'
import GecmisNotlar from './components/Gecmis.vue'

const routes = [
    {path: '/', name: "login", component: Login},
    {path: '/register', name:"register", component: Register},
    {path: '/Anaekran', name:"anaekran", component: Anaekran},
    {path: '/profil', name:"Profil", component: Profil},
    {path: '/DersHarfNotuHesapla', name:"NotHesapla", component: NotHesapla},
    {path: '/NotOrtalamasıHesapla', name:"OrtHesapla", component: OrtHesapla},
    {path: '/sifredegistir', name:"SifreDegistir", component: SifreDegistir},
    {path: '/GecmisNotlar', name:"GecmisNotlar", component: GecmisNotlar},
]

const router = createRouter({
    routes: routes,
    history: createWebHistory()
})

export default router;