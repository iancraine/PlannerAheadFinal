BEGIN TRANSACTION;

INSERT INTO users(username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users(username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public, created_by) 
VALUES('Crock Pot Roast','Place beef roast in crock pot.  Mix the dried mixes together in a bowl and sprinkle over the roast. Pour the water around the roast. Cook on low for 7-9 hours.','gluten-free',10,null,true,1);

INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public,created_by) 
VALUES('Roasted Asparagus','Preheat oven to 425°F.' 
'Cut off the woody bottom part of the asparagus spears and discard.' 
'With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears' 
'(this keeps the asparagus from being all., and if you eat asparagus you know what I mean by that). Place asparagus on foil-lined baking sheet and drizzle with olive oil.'
 'Sprinkle with salt.'
'With your hands, roll the asparagus around until they are evenly coated with oil and salt.
Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.
They should be tender when pierced with the tip of a knife.
The tips of the spears will get very brown but watch them to prevent burning.
They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.','Healthy',20,null,true,2);

INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public,created_by)
VALUES('Curried Lentils and Rice','Bring broth to a low boil.'
	  'Add curry powder and salt.'
	  'Cook lentils for 20 minutes.'
	  'Add rice and simmer for 20 minutes.'
	  'Enjoy!','Healthy',120,null,true,1);
	
	
INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public,created_by)
VALUES ('Big Night Pizza','Add hot water to yeast in a large bowl and let sit for 15 minutes.'
	   'Mix in oil, sugar, salt, and flour and let sit for 1 hour.'
	   'Knead the dough and spread onto a pan.'
	   'Spread pizza sauce and sprinkle cheese.'
	   'Add any optional toppings as you wish.'
	   'Bake at 400 deg Fahrenheit for 15 minutes.'
	   'Enjoy!','Veggan',25,null,true,1);
	
INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public,created_by)
VALUES ('Mic Yorkshire Puds','Put the flour and some seasoning into a large bowl.'
	   'Stir in eggs, one at a time.'
	   'Whisk in milk until you have a smooth batter.'
	   'Chill in the fridge for at least 30 minutes.'
	   'Heat oven to 220C/gas mark 7.'
	   'Pour the oil into the holes of a 8-hole muffin tin.'
	   'Heat tin in the oven for 5 minutes.'
	   'Ladle the batter mix into the tin.'
	   'Bake for 30 minutes until well browned and risen.','Low carb',45,null,true,1);
	
INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public,created_by)
VALUES ('Old-Fashioned Oatmeal Cookies','Simmer raisins and water over medium heat until raisins are plump, about 15 minutes.'
	   'Drain raisins, reserving the liquid.'
	   'Add enough water to reserved liquid to measure 1/2 cup.'
	   'Heat oven to 400°.'
	   'Mix thoroughly shortening, sugar, eggs and vanilla.'
	   'Stir in reserved liquid.'
	   'Blend in remaining ingredients.'
	   'Drop dough by rounded teaspoonfuls about 2 inches apart onto ungreased baking sheet.'
	   'Bake 8 to 10 minutes or until light brown.'
	   'About 6 1/2 dozen cookies.','Dessert',20,null,true,1);
	   
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,1);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,2);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,3);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,4);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,5);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,6);

INSERT INTO ingredients (ingredient_name) VALUES ('Flour');
INSERT INTO ingredients  (ingredient_name) VALUES ('Sugar');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Eggs');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Carrots');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Potato');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Paprika');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Chicken Broth');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Salt');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Butter');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Baking Powder');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Milk');

INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1,1,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 4, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 6, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (2,3,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (2, 2, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (2, 11, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (2, 7, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (4,4,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (4, 5, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (4, 6, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (4, 8, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (5,1,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (5, 2, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (5, 4, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (5, 6, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (6,8,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (6, 11, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (6, 9, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (6, 10, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (3,4,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (3, 1, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (3, 3, '1 tbsp');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (3, 11, '1 tbsp');

INSERT INTO meal_plan (plan_name) VALUES ('Beach Weekend!');
INSERT INTO meal_plan (plan_name) VALUES ('Turkey Day!');
INSERT INTO meal_plan (plan_name) VALUES ('Christmas Meals');
INSERT INTO meal_plan (plan_name) VALUES ('My One Healthy Week a Year');
INSERT INTO meal_plan (plan_name) VALUES ('Todays Plan');
INSERT INTO meal_plan (plan_name) VALUES ('Family Reunion Week');

INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (1, 2, '08/10/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (1, 1, '08/11/2023', 1);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (1, 5, '11/16/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (3, 5, '12/25/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (3, 6, '12/24/2023', 5);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (3, 2, '12/23/2023', 1);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (4, 3, '1/3/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (4, 6, '1/4/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (5, 5, '04/16/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (5, 4, '04/17/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (5, 2, '04/18/2023', 1);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (5, 1, '04/21/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (6, 2, '02/5/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (6, 6, '02/6/2023', 1);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (6, 5, '02/5/2023', 2);

INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (1, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (2, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (3, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (4, 2);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (5, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (6, 1);

INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 2, NULL, '3 lbs');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, NULL, 'Toilet Paper', NULL);
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 4, NULL, '1 can');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 5, NULL, '3 bushels');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 6, NULL, '3 lbs');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 8, NULL, '1 Tsp');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 9, NULL, '3 Tbsp');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 11, NULL, '2 Tsp');
INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) VALUES (1, 7, NULL, '1 quarts');



COMMIT TRANSACTION;
