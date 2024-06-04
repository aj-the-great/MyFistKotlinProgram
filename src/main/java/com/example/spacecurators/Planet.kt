package com.example.spacecurators

import kotlin.random.Random

class Planet {
    public var health: Int = 0
    public var environment: Int = 0
    public var attack: Int = 0
    public var defense: Int = 0

    public var pop = Population()
    private var specials: MutableList<Person> = mutableListOf()

    public var actions = 5

    fun init () {
        pop.init()
        health = 500
        environment = 5
    }

    fun skipTime (years: Int) {
        var timeLeft = years
        var rand: Int
        actions = 5

        while (timeLeft > 0) {
            rand = Random.nextInt(0, 100)
            if (rand < 5) {
                //Special person born
                spawnSpecial()
            } else if (rand < 10) {
                //Special person affects
                specialInfluence()
            } else if (rand < 15) {
                //Special person death
                if (specials.isNotEmpty()) {
                    rand = Random.nextInt(0, specials.size)
                    if (specials[rand].getMorta()) {
                        specials.removeAt(rand)
                    }
                }
            } else if (rand < 20) {
                //Population size change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    pop.incSize(environment)
                }
                else {
                    pop.decSize(environment)
                }
            } else if (rand < 25) {
                //Population intelligence change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    pop.incIntel()
                }
                else {
                    pop.decIntel()
                }
            } else if (rand < 30) {
                //Population happiness change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    pop.incHappi()
                }
                else {
                    pop.decIntel()
                }
            } else if (rand < 35) {
                //Population loyalty change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    pop.incLoyal()
                }
                else {
                    pop.decLoyal()
                }
            } else if (rand < 40) {
                //Population advancement change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    pop.incAdvanc()
                }
                else {
                    pop.decAdvanc()
                }
            } else if (rand < 45) {
                //Planet health change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    health += 1
                }
                else {
                    health -= 1
                }
            } else if (rand < 50) {
                //Planet environment change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    environment += 1
                }
                else {
                    environment -= 1
                }
            } else if (rand < 55) {
                //Planet attack change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    attack += 1
                }
                else {
                    attack -= 1
                }
            } else if (rand < 60) {
                //Planet defence change
                rand = Random.nextInt(0, 5)
                if (rand < 3) {
                    defense += 1
                }
                else {
                    defense -= 1
                }
            }

            timeLeft -= 1
        }
    }

    private fun spawnSpecial () {
        if (specials.size < 5) {
            val p: Person = Person()
            p.init(pop.getIntel(), pop.getHappi(), pop.getLoyal(), pop.getAdvanc(), health, environment, attack, defense)
            specials.add(p)
        }
    }

    private fun specialInfluence () {
        var intelDif: Int = 0
        var happiDif: Int = 0
        var loyalDif: Int = 0

        var i: Int

        for (p in specials) {
            i = p.getInflu()
            while (i >= 0) {
                if (p.getIntel() * 2 > pop.getIntel()) {
                    intelDif += 1
                }
                else if (p.getIntel() < pop.getIntel()) {
                    intelDif -= 1
                }

                if (p.getHappi() * 2 > pop.getHappi()) {
                    happiDif += 1
                }
                else if (p.getHappi() < pop.getHappi()) {
                    happiDif -= 1
                }

                if (p.getLoyal() * 2 > pop.getLoyal()) {
                    loyalDif += 1
                }
                else if (p.getLoyal() < pop.getLoyal()) {
                    loyalDif -= 1
                }

                i--
            }

            if (p.getAmbit() == "World Domination") {
                p.incInflu()
                p.decLoyal()

                pop.decSize(1)
                pop.decHappi()

                attack += 5
            }
            else if (p.getAmbit() == "Save the Planet") {
                p.decHappi()
                p.decLoyal()

                pop.incSize(environment)

                health += 1
                environment += 1
            }
            else if (p.getAmbit() == "World Peace") {
                p.decInflu()

                pop.incHappi()
                pop.incAdvanc()
                pop.incIntel()

                if (attack > 0)
                    attack -= 1
            }
            else if (p.getAmbit() == "Become Famous") {
                p.incInflu()
                p.incIntel()
                p.incHappi()
                p.incLoyal()

                pop.decAdvanc()
            }
            else if (p.getAmbit() == "Pursuit of Happiness") {
                p.incHappi()

                pop.incAdvanc()
                pop.incHappi()
                pop.decLoyal()

                environment += 1
            }
            else if (p.getAmbit() == "Pursuit of Science") {
                p.incIntel()
                p.decHappi()

                pop.incIntel()
                pop.incAdvanc()

                attack += 1
            }
            else if (p.getAmbit() == "Build Utopia") {
                p.incLoyal()
                p.incIntel()

                pop.incAdvanc()
                pop.incHappi()

                environment += 1
            }
            else if (p.getAmbit() == "Alien Overlords") {
                p.incLoyal()
                p.incInflu()

                pop.incSize(environment)
                pop.incAdvanc()

                defense += 1
            }
        }

        while (intelDif != 0) {
            if (intelDif > 0) {
                pop.incIntel()
                intelDif -=1
            }
            else {
                pop.decIntel()
                intelDif +=1
            }
        }

        while (happiDif != 0) {
            if (happiDif > 0) {
                pop.incHappi()
                happiDif -=1
            }
            else {
                pop.decHappi()
                happiDif +=1
            }
        }

        while (loyalDif != 0) {
            if (loyalDif > 0) {
                pop.incLoyal()
                loyalDif -=1
            }
            else {
                pop.decLoyal()
                loyalDif +=1
            }
        }

    }

    public fun getAnalysis (): String {
        var str: String = "You have " + actions + " actions left\n"
        str += "\nPlanet health: " + health +
                "\nPlanet environment: " + environment +
                "\nAttack power: " + attack +
                "\nDefense power: " + defense +
                "\nPopulation number: " + pop.getSize() +
                "\nPopulation loyalty: " + pop.getLoyal() +
                "\nPopulation happiness: " + pop.getHappi() +
                "\nPopulation intel: " + pop.getIntel() +
                "\nPopulation advancement: " + pop.getAdvanc()

        for (person in specials) {
            str += "\n" + person.getName() + ": " +
                    "\n\tIntelligence: " + person.getIntel() +
                    "\n\tHappiness: " + person.getHappi() +
                    "\n\tLoyalty: " + person.getLoyal() +
                    "\n\tInfluence: " + person.getInflu() +
                    "\n\tAmbition: " + person.getAmbit()
        }

        return str
    }
}