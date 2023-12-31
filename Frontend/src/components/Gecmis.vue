<template>
  <div class="gecmis">
    <div class="gecmis-upper">
      <div class="gecmis-header">
        <h1>Geçmiş Ders Harf Notu Hesapları:</h1>
      </div>
      <div class="gecmis-buttons">
        <!-- Ders notları için butonlar buraya eklenecek -->
        <div @click="goToNotHesapla(index.hesapID)" class="gecmis-button" v-for="index in notHesaplar">
          <button :id="index.hesapID">
            {{index.tarih}}<br>
            {{index.dersAd}}<br>
            {{index.harfNot}}
          </button>
        </div>
        <!-- Diğer butonlar da benzer şekilde eklenecek -->
      </div>
    </div>
    <hr />
    <div class="gecmis-lower">
      <div class="gecmis-footer">
        <h1>Geçmiş Ortalama Hesapları:</h1>
      </div>
      <div class="gecmis-buttons">
        <!-- Ortalama hesapları için butonlar buraya eklenecek -->
        <div  class="gecmis-button" v-for="index in ortHesaplar">
          <button @click="goToOrtHesapla(index.ortID)"  :id="index.ortID">
            {{index.date}}<br>
            GPA: {{index.yeniGno}}
          </button>
        </div>
        <!-- Diğer butonlar da benzer şekilde eklenecek -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      ortHesaplar: [],
      notHesaplar: [],
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    goToNotHesapla(hesapID) {
      // 'hesapID' parametresini kullanarak '/orthesapla' sayfasına yönlendirme yapın
      this.$router.push({ path: `/DersHarfNotuHesapla`, query: { id: hesapID } });
    },
    goToOrtHesapla(ortID) {
      // 'hesapID' parametresini kullanarak '/orthesapla' sayfasına yönlendirme yapın
      this.$router.push({ path: `/NotOrtalamasıHesapla`, query: { id: ortID } });
    },
    printle(){
      //console.log(this.ortHesaplar[0].dersAdi);
      console.log(this.notHesaplar[0].dersAd);
    },
    async fetchData() {
      await axios.get(`http://localhost:8081/odev/hasorthesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
      .then(async(response) => {
        for(var i = 0; i < response.data.length; i++){
          if(response.data[i].email == this.$store.state.user.email){
            await axios.get(`http://localhost:8081/odev/orthesap/${response.data[i].ortID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
              this.ortHesaplar.push(response.data);
            })
          }
        }
        }
      ).then(async()=>{
        await axios.get(`http://localhost:8081/odev/hasharfhesap`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response) => {
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].email == this.$store.state.user.email){
              await axios.get(`http://localhost:8081/odev/harfhesap/${response.data[i].hesapID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                this.notHesaplar.push(response.data);
              })
            }
          }
          }
        )
      })
    }
  }
};
</script>

<style scoped>
hr {
  border:none;
  align-items: center;
  justify-content: center;
  height: 2px;
  width: 98%;
  background-color: black; /* Çizgi rengi */
  margin: 10px ; /* Üst ve alt boşluk */
}
.gecmis {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-color: #ffffff;
  font-family: 'Arial', sans-serif;
  font-size: 0.8rem;
}

.gecmis-upper, .gecmis-lower {
  display: flex;
  flex-direction: column;
  flex: 1;
}

.gecmis-header,
.gecmis-footer {
  background-color: #ffffff;
  padding: 10px;
  text-align: left;
}

.gecmis-buttons {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.gecmis-button {
  background-color: #ffffff;
  border: 1px solid #000;
  width: 30px;
  height: 30px;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

</style>