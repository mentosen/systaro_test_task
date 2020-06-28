import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


export const constantRoutes = [
    {
        path: '/',
        component: () => import('@/components/PostsPageComponent'),
    },
    {
        path:'/task/2',
        component: () => import('@/components/SumOfDigitComponent')
    },
    {
        path:'/task/3',
        component: () => import('@/components/EmailComponent')
    }
];

export default new Router({
    mode: 'history', // require service support
    routes: constantRoutes
})