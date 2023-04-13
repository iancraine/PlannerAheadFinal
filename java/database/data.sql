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

INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,1);

INSERT INTO ingredients (ingredient_name) VALUES ('Flour');
INSERT INTO ingredients  (ingredient_name) VALUES ('Sugar');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Eggs');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Carrots');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Potato');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Paprika');
INSERT INTO ingredients  (ingredient_name)  VALUES ('Chicken Broth');

INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1,1,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 4, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 6, '1 tbsp');

INSERT INTO meal_plan (plan_name) VALUES ('Beach Weekend!');
INSERT INTO meal_plan (plan_name) VALUES ('Christmas Meals');
INSERT INTO meal_plan (plan_name) VALUES ('My One Healthy Week a Year');

INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (1, 2, '08/10/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (1, 1, '08/11/2023', 1);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (2, 2, '12/25/2023', 3);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (2, 1, '12/24/2023', 5);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (3, 1, '1/3/2023', 2);
INSERT INTO meal_plan_recipes (meal_plan_id, recipe_id, for_date, meal_type) VALUES (3, 2, '1/4/2023', 3);

INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (1, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (2, 1);
INSERT INTO users_meal_plan (meal_plan_id, user_id) VALUES (3, 2);



COMMIT TRANSACTION;
