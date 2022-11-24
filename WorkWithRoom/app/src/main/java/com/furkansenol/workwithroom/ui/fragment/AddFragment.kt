package com.furkansenol.workwithroom.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.furkansenol.workwithroom.R
import com.furkansenol.workwithroom.model.User
import com.furkansenol.workwithroom.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var age: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }
    }
    private fun insertDataToDatabase() {
        firstName = addFirstName_et.text.toString()
        lastName = addLastName_et.text.toString()
        age = addAge_et.text.toString()

        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, age.toInt())
            mUserViewModel.addUser(user)
            Toast.makeText(context?.applicationContext,"Successfully added!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(context?.applicationContext, "İşlem Başarısız", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        //return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(age))
        return !(firstName.isBlank() || lastName.isBlank() || age.isBlank())
    }

}