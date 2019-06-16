package com.madrapps.tetristranslate.play

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.lifecycle.Observer
import com.madrapps.tetristranslate.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_play.*
import javax.inject.Inject

class PlayFragment : DaggerFragment(), View.OnClickListener {

    @Inject
    lateinit var viewModel: PlayViewModel

    private lateinit var animator: ObjectAnimator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListeners()
        viewModel.currentScore.observe(this, Observer {
            score.text = it.toString()
        })

        answerContainer.viewTreeObserver.addOnGlobalLayoutListener {
            val height = answerContainer.height
            animator = ObjectAnimator.ofFloat(answer, "y", 0f, height.toFloat()).apply {
                duration = 1000
                interpolator = LinearInterpolator()
                start()
            }

            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    answer.y = 0f
                }

                override fun onAnimationCancel(animation: Animator?) {
                    answer.y = 0f
                }

                override fun onAnimationStart(animation: Animator?) {

                }
            })
        }
    }

    private fun setListeners() {
        btnTrue.setOnClickListener(this)
        btnFalse.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnTrue -> {
                animator.start()
            }
            R.id.btnFalse -> {
                animator.start()
            }
        }
    }
}
