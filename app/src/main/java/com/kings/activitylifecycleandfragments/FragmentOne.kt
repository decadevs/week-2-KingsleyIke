package com.kings.activitylifecycleandfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment() {

    lateinit var textView: TextView

    /**
     * Overriding the on create function
     * setting resources to load to the fragment activity
     */
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        // Setting Text view resource to be accessed in fragment activity class
        // Arguments are gotten in bundles
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        textView = view.findViewById(R.id.currentPositionStack1)
        textView.text = arguments?.getString("count")
        return view
    }
}
