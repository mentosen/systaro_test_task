import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


export const constantRoutes = [
    {
        path: '/',
        component: () => import('@/components/post/PostsPageComponent'),
    },
    {
        path:'/task/2',
        component: () => import('@/components/sum/SumOfDigitComponent')
    },
    {
        path:'/task/3',
        component: () => import('@/components/email/EmailComponent')
    }
];

export default new Router({
    mode: 'history', // require service support
    scrollBehavior: (to, from, savedPosition) => {
        if (savedPosition) {
            return savedPosition;
        } else {
            return {x: 0, y: 0};
        }
    },
    routes: constantRoutes
})