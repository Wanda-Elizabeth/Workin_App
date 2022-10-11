package ork.keeptrackingLog.keeptrackLog.uI

import ork.keeptrackingLog.keeptrackLog.database.ExerciseDao
import ork.keeptrackingLog.keeptrackLog.models.LoginRequest
import ork.keeptrackingLog.keeptrackLog.models.LoginResponse
import ork.keeptrackingLog.keeptrackLog.models.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterRequest>

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

//    @POST("/profile")
//    suspend fun userProfile(@Body profileRequest: ProfileRe): Response<ProfileResponse>


    //    GET REQUEST
    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization") token : String) : Response<List<ExerciseDao>>

    @GET("/exercises")
    suspend fun fetchExercises(@Header("Authorization") token : String) : Response<List<ExerciseDao>>

}


