package com.magic.customview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.magic.customview.page.FragmentWrapperActivity
import com.magic.customview.page.ItemFragment
import com.magic.customview.page.ItemModel


class ListAdapter(list: List<ItemModel>) : RecyclerView.Adapter<ListAdapter.BaseItemHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 1
        private const val VIEW_TYPE_TITLE = 2
    }
    private var mList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemHolder {
          when(viewType) {
              VIEW_TYPE_ITEM -> return DemoItemHolder.create(parent)
              VIEW_TYPE_TITLE -> return TitleHolder.create(parent)
          }
        return BaseItemHolder(parent)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BaseItemHolder, position: Int) {
        if (holder is TitleHolder) {
            holder.bind(mList[position])
        } else if (holder is DemoItemHolder) {
            holder.bind(mList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = mList[position]
        if (model.mPracticeLayoutRes < 0
            && model.mSampleLayoutRes < 0) {
            return VIEW_TYPE_TITLE
        }
        return VIEW_TYPE_ITEM
    }

    open class BaseItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class DemoItemHolder(itemView: View) : BaseItemHolder(itemView) {

        private var mText: TextView = itemView.findViewById(R.id.item_title)

        companion object {
            fun create(parent: ViewGroup): DemoItemHolder {
                return DemoItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
            }
        }

        fun bind(itemModel: ItemModel) {
            mText.setText(itemModel.mTitleRes)
            mText.setOnClickListener {
                val context = it.context
                val bundle = Bundle()
                bundle.putParcelable(ItemFragment.BUNDLE_KEY_MODEL, itemModel)
                val intent = FragmentWrapperActivity.createIntent(context, ItemFragment::class.java, bundle)
                context.startActivity(intent)
            }
        }

    }

    class TitleHolder(itemView: View) : BaseItemHolder(itemView) {

        private var mText: TextView = itemView.findViewById(R.id.item_title)

        companion object {
            fun create(parent: ViewGroup): TitleHolder {
                return TitleHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
            }
        }

        fun bind(itemModel: ItemModel) {
            mText.setText(itemModel.mTitleRes)
            mText.setBackgroundColor(Color.GRAY)
        }

    }
}