package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Sophie Tai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // replace the above line with instruction to create the binding object with whatever connects the layout with the activity,
        // in this case so that we can access the binding object through the done button (generated name)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /* findViewById<Button>(R.id.done_button).setOnClickListener {
           addNickName(it)
            }*/

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

        /* also available in this function, instead of using these two lines, add binding. in front of original code~
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE*/

        binding.apply {
            // using this apply function makes code easier to read
            binding.nicknameText.text = binding.nicknameEdit.text
            // can't remove this line above, otherwise will disappear!
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            //invalidating all binding data is necessary for it to get recreated with the right, updated data
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        // hides the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}