<template>
  <div id="headerNav">
      <div class="logoImg">
          <img class="logo" src="../assets/cropped-logo.png" alt="Planner ahead logo"/>
      </div>
      <!-- <div id="brandName"> Planner Ahead </div> -->
    
      <ul class="nav-links">
        <li id="home"> <router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li id="aboutUs"><router-link v-bind:to="{ name: 'about-us' }">About Us</router-link></li>
        <li id="mealPlans"><router-link v-bind:to="{ name: 'mealplans', params: {userId: this.$store.state.user.id}}" v-if="$store.state.token != ''">Meal Plans</router-link></li>
        <li id="myRecipes"> <router-link v-bind:to="{ name: 'recipes', params: {userId: this.$store.state.user.id} }" v-if="$store.state.token != ''">My Recipes</router-link> </li>
        <li id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        </ul>
    
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
@media(max-width: 1024px){
  #headerNav{
    display: flex;
    justify-content: flex-start;
    align-items: center;
  }
  .nav-links {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  /* background-color: darkgrey; */
  padding: 10px;
 flex-shrink: 1;
 
  
  }

.nav-links li{
  
  justify-content: flex-start;
   
}
  /* .logoImg{
    height: 40px;
  }
  .nav-links{
    display: flex;
    flex-shrink: 1;
  }
  .nav-links > li{
    display: inline;
    margin: 0px 0px;
  } */
}
     #headerNav {
      font-family: 'Poppins', sans-serif;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgb(226, 246, 202);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
  /* padding: 10px 20px; */
  width:100%;
  height: 100px;
  padding: 5px;
  
}

.logoImg {
  height: 80px;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
  margin: 2px;
}

.logo {
  height: 100%;
  width: auto;
  
  
}

.nav-links {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  /* background-color: darkgrey; */
  padding: 10px;
 flex-shrink: 0;
  
}

.nav-links li{
  margin: 0 10px;
  padding: 5px;
  min-width:120px;
  
   
}

.nav-links a {
  color: black;
  text-decoration: none;
  font-size: 18px;
  font-weight: 600;
  font-family: 'Dosis', monospace, sans-serif;
  padding: 15px;
  background-color: #89c36f;
  border-radius: 10px; 
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
}
.nav-links a:hover {
  color: white;
  background-color: #aadd92;
}

    /* #headerNav {
        display: flex;
        align-items: center;
        margin: 0 auto;
       padding: 0px;
       border-bottom: 3px solid rgb(244, 247, 224);
       background-color:rgb(236, 245, 226);
      
    }
li{
background-color: rgb(222, 247, 192);
padding: 15px;
list-style: none;
width:100px;
text-align: center;
border:5px  darkgrey;
margin: 0,10px;
}

.nav{
display: flex;
}
    .logo{
        border-radius: 10%;     
        width: 100px; 
    }

    .logoImg{
        padding-left: 25px;
        padding-top: 10px;
        padding-bottom: 10px;
    }

    a {
        text-decoration: none;
        text-transform: uppercase;
        font-size: 90%;
        font-family: Arial, Helvetica, sans-serif;
        color: black;

    }
    
    a:hover{
        background-color:rgb(220, 250, 206);
        font-weight: bold;
    }

    #brandName{
        text-decoration: none;
        text-transform: capitalize;
        font-size: 1.4em;
        font-family: Arial, Helvetica, sans-serif;
        color: black;
        position: absolute;
        left: 200px;
    }


    #home {
        position: absolute;
        right: 300px;
    }

    #myRecipes{
        position: absolute;
        right: 150px;
    }

    #logout{
        position: absolute;
        right: 50px;
    }

    #aboutUs{
        position: absolute;
        right: 400px;
    }
    #mealPlans{
        position: absolute;
        right: 500px;
    }
    */

</style>