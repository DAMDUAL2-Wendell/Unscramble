package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel: ViewModel(){
    private var _uiState = MutableStateFlow(GameUiState())

    val uiState: StateFlow<GameUiState>
        get() = _uiState.asStateFlow()

    private lateinit var currentWord: String

    private var usedWords: MutableSet<String> = mutableSetOf()

    init {
        resetGame()
    }

    private fun shuffleCurrentWord(word: String): String{
        val tempWord = word.toCharArray()
        while(String(tempWord) == word){
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame(){
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambleWord = pickRandomWordAndShuffle())
    }

    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random()
        return shuffleCurrentWord(currentWord)
    }


}