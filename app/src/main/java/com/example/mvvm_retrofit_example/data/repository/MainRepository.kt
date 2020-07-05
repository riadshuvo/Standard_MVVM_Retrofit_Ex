package com.example.mvvm_retrofit_example.data.repository

import com.example.mvvm_retrofit_example.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}