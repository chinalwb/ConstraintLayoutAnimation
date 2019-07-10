package com.chinalwb.constraintlayoutanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var constraintLayout: ConstraintLayout? = null
    var tap: ImageView? = null
    var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.constraint)
        tap = findViewById(R.id.backgroundImage)
        tap!!.setOnClickListener {
            if (show) {
                animateToKeyframeOne()
            } else {
                animateToKeyframeTwo()
            }
        }
    }

    fun animateToKeyframeTwo() {
        show = true
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.keyframe_2)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0F)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)
    }

    fun animateToKeyframeOne() {
        show = false
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0F)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)
    }


}
