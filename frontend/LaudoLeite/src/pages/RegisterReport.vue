<template>
  <q-page>
    <div class="vertical-top logo q-pa-md text-h3">
      Cadastrar laudo
    </div>
    <div class="q-pr-xl q-pl-xl row">
      <div class="col-6 q-pa-xs">
        <q-input
          standout="bg-teal text-white"
          v-model="text"
          label="Cliente"
        />
      </div>
      <div class="col-6 q-pa-xs">
        <q-input
          filled
          v-model="dateColeta"
          mask="date"
          :rules="['date']"
          label="Data da coleta"
        >
          <template v-slot:append>
            <q-icon
              name="event"
              class="cursor-pointer"
            >
              <q-popup-proxy
                ref="qDateProxy"
                transition-show="scale"
                transition-hide="scale"
              >
                <q-date
                  mask="DD-MM-YYYY"
                  v-model="dateColeta"
                  @input="() => $refs.qDateProxy.hide()"
                />
              </q-popup-proxy>
            </q-icon>
          </template>
        </q-input>
      </div>
      <div class="col-6 q-pr-xs q-pl-xs">
        <q-input
          standout="bg-teal text-white"
          v-model="responsibleCollection"
          label="Responsável pela coleta"
        />
      </div>
      <div class="col-6 q-pr-xs q-pl-xs">
        <q-input
          filled
          v-model="timeColeta"
          mask="time"
          :rules="['time']"
          label="Hora da coleta"
        >
          <template v-slot:append>
            <q-icon
              name="access_time"
              class="cursor-pointer"
            >
              <q-popup-proxy
                transition-show="scale"
                transition-hide="scale"
              >
                <q-time v-model="timeColeta" />
              </q-popup-proxy>
            </q-icon>
          </template>
        </q-input>
      </div>
    </div>
    <div class="q-pr-xl q-pl-xl text-subtitle1">
      <div class="text-h6">
        Produto:
      </div>
      <q-option-group
        v-model="groupProduto"
        :options="optionsProduct"
        color="primary"
        inline
      />
    </div>
    <div class="q-pr-xl q-pl-xl text-subtitle1">
      <div class="text-h6">
        Análises solicitadas:
      </div>
      <q-option-group
        v-model="groupAnalise"
        :options="optionsAnalise"
        color="primary"
        inline
      />
    </div>
    <div class="q-pr-xl q-pl-xl text-subtitle1">
      <div class="text-h6">
        Dados do produto:
      </div>
      <div class="row q-pt-md">
        <div class="col-6 q-pa-xs">
          <q-input
            standout="bg-teal text-white"
            v-model="idiarn"
            label="N° SIF/IDIARN/SIM"
          />
        </div>
        <div class="col-6 q-pa-xs">
          Tipo da amostra:
          <q-option-group
            v-model="groupTipoAmostra"
            :options="optionsAmostra"
            color="primary"
            inline
          />
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      text: '',
      dateColeta: '28/04/2000',
      responsibleCollection: '',
      timeColeta: '10:56',
      groupProduto: 'op1',
      groupAnalise: 'ot1',
      groupTipoAmostra: '',
      idiarn: '',
      optionsProduct: [
        {
          label: 'Leite cru',
          value: 'op1'
        },
        {
          label: 'Leite Pasteurizado',
          value: 'op2'
        },
        {
          label: 'Queijo',
          value: 'op3'
        },
        {
          label: 'Nata',
          value: 'op4'
        },
        {
          label: 'Creme de leite',
          value: 'op5'
        },
        {
          label: 'Sorvete',
          value: 'op6'
        },
        {
          label: 'Doce de leite',
          value: 'op7'
        },
        {
          label: 'Requeijão',
          value: 'op8'
        },
        {
          label: 'Manteiga',
          value: 'op9'
        },
        {
          label: 'Iorgute',
          value: 'op10'
        },
        {
          label: 'Bebida láctea',
          value: 'op11'
        },
        {
          label: 'Coalhada',
          value: 'op12'
        },
        {
          label: 'Bebida láctea',
          value: 'op13'
        },
        {
          label: 'Outro',
          value: 'op14'
        }
      ],
      optionsAnalise: [
        {
          label: 'CPP',
          value: 'ot1'
        },
        {
          label: 'Coliformes a 30° - 35° C',
          value: 'ot2'
        },
        {
          label: 'Coliformes a 45° C',
          value: 'ot3'
        }
      ],
      optionsAmostra: [
        {
          label: 'individual',
          value: 'oa1'
        },
        {
          label: 'Não individual',
          value: 'oa2'
        }
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
.areaCliente {
  width: 300px;
  align-items: center;
}
</style>
