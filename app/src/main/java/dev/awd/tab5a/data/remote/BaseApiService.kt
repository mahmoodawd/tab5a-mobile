package dev.awd.tab5a.data.remote

import retrofit2.http.GET

interface BaseApiService {
    // Example: Fetch random meal
    @GET("random.php")
    suspend fun getRandomMeal(): Any // Use placeholder for now
}
