package ork.keeptrackingLog.keeptrackLog.models

import com.google.gson.annotations.SerializedName

data class User(
@SerializedName("first_name") val firstname:String,
@SerializedName("last_name")val lastname:String,
var email:String,
@SerializedName("user_id")val userId:String,)