
const routes = [{
  path: '/login', component: () => import('pages/Register.vue')
},
{
  path: '/',
  component: () => import('layouts/MainLayout.vue'),
  children: [
    { path: '', component: () => import('pages/Index.vue') },
    { path: '/RegisterReport', component: () => import('pages/RegisterReport.vue') },
    { path: '/Register', component: () => import('pages/Register.vue') },
    { path: '/ViewReports', component: () => import('pages/ViewReports') },
    { path: '/Report/:id?', component: () => import('pages/Report') }
  ]
}
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
