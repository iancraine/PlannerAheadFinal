<template>
  <!-- <div class="footer"> -->
  <!-- <div class="container1"> -->
<div class ="container1">
<div class="footer">
  <div class="container2">
    <div class="aboutus">
      <h2 class="header">About Us</h2>
      <p class="aboutUsText">Lorem ipsum dolor sit amet, consectetur, blah blah adhbcjbsjabsadjcbdsjkcdbckjsddscdscdcdcdscdscsdcdscdscdscdscdcsdcdscdscdcdscdcdsccdshcbdhcbdhbdsbc djsbcsdjhcbsdcjhbsdjh jhvhvhjvjkjn kbkhbyvjhbk</p>
      <ul class="social-media">
        <li class="sm_list"><a href="#" class="sm_a"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
        <li class="sm_list"><a href="#" class="sm_a"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
        <li class="sm_list"><a href="#" class="sm_a"><i class="fa-brands fa-instagram"></i></a></li>
          <li class="sm_list"><a href="#" class="sm_a"><i class="fa-brands fa-linkedin"></i></a></li>
      </ul>
    </div>
    <div class="quicklinks">
      <h2 class="header">Quick Links</h2>
      <ul>
        <li><a href="#">About Us</a></li>
        <li><a href="#">My Meal Plans</a></li>
        <li><a href="#">New Recipe Form </a></li>
        <li><a href="#">Recipe Detail</a></li>
        <li><a href="#">Recipe List</a></li>
      </ul>
    </div>
    <div class ="contact">
      <h2 class="header">Contact Us</h2>
      <ul class="info">
        <li>
          <span><i class="fa-solid fa-map"></i></span>
          <p>Coding Street
            <br>
            Code City, TX 77777
          </p>
        </li>
        <li>
          <span><i class="fa-solid fa-phone"></i></span>
            <p><a href="#">+1(777)-777-7777</a>
           </p>
           </li>
            <li>
              <span><i class="fa-solid fa-envelope"></i></span>
                 <p><a href="#">contact@plannerahead.com</a>
              </p>
            </li>
            </ul>                                                                                                                                                                                                                                                                >
   </div>
  </div>
    <div class="copyright">
    <p>Copyright © 2023 Planner Ahead</p>
  </div>
  <!-- </div> -->
</div>
</div>
</template>
<script>
export default {
    name: 'footer',
    components: {
  }
}
</script>
<style>
/* div.footer{
    @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap')
    *
    */
   div.footer {
  font-family: 'Poppins', sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
 .container1 {
  display: grid;
  justify-content: end;
  align-content: end;
  min-height: 15%;
}
.footer {
  position: relative;
  width: 100%;
  height: auto;
  padding: 50px 100px;
  background: #bfcbfa;
  justify-items: center;
}
.container2 {
  width: 100%;
  display: grid;
  grid-template-columns: 2fr 1fr 1fr 1fr;
  grid-gap: 30px;
  justify-items: center;
}
.header {
  position: relative;
  color:black;
  font-weight: 500;
  margin-bottom: 15px;
  padding-left: 15px;
}
.header::before {
  content: '';
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 50px;
  height: 2px;
  background: #FFEB3B;
  margin-left: 15px;
}
.aboutUsText {
  color: black;
  padding-left: 15px;
}
.social-media {
  margin-top: 20px;
  display: grid;
  grid-template-columns: repeat(4, 50px);
  grid-gap: 10px;
}
.sm_list {
  list-style: none;
}
.sm_a {
  display: inline-block;
  width: 48px;
  height: 48px;
  background: #3E56CB;
  display: grid;
  align-content: center;
  justify-content: center;
  text-decoration: none;
  border-radius: 4px;
}
.sm_a:hover {
  background: #6380FE
}
.sm_a .fa {
  color: black;
  font-size: 20px;
}
.quicklinks {
  position: relative;
}
.quicklinks li {
  list-style: none;
}
.quicklinks li a {
  color:black;
  text-decoration: none;
  margin-bottom: 10px;
  display: inline-block;
}
.quicklinks li a:hover {
  color: #FFEB3B;
}
.info {
  position: relative;
}
.info li {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-areas: "images word";
  margin-bottom: 16px;
  
}
.info li span:nth-child(1) {
  color:black;
  font-size: 20px;
  grid-area: images;
  
}
.info li span {
  color:black;
  
 
}
.info li p {
  grid-area: word;
  align-items: start;
  margin-top: 0;
}
.info a {
  color:black;
  text-decoration: none;
}
.info a:hover {
  color: #FFEB3B;
}
.copyright {
  width: 100%;
  background: #1F3389;
  padding: 2px 0;
  text-align: center;
  color: #fff;
}
@media (max-width: 991px)
{
  footer
  {
    padding: 40px;
  }
  footer .container1 {
    grid-template-columns: repeat(2,1fr);
  }
}
@media (max-width: 769px)
{
  footer .container
  {
    grid-template-columns: repeat(2,1fr);
  }
}
</style>