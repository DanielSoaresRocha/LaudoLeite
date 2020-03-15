<template>
  <q-page>
    <div class="vertical-top logo q-pa-md text-h3">
      Cadastrar laudo
    </div>
    <div class="q-pr-xl q-pl-xl row">
      <div class="col-6 q-pa-xs">
        <q-input
          standout="bg-primary text-white"
          v-model="text"
          label="Cliente"
        />
      </div>
      <div class="col-6 q-pa-xs">
        <q-input
          standout="bg-primary text-white"
          filled
          v-model="dateColeta"
          label="Data da coleta"
          mask="##/##/####"
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
          standout="bg-primary text-white"
          v-model="responsibleCollection"
          label="Responsável pela coleta"
        />
      </div>
      <div class="col-6 q-pr-xs q-pl-xs">
        <q-input
          standout="bg-primary text-white"
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
        @click="enviarAlerta"
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
            standout="bg-primary text-white"
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
        <div class="col-6 q-pr-xs q-pl-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="dateProducao"
            mask="##/##/####"
            label="Data da produção"
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
                    v-model="dateProducao"
                    @input="() => $refs.qDateProxy.hide()"
                  />
                </q-popup-proxy>
              </q-icon>
            </template>
          </q-input>
        </div>
        <div class="col-4 q-pr-xs q-pl-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="dateValidade"
            mask="##/##/####"
            label="Data da validade"
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
                    mask="##/##/####"
                    v-model="dateValidade"
                    @input="() => $refs.qDateProxy.hide()"
                  />
                </q-popup-proxy>
              </q-icon>
            </template>
          </q-input>
        </div>
        <div class="col-2 q-pr-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="quantidade"
            label="Quantidade: "
            type="number"
          />
        </div>
      </div>
    </div>
    <div class="q-pr-xl q-pl-xl text-subtitle1">
      <div class="text-h6">
        Condições da amostra no recebimento:
      </div>
      <div class="row q-pt-md">
        <div class="col-3 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="temperatura"
            label="Temperatura (°C)"
            type="number"
          />
        </div>
        <div class="col-9 q-pa-xs">
          Estado:
          <q-option-group
            v-model="groupCondicao"
            :options="optionsCondicion"
            color="primary"
            inline
          />
        </div>
        <div class="col-12 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="ordemServico"
            label="Ordem de serviço"
          />
        </div>
        <div class="col-4 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="responsavelRecebimento"
            label="Responsável pelo recebimento: "
          />
        </div>
        <div class="col-4 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="dateRecebimento"
            mask="##/##/####"
            label="Data do recebimento"
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
                    v-model="dateRecebimento"
                    @input="() => $refs.qDateProxy.hide()"
                  />
                </q-popup-proxy>
              </q-icon>
            </template>
          </q-input>
        </div>
        <div class="col-4 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="timeRecebimento"
            mask="time"
            :rules="['time']"
            label="Hora do recebimento"
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
                  <q-time v-model="timeRecebimento" />
                </q-popup-proxy>
              </q-icon>
            </template>
          </q-input>
        </div>
      </div>
      <div class="text-h6">
        Amostras:
      </div>
      <q-btn
        color="blue"
        label="Adicionar amostra"
        @click="adicionarAmostra"
      />
      <q-list
        bordered
        separator
      >
        <q-item
          clickable
          v-ripple
          v-for="amostra in amostras"
          :key="amostra.id"
        >
          <q-item-section>Amostra {{amostra.key}}</q-item-section>
        </q-item>
      </q-list>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      amostras: [],
      text: '',
      responsavelRecebimento: '',
      dateColeta: '',
      dateProducao: '',
      dateValidade: '',
      dateRecebimento: '',
      horaRecebimento: '',
      timeRecebimento: '',
      responsibleCollection: '',
      timeColeta: '',
      groupProduto: '',
      groupAnalise: '',
      groupCondicao: '',
      groupTipoAmostra: '',
      idiarn: '',
      quantidade: '',
      temperatura: '',
      ordemServico: '',
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
      ],
      optionsCondicion: [
        {
          label: 'Congelado sólido',
          value: 'oc1'
        },
        {
          label: 'Cristais de gelo',
          value: 'oc2'
        },
        {
          label: 'Resfriado',
          value: 'oc3'
        },
        {
          label: 'Decomposição',
          value: 'oc4'
        }
      ]
    }
  },
  methods: {
    enviarAlerta () {
      console.log(this.groupProduto)
    },
    adicionarAmostra () {
      this.amostras.push({ key: 2, num: 2 })
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
