package com.example.mvvm_retrofit_example.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_retrofit_example.utils.Resource

import com.example.mvvm_retrofit_example.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message ?: "Error Occurred"))
        }
    }

}

/**
 * @Dispatchers: Dispatchers help coroutines in deciding the thread on which the work has to be done.
 * There are majorly three types of Dispatchers which are as IO, Default, and Main.
 *  @IO dispatcher is used to do the network and disk-related work.
 * @Default is used to do the CPU intensive work.
 * @Main is the UI thread of Android.
 * In order to use these, we need to wrap the work under the async function.
 * Async function looks like below.
 * suspend fun async() // implementation removed for brevity
 *@suspend: Suspend function is a function that could be started, paused, and resume
 * */