package net.rf43.bizzyplanets.ui.screens

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

    private val _homeContentTitle: MutableStateFlow<String> = MutableStateFlow("")
    val homeContentTitle: StateFlow<String> = _homeContentTitle

    private val _homeContentSubtitle: MutableStateFlow<String> = MutableStateFlow("")
    val homeContentSubtitle: StateFlow<String> = _homeContentSubtitle

    private val _allPlanetsStateFlow: MutableStateFlow<List<PlanetModel>> = MutableStateFlow(emptyList())
    val allPlanetsStateFlow: StateFlow<List<PlanetModel>> = _allPlanetsStateFlow

    private val _planetDetailStateFlow: MutableStateFlow<PlanetModel> = MutableStateFlow(PlanetModel())
    val planetDetailStateFlow: StateFlow<PlanetModel> = _planetDetailStateFlow

    init {
        viewModelScope.launch {
            repository.fetchContentData()
            _homeContentTitle.value = repository.fetchHomeTitle()
            _homeContentSubtitle.value = repository.fetchHomeSubtitle()
            _allPlanetsStateFlow.value = repository.fetchAllPlanets()
        }
    }

    fun fetchPlanetDetails(planetName: String) {
        viewModelScope.launch {
            _planetDetailStateFlow.value = repository.fetchPlanetDetails(planetName)
        }
    }
}