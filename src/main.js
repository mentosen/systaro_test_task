import Vue from 'vue'
import App from './App.vue'

import '@/assets/styles.scss';

import Paginate from 'vuejs-paginate';
import VueRouter from 'vue-router';

import router from '@/router';

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');

Vue.component('paginate', Paginate);

Vue.use(VueRouter);