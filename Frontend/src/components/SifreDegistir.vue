
<template>
    <div class="container">
      <div class="formmmm">
        <div class="formmm-group">
          <label for="current-password">Mevcut Sifre:</label>
          <input type="password" id="current-password" v-model="currentPassword" />
        </div>
        <div class="formmm-group">
          <label for="new-password">Yeni Sifre:</label>
          <input type="password" id="new-password" v-model="newPassword" />
        </div>
        <div class="formmm-group">
          <label for="repeat-password">Yeni Sifre Tekrar:</label>
          <input type="password" id="repeat-password" v-model="repeatPassword" />
        </div>
        <!--<RouterLink to="/profil"></RouterLink>-->
        <button @click="savePassword">Kaydet</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    computed: {
    user() {
      return this.$store.state.user;
    },
  },
    data() {
      return {
        currentPassword: '',
        newPassword: '',
        repeatPassword: '',
        headers: {
          "headers": {
  'Authorization': `Bearer ${this.$store.state.token}`
}}
      };
    },
    methods: {
      savePassword() {
        if (this.newPassword != this.repeatPassword || this.currentPassword != this.$store.state.user.sifre) {
          // Show error message or handle the mismatched passwords
          alert('Passwords do not match.');
        } else if(this.newPassword == '' || this.repeatPassword == '' || this.currentPassword == ''){
          alert('Fill in the blanks.')
        }else{
          console.log('Bearer ' + this.$store.state.user.token)
          var sonuc = axios.put(`http://localhost:8081/odev/kullanici`, {
            "email": this.$store.state.user.email,
            "newEmail": this.$store.state.user.email,
            "ad": this.$store.state.user.ad,
            "soyad": this.$store.state.user.soyad,
            "sifre": this.newPassword,
            },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
              if(response.data != null){
                alert("Şifreniz başarıyla değiştirildi!");
                this.$store.commit('LOGIN', {
                  email: this.$store.state.user.email,
                  ad: this.$store.state.user.ad,
                  soyad: this.$store.state.user.soyad,
                  sifre: this.newPassword,
                  token: response.data.token
                });
                this.$router.push("/Profil");
            }else{
              alert("Şifreniz değiştirilemedi!");
            }}
            )
        }
      }
    }
  };
  </script>
  
  <style>
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  
  .formmm{
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .formmm-group {
    margin-bottom: 10px;
  }
  
  .error-message {
    color: red;
    margin-top: 10px;
  }
  </style>
  