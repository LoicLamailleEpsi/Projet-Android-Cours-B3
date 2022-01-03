package com.example.tp1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServiceInterface {
    @GET("photos/{idPhoto}")
    fun getPhotosById(@Path("idPhoto") id : Int): Call<Photos>

    @GET("photos")
    fun getAllPhotos(@Query("albumId") albumId : Int) : Call<Array<Photos>>
}