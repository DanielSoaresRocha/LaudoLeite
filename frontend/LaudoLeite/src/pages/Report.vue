<template>
  <q-page>hello world</q-page>
</template>

<script>
import api from '../services/api'

export default {
  async created () {
    const laudo = await api.get(`/laudos/${this.$route.params.id}`)
    console.log(laudo.data)
  },
  name: 'Report',
  data () {
    return {}
  }
}
</script>

<style>
</style>
