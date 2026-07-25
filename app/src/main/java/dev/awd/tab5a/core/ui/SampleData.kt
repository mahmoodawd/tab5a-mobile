package dev.awd.tab5a.core.ui

import dev.awd.tab5a.domain.model.Ingredient
import dev.awd.tab5a.domain.model.Meal
import dev.awd.tab5a.domain.model.MealReview
import dev.awd.tab5a.domain.model.User

val sampleUser = User(
    email = "john@example.com",
    name = "John Doe",
    mobile = "+123456789",
    imageUrl = "https://unsplash.com/photos/water-on-orange-tomato-AvvdZlhDowA"
)
val sampleMealReviews = listOf(
    MealReview(
        id = "review_001",
        author = "John Doe",
        rating = 4.5,
        comment = "Great meal! The flavors were amazing."
    ),
    MealReview(
        id = "review_002",
        author = "Jane Smith",
        rating = 3.0,
        comment = "The ingredients were a bit overwhelming."
    ),
    MealReview(
        id = "review_003",
        author = "Bob Johnson",
        rating = 5.0,
        comment = "This was the best meal I've ever had!"
    )
)


val sampleIngredients = listOf(
    Ingredient(
        id = "001",
        title = "Tomato",
        imageUrl = "https://unsplash.com/photos/water-on-orange-tomato-AvvdZlhDowA"
    ),
    Ingredient(
        id = "002",
        title = "Onion",
        imageUrl = "https://unsplash.com/photos/brown-onion-on-white-background-iUGPq02__Gc"
    ),
    Ingredient(
        id = "003",
        title = "Garlic",
        imageUrl = ""
    ),
    Ingredient(
        id = "004",
        title = "Pepper",
        imageUrl = ""
    ),
    Ingredient(
        id = "005",
        title = "Cheese",
        imageUrl = ""
    ),
    Ingredient(
        id = "006",
        title = "Rice",
        imageUrl = ""
    ),
    Ingredient(
        id = "007",
        title = "Beef",
        imageUrl = ""
    )
)
val sampleMealIngredients = mapOf(
    "meal_001" to listOf(
        "001" to "2 pcs",  // Tomato
        "002" to "1 pc",   // Onion
        "005" to "100g",   // Cheese
    ),
    "meal_002" to listOf(
        "003" to "100g",   // Garlic,
        "004" to "100g",   // Pepper
        "005" to "100g",   // Cheese
    ),
    "meal_003" to listOf(
        "001" to "2 pcs",  // Tomato
        "002" to "1 pc",   // Onion
        "005" to "100g",   // Cheese
    ),
    "meal_004" to listOf(
        "001" to "2 pcs",  // Tomato
        "002" to "1 pc",   // Onion
        "005" to "100g",   // Cheese
    )
)
val sampleMeals = listOf(
    Meal(
        id = "meal_001",
        title = "Spaghetti Carbonara",
        description = "Classic Italian pasta dish with bacon, eggs, and cheese.",
        imageUrl = "https://www.themealdb.com/images/media/meals/b66myb1683207208.jpg",
        chef = "Chef Mario",
        rating = 2.5,
        ratingCount = 10,
        category = "Protein",
        ingredients = sampleMealIngredients["meal_001"]
            ?.associate { (id, quantity) -> getIngredientById(id) to quantity }
            ?: emptyMap()
    ),
    Meal(
        id = "meal_002",
        title = "Grilled Chicken Salad",
        description = "Fresh salad with grilled chicken, lettuce, and croutons.",
        imageUrl = "https://www.themealdb.com/images/media/meals/qstyvs1505931190.jpg",
        chef = "Chef Sara",
        rating = 4.5,
        ratingCount = 15,
        category = "Protein",
        ingredients = sampleMealIngredients["meal_002"]
            ?.associate { (id, quantity) -> getIngredientById(id) to quantity }
            ?: emptyMap()
    ),
    Meal(
        id = "meal_003",
        title = "Sushi Platter",
        description = "Assorted sushi rolls with soy sauce and wasabi.",
        imageUrl = "https://www.themealdb.com/images/media/meals/tyywsw1505930373.jpg",
        chef = "Chef Kenji",
        rating = 3.0,
        ratingCount = 8,
        category = "Sweets",
        ingredients = sampleMealIngredients["meal_003"]
            ?.associate { (id, quantity) -> getIngredientById(id) to quantity }
            ?: emptyMap()
    ),
    Meal(
        id = "meal_004",
        title = "Beef Tacos",
        description = "Mexican beef tacos with salsa and sour cream.",
        imageUrl = "https://www.themealdb.com/images/media/meals/4er7mj1598733193.jpg",
        chef = "Chef Luis",
        rating = 5.0,
        ratingCount = 20,
        category = "Meat",
        ingredients = sampleMealIngredients["meal_004"]
            ?.associate { (id, quantity) -> getIngredientById(id) to quantity }
            ?: emptyMap()
    ),
    Meal(
        id = "meal_005",
        title = "Vegan Buddha Bowl",
        description = "Healthy vegan bowl with mixed greens and tofu.",
        imageUrl = "https://www.themealdb.com/images/media/meals/qtqwwu1511792650.jpg",
        chef = "Chef Amina",
        rating = 1.0,
        ratingCount = 2,
        category = "Meat",
        ingredients = sampleMealIngredients["meal_001"]
            ?.associate { (id, quantity) -> getIngredientById(id) to quantity }
            ?: emptyMap()
    )
)

val sampleCategories = listOf("Protein", "Meat", "Chicken", "Sweets", "Salts")

fun getIngredientById(id: String): Ingredient = sampleIngredients.first { item -> item.id == id }
