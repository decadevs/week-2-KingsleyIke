package com.kings.activitylifecycleandfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf


class FragmentActivity : AppCompatActivity() {

    //assigning Fragment Manager method to a variable to be used in adding fragments to layout
    var fragmentManager = supportFragmentManager

    /**
     * Overriding the onCreate Method
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        //Linking variables to the fragment addition buttons using their id
        val fragmentOneButton: Button = findViewById(R.id.fragmentOneButton)
        val fragmentTwoButton: Button = findViewById(R.id.fragmentTwoButton)


        //Fragment transaction to add fragment instances to the layout and backstack
        fragmentOneButton.setOnClickListener {
            val firstFragment = FragmentOne()
            fragmentManager.beginTransaction().apply {
                //set initial fragment to first fragment
                add(R.id.flmainFragment, firstFragment)
                addToBackStack(null)
                commit()
            }

            //Importing textview resource form fragment one
            val bundle = bundleOf("count" to (fragmentManager.backStackEntryCount + 1).toString())
            firstFragment.arguments = bundle
        }

        //Fragment transaction to add fragment instances to the layout and backstack
        fragmentTwoButton.setOnClickListener {
            val secondFragment = FragmentTwo()
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().apply {
                add(R.id.flmainFragment, secondFragment)
                addToBackStack(null)
                commit()
            }

            //Importing textview resource form fragment two
            //Arguments are saved in bundles aand passed when instance is created
            val bundle = bundleOf("count2" to (fragmentManager.backStackEntryCount + 1).toString())
            secondFragment.arguments = bundle
        }

    }

    //Function linked to the back button to remove topmost stack
    fun back(view: View) {
        fragmentManager.popBackStack()
    }

    //Function linked to the a button returning the user back to the main activity page
    fun home (view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

