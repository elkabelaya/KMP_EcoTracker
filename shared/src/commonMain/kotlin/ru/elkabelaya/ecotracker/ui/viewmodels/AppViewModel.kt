package ru.elkabelaya.ecotracker.ui.viewmodels

import RequestPermissionUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AppViewModel(
    private val requestPermissionUseCase: RequestPermissionUseCase,
) : ViewModel() {
    init {
        viewModelScope.launch {
            requestPermissionUseCase.invoke()
        }
    }
}
