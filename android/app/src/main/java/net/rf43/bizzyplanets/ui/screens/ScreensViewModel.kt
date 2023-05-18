package net.rf43.bizzyplanets.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.rf43.bizzyplanets.data.BizzyPlanetsRepository
import net.rf43.bizzyplanets.data.models.PlanetModel
import javax.inject.Inject

@HiltViewModel
class ScreensViewModel @Inject constructor(
    private val repository: BizzyPlanetsRepository
) : ViewModel() {

    private val _allPlanetsStateFlow: MutableStateFlow<List<PlanetModel>> = MutableStateFlow(emptyList())
    val allPlanetsStateFlow: StateFlow<List<PlanetModel>> = _allPlanetsStateFlow

    private val _planetDetailStateFlow: MutableStateFlow<PlanetModel> = MutableStateFlow(PlanetModel())
    val planetDetailStateFlow: StateFlow<PlanetModel> = _planetDetailStateFlow

    fun initPlanets() {
        Log.d("RF43", "initPlanets")
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