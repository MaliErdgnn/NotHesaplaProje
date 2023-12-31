
<template>
    <div class="main-container" >
      
        <h1 v-if="user" class="title">Hoşgeldiniz, {{user.ad}} {{user.soyad}}!</h1>
      
      <div class="button-container">
        <router-link to="/DersHarfNotuHesapla"><button class="button">Ders Harf Notu Hesapla</button></router-link>
        <div class="button-group">
          <button @click="login" class="button">Profil</button>
          <router-link to="/GecmisNotlar"><button class="button">Geçmiş Hesaplamaları Gör</button></router-link>
        </div>
        <router-link to="/NotOrtalamasıHesapla"><button class="button">Genel Ortalama Hesaplama</button></router-link>
      </div>
    </div>
  </template>

  <script>

  export default {
    computed: {
    user() {
      return this.$store.state.user;
    }
  },
    methods: {
      login() {
        this.$router.push("/Profil");
      }
    }
  };
 
  
  </script>

  <style>
  .main-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }
  
  .title {
    font-size: 44px;
    margin-bottom: 20px;
  }
  
  .button-container {
    display: flex;
    flex-wrap: wrap;
    justify-content:center;
    align-items: center;
  }
  
  .button {
    width: 190px;
    height: 170px;
    margin: 10px;
    border: 2px solid black;
    border-radius: 0px;
    margin-left: 45px;
    margin-right: 45px;
  }
  
  .button-group {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  </style>
  
  