package ork.keeptrackingLog.keeptrackLog.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ork.keeptrackingLog.keeptrackLog.models.LoginRequest
import ork.keeptrackingLog.keeptrackLog.models.LoginResponse
import ork.keeptrackingLog.keeptrackLog.models.RegisterRequest
import ork.keeptrackingLog.keeptrackLog.models.Registerresponse
import ork.keeptrackingLog.keeptrackLog.uI.ApiClient
import ork.keeptrackingLog.keeptrackLog.uI.ApiInterface
import retrofit2.Response


class UserRepository {
    val apiclient = ApiClient.buildApiClient()Client(ApiInterface:class.java)

    //   implementing the user Login network call
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> =
        withContext(Dispatchers.IO) {
            val response = apiclient.loginUser(loginRequest)
            return@withContext response
        }

    //implementing the User Register network call
    suspend fun registerUser(registerRequest: RegisterRequest) : Response<Registerresponse> =
        withContext(Dispatchers.IO){
            val response = apiclient.registerUser(registerRequest)
            return@withContext response
        }
}