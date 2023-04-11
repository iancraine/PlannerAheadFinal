BEGIN TRANSACTION;

INSERT INTO users(username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users(username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public) 
VALUES('Crock P  ot Roast','Place beef roast in crock pot.  Mix the dried mixes together in a bowl and sprinkle over the roast. Pour the water around the roast. 
	   Cook on low for 7-9 hours.','gluten-free',10,null,true);

INSERT INTO recipes(recipe_name,directions,tags,prep_time,food_pic,is_public) 
VALUES('Roasted Asparagus','Preheat oven to 425°F.'
	   'Cut off the woody bottom part of the asparagus spears and discard.
	   With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears (this keeps the asparagus from being all., and if you eat asparagus you know what I mean by that).
	   Place asparagus on foil-lined baking sheet and drizzle with olive oil.
	   Sprinkle with salt.
	   With your hands, roll the asparagus around until they are evenly coated with oil and salt.
	   Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.
	   They should be tender when pierced with the tip of a knife.
	   The tips of the spears will get very brown but watch them to prevent burning.
	   They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.','Healthy',20,null,true);

INSERT INTO users_recipes (user_id, recipe_id) VALUES (1,1);

INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Flour', 'Staple');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Sugar', 'Staple');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Eggs', 'Animal Product');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Carrots', 'Vegetable');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Potato', 'Vegetable');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Paprika', 'Seasoning');
INSERT INTO ingredients (ingredient_name, ingredient_type) VALUES ('Chicken Broth', 'Liquid');

INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1,1,'2 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 4, '3 cups');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES (1, 6, '1 tbsp');

COMMIT TRANSACTION;
