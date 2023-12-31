<template>
    <div class="container">
      <div class="title">
        <h1 class="title">{{ user.ad }} {{ user.soyad }}'aaa ait</h1>
        <h2 class="title">kullanıcı bilgilerini değiştirin!</h2>
      </div>
      <div class="formm">
        <div class="formm-group">
          <label for="email">E-mail:</label>
          <input type="email" id="email" v-model="email" :placeholder="user.email" />
        </div>
        <div class="formm-group">
          <label for="name">Isim:</label>
          <input type="text" id="name" v-model="name" :placeholder="user.ad" />
        </div>
        <div class="formm-group">
          <label for="surname">Soyisim:</label>
          <input type="text" id="surname" v-model="surname" :placeholder="user.soyad" />
        </div>
        <button @click="save">Kaydet</button>
        
      </div>
      <div class="actions">
        <button class="action_button" @click="sifreDegistireGit">Şifre Değiştir</button>
        <button @click="hesabiSil" class="action_button">Hesabı Sil</button>
      </div>
    </div>
  </template>
  
  <script>
  import { RouterLink } from 'vue-router';
  import axios from 'axios';
  export default {
    computed: {
    user() {
      return this.$store.state.user;
    },
  },
      data() {
          return {
              email: '',
              name: '',
              surname: '',
              ortID: [],
              dersID: [],
              
              hesapID: [],
              odevID: [],
              labID: [],
              quizID: [],
              projeID: [],
              };
      },
      methods: {
        async hesabiSil() {
          await axios.get(`http://localhost:8081/odev/hasorthesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                .then(async(response) => {
                  for(var i = 0; i < response.data.length; i++){
                    if(response.data[i].email == this.$store.state.user.email){
                      this.ortID.push(response.data[i].ortID);
                      await axios.delete(`http://localhost:8081/odev/hasorthesap/${response.data[i].ortID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }
                  }).then(async ()=>{
                    await axios.get(`http://localhost:8081/odev/hasders`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response) => {
                      for(var i = 0; i < response.data.length; i++){
                        for(var j = 0; j < this.ortID.length; j++){
                          if(response.data[i].ortID == this.ortID[j]){
                            this.dersID.push(response.data[i].dersID);
                            await axios.delete(`http://localhost:8081/odev/hasders/${response.data[i].dersID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                      }
                      }
                    )
                  }).then(async()=>{
                    for(var i=0; i < this.dersID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/ders/${this.dersID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    for(var i=0; i < this.ortID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/orthesap/${this.ortID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  })//BURADA ORT HESAPLAMAYA DAIR BILGILER SILINDI
                  .then(async()=>{
                    await axios.get(`http://localhost:8081/odev/hasharfhesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response) => {
                      for(var i = 0; i < response.data.length; i++){
                        if(response.data[i].email == this.$store.state.user.email){
                          this.hesapID.push(response.data[i].hesapID);
                          await axios.delete(`http://localhost:8081/odev/hasharfhesap/${response.data[i].hesapID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        }
                      }
                      }
                    )
                  }).then(async()=>{
                    await axios.get(`http://localhost:8081/odev/hasodev`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response) => {
                      for(var i = 0; i < response.data.length; i++){
                        for(var j = 0; j < this.hesapID.length; j++){
                          if(response.data[i].hesapID == this.hesapID[j]){
                            this.odevID.push(response.data[i].odevID);
                            await axios.delete(`http://localhost:8081/odev/hasodev/${response.data[i].odevID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                      }
                      }
                    )
                  }).then(async()=>{
                    await axios.get(`http://localhost:8081/odev/haslab`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response)=>{
                      for(var i = 0; i < response.data.length; i++){
                        for(var j = 0; j < this.hesapID.length; j++){
                          if(response.data[i].hesapID == this.hesapID[j]){
                            this.labID.push(response.data[i].labID);
                            await axios.delete(`http://localhost:8081/odev/haslab/${response.data[i].labID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                      }
                    })
                  }).then(async()=>{
                    await axios.get(`http://localhost:8081/odev/hasquiz`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response)=>{
                      for(var i = 0; i < response.data.length; i++){
                        for(var j = 0; j < this.hesapID.length; j++){
                          if(response.data[i].hesapID == this.hesapID[j]){
                            this.quizID.push(response.data[i].quizID);
                            await axios.delete(`http://localhost:8081/odev/hasquiz/${response.data[i].quizID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                      }
                    })
                  }).then(async()=>{
                    await axios.get(`http://localhost:8081/odev/hasproje`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response)=>{
                      for(var i = 0; i < response.data.length; i++){
                        for(var j = 0; j < this.hesapID.length; j++){
                          if(response.data[i].hesapID == this.hesapID[j]){
                            this.projeID.push(response.data[i].projeID);
                            await axios.delete(`http://localhost:8081/odev/hasproje/${response.data[i].projeID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                      }
                    })
                  }).then(async()=>{
                    for(var i=0; i < this.odevID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/odev/${this.odevID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    for(var i=0; i < this.labID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/lab/${this.labID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    for(var i=0; i < this.quizID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/quiz/${this.quizID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    for(var i=0; i < this.projeID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/proje/${this.projeID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    for(var i=0; i < this.hesapID.length; i++){
                      await axios.delete(`http://localhost:8081/odev/harfhesap/${this.hesapID[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    }
                  }).then(async()=>{
                    await axios.delete(`http://localhost:8081/odev/kullanici/sil/${this.$store.state.user.email}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                  }).then(()=>{
                    this.$store.commit('LOGOUT');
                    this.$router.push("/");
                  })
          },
          async save() {
            await axios.get(`http://localhost:8081/odev/hasorthesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                  .then(async(response) => {
                    for(var i = 0; i < response.data.length; i++){
                      if(response.data[i].email == this.$store.state.user.email){
                        this.ortID.push(response.data[i].ortID);
                        await axios.delete(`http://localhost:8081/odev/hasorthesap/${response.data[i].ortID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                      }
                    }
                    }).then(async()=>{
                      await axios.get(`http://localhost:8081/odev/hasharfhesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                      .then(async(response) => {
                        for(var i = 0; i < response.data.length; i++){
                          if(response.data[i].email == this.$store.state.user.email){
                            this.hesapID.push(response.data[i].hesapID);
                            await axios.delete(`http://localhost:8081/odev/hasharfhesap/${response.data[i].hesapID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          }
                        }
                        }
                      )
                    }).then(async () => {
                      for(var i = 0; i < this.ortID.length; i++){
                        await axios.post(`http://localhost:8081/odev/hasorthesap`, {
                          "email": this.email,
                          "ortID": this.ortID[i],
                          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                      }
                    }).then(async () => {
                      for(var i = 0; i < this.hesapID.length; i++){
                        await axios.post(`http://localhost:8081/odev/hasharfhesap`, {
                          "email": this.email,
                          "hesapID": this.hesapID[i],
                          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                      }

                    }).then(async () => {
                      

                      await axios.put(`http://localhost:8081/odev/kullanici`, {
              "email": this.$store.state.user.email,
              "newEmail": this.email,
              "ad": this.name,
              "soyad": this.surname,
              "sifre": this.$store.state.user.sifre,
              },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async (response)=>{
                      this.$store.commit('LOGIN', {
                    email: this.email,
                    ad: this.name,
                    soyad: this.surname,
                    sifre: this.$store.state.user.sifre,
                    token: response.data.token
                  });
                    })
                    })
                    







            
          },
          sifreDegistireGit(){
            this.$router.push("/sifredegistir");}
      },
      components: { RouterLink }
  }
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
  