
<template>
    <div class="login-screen">
      <div class="login-container">
        
        <h1>Not hesapla'ya Hoş Geldiniz!</h1>
        <h1>Lütfen Giriş Yapın!</h1>
        <form>
          <div class="form">
            <div class="input-container">
            <label for="email">E-mail:</label>
            <label for="password">Password:</label>
          </div>
          <div class="input-container">
            <input type="email" id="email" v-model="email" required>
            <input type="password" id="password" v-model="password" required>
          </div>
          </div>
          <router-link to="/Anaekran"><button @click="login">Giriş Yap</button></router-link>
          
        </form>
        <router-link to="/register">Kayıt Ol</router-link>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: '',
        password: ''
      };
    },
    methods: {
      login() {
        // Implement your login logic here
      }
    }
  };
  </script>
  
  <style>
  .login-screen {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0 auto;
  }
  
  .login-container {
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .login-container h1 {
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0px;
    padding: 0px;
  }
  
  .form {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    margin-top: 50px;
  }
  
  .input-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 10px;
  }
  
  .input-container label {
    margin-right: 10px; 
    margin-bottom: 10px;
  }
  
  .input-container input {
    margin-bottom: 10px;
  }
  </style>