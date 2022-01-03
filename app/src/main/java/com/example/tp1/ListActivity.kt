package com.example.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp1.databinding.ActivityListBinding
import com.example.tp1.databinding.ActivitySecondBinding

class ListActivity : AppCompatActivity(), OnPhotoListClickListener {
    private lateinit var  binding: ActivityListBinding
    private lateinit var  allPhotos: Array<Photos>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)

        allPhotos = intent.getSerializableExtra("photos") as Array<Photos>

        binding.photoListRecyclerView.setHasFixedSize(true)

        val photoListLayoutManager = LinearLayoutManager(this)

        binding.photoListRecyclerView.layoutManager = photoListLayoutManager

        val photoListAdapter = PhotoListAdapter(allPhotos, this)

        binding.photoListRecyclerView.adapter = photoListAdapter

        setContentView(binding.root)
    }

    override fun clickOnPhotoAction(photo: Photos) {
        val navigateToSecondActivityIntent = Intent(this, SecondActivity::class.java)
        navigateToSecondActivityIntent.putExtra("photo",photo)
        startActivity(navigateToSecondActivityIntent)
    }
}