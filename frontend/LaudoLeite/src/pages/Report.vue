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
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Produto:</b> <br> {{laudo.produto}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Análise solicitada:</b> <br> {{laudo.analise_solicitada}}
          </q-card-section>
        </q-card>
      </div>
      <div class="text-h6 col-12 q-pa-md">
        Dados do produto:
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Nº SIF/IDIARN/SIM:</b> <br> {{laudo.sif_idiarn_sim}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Tipo de amostra:</b> <br> {{tipoApostra()}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Data da produção: </b> <br> {{laudo.data_producao}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Tipo da validade:</b> <br> {{laudo.data_validacao}}
          </q-card-section>
        </q-card>
      </div>
      <div class="text-h6 col-12 q-pa-md">
        Condições da amostra no recebimento:
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Temperatura : </b> <br> {{laudo.temperatura}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Estado:</b> <br> Resfriado
            <!-- Falta retornar do banco {{laudo.estado}} -->
          </q-card-section>
        </q-card>
      </div>
      <div class="col-12 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Ordem de serviço:</b> <br> {{laudo.ordem_servico}}
            <!-- Falta retornar do banco {{laudo.estado}} -->
          </q-card-section>
        </q-card>
      </div>
      <div class="col-12 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Respondável pelo recebimento:</b> <br> {{laudo.responsavel_recebimento}}
            <!-- Falta retornar do banco {{laudo.estado}} -->
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>Data do recebimento: </b> <br> {{laudo.data_recebimento}}
          </q-card-section>
        </q-card>
      </div>
      <div class="col-6 q-pa-xs">
        <q-card>
          <q-card-section style="background-color: Silver">
            <b>hora do recebimento:</b> <br> {{laudo.hora_recebimento}}
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
  },
  methods: {
    tipoApostra () {
      if (this.laudo.individual) {
        return 'individual'
      } else {
        return 'Não individual'
      }
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
