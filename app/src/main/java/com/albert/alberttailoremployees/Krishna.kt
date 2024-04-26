package com.albert.alberttailoremployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.albert.alberttailoremployees.utils.NavigationUtils

class Krishna : AppCompatActivity() {

    private lateinit var etCoatKrishna: EditText
    private lateinit var etShirtKrishna: EditText
    private lateinit var etSafariKrishna: EditText
    private lateinit var etPjamaiKrishna: EditText
    private lateinit var etKameejKrishna: EditText
    private lateinit var etJawarkatKrishna: EditText
    private lateinit var etBaaskatKrishna: EditText

    private lateinit var txtCoatAmtKrishna: TextView
    private lateinit var txtShirtAmtKrishna: TextView
    private lateinit var txtSafariAmtKrishna: TextView
    private lateinit var txtPjamaiAmtKrishna: TextView
    private lateinit var txtKameejAmtKrishna: TextView
    private lateinit var txtJawarkatAmtKrishna: TextView
    private lateinit var txtBaaskatAmtKrishna: TextView

    private lateinit var txtWeekAmtKrishna: TextView

    private lateinit var etPreviousAmtKrishna: TextView
    private lateinit var txtTotalAmtKrishna: TextView
    private lateinit var txtPaidAmtKrishna: TextView

    private lateinit var etExpenseAmtKrishna: EditText

    private lateinit var btnTotalItemsKrishna: Button
    private lateinit var btnTotalAmtKrishna: Button
    private lateinit var btnPaidAmtKrishna: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_krishna)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val txtName: TextView = findViewById(R.id.txtNameKrishna)
        val txtSpecialWork: TextView = findViewById(R.id.txtWorkKrishna)


        val name = intent.getStringExtra("name")
        val specialWork = intent.getStringExtra("specialist")

        txtName.text = name
        txtSpecialWork.text = specialWork

        val imgBack: ImageView = findViewById(R.id.imgBack)
        NavigationUtils.setUpBackButton(this, imgBack)

        etCoatKrishna = findViewById(R.id.etCoatKrishna)
        etShirtKrishna = findViewById(R.id.etShirtKrishna)
        etSafariKrishna = findViewById(R.id.etSafariKrishna)
        etPjamaiKrishna = findViewById(R.id.etPjamaiKrishna)
        etKameejKrishna = findViewById(R.id.etKameejKrishna)
        etJawarkatKrishna = findViewById(R.id.etJawarkatKrishna)
        etBaaskatKrishna = findViewById(R.id.etBaaskatKrishna)

        btnTotalItemsKrishna = findViewById(R.id.btnTotalItemsKrishna)
        btnTotalAmtKrishna = findViewById(R.id.btnTotalAmountKrishna)
        btnPaidAmtKrishna = findViewById(R.id.btnPaidAmtKrishna)

        txtCoatAmtKrishna = findViewById(R.id.txtCoatAmtKrishna)
        txtShirtAmtKrishna = findViewById(R.id.txtShirtAmtKrishna)
        txtSafariAmtKrishna = findViewById(R.id.txtSafariAmtKrishna)
        txtPjamaiAmtKrishna = findViewById(R.id.txtPjamaiAmtKrishna)
        txtKameejAmtKrishna = findViewById(R.id.txtKameejAmtKrishna)
        txtJawarkatAmtKrishna = findViewById(R.id.txtJawarkatAmtKrishna)
        txtBaaskatAmtKrishna = findViewById(R.id.txtBaaskatAmtKrishna)


        txtWeekAmtKrishna = findViewById(R.id.txtWeekAmtKrishna)
        etPreviousAmtKrishna = findViewById(R.id.etPreviousAmtKrishna)

        txtTotalAmtKrishna = findViewById(R.id.txtTotalAmtKrishna)
        txtPaidAmtKrishna = findViewById(R.id.txtPaidAmtKrishna)

        etExpenseAmtKrishna = findViewById(R.id.etExpenseKrishna)

        btnTotalItemsKrishna.setOnClickListener {

            coat()
            shirt()
            safari()
            pjamai()
            kameej()
            jawarkat()
            baaskat()

            val totalCoatAmt = txtCoatAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalShirtAmt = txtShirtAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalSafariAmt = txtSafariAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalPjamaiAmt = txtPjamaiAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalKameejAmt = txtKameejAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalJawarkatAmt = txtJawarkatAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalBaaskatAmt = txtBaaskatAmtKrishna.text.toString().toIntOrNull() ?: 0

            val totalWeekAmt =
                totalCoatAmt + totalShirtAmt + totalSafariAmt + totalPjamaiAmt + totalKameejAmt + totalJawarkatAmt + totalBaaskatAmt

            txtWeekAmtKrishna.text = totalWeekAmt.toString()

        }

        btnTotalAmtKrishna.setOnClickListener {
            val previousAmt = etPreviousAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalWeekAmt = txtWeekAmtKrishna.text.toString().toIntOrNull() ?: 0

            val totalAmt = totalWeekAmt + previousAmt
            txtTotalAmtKrishna.text = totalAmt.toString()
        }

        btnPaidAmtKrishna.setOnClickListener {
            val totalExpense = etExpenseAmtKrishna.text.toString().toIntOrNull() ?: 0
            val totalAmt = txtTotalAmtKrishna.text.toString().toIntOrNull() ?: 0

            val totalPaid = totalAmt - totalExpense
            txtPaidAmtKrishna.text = totalPaid.toString()

        }
    }

    private fun coat(): Int {

        val coat = etCoatKrishna.text.toString().toIntOrNull()

        if (coat != null) {
            val totalJawarkatAmountSaleem = coat * 750
            txtCoatAmtKrishna.text = totalJawarkatAmountSaleem.toString()

        } else {
            txtCoatAmtKrishna.text = "0"

        }
        return 0
    }

    private fun shirt(): Int {

        val shirt = etShirtKrishna.text.toString().toIntOrNull()

        if (shirt != null) {
            val totalPantAmount = shirt * 95
            txtShirtAmtKrishna.text = totalPantAmount.toString()

        } else {
            txtShirtAmtKrishna.text = "0"

        }
        return 0
    }

    private fun safari(): Int {

        val safari = etSafariKrishna.text.toString().toIntOrNull()

        if (safari != null) {
            val totalSafariAmount = safari * 200
            txtSafariAmtKrishna.text = totalSafariAmount.toString()

        } else {
            txtSafariAmtKrishna.text = "0"

        }
        return 0
    }

    private fun pjamai(): Int {

        val pajama = etPjamaiKrishna.text.toString().toIntOrNull()

        if (pajama != null) {
            val totalpajamaiAmount = pajama * 65
            txtPjamaiAmtKrishna.text = totalpajamaiAmount.toString()

        } else {
            txtPjamaiAmtKrishna.text = "0"

        }
        return 0
    }

    private fun kameej(): Int {

        val kameej = etKameejKrishna.text.toString().toIntOrNull()

        if (kameej != null) {
            val totalKameejAmount = kameej * 100
            txtKameejAmtKrishna.text = totalKameejAmount.toString()

        } else {
            txtKameejAmtKrishna.text = "0"

        }
        return 0
    }

    private fun jawarkat(): Int {

        val jawarkat = etJawarkatKrishna.text.toString().toIntOrNull()

        if (jawarkat != null) {
            val totalJawarkatAmountSaleem = jawarkat * 340
            txtJawarkatAmtKrishna.text = totalJawarkatAmountSaleem.toString()

        } else {
            txtJawarkatAmtKrishna.text = "0"

        }
        return 0
    }

    private fun baaskat(): Int {

        val baaskat = etBaaskatKrishna.text.toString().toIntOrNull()

        if (baaskat != null) {
            val totalJawarkatAmountSaleem = baaskat * 200
            txtBaaskatAmtKrishna.text = totalJawarkatAmountSaleem.toString()

        } else {
            txtBaaskatAmtKrishna.text = "0"

        }
        return 0
    }
}
