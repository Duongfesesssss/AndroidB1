package com.example.androidb1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtMSSV: EditText
    private lateinit var edtName: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText
    private lateinit var calendarView: CalendarView
    private lateinit var spinnerLocation: Spinner
    private lateinit var checkAgreement: CheckBox
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtMSSV = findViewById(R.id.edtMSSV)
        edtName = findViewById(R.id.edtName)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)
        calendarView = findViewById(R.id.calendarView)
        spinnerLocation = findViewById(R.id.spinnerLocation)
        checkAgreement = findViewById(R.id.checkAgreement)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Set up the spinner
        val locations = arrayOf("Phường A", "Phường B", "Quận C", "Tỉnh D")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter = adapter

        findViewById<Button>(R.id.btnShowCalendar).setOnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        btnSubmit.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val mssv = edtMSSV.text.toString()
        val name = edtName.text.toString()
        val email = edtEmail.text.toString()
        val phone = edtPhone.text.toString()
        val genderId = radioGroupGender.checkedRadioButtonId
        val location = spinnerLocation.selectedItem.toString()
        val isAgreed = checkAgreement.isChecked

        if (mssv.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || genderId == -1 || !isAgreed) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, "Thông tin hợp lệ!", Toast.LENGTH_SHORT).show()
    }
}
