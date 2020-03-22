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
export default {
  name: 'ViewReports',
  data () {
    return {
      laudosPendentes: [
        { id: '', nome: 'laudo 1', tipo: 'microbiológico' },
        { id: '', nome: 'laudo 2', tipo: 'físico químico' },
        { id: '', nome: 'laudo 3', tipo: 'microbiológico' }
      ]
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
