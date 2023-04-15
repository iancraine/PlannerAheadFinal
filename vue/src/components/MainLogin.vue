<template>
  <div class="image-container">
      
          <p calss="para zoom">More Time Eating!</p>
         <div class="img">
    <img src="..\assets\1M.png" alt="Pot Roast" class="two">
      </div>
    <div class="last">
        <img class= "lastimg img1" src="..\assets\M4.png" alt="meals" />
         <img  class="roast img1" src="..\assets\M9.png" alt="meals" />
        <!-- <img class="img1 lastimg" src="..\assets\M2.jpg" alt="meals" /> -->
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
    
    padding-left: 90px;
   
 
    
}
div p{
    /* text-align: center; */
     font-family: "Brush Script MT", cursive; 
     font-size: 44px;
     font-weight:700;
      transform: rotate(-20deg);
      text-shadow: #FC0 1px 0 10px;
      
}

.img{
    max-width:350px;
    max-height:400px;
}
.two{
    max-width:700px
}

.img1:hover {
    border: .5px solid #8adf7f;
    border-radius: 8px;
    box-shadow: 0 0 2px 1px rgba(148, 224, 181, 0.5);
}
.roast{
    max-width:320px;
    max-height:350;
}
.lastimg{
max-width:220px;
}
div img{
    display: inline-block;
}
p:hover{
      /* transform: scale(0.5); */
      color:rgb(99, 238, 87);
}
</style>