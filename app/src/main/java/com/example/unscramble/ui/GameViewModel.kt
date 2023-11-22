package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel: ViewModel(){
    private var _uiState = MutableStateFlow(GameUiState())

    val uiState: StateFlow<GameUiState>
        get() = _uiState.asStateFlow()

    private lateinit var currentWord: String


}