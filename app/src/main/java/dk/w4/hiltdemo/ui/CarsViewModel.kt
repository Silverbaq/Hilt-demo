package dk.w4.hiltdemo.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dk.w4.hiltdemo.data.CarRepository
import dk.w4.hiltdemo.data.model.Car

@ActivityRetainedScoped
class CarsViewModel @ViewModelInject constructor(
    private val carRepository: CarRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _carsLiveData: MutableLiveData<List<Car>> = MutableLiveData()
    val carsLiveData: LiveData<List<Car>> = _carsLiveData

    fun onViewReady() {
        _carsLiveData.postValue(carRepository.getCars())
    }

}