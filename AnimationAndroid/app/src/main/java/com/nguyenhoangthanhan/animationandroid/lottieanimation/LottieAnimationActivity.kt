package com.nguyenhoangthanhan.animationandroid.lottieanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.animationandroid.R
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityAddToCardBinding
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityLottieAnimationBinding

class LottieAnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLottieAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLottieAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.controlAnimation.setOnClickListener {
            if (binding.animationView.isAnimating) {
                binding.controlAnimation.text = getString(R.string.play_animation)
                binding.animationView.cancelAnimation()
            } else {
                binding.controlAnimation.text = getString(R.string.stop_animation)
                binding.animationView.playAnimation()
            }
        }
    }
}