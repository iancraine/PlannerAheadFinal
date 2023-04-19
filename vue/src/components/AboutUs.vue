<template>
  <div>
    <div class="container">
      <div class="title">
        <!-- <div>
			<img src="../assets/healthy-food.jpg"/>
			</div> -->
        <h1 class="plannerTitle">
          Welcome to <br /><span class="aboutUs"> PLANNER AHEAD</span><br />
          Meal Planner
        </h1>
      </div>
      <div class="para">
        <section class="section">
          <h2>Our mission</h2>
          <p style="font-weight: bold; text-align: center">
            Your one-stop solution for planning, cooking, and enjoying delicious
            and healthy meals every day!
          </p>
          <p>
            We are a team of passionate food lovers, nutrition experts, and tech
            enthusiasts who came together to make meal planning and cooking
            easier and more enjoyable for everyone.
          </p>
          <p>
            At Meal Planner, we believe that eating healthy and delicious meals
            should be effortless, fun, and affordable for everyone. That's why
            we created a simple and intuitive meal planning platform that helps
            you plan your meals for the week, create a shopping list, and cook
            delicious and healthy meals in no time.
          </p>
        </section>

        <section class="section">
          <h2>Simplify your meal planning</h2>
          <div class="specialSection">
            <div class="box">Save Time</div>
            <p class="specialPara">
              Our platform is designed to
              <span style="font-weight: bold; text-align: center"
                >take the hassle out of meal planning
              </span>
              and cooking. Whether you're a busy professional, a parent, a
              student, or anyone who wants to eat healthy and tasty meals
              without spending hours in the kitchen, Meal Planner is the perfect
              solution for you.
            </p>
          </div>

          <div class="specialSection">
            <div class="box">Customize</div>
            <p class="specialPara">
              We understand that everyone has different dietary needs and
              preferences, which is why we offer a
              <span style="font-weight: bold; text-align: center"
                >wide range of customizable meal plans </span
              >that cater to different diets, including vegetarian, vegan,
              low-carb, and gluten-free. Our platform also allows you to
              personalize your meal plans based on your favorite foods,
              allergies, and nutritional goals.
            </p>
          </div>

          <div class="specialSection">
            <div class="box">Features</div>
            <p class="specialPara">
              Save all your recipes and created meal plans for later use. You
              can always add, modify, delete any recipes or meal plans at any
              time. Have tailored meal plans organized in one space!
            </p>
          </div>
        </section>

        <section class="section">
          <h2>What our customers say</h2>
          <div class="all-reviews">
            <div class="review">
              <span>
                <img
                  class="person"
                  src="../assets/person-one.jpg"
                  height="200"
                  width="150"
                />
                <p class="person-name">Christina</p></span
              >

              <p>
                As a busy graduate student, using the Planner Ahead meal planner
                has saved me so much time so that I can focus on cooking
              </p>
            </div>
            <div class="review">
               <p>
                I had all these recipes writed down that my Mom and Grandma used to make.  I was always spilling food on them and ruining them.
                Now, I input all my family recipes in one location where they'll never get splashed with pasta sauce again! Plus, the grocery list 
                feature saves me time!
              </p>  
               <span>
                <img
                  class="person"
                  src="../assets/person-two.jpg"
                  height="200"
                  width="150"
                />
                <p class="person-name">Matthew</p></span
              >
              
            </div>
            <div class="review">
               <span>
                <img
                  class="person"
                  src="../assets/person-three.jpg"
                  height="200"
                  width="150"
                />
                <p class="person-name"> Nicky </p></span
              >

              <p>
               I really love the features that Planner Ahead provides. I get to save all my recipes, and now it's so easy to look up any recipe that I need to use for the day!
               
              </p>
            </div>
          </div>
        </section>
        <p>
          At Planner Ahead, we are committed to helping you eat healthier, save
          time and money, and enjoy delicious and nutritious meals every day. We
          hope you enjoy using our platform and join us on this exciting journey
          of healthy and tasty eating!
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "aboutUs",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Baloo+Chettan+2&family=Calligraffitti&display=swap");

/*img {
  position: absolute;
      display: flex;
      justify-content: flex-start; 
  top: 0;
  left: 0;
  width: 50%;
  height: 100%;

  object-fit: cover;
  -webkit-box-reflect: right;
}
*/
.para {
  padding: 25px;
  width: 80%;
  margin: 0 auto;
  background-color: aliceblue;
  opacity: 0.953;
  border-radius: 20px;
}
.title {
  display: flex;
  /* width: 45%; */
  flex-grow: 0.5;
  flex-direction: column;
  height: 10%;
  margin: 0 auto;
  margin-top: 1.2em;
  margin-bottom: 1.2em;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  text-shadow: 5px 2px 2px rgba(255, 255, 255, 0.4);
  background-color: #ecf5fd;
}

.title h1 {
  /* position: relative; */
  z-index: 1;
  text-align: center;
  color: rgb(3, 94, 48);
  align-content: center;
  font-size: 3rem;
  margin: 0;
  padding: 0 20px;
}

h1 {
  align-content: center;
  margin: 40px 0;
}

h2 {
  /* text-align: center;
  color:rgb(2, 3, 20);
   background: linear-gradient(
    142deg,
    rgb(160, 226, 143) 0%,
    rgb(221, 240, 220) 100%
  ); */
  text-align: center;
  font-family: "Calligraffitti", cursive;
  font-weight: 700;
  font-size: 1.6em;
  text-shadow: -15px 5px 20px #ced0d3;

  letter-spacing: 0.02em;
  color: #e78f14;
  text-shadow: 2px 2px 0px #ffd662;
}

p {
  font-size: 1.2em;
  line-height: 1.5;
  margin: 20px 0;
  padding: 0 20px;
  justify-content: center;
}

.person-name {
  margin-top: 0;
  text-align: center;
  font-weight: 600;
}
/* .specialPara {
  border-radius: 10px 10px 10px 10px;
  border-style: solid;
    border-width: 2px;
    border-color: #688492;
    padding: 1;
} */

.specialSection {
  display: flex;
  border-radius: 10px 10px 10px 10px;
  border-style: solid;
  border-width: 2px;
  border-color: #688492;
  padding: 1;
  margin: 15px;
  align-items: center;
}

.box {
  text-align: center;
  margin-left: 1em;
  min-width: 15%;
  color: white;
  font-size: 1.2em;
  background-color: #688492;
}

.aboutUs {
  color: #ffd662;
}

.container {
  display: flex;
  flex-direction: column;
  background-color: #faf7f0;
  margin: 0 auto;
  background-color: #faf7f0;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  justify-content: center;
  width: 100%;
  font-family: "Dosis", monospace, sans-serif;
  background: url(../assets/mealPlan-photo.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
}

section {
  margin-bottom: 40px;
}

.review {
  display: flex;
  align-items: center;
  background-color: #dbf0e7;
  padding-top: 20px;
  border-bottom: 2px solid;
  border-bottom-style: groove;
  max-width:80%;
  margin: 0 auto;
  /* border-radius: 10px / 30px; */
  
}

.review:nth-child(even) {
border-top-right-radius: 15px;
border-bottom-left-radius: 15px;

}


.review:nth-child(odd) {
 border-top-left-radius: 15px;
 border-bottom-right-radius: 15px;

}

.person {
  border-radius: 10%;
  padding: 10px;
}
</style>