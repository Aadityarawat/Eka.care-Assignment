package com.adityarawat.ekacareassignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adityarawat.ekacareassignment.repository.UserRepository
import com.adityarawat.ekacareassignment.room.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun getUser() : LiveData<List<User>> {
        return userRepository.getUser()
    }

    fun insertUser(user: User){
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}