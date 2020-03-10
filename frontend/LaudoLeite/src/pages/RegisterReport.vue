<template>
  <q-page>
    <div class="vertical-top logo q-pa-md text-h3">
      Cadastrar laudo
    </div>
    <div class="q-pa-xl row">
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
          v-model="date"
          mask="date"
          :rules="['date']"
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
                  v-model="date"
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
          v-model="time"
          mask="time"
          :rules="['time']"
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
                <q-time v-model="time" />
              </q-popup-proxy>
            </q-icon>
          </template>
        </q-input>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      text: '',
      date: '28/04/2000',
      responsibleCollection: '',
      time: '10:56'
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
