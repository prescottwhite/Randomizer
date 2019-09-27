package puulr.com.randomizer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button to "roll" new random number
        val rollButton = findViewById<Button>(R.id.rollButton)
        //shows the random number
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        //the SeekBar for changing the range
        val seekerBar = findViewById<SeekBar>(R.id.seekerBar)
        //shows the range of values
        val rangeTextView = findViewById<TextView>(R.id.rangeTextView)

        //show range value on startup
        rangeTextView.text = (seekerBar.progress + 1).toString()

        //listen for changes to seekerBar and show in rangeTextView
        seekerBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rangeTextView.text = (progress + 1).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Toast.makeText(this@MainActivity, "Slide to change range", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        //listen for clicks on rollButton and generate random value, display in resultsTextView
        rollButton.setOnClickListener {
            val rand = java.util.Random().nextInt(seekerBar.progress + 1) + 1
            resultsTextView.text = rand.toString()
        }

    }
}
