package com.nguyenhoangthanhan.animationandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.animationandroid.recycleview.dragdropitem.DragDropItemRVActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvents()
    }

    private fun initEvents() {
        binding.btnOpenDragDropItemRv.setOnClickListener {
            startActivity(Intent(this, DragDropItemRVActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            })
        }
    }
}