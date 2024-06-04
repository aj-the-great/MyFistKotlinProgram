package com.example.spacecurators

import kotlin.math.cbrt

class Population {
    private var size: Int = 0
    private var intelligence: Int = 0
    private var happiness: Int = 0
    private var loyalty: Int = 0
    private var advancement: Int = 0

    fun init () {
        size = 100
    }

    fun getSize (): Int {
        return size
    }

    fun incSize (worldEnv: Int): Boolean {
        if (size < 10000000) {
            size += 1 + (size + 25 * (worldEnv + happiness)) / 20
            return true
        }
        return false
    }

    fun decSize (damage: Int): Boolean {
        size -= 1 + (size / 25) * damage
        if (size > 0) {
            return true
        }
        return false
    }

    fun getIntel (): Int {
        return intelligence
    }

    fun incIntel (): Boolean {
        if (intelligence < 25) {
            intelligence += 1
            return true
        }
        return false
    }

    fun decIntel (): Boolean {
        if (intelligence > -25) {
            intelligence -= 1
            return true
        }
        return false
    }

    fun getHappi (): Int {
        return happiness
    }

    fun incHappi (): Boolean {
        if (happiness < 25) {
            happiness += 1
            return true
        }
        return false
    }

    fun decHappi (): Boolean {
        if (happiness > -25) {
            happiness -= 1
            return true
        }
        return false
    }

    fun getLoyal (): Int {
        return loyalty
    }

    fun incLoyal (): Boolean {
        if (loyalty < 25) {
            loyalty += 1
            return true
        }
        return false
    }

    fun decLoyal (): Boolean {
        if (loyalty > -25) {
            loyalty -= 1
            return true
        }
        return false
    }

    fun getAdvanc (): Int {
        return advancement
    }

    fun incAdvanc (): Boolean {
        if (advancement < 3000) {
            advancement += 1 + 5 * intelligence + cbrt(size.toDouble()).toInt()
            return true
        }
        return false
    }

    fun decAdvanc (): Boolean {
        if (advancement >= 10) {
            advancement -= advancement / 10
            return true
        }
        return false
    }
}