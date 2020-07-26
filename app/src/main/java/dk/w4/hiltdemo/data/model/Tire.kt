package dk.w4.hiltdemo.data.model

data class Tire(val size: Int, val type: TireType)

enum class TireType {
    RUBBER, WOOD, PLASTIC
}