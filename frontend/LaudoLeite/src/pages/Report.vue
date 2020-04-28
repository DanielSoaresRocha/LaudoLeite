<template>
  <q-page>hello world</q-page>
</template>

<script>
export default {
  created () {
    console.log(this.$route.params.id)
  },
  name: 'Report',
  data () {
    return {}
  }
}
</script>

<style>
</style>
