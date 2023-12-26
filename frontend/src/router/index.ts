import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/board',
      name: 'board',
      component: () => import('../views/BoardView.vue')
    },
    {
      path: '/post',
      name: 'post-create',
      component: () => import('../views/PostView.vue')
    },
    {
      path: '/post/:id/',
      name: 'post-read',
      component: () => import('../views/PostView.vue')
    }
  ]
})

export default router
