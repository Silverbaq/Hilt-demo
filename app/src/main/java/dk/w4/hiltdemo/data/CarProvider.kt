package dk.w4.hiltdemo.data

import dk.w4.hiltdemo.data.model.*
import javax.inject.Inject

class CarProvider @Inject constructor() {

    fun makeCar(title: String, engine: EngineType, frontTires: TireType, rearTires: TireType): Car {
        val car = Car(title, Engine(engine), Pair(Tire(12, frontTires), Tire(13, rearTires)))
        return car
    }

    fun getCars(amount: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(amount){
            cars.add(makeCar("Car $it", EngineType.V6, TireType.RUBBER, TireType.RUBBER))
        }
        return cars
    }
}