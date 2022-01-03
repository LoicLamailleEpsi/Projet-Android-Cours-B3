package com.example.tp1

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Photos : Serializable {
    @SerializedName("id")
    var id : Int = 0

    @SerializedName("title")
    var title : String = ""

    @SerializedName("url")
    var url : String = ""

    @SerializedName("thumbnailUrl")
    var thumbnailUrl : String = ""

}