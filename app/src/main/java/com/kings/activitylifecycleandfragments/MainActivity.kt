package com.kings.activitylifecycleandfragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    //Declaring variables to be initialized later in the code
    private lateinit var orientation: TextView
    private lateinit var orientationCount: TextView
    private lateinit var status: TextView
    private lateinit var button: Button

    //assigning handler method to a variable to be called in all instances where handler is applied
    var handler = Handler()

    //Companion object to hold static count of orientation changes, so it remains the same even after onDestroyed is called
    companion object {
        var count: Int = -1
    }


    /**
     * Overriding the onCreate() method
     *Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instantiation of buttons and and text views when activity is created
        button = findViewById(R.id.fragmentsButton)
        orientation = findViewById(R.id.orientation)
        orientationCount = findViewById(R.id.orientationCountTextView)

        //Calling the configuration method when activity is created
        configurationCount()


        //Setting On click listener to
        button.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        //Setting text to be displayed when activity is created
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = "Create"
            //Toast.makeText(this, "Create", Toast.LENGTH_LONG).show()
        }, 1000)
    }

    /**
     *Overriding the onStart Method
     * Assigning text to display when activity is started
     * Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onStart() {
        super.onStart()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = getString(R.string.start)
            //Toast.makeText(this, getString(R.string.start), Toast.LENGTH_LONG).show()
        }, 1400)

    }

    /**
     *Overriding the onResume Method
     * Assigning a message to display when activity id resumed
     * Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = getString(R.string.resume)
            //Toast.makeText(this, getString(R.string.resume), Toast.LENGTH_LONG).show()
        }, 1800)
    }

    /**
     *Overriding the onPause Method
     * Assigning a message to display when activity is paused
     * Using handler to delay the activity at this callback method so text display can be seen
     */
    override fun onPause() {
        super.onPause()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = "Paused"
            //Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show()
        }, 2000)
    }

    /**
     *Overriding the onRestart Method
     * Assigning a message to display when activity is restarted
     * Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onRestart() {
        super.onRestart()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = "Restarted"
            //Toast.makeText(this, "Restarted", Toast.LENGTH_LONG).show()
        }, 2000)
    }

    /**
     *Overriding the onStop Method
     * Assigning a message to Display when activity is stopped
     * Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onStop() {
        super.onStop()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = "Stopped"
            //Toast.makeText(this, "Stopped", Toast.LENGTH_LONG).show()
        }, 2200)
    }

    /**
     *Overriding the onDestroy Method
     * Assigning a message to display when activity id destroyed
     * Using handler to delay the activity at this callback method so text display can be seen
     */

    override fun onDestroy() {
        super.onDestroy()
        handler.postDelayed({
            status = findViewById(R.id.status)
            status.text = "Destroyed"
            //Toast.makeText(this, "Destroyed", Toast.LENGTH_LONG).show()
        }, 3000)

    }

    /**
     * Function declaration for handling Orientation Change Messages and count
     *
     */

    private fun configurationCount () {

        if (resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Log.e("Debug", "In Landscape")
            orientation.text = ("Current Mode: Landscape")

        } else if (resources.configuration.orientation === Configuration.ORIENTATION_PORTRAIT) {

            Log.e("Debug", "In Portrait")
            orientation.text = ("Current Mode: Portrait")
        }
            count++

        val orientationCountText = getString(R.string.orientationCount, count)
        orientationCount.text = orientationCountText
    }


}