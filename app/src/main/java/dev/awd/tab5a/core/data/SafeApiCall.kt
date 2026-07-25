package dev.awd.tab5a.core.data

import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> NetworkResult.Error("Network Error: Please check your internet connection")
            is HttpException -> {
                val code = throwable.code()
                NetworkResult.Error("HTTP Error: $code", code)
            }

            else -> NetworkResult.Error("Unknown Error: ${throwable.message}")
        }
    }
}
