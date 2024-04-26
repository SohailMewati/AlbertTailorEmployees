package com.albert.alberttailoremployees

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.albert.alberttailoremployees.utils.NavigationUtils

class Saleem : AppCompatActivity() {

    private lateinit var etPantSaleem: EditText
    private lateinit var etJawarkatSaleem: EditText
    private lateinit var etBaaskatSaleem: EditText

    private lateinit var txtPantAmtSaleem: TextView
    private lateinit var txtJawarkatAmtSaleem: TextView
    private lateinit var txtBaaskatAmtSaleem: TextView

    private lateinit var txtWeekAmtSaleem: TextView

    private lateinit var etPreviousAmtSaleem: TextView
    private lateinit var txtTotalAmtSaleem: TextView
    private lateinit var txtPaidAmtSaleem: TextView

    private lateinit var etExpenseAmtSaleem: EditText

    private lateinit var btnTotalItemsSaleem: Button

    private lateinit var btnTotalAmtSaleem: Button
    private lateinit var btnPaidAmtSaleem: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saleem)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val txtName: TextView = findViewById(R.id.txtNameSaleem)
        val txtSpecialWork: TextView = findViewById(R.id.txtWorkSaleem)


        val name = intent.getStringExtra("name")
        val specialWork = intent.getStringExtra("specialist")


        txtName.text = name
        txtSpecialWork.text = specialWork

        val imgBack: ImageView = findViewById(R.id.imgBack)
        NavigationUtils.setUpBackButton(this, imgBack)

        etPantSaleem = findViewById(R.id.etPantSaleem)
        etJawarkatSaleem = findViewById(R.id.etJawarkatSaleem)
        etBaaskatSaleem = findViewById(R.id.etBaaskatSaleem)

        btnTotalItemsSaleem = findViewById(R.id.btnTotalItemsSaleem)
        btnTotalAmtSaleem = findViewById(R.id.btnTotalAmountSaleem)
        btnPaidAmtSaleem = findViewById(R.id.btnPaidAmtSaleem)

        txtPantAmtSaleem = findViewById(R.id.txtPantAmtSaleem)
        txtJawarkatAmtSaleem = findViewById(R.id.txtJawarkatAmtSaleem)
        txtBaaskatAmtSaleem = findViewById(R.id.txtBaaskatAmtSaleem)

        txtWeekAmtSaleem = findViewById(R.id.txtWeekAmtSaleem)
        etPreviousAmtSaleem = findViewById(R.id.etPreviousAmtSaleem)

        txtTotalAmtSaleem = findViewById(R.id.txtTotalAmtSaleem)
        txtPaidAmtSaleem = findViewById(R.id.txtPaidAmtSaleem)

        etExpenseAmtSaleem = findViewById(R.id.etExpenseSaleem)


        btnTotalItemsSaleem.setOnClickListener {
            pant()
            jawarkat()
            baaskat()

            val totalPantAmt = txtPantAmtSaleem.text.toString().toIntOrNull() ?: 0
            val totalJawarkatAmt = txtJawarkatAmtSaleem.text.toString().toIntOrNull() ?: 0
            val totalBaaskatAmt = txtBaaskatAmtSaleem.text.toString().toIntOrNull() ?: 0

            val totalWeekAmt = totalPantAmt + totalJawarkatAmt + totalBaaskatAmt
            txtWeekAmtSaleem.text = totalWeekAmt.toString()
        }

        btnTotalAmtSaleem.setOnClickListener {
            val previousAmt = etPreviousAmtSaleem.text.toString().toIntOrNull() ?: 0
            val totalWeekAmt = txtWeekAmtSaleem.text.toString().toIntOrNull() ?: 0

            val totalAmt = totalWeekAmt + previousAmt
            txtTotalAmtSaleem.text = totalAmt.toString()
        }

        btnPaidAmtSaleem.setOnClickListener {
            val totalExpense = etExpenseAmtSaleem.text.toString().toIntOrNull() ?: 0
            val totalAmt = txtTotalAmtSaleem.text.toString().toIntOrNull() ?: 0

            val totalPaid = totalAmt - totalExpense
            txtPaidAmtSaleem.text = totalPaid.toString()

        }


    }

    fun pant(): Int {
        val pant = etPantSaleem.text.toString().toIntOrNull()
        if (pant != null) {
            val totalPantAmount = pant * 140
            txtPantAmtSaleem.text = totalPantAmount.toString()
        } else {
            txtPantAmtSaleem.text = "0"
        }
        return 0
    }

    fun jawarkat(): Int {

        val jawarkat = etJawarkatSaleem.text.toString().toIntOrNull()

        if (jawarkat != null) {
            val totalJawarkatAmountSaleem = jawarkat * 340
            txtJawarkatAmtSaleem.text = totalJawarkatAmountSaleem.toString()

        } else {
            txtJawarkatAmtSaleem.text = "0"

        }
        return 0
    }

    fun baaskat(): Int {

        val baaskat = etBaaskatSaleem.text.toString().toIntOrNull()

        if (baaskat != null) {
            val totalJawarkatAmountSaleem = baaskat * 200
            txtBaaskatAmtSaleem.text = totalJawarkatAmountSaleem.toString()

        } else {
            txtBaaskatAmtSaleem.text = "0"

        }
        return 0
    }
}