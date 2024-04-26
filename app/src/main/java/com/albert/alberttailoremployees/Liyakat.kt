package com.albert.alberttailoremployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.albert.alberttailoremployees.utils.NavigationUtils

class Liyakat : AppCompatActivity() {

    private lateinit var etPant: EditText
    private lateinit var etSafari: EditText

    private lateinit var txtPantAmt: TextView
    private lateinit var txtSafariAmt: TextView

    private lateinit var txtWeekAmt: TextView

    private lateinit var etPreviousAmt: TextView
    private lateinit var txtTotalAmt: TextView
    private lateinit var txtPaidAmt: TextView

    private lateinit var etExpenseAmt: EditText

    private lateinit var btnTotalItems: Button

    private lateinit var btnTotalAmt: Button
    private lateinit var btnPaidAmt: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liyakat)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val txtName: TextView = findViewById(R.id.txtName)
        val txtSpecialWork: TextView = findViewById(R.id.txtWork)

        etPant = findViewById(R.id.etPant)
        etSafari = findViewById(R.id.etSafari)

        btnTotalItems = findViewById(R.id.btnTotalItems)
        btnTotalAmt = findViewById(R.id.btnTotalAmount)
        btnPaidAmt = findViewById(R.id.btnPaidAmt)

        txtPantAmt = findViewById(R.id.txtPantAmt)
        txtSafariAmt = findViewById(R.id.txtShafariAmt)

        txtWeekAmt = findViewById(R.id.txtWeekAmt)
        etPreviousAmt = findViewById(R.id.etPreviousAmt)

        txtTotalAmt = findViewById(R.id.txtTotalAmt)
        txtPaidAmt = findViewById(R.id.txtPaidAmt)

        etExpenseAmt = findViewById(R.id.etExpense)


        val name = intent.getStringExtra("name")
        val specialWork = intent.getStringExtra("specialist")

        txtName.text = name
        txtSpecialWork.text = specialWork

        val imgBack: ImageView = findViewById(R.id.imgBack)
        NavigationUtils.setUpBackButton(this, imgBack)

        btnTotalItems.setOnClickListener {
            pant()
            safari()

            val totalPantAmt = txtPantAmt.text.toString().toIntOrNull() ?: 0
            val totalSafariAmt = txtSafariAmt.text.toString().toIntOrNull() ?: 0

            val totalWeekAmt = totalPantAmt + totalSafariAmt
            txtWeekAmt.text = totalWeekAmt.toString()
        }

        btnTotalAmt.setOnClickListener {
            val previousAmt = etPreviousAmt.text.toString().toIntOrNull() ?: 0
            val totalWeekAmt = txtWeekAmt.text.toString().toIntOrNull() ?: 0

            val totalAmt = totalWeekAmt + previousAmt
            txtTotalAmt.text = totalAmt.toString()
        }

        btnPaidAmt.setOnClickListener {
            val totalExpense = etExpenseAmt.text.toString().toIntOrNull() ?: 0
            val totalAmt = txtTotalAmt.text.toString().toIntOrNull() ?: 0

            val totalPaid = totalAmt - totalExpense
            txtPaidAmt.text = totalPaid.toString()

        }

    }

    fun pant(): Int {
        val pant = etPant.text.toString().toIntOrNull()
        if (pant != null) {
            val totalPantAmount = pant * 140
            txtPantAmt.text = totalPantAmount.toString()
        } else {
            txtPantAmt.text = "0"
        }
        return 0
    }

    private fun safari(): Int {

        val safari = etSafari.text.toString().toIntOrNull()

        if (safari != null) {
            val totalSafariAmount = safari * 200
            txtSafariAmt.text = totalSafariAmount.toString()

        } else {
            txtSafariAmt.text = "0"

        }
        return 0
    }
}