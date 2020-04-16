<template>
  <q-page>
    <div class="q-pa-md logo text-h4">
      Laudos pendentes
    </div>
    <div class="q-pa-xl">
      <q-list
        bordered
        separator
      >
        <q-item
          clickable
          v-ripple
          v-for="laudo in laudosPendentes"
          :key="laudo.id"
        >
          <q-item-section>
            {{laudo.nome}}
          </q-item-section>
        </q-item>
      </q-list>
    </div>
  </q-page>
</template>

<script>
import api from '../services/api'

export default {
  name: 'ViewReports',
  created () {
    this.getReports()
  },
  data () {
    return {
      laudosPendentes: [
        { id: '1', nome: 'laudo 1', tipo: 'microbiológico' },
        { id: '2', nome: 'laudo 2', tipo: 'físico químico' },
        { id: '3', nome: 'laudo 3', tipo: 'microbiológico' }
      ]
    }
  },
  methods: {
    async getReports () {
      const response = await api.get('/laudos/1', {})
      console.log(response.data)
    }
  }
}
</script>

<style>
.logo {
  width: 100%;
  text-align: center;
}
</style>
