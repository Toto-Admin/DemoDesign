package com.example.demodesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
        val todoList: ArrayList<String>,
        val context: Context,
        val comesFrom: String,
        val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    companion object {
        var mClickListener: ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        if(comesFrom.equals("Main")){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
            return ViewHolder(view)
        }


    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        mClickListener = itemClickListener
        holder.bind(todoList, context, position)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuName: TextView = itemView.findViewById(R.id.menuName)
        private val linearLayout: LinearLayout = itemView.findViewById(R.id.itemLayout)

        fun bind(todoList: ArrayList<String>, context: Context, position: Int) {
            menuName.setText(todoList.get(position))
            linearLayout.setOnClickListener {
                mClickListener?.onItemClick()
            }

        }
    }

    open interface ItemClickListener {
        fun onItemClick()
    }
}