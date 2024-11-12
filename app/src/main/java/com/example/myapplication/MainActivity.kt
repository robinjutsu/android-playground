package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataForAdapter = ArrayList<String>()
        repeat (150) {
            dataForAdapter.add("Element $it")
        }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val simpleAdapter = SimpleAdapter()
        simpleAdapter.setData(dataForAdapter)
        //recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        recyclerView.adapter = simpleAdapter
        simpleAdapter.notifyDataSetChanged()
    }
}