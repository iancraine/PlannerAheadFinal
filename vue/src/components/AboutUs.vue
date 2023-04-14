<template>
  <div>
    <div class="container">
		<div class="title">
			<img src="../assets/healthy-food.jpg"/>
			<h1>Welcome to <br><span class="aboutUs"> PLANNER AHEAD</span><br> Meal Planner</h1>
			</div>
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
</template>

<script>
export default {
    name: 'aboutUs'

}
</script>

<style scoped>
img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 90%;
  float: left;
  object-fit: cover;
  -webkit-box-reflect: right;
}

.title h1 {
  position: relative;
  z-index: 1;
  text-align: left;
  color: white;
  align-content: center;
  font-size: 3rem;
  margin: 0;
  padding: 0 20px;
}

h1 {
  text-align: end;
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
  color: rgb(206, 111, 48);
}

.container {
  display: flex;
  flex-direction: column;
  background-color: #faf7f0;
  margin: 0 auto;
  background-color: #faf7f0;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  justify-content: center;
}

.title {
  position: relative;
  display: inline-block;
  flex-grow: 1;
  flex-direction: column;
}

</style>