<template>
  <div>
    <div class="container">
		<div class="title">
			<div>
			<img src="../assets/healthy-food.jpg"/>
			</div>
			<h1 class="plannerTitle">Welcome to <br><span class="aboutUs"> PLANNER AHEAD</span><br> Meal Planner</h1>
			</div>
		<div class="para">
    <h2>Our mission</h2>
		<p>Your one-stop solution for planning, cooking, and enjoying delicious and healthy meals every day! We are a team of passionate food lovers, nutrition experts, and tech enthusiasts who came together to make meal planning and cooking easier and more enjoyable for everyone.</p>
		<p>At Meal Planner, we believe that eating healthy and delicious meals should be effortless, fun, and affordable for everyone. That's why we created a simple and intuitive meal planning platform that helps you plan your meals for the week, create a shopping list, and cook delicious and healthy meals in no time.</p>
		
		<h2>What's special about Planner Ahead</h2>
		<p>Our platform is designed to take the hassle out of meal planning and cooking. Whether you're a busy professional, a parent, a student, or anyone who wants to eat healthy and tasty meals without spending hours in the kitchen, Meal Planner is the perfect solution for you.</p>
		<p>We understand that everyone has different dietary needs and preferences, which is why we offer a wide range of customizable meal plans that cater to different diets, including vegetarian, vegan, low-carb, and gluten-free. Our platform also allows you to personalize your meal plans based on your favorite foods, allergies, and nutritional goals.</p>
		<p>At Planner Ahead, we are committed to helping you eat healthier, save time and money, and enjoy delicious and nutritious meals every day. We hope you enjoy using our platform and join us on this exciting journey of healthy and tasty eating!</p>

		<h2>Reviews</h2>
    </div>
	</div>
  </div>
</template>

<script>
export default {
    name: 'aboutUs'

}
</script>

<style scoped>
img {
  position: absolute;
  /* display: flex; */
  /* justify-content: flex-start; */
  top: 0;
  left: 0;
  width: 50%;
  height: 100%;
  
  object-fit: cover;
  -webkit-box-reflect: right;
}
.para{
  padding: 25px;
}
.title {
  position: relative;
  display: flex;
  width: 100%;
  flex-grow: 1;
  flex-direction: column;
  height:10%;
}

.title h1 {
  /* position: relative; */
  z-index: 1;
  text-align: center;
  color: rgb(9, 172, 49);
  align-content: center;
  font-size: 3rem;
  margin: 0;
  padding: 0 20px;
}

h1 {
  align-content: center;
  margin: 40px 0;
}

p {
  font-size: 16px;
  line-height: 1.5;
  margin: 20px 0;
  padding: 0 20px;
  justify-content: center;
}

.aboutUs {
  color: rgb(235, 126, 53);
}

.container {
  display: flex;
  flex-direction: column;
  background-color: #faf7f0;
  margin: 0 auto;
  background-color: #faf7f0;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  justify-content: center;
  width: 70%;
}



</style>