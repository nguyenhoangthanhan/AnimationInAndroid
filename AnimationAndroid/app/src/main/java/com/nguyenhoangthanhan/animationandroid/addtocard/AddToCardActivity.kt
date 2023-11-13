package com.nguyenhoangthanhan.animationandroid.addtocard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.nguyenhoangthanhan.animationandroid.R
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityAddToCardBinding
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityDragDropItemRvactivityBinding

class AddToCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddToCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgCartStartAnimation.setOnClickListener {
            AnimationUtil.translateAnimation(
                binding.viewAnimation,
                binding.imgCartStartAnimation,
                binding.tvEndAnimation,
                null
            )
        }
    }
}