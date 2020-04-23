package com.toru.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.toru.myapplication.R

class ResultAdapter(private val list : ArrayList<String>) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result_list, parent, false)
        return ViewHolder(view)
    }
        // 回傳 Adapter 含有幾筆資料
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 重複使用ViewHolder 依據position 把值or監聽事件 跟ViewHolder綁定在一起
        holder.txtResult.text = list[position]
    }

    class ViewHolder(view: View) :  RecyclerView.ViewHolder(view) {
        // 連結項目布局檔
        val txtResult = view.findViewById<TextView>(R.id.txtResult)
    }
}