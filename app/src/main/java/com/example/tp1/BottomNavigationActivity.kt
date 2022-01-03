package com.example.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.tp1.databinding.ActivityBottomNavigationBinding
import com.example.tp1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding : ActivityBottomNavigationBinding
    private val textFragment = TextFragment()
    private val imageFragment = ImageFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)

        loadFragment(textFragment)

        setContentView(binding.root)
    }
    private fun loadFragment(fragment : Fragment?) : Boolean{
        if(fragment != null ){
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()

            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem) : Boolean {
        if(item.itemId == R.id.action_texte){
            return loadFragment(textFragment)
        }
        if(item.itemId == R.id.action_image){
            return loadFragment(imageFragment)
        }
        return false
    }

}