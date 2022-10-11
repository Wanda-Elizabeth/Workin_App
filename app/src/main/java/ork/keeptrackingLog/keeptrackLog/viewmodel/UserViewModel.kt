package ork.keeptrackingLog.keeptrackLog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ork.keeptrackingLog.keeptrackLog.Repository.UserRepository
import ork.keeptrackingLog.keeptrackLog.models.LoginRequest
import ork.keeptrackingLog.keeptrackLog.models.LoginResponse
import ork.keeptrackingLog.keeptrackLog.models.RegisterRequest
import ork.keeptrackingLog.keeptrackLog.models.Registerresponse

class UserViewModel : ViewModel() {
    val userRepository = UserRepository()
    //Login request
    val loginLiveData = MutableLiveData<LoginResponse>()
    var loginErrorLiveData = MutableLiveData<String>()

    //register user request
    val registerLiveData = MutableLiveData<Registerresponse>()
    val registerErrorLiveData = MutableLiveData<String>()

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else {
                loginErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }


    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }else{
                registerErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}