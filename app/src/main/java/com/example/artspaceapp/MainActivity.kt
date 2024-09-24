package com.example.artspaceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val imageView = arrayOf(
        R.drawable.unnamed,
        R.drawable.unnamed__1_,
        R.drawable.unnamed__2_,
        R.drawable.vincent_van_gogh___wheat_field_with_cypresses___google_art_project,
        R.drawable.wla_metmuseum_water_lilies_by_claude_monet,
    )
    private val textView = arrayOf(
        "Girl with a Pearl Earring by Johannes Vermeer, 1665",
        "Woman with a Parasol - Madame Monet and Her Son by Claude Monet, 1875",
        "Almond Blossoms by Vincent van Gogh, 1889",
        "Wheat Field with Cypresses by Vincent van Gogh, 1889",
        "Water Lilies by Claude Monet, 1873",
    )

    private var currentIndex = 0

    private lateinit var artImageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artImageView = findViewById(R. id.girl)
        descriptionTextView = findViewById(R.id.art)
        nextButton = findViewById(R.id.next)
        prevButton = findViewById(R.id.prev)

        updateContent()

        nextButton.setOnClickListener { changeContent(1) }
        prevButton.setOnClickListener { changeContent(-1) }
    }

    private fun updateContent() {
        artImageView.setImageResource(imageView[currentIndex])
        descriptionTextView.text = textView[currentIndex]
    }

    private fun changeContent(direction: Int) {
        currentIndex = (currentIndex + direction).coerceIn(0, imageView.size - 1)
        updateContent()
    }
}

