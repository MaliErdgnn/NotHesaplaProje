<template>
  <div class="container">
    <h1 class="title">Harf Notu Hesaplama</h1>
    <div class="form-container">
      <div class="colum">
        <div class="input-group">
        <label for="numCourses">Quiz Sayısı: </label>
        <input type="number" id="quizSayisi" v-model="quizSayisi" />
      </div>
      <div class="input-group">
        <label for="gpa">Odev Sayısı: </label>
        <input type="number" id="odevSayisi" v-model="odevSayisi" />
      </div>
      <div class="input-group">
        <label for="totalCredits">Proje Sayısı: </label>
        <input type="number" id="projeSayisi" v-model="projeSayisi" />
      </div>
      <div class="input-group">
        <label for="totalCredits">Lab sayısı:</label>
        <input type="number" id="labSayisi" v-model="labSayisi" />
      </div>
      <div class="input-group">
        <label for="numCourses">Quizlerin yüzde ağırlığını girin: </label>
        <input type="number" id="quizYuzde" v-model="quizYuzde" />
      </div>
      <div class="input-group">
        <label for="gpa">Odevlerin yüzde ağırlığını girin: </label>
        <input type="number" id="odevYuzde" v-model="odevYuzde" />
      </div>
      <div class="input-group">
        <label >Vizenin yüzde ağırlığını girin: </label>
        <input type="number" id="vizeYuzde" v-model="vizeYuzde" />
      </div>
      
      </div>
      
      <div>
        <div class="input-group">
        <label >Finalin yüzde ağırlığını girin: </label>
        <input type="number" id="finalYuzde" v-model="finalYuzde" />
      </div>
      <div class="input-group">
        <label for="totalCredits">Projelerin yüzde ağırlığını girin: </label>
        <input type="number" id="projeYuzde" v-model="projeYuzde" />
      </div>
        <div class="column">
          <div class="input-group">
        <label for="totalCredits">Labların yüzde ağırlığını girin: </label>
        <input type="number" id="labYuzde" v-model="labYuzde" />
      </div>
        </div>
        <div class="checkboxes">
        
        <label>Harf Sistemini Seçin:</label>
        <label>
          <input type="radio" v-model="selectedOption" value="ilkinci" />
          AA, BA, BB
        </label>
        <label>
          <input type="radio" v-model="selectedOption" value="ikinci" />
          AA, AB, BA
        </label>
        <label>
          <input type="radio" v-model="selectedOption" value="ucuncu" />
          A, A-, B+
        </label>
      </div>
      <Switch v-model:checked="isKatalog"  label="Katalog"/>
      </div>
    </div>
    <hr class="hr"/>
    
    <div class="detay">
      <div>
      <div class="course-details" v-for="index in quizSayisi" :key="index">
      
      <div class="course-detailss"> 
       <label >Quiz {{ index }} : </label>
       <input type="number"  v-model=quizDeger[index] />
     </div>
    </div>
     
   </div>

   <div>
   <div class="course-details" v-for="index in odevSayisi" :key="index">
      
      <div class="course-detailss"> 
       <label >Odev {{ index }} : </label>
       <input type="number"  v-model=odevDeger[index] />
     </div>
     
   </div>
  </div>

    <div>
   <div class="course-details" v-for="index in projeSayisi" :key="index">
      
      <div class="course-detailss"> 
       <label >Proje {{ index }} : </label>
       <input type="number"  v-model=projeDeger[index] />
     </div>
     
   </div>
   </div>

    <div>
   <div class="course-details" v-for="index in labSayisi" :key="index">
      
      <div class="course-detailss"> 
       <label >Lab {{ index }} : </label>
       <input type="number"  v-model=labDeger[index] />
     </div>
     
   </div>
  </div>
    </div>
  <div class="column">
    <div class="input-groupp">
      <div class="input-group">
        <label >Vize: </label>
        <input type="number" id="vizeNot" v-model="vizeNot" />
      </div>
      <div class="input-group">
        <label >Final: </label>
        <input type="number" id="finalNot" v-model="finalNot" />
      </div>
    </div>
    <div class="input-groupp">
      <div class="input-group">
        <label >Sınıf Ortalamasını girin: </label>
        <input type="number" id="sinifOrt" v-model="sinifOrt" />
      </div>
      <div class="input-group">
        <label >Ders adını girin: </label>
        <input type="text" id="sinifOrt" v-model="dersAdi" />
      </div>
    </div>
  </div>
    <button  @click="listeleVerileri()">Kaydet</button>
    <hr class="hr2" />
      <div class="input-group">
        <label for="numCourses">Ders Harf Notu: </label>
        <input type="passive" id="dersHarfNo" readonly v-model="dersHarfNo" />
      </div>
      <div class="input-group">
        <label for="numCourses">Ders Puanı: </label>
        <input type="passive" id="dersPuan" readonly v-model="dersPuan" />
      </div>
      <button v-if="id"  @click="sil()">Sil</button>
  </div>
</template>

<script>
import Switch from './Switch.vue';
import axios from 'axios';
export default {
  mounted() {
    // URL'den gelen 'id' parametresini alıp data modeline atayın
    if (this.$route.query.id) {
      this.id = this.$route.query.id;
      // İlgili verileri çekmek için bir API çağrısı yapabilirsiniz
      this.fetchData();
    }
  },
  components: {
          Switch
        },
  data() {
    return {
      id: null,
      odevId: [],
      projeId: [],
      quizId: [],
      labId: [],
      dersAdi: '',
      quizSayisi: 0,
      odevSayisi: 0,
      labSayisi: 0,
      projeSayisi: 0,
      quizYuzde: 0,
      odevYuzde: 0,
      labYuzde: 0,
      projeYuzde: 0,
      vizeYuzde: 0,
      finalYuzde: 0,
      vizeNot: 0,
      finalNot: 0,
      selectedOption: '',
      quizList: [],
      projeList: [],
      labList: [],
      odevList: [],
      quizDeger: {},
      labDeger: {},
      projeDeger: {},
      odevDeger: {},
      sinifOrt: 0,
      isKatalog: false,
      dersHarfNo: "",
      dersPuan: 0,
    };
  },
  methods: {
    async sil(){
      
        await axios.get(`http://localhost:8081/odev/hasquiz`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response)=>{
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].hesapID == this.id){
              let idd = response.data[i].quizID
              await axios.delete(`http://localhost:8081/odev/hasquiz/${response.data[i].quizID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async (response)=>{
                await axios.delete(`http://localhost:8081/odev/quiz/${idd}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                
              })
              })
            }
          }
        
      }).then(async (response)=>{
        await axios.get(`http://localhost:8081/odev/haslab`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response)=>{
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].hesapID == this.id){
              let idd = response.data[i].labID
              await axios.delete(`http://localhost:8081/odev/haslab/${response.data[i].labID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async (response)=>{
                await axios.delete(`http://localhost:8081/odev/lab/${idd}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                
              })
              })
            }
          }
        })
      }).then(async (response)=>{
        await axios.get(`http://localhost:8081/odev/hasodev`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response)=>{
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].hesapID == this.id){
              let idd = response.data[i].odevID
              await axios.delete(`http://localhost:8081/odev/hasodev/${response.data[i].odevID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async (response)=>{
                await axios.delete(`http://localhost:8081/odev/odev/${idd}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                
              })
              })
            }
          }
        })
      }).then(async (response)=>{
        await axios.get(`http://localhost:8081/odev/hasproje`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response)=>{
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].hesapID == this.id){
              let idd = response.data[i].projeID
              await axios.delete(`http://localhost:8081/odev/hasproje/${response.data[i].projeID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async (response)=>{
                await axios.delete(`http://localhost:8081/odev/proje/${idd}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                
              })
              })
            }
          }
        })
      }).then(async (response)=>{
        await axios.delete(`http://localhost:8081/odev/hasharfhesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async (response)=>{
          await axios.delete(`http://localhost:8081/odev/harfhesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
          .then((response)=>{
            this.$router.push('/Anaekran')
          })
        })
      })
    },
    async fetchData(){
      await axios.get(`http://localhost:8081/odev/harfhesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
      .then(async(response)=>{
        this.dersAdi = response.data.dersAd;
        this.vizeYuzde = response.data.vizeYuzde;
        this.vizeNot = response.data.vizeNot;
        this.finalYuzde = response.data.finalYuzde;
        this.finalNot = response.data.finalNot;
        this.sinifOrt = response.data.sinifOrt;
        this.odevSayisi = response.data.odevSy;
        this.odevYuzde = response.data.odevYuzde;
        this.quizSayisi = response.data.quizSy;
        this.quizYuzde = response.data.quizYuzde;
        this.labSayisi = response.data.labSy;
        this.labYuzde = response.data.labYuzde;
        this.projeSayisi = response.data.projeSy;
        this.projeYuzde = response.data.projeYuzde;
        this.selectedOption = response.data.harfSIS;
        this.isKatalog = response.data.notSis == "Katalog" ? true : false;
        this.dersHarfNo = null;
        this.dersHarfNo = response.data.harfNot;
        this.dersPuan = response.data.puan;
        await axios.get(`http://localhost:8081/odev/hasquiz`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async(response)=>{
          let count = 1;
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].hesapID == this.id){
              this.quizId.push(response.data[i].quizID);
              await axios.get(`http://localhost:8081/odev/quiz/${response.data[i].quizID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                this.quizDeger[count] = response.data.quizNot;
                count++;
              })
            }
          }
        }).then(async()=>{
          await axios.get(`http://localhost:8081/odev/hasodev`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
          .then(async(response)=>{
            let count = 1;
            for(var i = 0; i < response.data.length; i++){
              if(response.data[i].hesapID == this.id){
                this.odevId.push(response.data[i].odevID);
                await axios.get(`http://localhost:8081/odev/odev/${response.data[i].odevID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                .then((response)=>{
                  console.log(response.data.odevNot);
                  this.odevDeger[count] = response.data.odevNot;
                  count++;
                })
              }
            }
          }).then(async()=>{
            await axios.get(`http://localhost:8081/odev/hasproje`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
            .then(async(response)=>{
              let count = 1;
              for(var i = 0; i < response.data.length; i++){
                if(response.data[i].hesapID == this.id){
                  this.projeId.push(response.data[i].projeID);
                  await axios.get(`http://localhost:8081/odev/proje/${response.data[i].projeID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                  .then((response)=>{
                    this.projeDeger[count] = response.data.projeNot;
                    count++;
                  })
                }
              }
            }).then(async()=>{
              await axios.get(`http://localhost:8081/odev/haslab`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response)=>{
                let count = 1;
                for(var i = 0; i < response.data.length; i++){
                  if(response.data[i].hesapID == this.id){
                    this.labId.push(response.data[i].labID);
                    await axios.get(`http://localhost:8081/odev/lab/${response.data[i].labID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then((response)=>{
                      this.labDeger[count] = response.data.labNot;
                      count++;
                    })
                  }
                }
              })
            })
          })
        })
      })
    },
    async listeleVerileri( ) {
      console.log(this.isKatalog);
      this.quizList = [];
      this.odevList = [];
      this.projeList = [];
      this.labList = [];
      for(var i = 1; i < this.quizSayisi+1; i++){
        this.quizList.push({
        "quizNot": this.quizDeger[i],
      });
      };
      for(var i = 1; i < this.odevSayisi+1; i++){
        this.odevList.push({
        "odevNot": this.odevDeger[i],
      });
      };
      for(var i = 1; i < this.projeSayisi+1; i++){
        this.projeList.push({
        "projeNot": this.projeDeger[i],
      });
      };
      for(var i = 1; i < this.labSayisi+1; i++){
        this.labList.push({
        "labNot": this.labDeger[i],
      });
      };

      await this.hesaplaBakam();

    
    },
    async hesaplaBakam(){
      if(this.id == null){
       await axios.post(`http://localhost:8081/odev/harfhesap`, {
          "dersAd": this.dersAdi,
          "vizeYuzde": this.vizeYuzde,
          "vizeNot": this.vizeNot,
          "finalYuzde": this.finalYuzde,
          "finalNot": this.finalNot,
          "notSis": this.isKatalog ? 'Katalog' : 'Çan',
          "harfSIS": this.selectedOption,
          "sinifOrt": this.sinifOrt,
          "odevSy": this.odevSayisi,
          "odevYuzde": this.odevYuzde,
          "quizSy": this.quizSayisi,
          "quizYuzde": this.quizYuzde,
          "labSy": this.labSayisi,
          "labYuzde": this.labYuzde,
          "projeSy": this.projeSayisi,
          "projeYuzde": this.projeYuzde,
          "quizList": this.quizList,
          "odevList": this.odevList,
          "projeList": this.projeList,
          "labList": this.labList,
          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
            if(response != null){
              this.dersHarfNo = null;
              this.dersHarfNo = response.data.harfNot;
              this.dersPuan = response.data.puan;
              this.id = response.data.hesapID;
              console.log("Notlarınız başarıyla hesaplandı!");
            }else{
              console.log("Notlarınız hesaplanamadı!");
            }}).then(async()=>{
              await axios.post(`http://localhost:8081/odev/hasharfhesap`,{
                "hesapID": this.id,
                "email": this.$store.state.user.email,
              },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                if(response != null){
                  console.log("hasharfhesap başarıyla kaydedildi!");
                }else{
                  console.log("hasharfhesap kaydedilemedi!");
                }
              })})
              .then(async()=>{////////////////////////////////////////
                for(var i = 0; i < this.quizSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/quiz`, {
                  "quizNot": this.quizList[i].quizNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.quizId.push(response.data.quizID);
                      console.log("quiz başarıyla kaydedildi!");
                    }else{
                      console.log("quiz kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.odevSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/odev`, {
                  "odevNot": this.odevList[i].odevNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.odevId.push(response.data.odevID);
                      console.log("odev başarıyla kaydedildi!");
                    }else{
                      console.log("odev kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.projeSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/proje`, {
                  "projeNot": this.projeList[i].projeNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.projeId.push(response.data.projeID);
                      console.log("proje başarıyla kaydedildi!");
                    }else{
                      console.log("proje kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.labSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/lab`, {
                  "labNot": this.labList[i].labNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.labId.push(response.data.labID);
                      console.log("lab başarıyla kaydedildi!");
                    }else{
                      console.log("lab kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.quizSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasquiz`, {
                  "hesapID": this.id,
                  "quizID": this.quizId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasquiz başarıyla kaydedildi!");
                    }else{
                      console.log("hasquiz kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.odevSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasodev`, {
                  "hesapID": this.id,
                  "odevID": this.odevId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasodev başarıyla kaydedildi!");
                    }else{
                      console.log("hasodev kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.projeSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasproje`, {
                  "hesapID": this.id,
                  "projeID": this.projeId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasproje başarıyla kaydedildi!");
                    }else{
                      console.log("hasproje kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.labSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/haslab`, {
                  "hesapID": this.id,
                  "labID": this.labId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("haslab başarıyla kaydedildi!");
                    }else{
                      console.log("haslab kaydedilemedi!");
                    }
               })
                }
              })
            
      }else{
        await axios.put(`http://localhost:8081/odev/harfhesap`, {
          "hesapID": this.id,
          "dersAd": this.dersAdi,
          "vizeYuzde": this.vizeYuzde,
          "vizeNot": this.vizeNot,
          "finalYuzde": this.finalYuzde,
          "finalNot": this.finalNot,
          "notSis": this.isKatalog ? 'Katalog' : 'Çan',
          "harfSIS": this.selectedOption,
          "sinifOrt": this.sinifOrt,
          "odevSy": this.odevSayisi,
          "odevYuzde": this.odevYuzde,
          "quizSy": this.quizSayisi,
          "quizYuzde": this.quizYuzde,
          "labSy": this.labSayisi,
          "labYuzde": this.labYuzde,
          "projeSy": this.projeSayisi,
          "projeYuzde": this.projeYuzde,
          "quizList": this.quizList,
          "odevList": this.odevList,
          "projeList": this.projeList,
          "labList": this.labList,
          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
            if(response != null){
              this.dersHarfNo = response.data.harfNot;
              this.dersPuan = response.data.puan;
              console.log("Notlarınız başarıyla hesaplandı!");
            }else{
              console.log("Notlarınız hesaplanamadı!");
            }}).then(async()=>{
              await axios.get(`http://localhost:8081/odev/hasproje`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then(async(response) => {
                for(var i = 0; i < response.data.length; i++){
                  if(response.data[i].hesapID == this.id){
                    await axios.delete(`http://localhost:8081/odev/hasproje/${response.data[i].projeID}`),{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}
                    .then((response)=>{
                      if(response.data == 1){
                        console.log("hasproje başarıyla silindi!");
                      }else{
                        console.log(response.data);
                        console.log("hasproje silinemedi!");
                      }
                    })
                  }
                }
              })
              }).then(async()=>{
                await axios.get(`http://localhost:8081/odev/haslab`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                .then(async(response) => {
                  for(var i = 0; i < response.data.length; i++){
                    if(response.data[i].hesapID == this.id){
                      await axios.delete(`http://localhost:8081/odev/haslab/${response.data[i].labID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                      .then((response)=>{
                        if(response.data == 1){
                          console.log("haslab başarıyla silindi!");
                        }else{
                          console.log(response.data);
                          console.log("haslab silinemedi!");
                        }
                      })
                    }
                  }
                }).then(async() => {
                  await axios.get(`http://localhost:8081/odev/hasodev`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                  .then(async(response) => {
                    for(var i = 0; i < response.data.length; i++){
                      if(response.data[i].hesapID == this.id){
                        await axios.delete(`http://localhost:8081/odev/hasodev/${response.data[i].odevID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        .then((response)=>{
                          if(response.data == 1){
                            console.log("hasodev başarıyla silindi!");
                          }else{
                            console.log(response.data);
                            console.log("hasodev silinemedi!");
                          }
                        })
                      }
                    }
                  }).then(async () => {
                    await axios.get(`http://localhost:8081/odev/hasquiz`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                    .then(async(response) => {
                      for(var i = 0; i < response.data.length; i++){
                        if(response.data[i].hesapID == this.id){
                          await axios.delete(`http://localhost:8081/odev/hasquiz/${response.data[i].quizID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                          .then((response)=>{
                            if(response.data == 1){
                              console.log("hasquiz başarıyla silindi!");
                            }else{
                              console.log(response.data);
                              console.log("hasquiz silinemedi!");
                            }
                          })
                        }
                      }
                    }).then(async ()=> {
                      for(var i = 0; i < this.projeId.length; i++){
                        await axios.delete(`http://localhost:8081/odev/proje/${this.projeId[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        .then((response)=>{
                          if(response.data == 1){
                            console.log("Proje başarıyla silindi!");
                          }else{
                            console.log(response.data);
                            console.log("Proje silinemedi!");
                          }
                        }
                        )
                      }
                      this.projeId = []
                    }).then(async ()=>{
                      for(var i = 0; i < this.labId.length; i++){
                        await axios.delete(`http://localhost:8081/odev/lab/${this.labId[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        .then((response)=>{
                          if(response.data == 1){
                            console.log("Lab başarıyla silindi!");
                          }else{
                            console.log(response.data);
                            console.log("Lab silinemedi!");
                          }
                        }
                        )
                      }
                      this.labId = []
                    }).then(async ()=>{
                      for(var i = 0; i < this.odevId.length; i++){
                        await axios.delete(`http://localhost:8081/odev/odev/${this.odevId[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        .then((response)=>{
                          if(response.data == 1){
                            console.log("Odev başarıyla silindi!");
                          }else{
                            console.log(response.data);
                            console.log("Odev silinemedi!");
                          }
                        }
                        )
                      }
                      this.odevId = []
                    }).then(async ()=>{
                      for(var i = 0; i < this.quizId.length; i++){
                        await axios.delete(`http://localhost:8081/odev/quiz/${this.quizId[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
                        .then((response)=>{
                          if(response.data == 1){
                            console.log("quiz başarıyla silindi!");
                          }else{
                            console.log(response.data);
                            console.log("quiz silinemedi!");
                          }
                        }
                        )
                      }
                      this.quizId = []
                    })
                    .then(async()=>{////////////////////////////////////////
                for(var i = 0; i < this.quizSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/quiz`, {
                  "quizNot": this.quizList[i].quizNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.quizId.push(response.data.quizID);
                      console.log("quiz başarıyla kaydedildi!");
                    }else{
                      console.log("quiz kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.odevSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/odev`, {
                  "odevNot": this.odevList[i].odevNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.odevId.push(response.data.odevID);
                      console.log("odev başarıyla kaydedildi!");
                    }else{
                      console.log("odev kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.projeSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/proje`, {
                  "projeNot": this.projeList[i].projeNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.projeId.push(response.data.projeID);
                      console.log("proje başarıyla kaydedildi!");
                    }else{
                      console.log("proje kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.labSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/lab`, {
                  "labNot": this.labList[i].labNot,
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      this.labId.push(response.data.labID);
                      console.log("lab başarıyla kaydedildi!");
                    }else{
                      console.log("lab kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.quizSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasquiz`, {
                  "hesapID": this.id,
                  "quizID": this.quizId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasquiz başarıyla kaydedildi!");
                    }else{
                      console.log("hasquiz kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.odevSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasodev`, {
                  "hesapID": this.id,
                  "odevID": this.odevId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasodev başarıyla kaydedildi!");
                    }else{
                      console.log("hasodev kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.projeSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/hasproje`, {
                  "hesapID": this.id,
                  "projeID": this.projeId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("hasproje başarıyla kaydedildi!");
                    }else{
                      console.log("hasproje kaydedilemedi!");
                    }
               })
                }
              }).then(async()=>{
                for(var i = 0; i < this.labSayisi; i++){
                  await axios.post(`http://localhost:8081/odev/haslab`, {
                  "hesapID": this.id,
                  "labID": this.labId[i],
                  },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
                    if(response != null){
                      console.log("haslab başarıyla kaydedildi!");
                    }else{
                      console.log("haslab kaydedilemedi!");
                    }
               })
                }
              })
              })
            }
              )}
    )}},
}};
</script>

<style scoped>
.column {
  display: flex;
  flex-direction: column;
  
}
.input-group input {
width: 40px;}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  text-align: center;
}

h1 {
  text-align:left;
  width: 100%;
  margin-left: 40px;
}

.form-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin-top: 20px;
}

.input-group {
  margin-top: 15px;
  flex-direction: row;
  justify-content: flex-end;
  display: flex;
  margin-right: 20px;
}
.input-groupp {
  margin-top: 5px;
  margin-bottom: 10px;
  flex-direction: row;
  justify-content: center;
  display: flex;
  margin-right: 0px;
}

.checkboxes {
  display: flex;
  flex-direction: column;
  margin-left: 20px;
}
.hr {
  border:none;
  height: 2px;
  width: 85%;
  background-color: black; /* Çizgi rengi */
  margin: 20px ; /* Üst ve alt boşluk */
}
.hr2 {
  border:none;
  height: 2px;
  width: 35%;
  background-color: black; /* Çizgi rengi */
  margin: 10px ; /* Üst ve alt boşluk */
}
hr3 {
  border:none;
  height: 2px;
  width: 100%;
  background-color: black; /* Çizgi rengi */
  margin: 10px ; /* Üst ve alt boşluk */
}
.checkboxes label {
  margin-top: 20px;
  justify-content: flex-start;
  align-items: center;
}
.checkboxes input {
  width: 20px;
}

.course-details {
  display: block;
  flex-direction: column;
  align-items: center;
  margin-left: 8px;
  margin-right: 8px;
  
}
.detay {
  display: flex;
  flex-direction: row;
align-items: center;
justify-content: center;
  
}
.course-detailss {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 3px;
}
.course-detailss input {
 width: 40px;
 margin-left: 3px;
 margin-right: 3px;
}

.course-details-label{
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  flex-direction: row;
}
.course-details-label label{
  
  margin-left: 30px;
  margin-right: 30px;
}

.course-details input {
 width: 40px;
 margin-left: 3px;
 margin-right: 3px;
}

button {
  margin-left: 10px;
}





</style>
