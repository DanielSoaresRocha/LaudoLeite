<template>
  <q-page>
    <div class="vertical-top logo q-pa-md text-h3">
      Solicitar análise
    </div>
    <div class="q-pr-xl q-pl-xl row">
      <div class="col-6 q-pa-xs">
        <q-input
          standout="bg-primary text-white"
          v-model="laudo.cliente"
          label="Cliente"
        />
      </div>
      <div class="col-6 q-pa-xs">
        <q-input
          standout="bg-primary text-white"
          filled
          v-model="laudo.data_coleta"
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
                  v-model="laudo.data_coleta"
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
          v-model="laudo.responsavel_coleta"
          label="Responsável pela coleta"
        />
      </div>
      <div class="col-6 q-pr-xs q-pl-xs">
        <q-input
          standout="bg-primary text-white"
          filled
          v-model="laudo.hora_coleta"
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
                <q-time v-model="laudo.hora_coleta" />
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
        v-model="laudo.produto"
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
        v-model="laudo.analise_solicitada"
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
            v-model="laudo.sif_idiarn_sim"
            label="N° SIF/IDIARN/SIM"
          />
        </div>
        <div class="col-6 q-pa-xs">
          Tipo da amostra:
          <q-option-group
            v-model="laudo.individual"
            :options="optionsAmostra"
            color="primary"
            inline
          />
        </div>
        <div class="col-6 q-pr-xs q-pl-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="laudo.data_producao"
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
                    v-model="laudo.data_producao"
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
            v-model="laudo.data_validacao"
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
                    mask="DD-MM-YYYY"
                    v-model="laudo.data_validacao"
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
            v-model="laudo.quantidade"
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
            v-model="laudo.temperatura"
            label="Temperatura (°C)"
            type="number"
          />
        </div>
        <div class="col-9 q-pa-xs">
          Estado:
          <q-option-group
            v-model="laudo.estado"
            :options="optionsCondicion"
            color="primary"
            inline
          />
        </div>
        <div class="col-12 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="laudo.ordem_servico"
            label="Ordem de serviço"
          />
        </div>
        <div class="col-4 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            v-model="laudo.responsavel_recebimento"
            label="Responsável pelo recebimento: "
          />
        </div>
        <div class="col-4 q-pa-xs">
          <q-input
            standout="bg-primary text-white"
            filled
            v-model="laudo.data_recebimento"
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
                    v-model="laudo.data_recebimento"
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
            v-model="laudo.hora_recebimento"
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
                  <q-time v-model="laudo.hora_recebimento" />
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
        class="q-ma-sm"
        color="blue"
        label="Adicionar amostra"
        @click="adicionarAmostra"
      />
      <q-btn
        class="q-ma-sm"
        color="red"
        label="Excluir amostra"
        @click="excluirAmostra"
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
          <q-item-section>
            <q-input
              standout="bg-primary text-white"
              v-model="amostra.numAmostra"
              label="Número da amostra: "
              type="number"
            />
          </q-item-section>
          <q-item-section>
            <q-input
              standout="bg-primary text-white"
              v-model="amostra.identificador"
              label="Identificador da amostra: "
              type="number"
            />
          </q-item-section>
        </q-item>
      </q-list>
      <div
        class="q-pa-sm"
        style="width: 100%; text-align: center"
      >
        <q-btn
          class="vertical-middle"
          color="green"
          label="Enviar laudo"
          @click="register"
        />
      </div>
    </div>
  </q-page>
</template>

<script>
import api from '../services/api'

export default {
  data () {
    return {
      laudo: {
        analise: '', // objeto
        analise_solicitada: '',
        cliente: '', // objeto
        data_coleta: '',
        data_producao: '',
        data_validacao: '',
        ensaio: '', // falta incluir na interface
        especie: '', // falta incluir na interface
        hora_coleta: '',
        hora_recebimento: '',
        id: 0,
        individual: false,
        ordem_servico: '', // objeto
        produto: '',
        quantidade: 0,
        responsavel_coleta: '',
        responsavel_recebimento: '',
        resultado: '', // objeto: lista de resultados
        sif_idiarn_sim: '',
        temperatura: '',
        volume: '', // falta incluir na interface
        estado: '',
        data_recebimento: ''
      },
      numAmostra: 1,
      amostras: [],
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
          value: true
        },
        {
          label: 'Não individual',
          value: false
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
    adicionarAmostra () {
      this.amostras.push({ numAmostra: this.numAmostra, identificador: 0, resultado: '' })
      this.numAmostra++
    },
    excluirAmostra () {
      this.amostras.pop()
      if (this.numAmostra > 1) {
        this.numAmostra--
      }
    },
    async register () {
      try {
        await api.post('/laudos/microbiologica', this.laudo)
        alert('Realizado com sucesso!!')
      } catch (e) {
        alert('Erro ao tentar isto')
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
.areaCliente {
  width: 300px;
  align-items: center;
}
</style>
