package com.albert.alberttailoremployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.albert.alberttailoremployees.adapter.EmployeesAdapter
import com.albert.alberttailoremployees.model.Employees

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.tool_bar)

        val employeesRecyclerView: RecyclerView = findViewById(R.id.recyclerViewEmployeeDetails)

        val employeesDetails = ArrayList<Employees>()

        employeesDetails.add(
            Employees(
                R.drawable.liyakat,
                "Liaykat Bhai",
                "Pant, Safari, Kurta pjama"
            )
        )
        employeesDetails.add(Employees(R.drawable.saleem, "Saleem Bhai", "Pant, Jawarkat"))
        employeesDetails.add(
            Employees(
                R.drawable.siyaram,
                "Siyaram",
                "Pant, Shirt, Safari, Kurta Pjama"
            )
        )
        employeesDetails.add(
            Employees(
                R.drawable.krishna,
                "Krishna Bhai",
                "Coat, Jawarkat, Safari, Kurta Pjama"
            )
        )
        employeesDetails.add(Employees(R.drawable.ishaak, "Ishaak Aalam", "Shirt"))
        employeesRecyclerView.adapter = EmployeesAdapter(employeesDetails, this)
        employeesRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}