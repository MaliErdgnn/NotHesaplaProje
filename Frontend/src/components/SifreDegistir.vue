
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
  export default {
    data() {
      return {
        currentPassword: '',
        newPassword: '',
        repeatPassword: ''
      };
    },
    methods: {
      savePassword() {
        if (this.newPassword !== this.repeatPassword) {
          // Show error message or handle the mismatched passwords
          alert('Passwords do not match.');
        } else if(this.newPassword == '' || this.repeatPassword == '' || this.currentPassword == ''){
          alert('Fill in the blanks.')
        }else{
          this.$router.push('/profil');
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
  