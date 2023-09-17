<template>
  <div class="image-container">
      
          <p calss="para zoom">More Time Eating!</p>
          <p class="para">"Effortlessly plan, cook, and enjoy deliciously healthy meals<br> with Meal Planner - your one-stop solution for mealtime bliss!"</p>
         <div class="img">
    <img src="..\assets\1M.png" alt="Pot Roast" class="two">
      </div>
    <div class="last">
        <img class= "lastimg img1" src="..\assets\M4.png" alt="meals" />
         <img  class="roast img1" src="..\assets\M9.png" alt="meals" />
        <img class="img1 lastimg" src="..\assets\M6.png" alt="meals" />
       
       
    </div>
    
    
</div>

</template>

<script>
export default {

}
</script>

<style scoped>
.image-container{
    
    padding-left: 20px;
   
 
    
}
div p{
    /* text-align: center; */
     font-family: "Brush Script MT", cursive; 
     font-size: 44px;
     font-weight:700;
      transform: rotate(-20deg);
      text-shadow: #FC0 1px 0 10px;
      
}
.para{
    font-size: 16px;
}
/* p .logo{
    display: inline-block;
} */
/* .logo{
    max-width: 150px;
    border-radius: 50%;
    box-shadow: #FC0 1px 0 10px;
    /* margin-left:200px; 
}  
*/

.img{
    max-width:200px;
    max-height:400px;
    margin-left: 135px;
}
.two{
    max-width:600px
}

.img1:hover {
    border: .5px solid #8adf7f;
    border-radius: 8px;
    box-shadow: 0 0 2px 1px rgba(148, 224, 181, 0.5);
}
.roast{
    max-width:300px;
    max-height:300;
}
.lastimg{
max-width:200px;
}
div img{
    display: inline-block;
}
p:hover{
      /* transform: scale(0.5); */
      color:rgb(99, 238, 87);
}
</style>