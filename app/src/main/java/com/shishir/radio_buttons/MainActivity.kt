package com.shishir.radio_buttons

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var radiobtn: RadioButton
    private lateinit var ratingBar: SeekBar
    private lateinit var showRate: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.radioGroup= findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            radiobtn= findViewById(i)

            when(radiobtn.id){
                R.id.aYes ->{
                    Toast.makeText(this@MainActivity, "Yes Button is Clicked!", Toast.LENGTH_LONG).show()
                }
                R.id.aNo ->{
                    Toast.makeText(this@MainActivity, "No Button is Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.aMaybe ->{
                    Toast.makeText(this@MainActivity, "Maybe Button is Clicked!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        this.ratingBar= findViewById(R.id.rateBar)
        this.showRate= findViewById(R.id.showRate)
        ratingBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@MainActivity, "On Progress", Toast.LENGTH_SHORT).show()
                showRate.text="Rating is: "+ratingBar.progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MainActivity, "Started to Touch", Toast.LENGTH_SHORT).show()
                showRate.text="Rating is: "+ratingBar.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MainActivity, "Stopped Touching", Toast.LENGTH_SHORT).show()
                showRate.text=getString(R.string.fRating)+" "+ratingBar.progress.toString()
            }

        })
    }
}