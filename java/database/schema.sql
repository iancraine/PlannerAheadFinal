BEGIN TRANSACTION;

DROP TABLE IF EXISTS users_ingredients, users_recipes, users, ingredients, recipes, daily_plan, weekly_plan,
weekly_daily_plan, users_meal_plan, grocery_list,recipe_ingredients CASCADE;

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
CREATE TABLE daily_plan(
	daily_plan_id serial,
	breakfast_recipe_id int, 
	lunch_recipe_id int, 
	dinner_recipe_id int,
	
	CONSTRAINT PK_daily_plan PRIMARY KEY (daily_plan_id),
	CONSTRAINT FK_users_recipes_daily_plan_breakfast FOREIGN KEY (breakfast_recipe_id) REFERENCES recipes(recipe_id),
	CONSTRAINT FK_users_recipes_daily_plan_lunch FOREIGN KEY (lunch_recipe_id) REFERENCES recipes(recipe_id),
	CONSTRAINT FK_users_recipes_daily_plan_dinner FOREIGN KEY (dinner_recipe_id) REFERENCES recipes(recipe_id)
);
CREATE TABLE weekly_plan(
	weekly_plan_id serial,
	plan_name varchar(50) NOT NULL,
	date_created date NOT NULL DEFAULT CURRENT_DATE,
	
	CONSTRAINT PK_weekly_plan_id PRIMARY KEY (weekly_plan_id)
); 
CREATE TABLE weekly_daily_plan(
	daily_plan_id int NOT NULL,
	weekly_plan_id int NOT NULL,
	day_of_week varchar(20) NOT NULL,
	
	CONSTRAINT PK_weekly_daily_plan PRIMARY KEY (daily_plan_id, weekly_plan_id),
	CONSTRAINT FK_weekly_daily_plan_daily_plan_id FOREIGN KEY (daily_plan_id) REFERENCES daily_plan(daily_plan_id),
	CONSTRAINT FK_weekly_daily_plan_weekly_plan_id FOREIGN KEY (weekly_plan_id) REFERENCES weekly_plan(weekly_plan_id)
);
CREATE TABLE users_meal_plan (
	weekly_plan_id int NOT NULL,
	user_id int NOT NULL,
	
	CONSTRAINT PK_users_meal_plan PRIMARY KEY (weekly_plan_id, user_id),
	CONSTRAINT FK_users_meal_plan_weekly_plan_id FOREIGN KEY (weekly_plan_id) REFERENCES weekly_plan(weekly_plan_id),
	CONSTRAINT FK_users_meal_plan_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
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
