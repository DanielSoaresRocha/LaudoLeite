<template>
  <q-page>
    <div class="tela q-pa-sm absolute-center">
      <div class="cadastro absolute-center">
        <div class="q-pa-xl">
          <q-input
            class="q-pb-md"
            standout="bg-primary text-white"
            v-model="name"
            label="Nome"
          />
          <q-input
            class="q-pb-md"
            standout="bg-primary text-white"
            v-model="password"
            label="senha"
            type="password"
          />
          <q-input
            class="q-pb-md"
            standout="bg-primary text-white"
            v-model="passwordRepeat"
            label="repita sua senha"
            type="password"
          />
          <div class="btnCadastrar">
            <q-btn
              color="green"
              label="Cadastrar"
            />
          </div>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      name: '',
      password: '',
      passwordRepeat: ''
    }
  }
}
</script>

<style>
.cadastro {
  width: 50%;
  height: 50%;
  background-color: aqua;
  border-radius: 25%;
}
.btnCadastrar {
  width: 100%;
  align-items: center;
  text-align: center;
}
.tela {
  width: 100%;
  height: 100%;
  background-color: aqua;
}
</style>
