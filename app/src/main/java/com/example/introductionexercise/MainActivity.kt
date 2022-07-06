package com.example.introductionexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    /** Variable to count number of clicks on the button **/
    var numClicks = 0
    var userName = ""

    /** Layout elements **/
    lateinit var editTextTextPersonName: EditText
    lateinit var textTitle: TextView
    lateinit var changeImageButton: Button
    lateinit var myLayout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Initializing the layout elements **/
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName)
        textTitle = findViewById(R.id.textTitle)
        changeImageButton = findViewById(R.id.changeImageButton)
        myLayout = findViewById(R.id.myLayout)

        /** Setting the primary background image **/
        toggleBackgroundImage()

        /** Initializing the listeners **/
        prepareListeners()
    }

    fun prepareListeners() {
        editTextTextPersonName.addTextChangedListener {
            userName = it.toString()
            updateTitleText()
        }
        changeImageButton.setOnClickListener {
            numClicks++
            toggleBackgroundImage()
            updateTitleText()
        }

    }

    private fun toggleBackgroundImage() {
        when (numClicks % 3) {
            0 -> myLayout.background = getDrawable(R.drawable.image1)
            1 -> myLayout.background = getDrawable(R.drawable.image2)
            else -> myLayout.background = getDrawable(R.drawable.image3)
        }
    }

    private fun updateTitleText() {
        textTitle.text = "$userName - $numClicks"
    }
}