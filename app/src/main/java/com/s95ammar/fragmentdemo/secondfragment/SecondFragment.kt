package com.s95ammar.fragmentdemo.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.s95ammar.fragmentdemo.KeyboardManager
import com.s95ammar.fragmentdemo.R
import com.s95ammar.fragmentdemo.activity.SharedViewModel
import com.s95ammar.fragmentdemo.models.Product

class SecondFragment : Fragment() {

    companion object {
        const val TAG = "SecondFragment"
    }

    // scope: fragment
    private val viewModel: SecondViewModel by viewModels()
    // scope: host activity. Gets the same view model instance
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userTexView = view.findViewById<TextView>(R.id.user_text_view)
/*      (arguments?.getSerializable("user") as? User)?.let { user ->
            userTexView.text = "${user.name}: ${user.age}"
        }
*/
        sharedViewModel.user.observe(viewLifecycleOwner) { user ->
            userTexView.text = user.toString()
        }
        val productTextView = view.findViewById<TextView>(R.id.product_text_view)
        arguments?.getParcelable<Product>("laptop")?.let { product ->
            productTextView.text = "${product.name}: ${product.price}"
        }

        val nameEditText = view.findViewById<EditText>(R.id.name_edit_text)
        nameEditText.requestFocus()
        (activity as? KeyboardManager)?.showKeyboard()
        val ageEditText = view.findViewById<EditText>(R.id.age_edit_text)
        val saveButton = view.findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            sharedViewModel.setUserData(name, age)
        }
    }
}