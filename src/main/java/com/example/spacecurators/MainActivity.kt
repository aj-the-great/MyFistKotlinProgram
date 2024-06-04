package com.example.spacecurators

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacecurators.ui.theme.SpaceCuratorsTheme

class MainActivity : ComponentActivity(), View.OnClickListener {

    private lateinit var buttonContainer: LinearLayout
    private lateinit var buttonInteractPopulation: Button
    private lateinit var buttonInteractPlanet: Button
    //private lateinit var buttonInteractSpecialPeople: Button
    private lateinit var buttonSkipTime: Button

    var planet: Planet = Planet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        planet.init()
        setContent {
            setContentView(R.layout.activity_main)

            buttonContainer = findViewById(R.id.buttonContainer)
            buttonInteractPopulation = findViewById(R.id.interactPopulationButton)
            buttonInteractPlanet = findViewById(R.id.interactPlanetButton)
            //buttonInteractSpecialPeople = findViewById(R.id.interactSpecialPeopleButton)
            buttonSkipTime = findViewById(R.id.skipTimeButton)

            buttonInteractPopulation.setOnClickListener(this)
            buttonInteractPlanet.setOnClickListener(this)
            //buttonInteractSpecialPeople.setOnClickListener(this)
            buttonSkipTime.setOnClickListener(this)

            var text = findViewById<TextView>(R.id.textBox)
            text.text = "Planet Created\n" + planet.getAnalysis()
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.interactPopulationButton -> {
                showPopulationButtons()
            }
            R.id.interactPlanetButton -> {
                showPlanetButtons()
            }
            R.id.skipTimeButton -> {
                planet.skipTime(5)
                var text = findViewById<TextView>(R.id.textBox)
                text.text = planet.getAnalysis()
            }
        }
    }

    private fun showPopulationButtons() {
        var text = findViewById<TextView>(R.id.textBox)

        // Define the buttons for interacting with the population
        val buttonTeachScience = Button(this)
        buttonTeachScience.text = "Teach Science"

        val buttonGiveBlessings = Button(this)
        buttonGiveBlessings.text = "Give Blessings"

        val buttonAssertAuthority = Button(this)
        buttonAssertAuthority.text = "Assert Authority"

        val buttonCreateHumans = Button(this)
        buttonCreateHumans.text = "Create Humans"

        val buttonBack = Button(this)
        buttonBack.text = "Back"

        // Handle button clicks for population interaction
        buttonTeachScience.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.pop.incIntel()
                text.text = planet.getAnalysis()
            }
        }

        buttonGiveBlessings.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.pop.incHappi()
                text.text = planet.getAnalysis()
            }
        }

        buttonAssertAuthority.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.pop.incLoyal()
                text.text = planet.getAnalysis()
            }
        }

        buttonCreateHumans.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.pop.incSize(planet.environment)
                text.text = planet.getAnalysis()
            }
        }

        buttonBack.setOnClickListener {
            buttonContainer.removeAllViews()
            buttonContainer.addView(buttonInteractPopulation)
            buttonContainer.addView(buttonInteractPlanet)
            //buttonContainer.addView(buttonInteractSpecialPeople)
            buttonContainer.addView(buttonSkipTime)
        }

        buttonContainer.removeAllViews()
        buttonContainer.addView(buttonTeachScience)
        buttonContainer.addView(buttonGiveBlessings)
        buttonContainer.addView(buttonAssertAuthority)
        buttonContainer.addView(buttonCreateHumans)
        buttonContainer.addView(buttonBack)
    }

    private fun showPlanetButtons() {
        var text = findViewById<TextView>(R.id.textBox)

        // Define the buttons for interacting with the planet
        val buttonBuildWeapons = Button(this)
        buttonBuildWeapons.text = "Build Weapons"

        val buttonRebuildPlanet = Button(this)
        buttonRebuildPlanet.text = "Rebuild Planet"

        val buttonImproveEnvironment = Button(this)
        buttonImproveEnvironment.text = "Improve Environment"


        val buttonBack = Button(this)
        buttonBack.text = "Back"

        // Handle button clicks for planet interaction
        buttonBuildWeapons.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.attack += 1
                text.text = planet.getAnalysis()
            }
        }

        buttonRebuildPlanet.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.health += 1
                text.text = planet.getAnalysis()
            }
        }

        buttonImproveEnvironment.setOnClickListener {
            if (planet.actions > 0) {
                planet.actions -= 1
                planet.environment += 1
                text.text = planet.getAnalysis()
            }
        }

        buttonBack.setOnClickListener {
            buttonContainer.removeAllViews()
            buttonContainer.addView(buttonInteractPopulation)
            buttonContainer.addView(buttonInteractPlanet)
            //buttonContainer.addView(buttonInteractSpecialPeople)
            buttonContainer.addView(buttonSkipTime)
        }


        buttonContainer.removeAllViews()
        buttonContainer.addView(buttonBuildWeapons)
        buttonContainer.addView(buttonRebuildPlanet)
        buttonContainer.addView(buttonImproveEnvironment)
        buttonContainer.addView(buttonBack)
    }

    private fun showSpecialPeopleButtons() {
        // Define the buttons for interacting with the Special People

        val buttonBack = Button(this)
        buttonBack.text = "Back"

        // Handle button clicks for population interaction
        buttonBack.setOnClickListener {

        }

        buttonBack.setOnClickListener {
            buttonContainer.removeAllViews()
            buttonContainer.addView(buttonInteractPopulation)
            buttonContainer.addView(buttonInteractPlanet)
            //buttonContainer.addView(buttonInteractSpecialPeople)
            buttonContainer.addView(buttonSkipTime)
        }


        buttonContainer.removeAllViews()
        buttonContainer.addView(buttonBack)
    }
}