package com.albert.alberttailoremployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.albert.alberttailoremployees.utils.NavigationUtils

class Siyaram : AppCompatActivity() {

    private lateinit var etPantSiyaram: EditText
    private lateinit var etShirtSiyaram: EditText
    private lateinit var etSafariSiyaram: EditText
    private lateinit var etPjamaiSiyaram: EditText
    private lateinit var etKameejSiyaram: EditText

    private lateinit var txtPantAmtSiyaram: TextView
    private lateinit var txtShirtAmtSiyaram: TextView
    private lateinit var txtSafariAmtSiyaram: TextView
    private lateinit var txtPjamaiAmtSiyaram: TextView
    private lateinit var txtKameejAmtSiyaram: TextView

    private lateinit var txtWeekAmtSiyaram: TextView

    private lateinit var etPreviousAmtSiyaram: TextView
    private lateinit var txtTotalAmtSiyaram: TextView
    private lateinit var txtPaidAmtSiyaram: TextView

    private lateinit var etExpenseAmtSiyaram: EditText

    private lateinit var btnTotalItemsSiyaram: Button

    private lateinit var btnTotalAmtSiyaram: Button
    private lateinit var btnPaidAmtSiyaram: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siyaram)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val txtName: TextView = findViewById(R.id.txtNameSiyaram)
        val txtSpecialWork: TextView = findViewById(R.id.txtWorkSiyaram)

        val name = intent.getStringExtra("name")
        val specialWork = intent.getStringExtra("specialist")


        txtName.text = name
        txtSpecialWork.text = specialWork

        val imgBack: ImageView = findViewById(R.id.imgBack)
        NavigationUtils.setUpBackButton(this,imgBack)


        etPantSiyaram = findViewById(R.id.etPantSiyaram)
        etShirtSiyaram = findViewById(R.id.etShirtSiyaram)
        etSafariSiyaram = findViewById(R.id.etSafariSiyaram)
        etPjamaiSiyaram = findViewById(R.id.etPjamaiSiyaram)
        etKameejSiyaram = findViewById(R.id.etKameejSiyaram)

        btnTotalItemsSiyaram = findViewById(R.id.btnTotalItemsSiyaram)
        btnTotalAmtSiyaram = findViewById(R.id.btnTotalAmountSiyaram)
        btnPaidAmtSiyaram = findViewById(R.id.btnPaidAmtSiyaram)

        txtPantAmtSiyaram = findViewById(R.id.txtPantAmtSiyaram)
        txtShirtAmtSiyaram = findViewById(R.id.txtShirtAmtSiyaram)
        txtSafariAmtSiyaram = findViewById(R.id.txtSafariAmtSiyaram)
        txtPjamaiAmtSiyaram = findViewById(R.id.txtPjamaiAmtSiyaram)
        txtKameejAmtSiyaram = findViewById(R.id.txtKameejAmtSiyaram)

        txtWeekAmtSiyaram = findViewById(R.id.txtWeekAmtSiyaram)
        etPreviousAmtSiyaram = findViewById(R.id.etPreviousAmtSiyaram)

        txtTotalAmtSiyaram = findViewById(R.id.txtTotalAmtSiyaram)
        txtPaidAmtSiyaram = findViewById(R.id.txtPaidAmtSiyaram)

        etExpenseAmtSiyaram = findViewById(R.id.etExpenseSiyaram)

        btnTotalItemsSiyaram.setOnClickListener {
            pant()
            shirt()
            safari()
            pjamai()
            kameej()

            val totalPantAmt = txtPantAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalShirtAmt = txtShirtAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalSafariAmt = txtSafariAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalPjamaiAmt = txtPjamaiAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalKameejAmt = txtKameejAmtSiyaram.text.toString().toIntOrNull() ?: 0

            val totalWeekAmt =
                totalPantAmt + totalShirtAmt + totalSafariAmt + totalPjamaiAmt + totalKameejAmt
            txtWeekAmtSiyaram.text = totalWeekAmt.toString()

        }

        btnTotalAmtSiyaram.setOnClickListener {
            val previousAmt = etPreviousAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalWeekAmt = txtWeekAmtSiyaram.text.toString().toIntOrNull() ?: 0

            val totalAmt = totalWeekAmt + previousAmt
            txtTotalAmtSiyaram.text = totalAmt.toString()
        }

        btnPaidAmtSiyaram.setOnClickListener {
            val totalExpense = etExpenseAmtSiyaram.text.toString().toIntOrNull() ?: 0
            val totalAmt = txtTotalAmtSiyaram.text.toString().toIntOrNull() ?: 0

            val totalPaid = totalAmt - totalExpense
            txtPaidAmtSiyaram.text = totalPaid.toString()

        }

    }

    fun pant(): Int {
        val pant = etPantSiyaram.text.toString().toIntOrNull()
        if (pant != null) {
            val totalPantAmount = pant * 140
            txtPantAmtSiyaram.text = totalPantAmount.toString()
        } else {
            txtPantAmtSiyaram.text = "0"
        }
        return 0
    }

    fun shirt(): Int {

        val shirt = etShirtSiyaram.text.toString().toIntOrNull()

        if (shirt != null) {
            val totalPantAmount = shirt * 95
            txtShirtAmtSiyaram.text = totalPantAmount.toString()

        } else {
            txtShirtAmtSiyaram.text = "0"

        }
        return 0
    }

    private fun safari(): Int {

        val safari = etSafariSiyaram.text.toString().toIntOrNull()

        if (safari != null) {
            val totalSafariAmount = safari * 200
            txtSafariAmtSiyaram.text = totalSafariAmount.toString()

        } else {
            txtSafariAmtSiyaram.text = "0"

        }
        return 0
    }

    fun pjamai(): Int {

        val pajama = etPjamaiSiyaram.text.toString().toIntOrNull()

        if (pajama != null) {
            val totalpajamaiAmount = pajama * 65
            txtPjamaiAmtSiyaram.text = totalpajamaiAmount.toString()

        } else {
            txtPjamaiAmtSiyaram.text = "0"

        }
        return 0
    }

    fun kameej(): Int {

        val kameej = etKameejSiyaram.text.toString().toIntOrNull()

        if (kameej != null) {
            val totalKameejAmount = kameej * 100
            txtKameejAmtSiyaram.text = totalKameejAmount.toString()

        } else {
            txtKameejAmtSiyaram.text = "0"

        }
        return 0
    }
}