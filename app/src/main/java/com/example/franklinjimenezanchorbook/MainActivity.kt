package com.example.franklinjimenezanchorbook

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.activity.viewModels
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.example.franklinjimenezanchorbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val bookVM : BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookVM.getBooks()

    }
}