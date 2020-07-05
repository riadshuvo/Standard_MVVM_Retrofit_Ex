package com.example.mvvm_retrofit_example.data.api

import com.example.mvvm_retrofit_example.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<User>
}