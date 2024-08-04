package com.adityarawat.ekacareassignment.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.adityarawat.ekacareassignment.databinding.FragmentDashBoardBinding
import com.adityarawat.ekacareassignment.room.entities.User
import com.adityarawat.ekacareassignment.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

    private val binding by lazy { FragmentDashBoardBinding.inflate(layoutInflater) }
    private lateinit var viewModel: MainViewModel
    private val calendar = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        onClick()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onClick() {
        binding.submitBtn.setOnClickListener {
            verify()
        }

        binding.calendarIV.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val datePicker = DatePickerDialog(
            requireContext(), { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->

                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                binding.dateET.setText(formattedDate)

            },
            calendar.get(Calendar.YEAR),
            calendar . get (Calendar.MONTH),
            calendar . get (Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    private fun verify() {
        val name = binding.nameET.text.toString()
        val age = binding.ageET.text.toString()
        val address = binding.addressET.text.toString()
        val dob = binding.dateET.text.toString()

        if (name.isNotEmpty() && age.isNotEmpty() && address.isNotEmpty() && dob.isNotEmpty()){
            viewModel.insertUser(User(0,name,age, dob, address))
            Toast.makeText(requireContext(),"Data Submitted Successfully", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(requireContext(),"Fields can not be blank", Toast.LENGTH_SHORT).show()
        }

    }

}