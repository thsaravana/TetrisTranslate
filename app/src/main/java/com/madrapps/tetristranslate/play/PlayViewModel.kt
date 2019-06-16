package com.madrapps.tetristranslate.play

import androidx.lifecycle.LiveData

interface PlayViewModel {

    val currentScore: LiveData<Int>
}