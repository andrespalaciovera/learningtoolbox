package com.example.learningtoolbox.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PanelViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Panel Fragment"
    }
    val text: LiveData<String> = _text
}