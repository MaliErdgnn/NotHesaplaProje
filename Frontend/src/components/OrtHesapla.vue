<template>
  <div class="container">
    <h1 class="title">Not Ortalaması Hesaplama</h1>
    <div class="form-container">
      <div class="colum">
        <div class="input-group">
        <label for="numCourses">Ders Sayısı: </label>
        <input type="number" id="numCourses" v-model="numCourses" />
      </div>
      <div class="input-group">
        <label for="gpa">Genel Not Ortalaması: </label>
        <input type="number" id="gpa" v-model="gpa" />
      </div>
      <div class="input-group">
        <label for="totalCredits">Suana Kadarki Toplam Kredi: </label>
        <input type="number" id="totalCredits" v-model="totalCredits" />
      </div>
      </div>
      
      <div class="checkboxes">
        <label>Harf Sistemini Seçin:</label>
        <label>
          <input type="radio" v-model="selectedOption" value="option1" />
          AA, BA, BB
        </label>
        <label>
          <input type="radio" v-model="selectedOption" value="option2" />
          AA, AB, BA
        </label>
        <label>
          <input type="radio" v-model="selectedOption" value="option3" />
          A, A-, B+
        </label>
      </div>
    </div>
    <hr />
    <div class="course-details-label" v-if="numCourses >= 1">
      <label>Ders Adı</label>
      <label>Kredi</label>
      <label>Harf Notu</label>
    </div>
    <div class="course-details" v-for="index in numCourses" :key="index">
      <div>
        <input type="text" v-model="courseAd[index]" />
      <input type="number" v-model="courseKredi[index]" />
      <input type="char" v-model="courseNot[index]" />
      </div>
      <hr3 v-if="numCourses != index"/>
    </div>
    <button v-if="numCourses >= 1" @click="listeleVerileri()">Kaydet</button>
    <hr2 v-if="numCourses >= 1"/>
      <div class="input-group">
        <label for="numCourses">Dönem Not Ortalamsı: </label>
        <input type="number" id="ydno" v-model="yeniDNO" />
      </div>
      <div class="input-group">
        <label for="numCourses">Genel Not Ortalaması: </label>
        <input type="text" id="ygno" readonly v-model="yeniGNO" />
      </div>
      <button v-if="id" @click="sil">Sil</button>
  </div>
</template>

<script>
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
  data() {
    return {
      id: null,
      odevId: [],
      numCourses: 0,
      gpa: 0,
      totalCredits: 0,
      selectedOption: '',
      course: [],
      courseAd: {},
      courseKredi: {},
      courseNot: {},
      yeniDNO: 0,
      yeniGNO: 0,
    };
  },
  methods: {
    async sil(){
      await axios.get(`http://localhost:8081/odev/hasders`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
      .then(async (response)=>{
         for(var i = 0; i < response.data.length; i++){
           if(response.data[i].ortID == this.id){
            let iddd = response.data[i].dersID;
             await axios.delete(`http://localhost:8081/odev/hasders/${response.data[i].dersID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
             .then(async (response)=>{
              await axios.delete(`http://localhost:8081/odev/ders/${iddd}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})

               })
             }
           }
         }).then(async ()=>{
          await axios.delete(`http://localhost:8081/odev/hasorthesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
          .then(async(response)=>{
            await axios.delete(`http://localhost:8081/odev/orthesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
            .then(()=>{
              this.$router.push("/Anaekran")
            })
          })
         })
       },
    async fetchData(){
      await axios.get(`http://localhost:8081/odev/orthesap/${this.id}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
      .then(async(response)=>{
        this.numCourses = response.data.dersSy
        this.gpa = response.data.gno;
        this.totalCredits = response.data.eskiKredi;
        this.selectedOption = response.data.harfSis;
        this.yeniDNO = response.data.donemOrt;
        this.yeniGNO = response.data.yeniGno;
        await axios.get(`http://localhost:8081/odev/hasders`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        .then(async (response)=>{
          let count = 1;
           for(var i = 0; i < response.data.length; i++){
             if(response.data[i].ortID == this.id){
              this.odevId.push(response.data[i].dersID);
               await axios.get(`http://localhost:8081/odev/ders/${response.data[i].dersID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
               .then((response)=>{
                 this.courseAd[count] = response.data.dersAdi;
                 this.courseKredi[count] = response.data.kredi;
                 this.courseNot[count] = response.data.harfNotu;
                 count++;
               })
             }
           }
      })
    })},
    async listeleVerileri( ) {
      this.course = [];
      for(var i = 1; i < this.numCourses+1; i++){
        this.course.push({
        "dersAdi": this.courseAd[i],
        "kredi": this.courseKredi[i],
        "not": this.courseNot[i],
      });
      };
      await this.hesaplaBakam();
    
    },
    async hesaplaBakam(){
      if( this.id == null){
        var laa = await axios.post(`http://localhost:8081/odev/orthesap`, {
          "dersSayisi": this.numCourses,
          "gno": this.gpa,
          "eskiKredi": this.totalCredits,
          "harfSis": this.selectedOption,
          "dersList": this.course,
          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
            if(response != null){
              this.yeniDNO = response.data.donemOrt;
              this.yeniGNO = response.data.yeniGno;
              this.id = response.data.ortID;
              console.log("Notlarınız başarıyla hesaplandı!");
            }else{
              console.log("Notlarınız hesaplanamadı!");
            }

      }).then(async()=>{
       axios.post(`http://localhost:8081/odev/hasorthesap`, {
        "email": this.$store.state.user.email,
        "ortID": this.id,
          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {    
       })
    }).then(async()=>{
      for(var i = 0; i < this.numCourses; i++){
        var laaa = await axios.post(`http://localhost:8081/odev/ders`, {
        "dersAdi": this.course[i].dersAdi,
        "kredi": this.course[i].kredi,
        "not": this.course[i].not,
        },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
          if(response != null){
            this.odevId.push(response.data.dersID);
            console.log("ders başarıyla kaydedildi!");
            console.log('odev sayisi =' + this.odevId.length + 'odev id = ' + this.odevId[i]);
          }else{
            console.log("ders kaydedilemedi!");
          }
     })
      }
    }).then(async()=>{
      for(var i = 0; i < this.odevId.length; i++){
        var laaa = await axios.post(`http://localhost:8081/odev/hasders`, {
        "ortID": this.id,
        "dersID": this.odevId[i],
        },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
          if(response != null){
            console.log("hasders başarıyla kaydedildi!");
          }else{
            console.log("hasders kaydedilemedi!");
          }
     })
      }
    })
    }else{
        var la = await axios.put(`http://localhost:8081/odev/orthesap`, {
          "id": this.id,
          "dersSayisi": this.numCourses,
          "gno": this.gpa,
          "eskiKredi": this.totalCredits,
          "harfSis": this.selectedOption,
          "dersList": this.course,
          },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
            if(response != null){
              this.yeniDNO = response.data.donemOrt;
              this.yeniGNO = response.data.yeniGno;
              console.log("Notlarınız başarıyla hesaplandı!");
            }else{
              console.log("Notlarınız hesaplanamadı!");
            }
      }).then(async()=>{
       await axios.get(`http://localhost:8081/odev/hasders`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
       .then(async (response)=>{
          for(var i = 0; i < response.data.length; i++){
            if(response.data[i].ortID == this.id){
              await axios.delete(`http://localhost:8081/odev/hasders/${response.data[i].dersID}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
              .then((response)=>{
                if(response.data == 1){
                  console.log("hasders başarıyla silindi!");
                }else{
                  console.log(response.data);
                  console.log("hasders silinemedi!");
                }
              })
            }
          }
        })  
    }).then(async()=>{
      for(var i = 0; i < this.odevId.length; i++){
        await axios.delete(`http://localhost:8081/odev/ders/${this.odevId[i]}`,{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}})
        console.log("ders başarıyla silindi!");
      }
      this.odevId = [];
    }).then(async()=>{
      for(var i = 0; i < this.numCourses; i++){
        var laaa = await axios.post(`http://localhost:8081/odev/ders`, {
        "dersAdi": this.course[i].dersAdi,
        "kredi": this.course[i].kredi,
        "not": this.course[i].not,
        },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
          if(response != null){
            this.odevId.push(response.data.dersID);
            console.log("ders başarıyla kaydedildi!");
            console.log('odev sayisi =' + this.odevId.length + 'odev id = ' + this.odevId[i]);
          }else{
            console.log("ders kaydedilemedi!");
          }
     })
      }
    }).then(async()=>{
      for(var i = 0; i < this.odevId.length; i++){
        var laaa = await axios.post(`http://localhost:8081/odev/hasders`, {
        "ortID": this.id,
        "dersID": this.odevId[i],
        },{headers:{'Authorization': 'Bearer ' + this.$store.state.user.token}}).then(response => {
          if(response != null){
            console.log("hasders başarıyla kaydedildi!");
          }else{
            console.log("hasders kaydedilemedi!");
          }
     })
      }
    })
    }
    },
    }
    }
      ;
</script>

<style scoped>
.column {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  justify-content: flex-end;
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
  margin-top: 30px;
  flex-direction: row;
  justify-content: flex-end;
  display: flex;
  margin-right: 20px;
}

.checkboxes {
  display: flex;
  flex-direction: column;
  margin-left: 20px;
}
hr {
  border:none;
  height: 2px;
  width: 85%;
  background-color: black; /* Çizgi rengi */
  margin: 10px ; /* Üst ve alt boşluk */
}
hr2 {
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
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 10px;
  flex-direction: column;
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
 margin-left: 30px;
 margin-right: 30px;
}

button {
  margin-left: 10px;
}
</style>
