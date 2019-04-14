package com.magic.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.magic.customview.page.ItemModel
import com.magic.customview.page.PageModelsCreator

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = ListAdapter(createItemModels())
        mRecyclerView.adapter = mAdapter
        mRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun createItemModels(): ArrayList<ItemModel> {
        val itemList = ArrayList<ItemModel>()
        itemList.addAll(PageModelsCreator.getDrawBasicModeList())
        itemList.addAll(PageModelsCreator.getPaintColorModeList())
        itemList.addAll(PageModelsCreator.getPaintEffectModeList())
        itemList.addAll(PageModelsCreator.getCanvasDrawTextModelList())
        return itemList
    }
}
