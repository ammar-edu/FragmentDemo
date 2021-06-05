package com.s95ammar.fragmentdemo.mainfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.s95ammar.fragmentdemo.R
import com.s95ammar.fragmentdemo.activity.SharedViewModel

class MainFragment: Fragment() {
    companion object {
        const val TAG = "MainFragment"
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FRAGMENT_DEMO", "Fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FRAGMENT_DEMO", "Fragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FRAGMENT_DEMO", "Fragment: onCreateView")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FRAGMENT_DEMO", "Fragment: onViewCreated")
        val textView = view.findViewById<TextView>(R.id.my_text_view)
        sharedViewModel.user.observe(viewLifecycleOwner) { user ->
            textView.text = user.toString()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FRAGMENT_DEMO", "Fragment: onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("FRAGMENT_DEMO", "Fragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FRAGMENT_DEMO", "Fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FRAGMENT_DEMO", "Fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FRAGMENT_DEMO", "Fragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FRAGMENT_DEMO", "Fragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FRAGMENT_DEMO", "Fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FRAGMENT_DEMO", "Fragment: onDetach")
    }
}