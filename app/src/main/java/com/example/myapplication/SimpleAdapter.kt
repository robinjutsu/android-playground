package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<String>()
    private var headerText: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.view_holder_header -> SimpleHeaderViewHolder(parent)
            R.layout.view_holder_footer -> SimpleFooterViewHolder(parent)
            else -> SimpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SimpleViewHolder -> holder.onBind(data[position-1], position, position%10 == 0)
            is SimpleHeaderViewHolder -> holder.onBind(headerText)
            is SimpleFooterViewHolder -> holder.onBind()
        }
    }

    override fun getItemCount(): Int {
        return data.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> R.layout.view_holder_header
            data.size + 1 -> R.layout.view_holder_footer
            else -> R.layout.view_holder_textview
        }
    }

    fun setData( data: List<String>, headerText: String?){
        this.data.clear()
        this.data.addAll(data)
        this.headerText = headerText
    }

    inner class SimpleViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_textview,parent,false)
    ) {

        val textView:TextView = itemView.findViewById(R.id.textView)
        val checkbox:CheckBox = itemView.findViewById(R.id.checkbox)


        fun onBind(textToDisplay:String, position: Int, isChecked: Boolean) {
            textView.text = textToDisplay

            val color = itemView.context.getColor( if (position%2 == 0)
                R.color.light_background
            else
                R.color.white)
            itemView.setBackgroundColor(color)
            checkbox.isChecked = isChecked
        }
    }

    inner class SimpleHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_header,parent,false)
    ) {
        private val textView:TextView = itemView.findViewById(R.id.textView)

        fun onBind(headerText:String?) {
            var headerText = headerText ?: "no header for you!"
            textView.text = headerText
        }
    }

    inner class SimpleFooterViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_footer,parent,false)
    ) {
        private val leftButton: Button = itemView.findViewById(R.id.leftButton)
        private val rightButton: Button = itemView.findViewById(R.id.rightButton)

        fun onBind() {
            leftButton.setOnClickListener {
                Log.i("Left", "Button clicked!")
            }

            rightButton.setOnClickListener {
                Log.i("Right", "Button clicked!")
            }
        }
    }
}