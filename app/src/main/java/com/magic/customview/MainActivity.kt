package com.magic.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
        itemList.add(ItemModel(R.string.item_title_draw_basic, PageModelsCreator.getDrawBasicModeList()))
        itemList.add(ItemModel(R.string.item_title_paint_color, PageModelsCreator.getPaintColorModeList()))
        itemList.add(ItemModel(R.string.item_title_paint_effect, PageModelsCreator.getPaintEffectModeList()))
        return itemList
    }
}
