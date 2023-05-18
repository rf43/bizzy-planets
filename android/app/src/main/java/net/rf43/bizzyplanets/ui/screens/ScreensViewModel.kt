package net.rf43.bizzyplanets.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.rf43.bizzyplanets.data.BizzyPlanetsRepository
import net.rf43.bizzyplanets.data.models.Planet
import javax.inject.Inject

@HiltViewModel
class ScreensViewModel @Inject constructor(
    private val repository: BizzyPlanetsRepository
) : ViewModel() {

    private val _allPlanetsStateFlow: MutableStateFlow<List<Planet>> = MutableStateFlow(emptyList())
    val allPlanetsStateFlow: StateFlow<List<Planet>> = _allPlanetsStateFlow

    private val _planetDetailStateFlow: MutableStateFlow<Planet> = MutableStateFlow(Planet("", "", ""))
    val planetDetailStateFlow: StateFlow<Planet> = _planetDetailStateFlow

    fun initPlanets() {
        viewModelScope.launch {
            _allPlanetsStateFlow.value = repository.fetchAllPlanets()
        }
    }

    fun fetchPlanetDetails(planetName: String) {
        viewModelScope.launch {
            _planetDetailStateFlow.value = repository.fetchPlanetDetails(planetName)
        }
    }
}