package com.albert.alberttailoremployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.albert.alberttailoremployees.utils.NavigationUtils

class Ishaak : AppCompatActivity() {


    lateinit var etShirtIshaak: EditText
    lateinit var etPjamaiIshaak: EditText
    lateinit var etKameejIshaak: EditText

    lateinit var txtShirtAmtIshaak: TextView
    lateinit var txtPjamaiAmtIshaak: TextView
    lateinit var txtKameejAmtIshaak: TextView

    lateinit var txtWeekAmtIshaak: TextView

    lateinit var etPreviousAmtIshaak: TextView
    lateinit var txtTotalAmtIshaak: TextView
    lateinit var txtPaidAmtIshaak: TextView

    lateinit var etExpenseAmtIshaak: EditText

    lateinit var btnTotalItemsIshaak: Button

    lateinit var btnTotalAmtIshaak: Button
    lateinit var btnPaidAmtIshaak: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ishaak)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val txtName: TextView = findViewById(R.id.txtNameIshaak)
        val txtSpecialWork: TextView = findViewById(R.id.txtWorkIshaak)

        val name = intent.getStringExtra("name")
        val specialWork = intent.getStringExtra("specialist")

        val imgBack: ImageView = findViewById(R.id.imgBack)
        NavigationUtils.setUpBackButton(this, imgBack)


        txtName.text = name
        txtSpecialWork.text = specialWork

        etShirtIshaak = findViewById(R.id.etShirtIshaak)
        etPjamaiIshaak = findViewById(R.id.etPjamaiIshaak)
        etKameejIshaak = findViewById(R.id.etKameejIshaak)

        btnTotalItemsIshaak = findViewById(R.id.btnTotalItemsIshaak)
        btnTotalAmtIshaak = findViewById(R.id.btnTotalAmountIshaak)
        btnPaidAmtIshaak = findViewById(R.id.btnPaidAmtIshaak)

        txtShirtAmtIshaak = findViewById(R.id.txtShirtAmtIshaak)
        txtPjamaiAmtIshaak = findViewById(R.id.txtPjamaiAmtIshaak)
        txtKameejAmtIshaak = findViewById(R.id.txtKameejAmtIshaak)


        txtWeekAmtIshaak = findViewById(R.id.txtWeekAmtIshaak)
        etPreviousAmtIshaak = findViewById(R.id.etPreviousAmtIshaak)

        txtTotalAmtIshaak = findViewById(R.id.txtTotalAmtIshaak)
        txtPaidAmtIshaak = findViewById(R.id.txtPaidAmtIshaak)

        etExpenseAmtIshaak = findViewById(R.id.etExpenseIshaak)


        btnTotalItemsIshaak.setOnClickListener {

            shirt()
            pjamai()
            kameej()

            val totalShirtAmt = txtShirtAmtIshaak.text.toString().toIntOrNull() ?: 0
            val totalPjamaiAmt = txtPjamaiAmtIshaak.text.toString().toIntOrNull() ?: 0
            val totalKameejAmt = txtKameejAmtIshaak.text.toString().toIntOrNull() ?: 0

            val totalWeekAmt = totalShirtAmt + totalPjamaiAmt + totalKameejAmt
            txtWeekAmtIshaak.text = totalWeekAmt.toString()

        }

        btnTotalAmtIshaak.setOnClickListener {
            val previousAmt = etPreviousAmtIshaak.text.toString().toIntOrNull() ?: 0
            val totalWeekAmt = txtWeekAmtIshaak.text.toString().toIntOrNull() ?: 0

            val totalAmt = totalWeekAmt + previousAmt
            txtTotalAmtIshaak.text = totalAmt.toString()
        }

        btnPaidAmtIshaak.setOnClickListener {
            val totalExpense = etExpenseAmtIshaak.text.toString().toIntOrNull() ?: 0
            val totalAmt = txtTotalAmtIshaak.text.toString().toIntOrNull() ?: 0

            val totalPaid = totalAmt - totalExpense
            txtPaidAmtIshaak.text = totalPaid.toString()

        }

    }

    fun shirt(): Int {

        val shirt = etShirtIshaak.text.toString().toIntOrNull()

        if (shirt != null) {
            val totalPantAmount = shirt * 95
            txtShirtAmtIshaak.text = totalPantAmount.toString()

        } else {
            txtShirtAmtIshaak.text = "0"

        }
        return 0
    }

    fun pjamai(): Int {

        val pajama = etPjamaiIshaak.text.toString().toIntOrNull()

        if (pajama != null) {
            val totalpajamaiAmount = pajama * 65
            txtPjamaiAmtIshaak.text = totalpajamaiAmount.toString()

        } else {
            txtPjamaiAmtIshaak.text = "0"

        }
        return 0
    }

    fun kameej(): Int {

        val kameej = etKameejIshaak.text.toString().toIntOrNull()

        if (kameej != null) {
            val totalKameejAmount = kameej * 100
            txtKameejAmtIshaak.text = totalKameejAmount.toString()

        } else {
            txtKameejAmtIshaak.text = "0"

        }
        return 0
    }
}