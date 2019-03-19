package com.magic.customview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.magic.customview.page.PageActivity


class ListAdapter(list: List<ItemModel>) : RecyclerView.Adapter<ListAdapter.PagerItemHolder>() {

    companion object {
        private const val VIEW_TYPE_PAGER = 1
    }
    private var mList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerItemHolder {
          when(viewType) {
              VIEW_TYPE_PAGER -> return PagerItemHolder.create(parent)
          }
        return PagerItemHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: PagerItemHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_PAGER
    }

    class PagerItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var mText: TextView = itemView.findViewById(R.id.item_title)

        companion object {
            fun create(parent: ViewGroup): PagerItemHolder {
                return PagerItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
            }
        }

        fun bind(itemModel: ItemModel) {
            mText.setText(itemModel.mTitleId)
            mText.setOnClickListener {
                val context = it.context
                val intent = PageActivity.createIntent(context, itemModel.mPageModels)
                context.startActivity(intent)
            }
        }

    }
}