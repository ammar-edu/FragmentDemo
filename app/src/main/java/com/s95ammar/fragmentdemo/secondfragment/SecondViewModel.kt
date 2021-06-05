package com.s95ammar.fragmentdemo.secondfragment

import android.util.Log
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    init {
        Log.d("SecondViewModel", "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("SecondViewModel", "onCleared")
    }
}