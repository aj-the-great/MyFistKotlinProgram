package com.example.spacecurators
import kotlin.random.Random

class Person {
    private var sex: Char = ' '
    private var name: String = ""
    private var intel: Int = 0
    private var happi: Int = 0
    private var loyal: Int = 0
    private var influ: Int = 0
    private var ambit: String = ""
    private var morta: Boolean = true

    fun init (worldInt: Int, worldHap: Int, worldLoy: Int, worldAdv: Int, worldHea: Int, worldEnv: Int, worldAtt: Int, worldDef: Int) {
        val randVals = List(7) { Random.nextInt(0, 10) }

        //Set sex (odd number = boy, even number = girl)
        sex = 'F'
        if (randVals[0] % 2 == 1) {
            sex = 'M'
        }

        //Set name
        if (worldAdv < 1000) {
            if (sex == 'M'){
                when (randVals[1]) {
                    0 -> name = "Vid"
                    1 -> name = "Tokk"
                    2 -> name = "Ghuc"
                    3 -> name = "Giag"
                    4 -> name = "Turk"
                    5 -> name = "Zivik"
                    6 -> name = "Ozzac"
                    7 -> name = "Jargoud"
                    8 -> name = "Tatted"
                    9 -> name = "Krattug"
                }
            }
            else {
                when (randVals[1]) {
                    0 -> name = "Skigya"
                    1 -> name = "Osa"
                    2 -> name = "Azhah"
                    3 -> name = "Ebe"
                    4 -> name = "Ratyu"
                    5 -> name = "Jaasoe"
                    6 -> name = "Dirtha"
                    7 -> name = "Dasa"
                    8 -> name = "Zelmu"
                    9 -> name = "Lini"
                }
            }
        }
        else if (worldAdv < 2000) {
            if (sex == 'M'){
                when (randVals[1]) {
                    0 -> name = "Jerry Benjamin"
                    1 -> name = "Johnnie Monroe"
                    2 -> name = "Guy Fisher"
                    3 -> name = "Carl Foster"
                    4 -> name = "Karl Ballard"
                    5 -> name = "Joseph England"
                    6 -> name = "Matthew Holman"
                    7 -> name = "Oscar Melton"
                    8 -> name = "Casey Crane"
                    9 -> name = "Mark Armstrong"
                }
            }
            else {
                when (randVals[1]) {
                    0 -> name = "Julia Keith"
                    1 -> name = "Eula Richardson"
                    2 -> name = "Gloria Booker"
                    3 -> name = "Glenda Johnson"
                    4 -> name = "Vicky O'Connor"
                    5 -> name = "Carole Miller"
                    6 -> name = "Bridget Harrison"
                    7 -> name = "Dominique Cain"
                    8 -> name = "Desiree Baldwin"
                    9 -> name = "Meghan Gross"
                }
            }
        }
        else {
            if (sex == 'M'){
                when (randVals[1]) {
                    0 -> name = "Jesslow Devigbo"
                    1 -> name = "Embry Ullani"
                    2 -> name = "Samlor Xylix"
                    3 -> name = "Emsen Berisha"
                    4 -> name = "Pactin Melmusa"
                    5 -> name = "Angan Endrick"
                    6 -> name = "Kenton Pérez"
                    7 -> name = "Brynak Undan"
                    8 -> name = "Ibrakov Xulov"
                    9 -> name = "Tarun de Silva"
                }
            }
            else {
                when (randVals[1]) {
                    0 -> name = "Estellotte Iganox"
                    1 -> name = "Nimonia Evercia"
                    2 -> name = "Valani Eddix"
                    3 -> name = "Prasha Jansen"
                    4 -> name = "Darissia Zhu"
                    5 -> name = "Soluri Esposito"
                    6 -> name = "Genna Tabani"
                    7 -> name = "Jade Akerjee"
                    8 -> name = "Maddecca Lahro"
                    9 -> name = "Rebka Jahembu"
                }
            }
        }

        //Set intelligence
        intel = ((2 * randVals[2]) + worldInt) / 3

        //Set happiness
        happi = ((2 * randVals[3]) + worldHap) / 3

        //Set loyalty
        loyal = ((2 * randVals[4]) + worldLoy) / 3

        //Set influence
        influ = 1 + randVals[5]

        //Set Ambition (Character Ambition is partially motivated by the state of their planet and population)
        // world domination
        var wdChance: Int = -intel - happi - loyal + 5
        if (wdChance < 0)
            wdChance = 0
        // save the planet
        var spChance: Int = intel - worldHea - worldEnv + 5
        if (spChance < 0)
            spChance = 0
        // world peace
        var wpChance: Int = loyal + worldHea - worldDef + 5
        if (wpChance < 0)
            wpChance = 0
        // become famous
        val bfChance: Int = randVals[6] + 10
        // pursuit of happiness
        var phChance: Int = -happi + worldEnv + 10
        if (phChance < 0)
            phChance = 0
        // pursuit of science
        var psChance: Int = intel - worldAtt - worldDef + 5
        if (psChance < 0)
            psChance = 0
        // build utopia
        var buChance: Int = worldEnv - worldAtt + worldDef + 5
        if (buChance < 0)
            buChance = 0
        // alien overlords
        var aoChance: Int = happi + loyal + worldHea + 5
        if (aoChance < 0)
            aoChance = 0

        val totChance = wdChance + spChance + wpChance + bfChance + phChance + psChance + buChance + aoChance
        val randAmbit = Random.nextInt(0, totChance)

        if (randAmbit < wdChance) {
            ambit = "World Domination"
        }
        else if (randAmbit < wdChance + spChance) {
            ambit = "Save the Planet"
        }
        else if (randAmbit < wdChance + spChance + wpChance) {
            ambit = "World Peace"
        }
        else if (randAmbit < wdChance + spChance + wpChance + bfChance) {
            ambit = "Become Famous"
        }
        else if (randAmbit < wdChance + spChance + wpChance + bfChance + phChance) {
            ambit = "Pursuit of Happiness"
        }
        else if (randAmbit < wdChance + spChance + wpChance + bfChance + phChance + psChance) {
            ambit = "Pursuit of Science"
        }
        else if (randAmbit < wdChance + spChance + wpChance + bfChance + phChance + psChance + buChance) {
            ambit = "Build Utopia"
        }
        else {
            ambit = "Alien Overlords"
        }
    }

    fun getSex() : Char {
        return sex
    }

    fun getName () : String {
        return name
    }

    fun getIntel () : Int {
        return intel
    }

    fun incIntel () {
        intel += 1
    }

    fun decIntel () {
        intel -= 1
    }

    fun getHappi() : Int {
        return happi
    }

    fun incHappi () {
        happi += 1
    }

    fun decHappi () {
        happi -= 1
    }

    fun getLoyal() : Int {
        return loyal
    }

    fun incLoyal () {
        loyal += 1
    }

    fun decLoyal () {
        loyal -= 1
    }

    fun getInflu () : Int {
        return influ
    }

    fun incInflu () {
        influ += 1
    }

    fun decInflu () {
        if (influ > 0) {
            influ -= 1
        }
    }

    fun getAmbit () : String {
        return ambit
    }

    fun getMorta () : Boolean {
        return morta
    }

    fun setMorta (m: Boolean) {
        morta = m
    }
}