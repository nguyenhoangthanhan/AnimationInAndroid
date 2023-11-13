package com.nguyenhoangthanhan.animationandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.animationandroid.addtocard.AddToCardActivity
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.animationandroid.lottieanimation.LottieAnimationActivity
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
        binding.btnOpenAddToCartAnimation.setOnClickListener {
            startActivity(Intent(this, AddToCardActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            })
        }
        binding.btnOpenLottieAnimation.setOnClickListener {
            startActivity(Intent(this, LottieAnimationActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            })
        }
    }
}