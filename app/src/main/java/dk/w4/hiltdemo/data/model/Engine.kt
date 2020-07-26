package dk.w4.hiltdemo.data.model

data class Engine(val type: EngineType)

enum class EngineType { V6, V8, V12 }