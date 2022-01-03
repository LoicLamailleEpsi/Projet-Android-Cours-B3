package com.example.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp1.databinding.ActivitySecondBinding
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater);

        val stringFromMainActivity = intent.getStringExtra("Message")
        val photoFromMainActivity = intent.extras?.getSerializable("photo") as Photos

        binding.secondActivityTextView.text = photoFromMainActivity.url
        Picasso.get().load(photoFromMainActivity.url).into(binding.secondActivityImageView)

        setContentView(binding.root)
    }
}