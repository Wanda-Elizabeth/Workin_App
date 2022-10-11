package ork.keeptrackingLog.keeptrackLog.models

import com.google.gson.annotations.SerializedName

data class ExcersiseCategory(
    @SerializedName("category_name") val category: String,
    @SerializedName("category_id") val category_id: String

    )
