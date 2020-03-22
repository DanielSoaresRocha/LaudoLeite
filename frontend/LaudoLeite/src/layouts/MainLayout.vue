<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title>
          Quasar App
        </q-toolbar-title>

        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-1"
    >
      <q-list>
        <q-item-label header>Menu</q-item-label>
        <q-item
          v-for="item in menus"
          :key="item.label"
          @click="goTo(item.path)"
          clickable
          tag="a"
        >
          <q-item-section avatar>
            <q-icon :name="item.icon" />
          </q-item-section>
          <q-item-section>
            <q-item-label>{{item.label}}</q-item-label>
          </q-item-section>
        </q-item>
        <!-- </q-expansion-item> -->
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>

export default {
  name: 'MainLayout',
  data () {
    return {
      leftDrawerOpen: false,
      menus: [
        {
          label: 'Home',
          icon: 'home',
          path: '/'
        },
        {
          label: 'Solicitar análise',
          icon: 'business',
          path: '/RegisterReport'
        },
        {
          label: 'Cadastrar-se',
          icon: 'account_box',
          path: '/Register'
        }, {
          label: 'LaudosPendentes',
          icon: 'account_box',
          path: '/ViewReports'
        }
      ]
    }
  },
  methods: {
    goTo (path) {
      this.$router.push(path)
    }
  }
}
</script>
