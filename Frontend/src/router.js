
import { createRouter, createWebHistory } from 'vue-router'

import Login from './components/Login.vue'
import Register from './components/Register.vue'
import Anaekran from './components/Anasayfa.vue'
import Profil from './components/Profil.vue'
import NotHesapla from './components/NotHesapla.vue'
import OrtHesapla from './components/OrtHesapla.vue'
import SifreDegistir from './components/SifreDegistir.vue'
import GecmisNotlar from './components/Gecmis.vue'
import $store from './store.js'
const routes = [
    { path: '/', name: "login", component: Login, meta: { auth: false } },
    { path: '/register', name: "register", component: Register, meta: { auth: false } },
    { path: '/Anaekran', name: "anaekran", component: Anaekran, meta: { auth: true },/* props: (route) => ({user: user, ...route.params})props: true*/ },
    { path: '/profil', name: "Profil", component: Profil, meta: { auth: true } },
    { path: '/DersHarfNotuHesapla', name: "NotHesapla", component: NotHesapla, meta: { auth: true }, /*props: true*/  },
    { path: '/NotOrtalamasıHesapla', name: "OrtHesapla", component: OrtHesapla, meta: { auth: true },/* props: true*/ },
    { path: '/sifredegistir', name: "SifreDegistir", component: SifreDegistir, meta: { auth: true }, /*props: true*/ },
    { path: '/GecmisNotlar', name: "GecmisNotlar", component: GecmisNotlar, meta: { auth: true }, /*props: true */},
]

const router = createRouter({
    routes: routes,
    history: createWebHistory()
})

router.beforeEach((to, from, next) => {
    if (to.meta.auth && $store.state.user.email == '') {
        next({ path: '/' })
    } else {
        next()
    }
})

export default router;