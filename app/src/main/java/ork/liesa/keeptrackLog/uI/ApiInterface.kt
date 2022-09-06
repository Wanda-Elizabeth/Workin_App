package ork.liesa.keeptrackLog.uI

import ork.liesa.keeptrackLog.models.LoginRequest
import ork.liesa.keeptrackLog.models.LoginResponse
import ork.liesa.keeptrackLog.models.RegisterRequest
import ork.liesa.keeptrackLog.models.Registerresponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST(" /register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<Registerresponse>

    @POST(" /login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>
}



