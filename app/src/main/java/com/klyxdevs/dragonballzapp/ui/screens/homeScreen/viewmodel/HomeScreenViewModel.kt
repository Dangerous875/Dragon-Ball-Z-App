package com.klyxdevs.dragonballzapp.ui.screens.homeScreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klyxdevs.dragonballzapp.domain.GetAllCharactersFromApiUseCase
import com.klyxdevs.dragonballzapp.domain.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCharactersFromApiUseCase: GetAllCharactersFromApiUseCase
) :
    ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()
    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _characters.value = getAllCharactersFromApiUseCase()
                _isLoading.value = false
            }
        }
    }
}