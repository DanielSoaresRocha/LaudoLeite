<template>
  <q-page>
    <div class="q-pa-md logo text-h3">Laudo</div>
    <div class="q-pr-xl q-pl-xl row text-subtitle1">
      <div class="col-7 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Cliente: </b> <br>{{laudo.cliente}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-5 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Data da coleta: </b> <br>{{laudo.data_coleta}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-7 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Responsável pela coleta:</b> <br>{{laudo.responsavel_coleta}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-5 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Hora da coleta:</b> <br> {{laudo.hora_coleta}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-5 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Produto:</b> <br> {{laudo.produto}}
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
import api from '../services/api'

export default {
  async created () {
    const response = await api.get(`/laudos/${this.$route.params.id}`)
    this.laudo = response.data
    console.log(this.laudo)
  },
  name: 'Report',
  data () {
    return {
      laudo: {}
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
