
<template>
    <div class="login-screen">
      <div class="login-container">
        
        <h1>Giriş Yapmak Için Lütfen Kaydolun!</h1>
        <form>
            <div class="input-container">
            <label for="email">E-mail:</label>
            <input type="email" id="email" v-model="email" required>
            
          </div>
          <div class="input-container">
            <label for="name">Ad:</label>
            <input type="name" id="name" v-model="name" required>
          </div>
          <div class="input-container">
            <label for="surname">Soyad:</label>
            <input type="surname" id="surname" v-model="surname" required>
          </div>
          <div class="input-container">
            <label for="password">Şifre:</label>
            <input type="password" id="password" v-model="password" required>
          </div>
          <div class="input-container">
            <label for="passwordAgain">Şifre Tekrar:</label>
            <input type="passwordAgain" id="passwordAgain" v-model="passwordAgain" required>
          </div>
          <button @click="login">Giriş Yap</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: '',
        name: '',
        surname: '',
        password: '',
        passwordAgain: ''
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
    justify-content: flex-start;
  }
  
  .input-container input {
    margin-bottom: 10px;
  }
  </style>