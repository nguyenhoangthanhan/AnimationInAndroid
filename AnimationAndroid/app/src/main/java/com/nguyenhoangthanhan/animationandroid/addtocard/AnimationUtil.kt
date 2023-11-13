package com.nguyenhoangthanhan.animationandroid.addtocard

import android.graphics.Bitmap
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView

object AnimationUtil {
    private const val ANIMATION_DURATION = 1000L
    private var isAnimationStart: Boolean? = null;

    fun translateAnimation(
        viewAnimation: ImageView,
        startView: View,
        endView: View,
        animationListener: Animation.AnimationListener?
    ) {
        startView.isDrawingCacheEnabled = true
        val cache = startView.drawingCache ?: return

        val bitmap = Bitmap.createBitmap(cache)
        startView.isDrawingCacheEnabled = false

        viewAnimation.setImageBitmap(bitmap)

        val startViewWidthCenter = startView.width / 2
        val startViewHeightCenter = startView.height / 2

        val endViewWidthCenter = endView.width * 0.75f
        val endViewHeightCenter = endView.height / 2f

        val startPos = IntArray(2)
        startView.getLocationOnScreen(startPos)

        val endPos = IntArray(2)
        endView.getLocationOnScreen(endPos)

        val fromX:Float = startPos[0].toFloat()
        val toX:Float = endPos[0] + endViewWidthCenter - startViewWidthCenter
        val fromY:Float = startPos[1].toFloat() - startViewHeightCenter
        val toY:Float = endPos[1] - endViewHeightCenter + startViewHeightCenter

        val animationSet = AnimationSet(true)
        animationSet.interpolator = AccelerateInterpolator()

        val animationDuration = 200L

        val startScaleAnimation = ScaleAnimation(
            1.0f, 1.5f, 1f, 1.5f,
            startViewWidthCenter.toFloat(), startViewHeightCenter.toFloat()
        )
        startScaleAnimation.duration = animationDuration

        val translateAnimation = TranslateAnimation(fromX, toX, fromY, toY)
        translateAnimation.startOffset = animationDuration
        translateAnimation.duration = ANIMATION_DURATION

        val translateScaleAnimation = ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, toX, toY)
        translateScaleAnimation.startOffset = animationDuration
        translateScaleAnimation.duration = ANIMATION_DURATION

        animationSet.addAnimation(startScaleAnimation)
        animationSet.addAnimation(translateAnimation)
        animationSet.addAnimation(translateScaleAnimation)

        if (isAnimationStart == true){
            viewAnimation.clearAnimation()
            animationListener?.onAnimationEnd(null)
        }

        viewAnimation.startAnimation(animationSet)

        animationSet.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                isAnimationStart = true

                viewAnimation.visibility = View.VISIBLE
                startView.visibility = View.INVISIBLE

                animationListener?.onAnimationStart(p0)

            }

            override fun onAnimationEnd(p0: Animation?) {
                viewAnimation.visibility = View.GONE
                startView.visibility = View.VISIBLE

                animationListener?.onAnimationEnd(p0)

                isAnimationStart = false
            }

            override fun onAnimationRepeat(p0: Animation?) {
                animationListener?.onAnimationRepeat(p0)
            }

        })
    }
}