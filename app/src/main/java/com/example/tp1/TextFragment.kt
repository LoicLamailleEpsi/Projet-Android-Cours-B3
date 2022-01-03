package com.example.tp1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tp1.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    private  lateinit var  binding : FragmentTextBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTextBinding.inflate(inflater)
        return binding.root
    }
}