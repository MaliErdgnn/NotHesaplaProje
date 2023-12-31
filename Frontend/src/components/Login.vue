
<template>
  <div class="login-screen">
    <div class="login-container">
      <h1>Not hesapla'ya Hoş Geldiniz!</h1>
      <h1>Lütfen Giriş Yapın!</h1>
      <form @submit.prevent="login">
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
        <button type="submit">Giriş Yap</button>
      </form>
      <router-link to="/register">Kayıt Ol</router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      email: '',
      password: '',
      user: null,
      ourUSer:{
        email: null,
        ad: null,
        soyad: null,
        sifre: null,
        token: ''
      }
    };
  },
  methods: {
    async login() {
      const user = await this.getUser();
      if (user != null) {
        console.log("Giriş başarılı!");
        this.ourUSer.email = user.email;
        this.ourUSer.ad = user.ad;
        this.ourUSer.soyad = user.soyad;
        this.ourUSer.sifre = this.password;
        this.ourUSer.token = user.token;
        this.$store.commit('LOGIN', this.ourUSer);
        this.$router.push("/Anaekran");
      } else {
        console.log("Kullanıcı adı veya şifre yanlış!");
      }
    },
    async getUser() {
      const response = await axios.post(`http://localhost:8081/odev/kullanici/authenticate`,{
        email: this.email,
        sifre: this.password
      });
      const user = response.data;
      //const user = users.find(user => user.email === email && user.password === password);
      console.log(user);
      return user;
    }
  },
  provide() {
    return {
      user: this.user
    };
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