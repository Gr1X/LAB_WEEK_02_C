package com.umn.lab_week_02_c

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    companion object{
        private const val DEBUG_TAG = "MainActivityDebug"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Called enableEdgeToEdge
        setContentView(R.layout.activity_main)

        // Apply window insets listener for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(DEBUG_TAG, "onCreate")

        val buttonClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.button_standard -> {
                    Log.d(DEBUG_TAG, "Standard Activity button clicked")
                    startActivity(
                        Intent(this, StandardActivity::class.java)
                    )
                }
                R.id.button_single_top -> {
                    Log.d(DEBUG_TAG, "SingleTop Activity button clicked")
                    startActivity(
                        Intent(this, SingleTopActivity::class.java)
                    )
                }
            }
        }

        findViewById<Button>(R.id.button_standard).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button_single_top).setOnClickListener(buttonClickListener)
    }
}
