import { createRouter, createWebHistory } from "vue-router";
import HomeView from '../views/HomeView.vue'


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes:[
        {
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/catalogo',
            name: 'catalogo',
            component: () => import('../views/CatalogoView.vue')
        },
        {
            path: '/panel_admin',
            name: 'panel_admin',
            component: () => import('../views/PanelAdminView.vue')
        },
        {
            path: '/tablaproductos',
            name: 'tablaproductos',
            component: () => import('../views/TProductosView.vue')
        },
        {
            path: '/polo',
            name: 'polo',
            component: () => import('../views/PoloView.vue')
        },
        {
            path: '/estampado',
            name: 'estampado',
            component: () => import('../views/EstampadoView.vue')
        },
        {
            path: '/camiseta',
            name: 'camiseta',
            component: () => import('../views/CamisetaView.vue')
        },
        {
            path: '/tank',
            name: 'tank',
            component: () => import('../views/TankView.vue')
        }
    ]
})

export default router