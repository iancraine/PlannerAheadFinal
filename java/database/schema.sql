BEGIN TRANSACTION;

DROP TABLE IF EXISTS users_ingredients, users_recipes, users, ingredients, recipes, meal_plan, 
meal_plan_recipes, users_meal_plan, grocery_list,recipe_ingredients CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE ingredients (
	ingredient_id serial,
	ingredient_name varchar(50) NOT NULL,
	ingredient_type varchar(50) NULL,
	
	CONSTRAINT PK_ingredients PRIMARY KEY (ingredient_id)
);
CREATE TABLE users_ingredients (
	ingredient_id int,
	user_id int,
	
	CONSTRAINT FK_users_ingredients_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredients(ingredient_id),
	CONSTRAINT FK_users_ingredients_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE recipes(
	recipe_id serial,
	recipe_name varchar(50) NOT NULL,
	directions varchar(1500) NOT NULL,
	tags varchar(300),
	prep_time int,
	food_pic varchar(100),
	is_public boolean,
	created_by int, 
	
	CONSTRAINT PK_recipes PRIMARY KEY (recipe_id),
	CONSTRAINT FK_recipes_created_by FOREIGN KEY (created_by) REFERENCES users(user_id)
);
CREATE TABLE users_recipes(
	user_id int NOT NULL,
	recipe_id int NOT NULL,
	
	CONSTRAINT PK_users_recipe PRIMARY KEY (recipe_id, user_id),
	CONSTRAINT FK_users_recipes_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id),
	CONSTRAINT FK_users_recipes_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE meal_plan(
	meal_plan_id serial,
	plan_name varchar(50) NOT NULL,
	CONSTRAINT PK_meal_plan_id PRIMARY KEY (meal_plan_id)
	);																		 

CREATE TABLE users_meal_plan (
	meal_plan_id int NOT NULL,
	user_id int NOT NULL,
	
	CONSTRAINT PK_users_meal_plan PRIMARY KEY (meal_plan_id, user_id),
	CONSTRAINT FK_users_meal_plan_meal_plan_id FOREIGN KEY (meal_plan_id) REFERENCES meal_plan(meal_plan_id),
	CONSTRAINT FK_users_meal_plan_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE meal_plan_recipes(
	meal_plan_recipes_id serial,
	meal_plan_id int NOT NULL,
	recipe_id int NOT NULL,
	for_date date,
	meal_type int,
	
	CONSTRAINT PK_meal_plan_recipes PRIMARY KEY (meal_plan_recipes_id),
	CONSTRAINT FK_meal_plan_meal_plan_id FOREIGN KEY (meal_plan_id) REFERENCES meal_plan (meal_plan_id),
	CONSTRAINT FK_meal_plan_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes (recipe_id)
);
CREATE TABLE grocery_list(
	list_id serial,
	ingredient_id int NULL,
	non_food_option varchar(50) NULL,
	quantity varchar (20),
	
	CONSTRAINT PK_grocery_list PRIMARY KEY (list_id),
	CONSTRAINT FK_grocery_list_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredients(ingredient_id)
);
CREATE TABLE recipe_ingredients(
	recipe_id int NOT NULL,
	ingredient_id int NOT NULL,
	amount varchar(30),
	CONSTRAINT PK_recipe_ingredients_id PRIMARY KEY(recipe_id,ingredient_id),
	CONSTRAINT FK_recipe_ingredients_recipe FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id),
	CONSTRAINT FK_recipe_ingredients_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredients(ingredient_id)
	
);
COMMIT TRANSACTION;
