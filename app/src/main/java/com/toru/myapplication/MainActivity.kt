package com.toru.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.toru.myapplication.Adapter.ResultAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listResult = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rlResult.layoutManager = LinearLayoutManager(this)
//        rlResult.layoutManager = GridLayoutManager(this,3)
    }

    fun clickCalculate(sender: View){
        var result = 0.0
        when(sender.tag){
            "+" -> result = etFirst.text.toString().toDouble() + etSecond.text.toString().toDouble()
            "-" -> result = etFirst.text.toString().toDouble() - etSecond.text.toString().toDouble()
            "*" -> result = etFirst.text.toString().toDouble() * etSecond.text.toString().toDouble()
            "/" -> result = etFirst.text.toString().toDouble() / etSecond.text.toString().toDouble()
        }

        listResult.add("${etFirst.text} ${sender.tag} ${etSecond.text} = $result")

        rlResult.adapter = ResultAdapter(listResult) //it's mean-> rlResult.setAdapter(new ResultAdapter(listResult))

        // listResult AlertDialog
        for( resultXxX in listResult){
            val builder = AlertDialog.Builder(this)
            builder.setMessage(resultXxX)
            builder.setPositiveButton("ok") { _, _ -> null }
            builder.show()
        }
    }
}
