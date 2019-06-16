package com.madrapps.tetristranslate.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.madrapps.tetristranslate.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_play.*
import javax.inject.Inject

class PlayFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: PlayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.currentScore.observe(this, Observer {
            score.text = it.toString()
        })
    }
}
