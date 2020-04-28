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
            <div class="row q-gutter-md">
              <q-btn
                round
                color="secondary"
                clickable
                v-close-popup
                icon="done"
                @click="showAnalyzeDialog(laudo)"
              >
                <q-tooltip
                  :delay="500"
                  :offset="[0, 10]"
                >Colocar em análise</q-tooltip>
              </q-btn>
              <q-btn
                round
                color="red"
                clickable
                v-close-popup
                icon="close"
              >
                <q-tooltip
                  :delay="500"
                  :offset="[0, 10]"
                >Recusar análise</q-tooltip>
              </q-btn>
              <q-btn
                round
                color="secondary"
                clickable
                v-close-popup
                icon="info"
              >
                <q-tooltip
                  :delay="500"
                  :offset="[0, 10]"
                >Ver informações</q-tooltip>
              </q-btn>
              <q-item-label overline>
                {{laudo.cliente}} <br><br>
                {{laudo.analise}}
              </q-item-label>
            </div>
          </q-item-section>
        </q-item>
      </q-list>
    </div>
    <q-dialog v-model="showAnalyze">
      <q-card style="width: 700px; max-width: 80vw;">
        <q-card-section>
          <div class="col">
            <center>
              <h5>Deseja confirmar a aprovação do laudo de {{laudo.cliente}} para análise?</h5>
            </center>
            <br>
            <div class="q-pa-md q-gutter-md row justify-end">
              <q-btn
                label="cancelar"
                color="red"
                @click="showAnalyze = false"
                clickable
              />
              <q-btn
                @click="approveReservation()"
                label="confirmar"
                color="green"
              />
            </div>
          </div>
        </q-card-section>
      </q-card>
    </q-dialog>
  </q-page>
</template>

<script>
import api from '../services/api'

export default {
  name: 'ViewReports',
  async created () {
    this.laudosPendentes = await this.getReports()
  },
  data () {
    return {
      laudosPendentes: [],
      showApproved: false,
      showAnalyze: false,
      laudo: {}
    }
  },
  methods: {
    async getReports () {
      const response = await api.get('/laudos', {})
      return response.data
    },
    showAnalyzeDialog (laudo) {
      this.showAnalyze = true
      this.laudo = laudo
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
