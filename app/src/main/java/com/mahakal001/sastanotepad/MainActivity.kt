package com.mahakal001.sastanotepad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mahakal001.sastanotepad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        Log.i("MainActivity","MainActivity has called the onCreate Methods")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}