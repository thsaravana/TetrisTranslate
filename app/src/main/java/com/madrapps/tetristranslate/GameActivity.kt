package com.madrapps.tetristranslate

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class GameActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}