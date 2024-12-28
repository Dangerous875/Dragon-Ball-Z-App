package com.klyxdevs.dragonballzapp.ui.screens.detailScreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klyxdevs.dragonballzapp.domain.model.CharacterDetailModel
import com.klyxdevs.dragonballzapp.domain.usecases.GetCharacterFromApiByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getCharacterFromApiByIdUseCase: GetCharacterFromApiByIdUseCase
) : ViewModel() {

    private val _characterDetail = MutableStateFlow<CharacterDetailModel?>(null)
    val characterDetail = _characterDetail.asStateFlow()

     fun getCharacterById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        val character = getCharacterFromApiByIdUseCase(id)
        _characterDetail.value = character
         Log.i("CharacterDETAILOK", character.toString())
    }

}