<template>
    <div class="container">
      <div class="title">
        <h1 class="title">Mehmet Ali Erdoğan'a ait</h1>
        <h2 class="title">kullanıcı bilgilerini değiştirin!</h2>
      </div>
      <div class="formm">
        <div class="formm-group">
          <label for="email">E-mail:</label>
          <input type="email" id="email" v-model="email" placeholder="email@provider.com" />
        </div>
        <div class="formm-group">
          <label for="name">Isim:</label>
          <input type="text" id="name" v-model="name" placeholder="Mehmet Ali" />
        </div>
        <div class="formm-group">
          <label for="surname">Soyisim:</label>
          <input type="text" id="surname" v-model="surname" placeholder="Erdoğan" />
        </div>
        <RouterLink to="/Anaekran"><button @click="save">Kaydet</button></RouterLink>
        
      </div>
      <div class="actions">
        <RouterLink to="/sifredegistir"><button class="action_button">Şifre Değiştir</button></RouterLink>
        <RouterLink to="/"><button class="action_button">Hesabı Sil</button></RouterLink>
      </div>
    </div>
  </template>
  
  <script>
  import { RouterLink } from 'vue-router';
  
  export default {
      data() {
          return {
              email: 'email@provider.com',
              name: 'Mehmet Ali',
              surname: 'Erdoğan'
          };
      },
      methods: {
          save() {
              // Save logic goes here
          }
      },
      components: { RouterLink }
  };
  </script>
  
  <style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }
  
  .title {
    text-align: center;
    margin: 0px;
  }
  
  .formm {
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-bottom: 20px;
    margin-top: 20px;
  }
  
  .formm-group {
    margin-bottom: 10px;
    flex-direction: column;
  }
  
  label {
    display: flex;
  }
  
  input {
    width: 170px;
  }
  .actions {
    display:block;
    justify-content:center;
    align-items: center;
    margin-top: 20px;
  }
  
  button {
    margin: 0px;
    width: 110px;
  }
  .action_button {
    width: 150px;
  }
  </style>
  