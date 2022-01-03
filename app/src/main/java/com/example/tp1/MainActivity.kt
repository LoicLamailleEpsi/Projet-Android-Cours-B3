package com.example.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import com.example.tp1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.mainActivityTextView.text = "salut"
        setContentView(binding.root)
    }

    fun changeTextAction(view : View){
        binding.mainActivityTextView.text = "Le texte est changé"
    }

    fun navigateToActivitySecondAction(view: View){
        val  navigateToActivitySecondIntent = Intent(this, SecondActivity::class.java)
        navigateToActivitySecondIntent.putExtra("Message","Message envoyé depuis la mainActivity")

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()

        val ws = retrofit.create(WebServiceInterface::class.java)
        val callGetPhotoById = ws.getPhotosById(15)
        //val callGetAllPhotos = ws.getAllPhotos()

        callGetPhotoById.enqueue(object : Callback<Photos>{
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                val photo = response.body()
                println(photo?.url)
                navigateToActivitySecondIntent.putExtra("photo",photo)
                startActivity(navigateToActivitySecondIntent)
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.d("JLE",t.message!!)
            }

        })

        /*callGetAllPhotos.enqueue(object : Callback<Array<Photos>>{
            override fun onResponse(call: Call<Array<Photos>>, response: Response<Array<Photos>>) {
                for( p : Photos in response.body()!!)
                    println(p.url)
            }

            override fun onFailure(call: Call<Array<Photos>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })*/





    }
    fun navigateToActivityListAction(view: View){
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()
        val ws = retrofit.create(WebServiceInterface::class.java)
        val navigateToListActivityIntent = Intent(this, ListActivity::class.java)

        val callGetAllPhotos = ws.getAllPhotos(1)
        callGetAllPhotos.enqueue(object : Callback<Array<Photos>>{
            override fun onResponse(
                call: Call<Array<Photos>>,
                response: Response<Array<Photos>>
            ) {
                val allPhotos = response.body()
                navigateToListActivityIntent.putExtra("photos",allPhotos)
                startActivity(navigateToListActivityIntent)
            }

            override fun onFailure(call: Call<Array<Photos>>, t: Throwable) {
                println("Fail")
                println(t.message)
            }
        })
    }

    fun navigateToActivityBottomNavigation(view: View){
        val navigateToBottomNavigationActivityIntent = Intent(this, BottomNavigationActivity::class.java)
        startActivity(navigateToBottomNavigationActivityIntent)


    }
}