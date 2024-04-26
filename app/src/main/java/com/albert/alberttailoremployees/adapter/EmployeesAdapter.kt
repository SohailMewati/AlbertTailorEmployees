package com.albert.alberttailoremployees.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.albert.alberttailoremployees.Ishaak
import com.albert.alberttailoremployees.Krishna
import com.albert.alberttailoremployees.model.Employees
import com.albert.alberttailoremployees.Liyakat
import com.albert.alberttailoremployees.R
import com.albert.alberttailoremployees.Saleem
import com.albert.alberttailoremployees.Siyaram

class EmployeesAdapter(val employees: List<Employees>, var context: Context) :
    RecyclerView.Adapter<EmployeesAdapter.MyEmployeesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEmployeesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.employeedetails, parent, false)
        return MyEmployeesViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyEmployeesViewHolder, position: Int) {

        val employeesDetails = employees[position]

        holder.employeeImage.setImageResource(employeesDetails.empImage)
        holder.employeesName.text = employeesDetails.name

        val specialistMaxLength = 15
        if (employeesDetails.specialist.length > specialistMaxLength) {
            holder.employeesSpecialist.text =
                employeesDetails.specialist.substring(0, specialistMaxLength) + "...."
        } else {
            holder.employeesSpecialist.text = employeesDetails.specialist
        }

        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(context, Liyakat::class.java)
                    intent.putExtra("imageResourceId", employeesDetails.empImage)
                    intent.putExtra("name", employeesDetails.name)
                    intent.putExtra("specialist", "Specialist: ${employeesDetails.specialist}")
                    context.startActivity(intent)
                }

                1 -> {
                    val intent = Intent(context, Saleem::class.java)
                    intent.putExtra("name", employeesDetails.name)
                    intent.putExtra("specialist", "Specialist: ${employeesDetails.specialist}")
                    context.startActivity(intent)
                }

                2 -> {
                    val intent = Intent(context, Siyaram::class.java)
                    intent.putExtra("name", employeesDetails.name)
                    intent.putExtra("specialist", "Specialist: ${employeesDetails.specialist}")
                    context.startActivity(intent)
                }

                3 -> {
                    val intent = Intent(context, Krishna::class.java)
                    intent.putExtra("name", employeesDetails.name)
                    intent.putExtra("specialist", "Specialist: ${employeesDetails.specialist}")
                    context.startActivity(intent)
                }

                4 -> {
                    val intent = Intent(context, Ishaak::class.java)
                    intent.putExtra("name", employeesDetails.name)
                    intent.putExtra("specialist", "Specialist: ${employeesDetails.specialist}")
                    context.startActivity(intent)
                }
            }
        }


    }


    override fun getItemCount(): Int {
        return employees.size
    }


    class MyEmployeesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var employeeImage: ImageView = itemView.findViewById(R.id.imgEmpImage)
        var employeesName = itemView.findViewById<TextView>(R.id.txtEmpName)
        var employeesSpecialist = itemView.findViewById<TextView>(R.id.txtEmpSpecialist)


    }
}