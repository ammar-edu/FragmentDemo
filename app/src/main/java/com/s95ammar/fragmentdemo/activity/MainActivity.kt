package com.s95ammar.fragmentdemo.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.s95ammar.fragmentdemo.KeyboardManager
import com.s95ammar.fragmentdemo.R
import com.s95ammar.fragmentdemo.mainfragment.MainFragment
import com.s95ammar.fragmentdemo.models.Product
import com.s95ammar.fragmentdemo.models.User
import com.s95ammar.fragmentdemo.secondfragment.SecondFragment

class MainActivity : AppCompatActivity(), KeyboardManager {

    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) startMainFragment()
        setUpViews()
        sharedViewModel.user.observe(this) { user ->
            Log.d("SharedViewModel", user.toString())
        }

        Log.d("FRAGMENT_DEMO", "Activity: onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("FRAGMENT_DEMO", "Activity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FRAGMENT_DEMO", "Activity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FRAGMENT_DEMO", "Activity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FRAGMENT_DEMO", "Activity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FRAGMENT_DEMO", "Activity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FRAGMENT_DEMO", "Activity: onRestart")
    }

    private fun setUpViews() {
        findViewById<Button>(R.id.main_fragment_button).setOnClickListener {
            switchToFragment(MainFragment.TAG)
        }
        findViewById<Button>(R.id.second_fragment_button).setOnClickListener {
            switchToFragment(SecondFragment.TAG)
        }
        findViewById<Button>(R.id.remove_current_fragment_button).setOnClickListener {
            removeCurrentFragment()
        }
    }

    private fun switchToFragment(tag: String) {
        val transaction = supportFragmentManager.beginTransaction()

        val fragment = when (tag) {
            MainFragment.TAG -> MainFragment()
            SecondFragment.TAG -> SecondFragment()
            else -> return
        }

        val bundle = Bundle()
        bundle.putString("name", "Andrey")
        bundle.putInt("age", 30)
        val user = User("Andrey", 30)
        bundle.putSerializable("user", user)
        val product = Product("Laptop", 1000)
        bundle.putParcelable("laptop", product)
        fragment.arguments = bundle

        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun startMainFragment() {
        val mainFragment = MainFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, mainFragment, MainFragment.TAG)
        transaction.commit()
    }

    private fun removeCurrentFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.fragments.find { fragment ->
            fragment.isResumed
        }?.let { currentFragment ->
            transaction.remove(currentFragment)
        }
        transaction.commit()
    }

    override fun showKeyboard() {
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}