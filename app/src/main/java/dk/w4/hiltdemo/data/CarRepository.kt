package dk.w4.hiltdemo.data

import dk.w4.hiltdemo.data.model.Car
import dk.w4.hiltdemo.data.model.EngineType
import dk.w4.hiltdemo.data.model.TireType
import javax.inject.Inject

class CarRepository @Inject constructor(private val carProvider: CarProvider) {
    private val cars = carProvider.getCars(10).toMutableList()

    fun getCars() = cars.toList()

    fun applyCar(title: String, engine: EngineType, frontTires: TireType, rearTires: TireType): List<Car> {
        cars.add(carProvider.makeCar(title, engine, frontTires, rearTires))
        return cars
    }
}