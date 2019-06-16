package com.madrapps.tetristranslate.play

import android.animation.Animator
import android.animation.ValueAnimator
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

    private lateinit var animator: ValueAnimator

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
            val step = height / 10f
            animator = ValueAnimator.ofFloat(0f, height.toFloat()).apply {
                duration = 10000 / 2
                interpolator = LinearInterpolator()
                setFloatValues(
                    0f, 0f, step * 1, step * 1, step * 2, step * 2, step * 3, step * 3, step * 4, step * 4,
                    step * 5, step * 5, step * 6, step * 6, step * 7, step * 7, step * 8, step * 8, step * 9, step * 9
                )
                addUpdateListener {
                    answer.y = it.animatedValue as Float
                }
                repeatCount = 5
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
