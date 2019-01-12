package com.magic.customview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

/**
 * author : maji
 * date   : 12/01/2019
 * mail   : maji@bilibili.com
 */


class PageActivity : AppCompatActivity() {

    lateinit var mTabLayout: TabLayout
    lateinit var mViewPager: ViewPager
    var mPageModels: List<PageModel>? = null

    companion object {

        private const val BUNDLE_KEY_MODEL_LIST = "bundle.key.model.list"

        fun createIntent(context: Context, list: ArrayList<PageModel>): Intent {
            val intent = Intent(context, PageActivity::class.java)
            intent.putParcelableArrayListExtra(BUNDLE_KEY_MODEL_LIST, list)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        extractIntent()

        mViewPager = findViewById(R.id.pager)
        mTabLayout = findViewById(R.id.tab_layout)

        if (mPageModels != null && mPageModels!!.isNotEmpty()) {
            mViewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

                override fun getItem(position: Int): Fragment {
                    val model = mPageModels!![position]
                    return PageFragment.newInstance(
                        model.mSampleLayoutRes,
                        model.mPracticeLayoutRes
                    )
                }

                override fun getCount(): Int {
                    return mPageModels!!.size
                }

                override fun getPageTitle(position: Int): CharSequence? {
                    return getString(mPageModels!![position].mTitleRes)
                }
            }
        }

        mTabLayout.setupWithViewPager(mViewPager)
    }

    private fun extractIntent() {
        mPageModels = intent.getParcelableArrayListExtra(BUNDLE_KEY_MODEL_LIST)
    }

    class PageModel(
        @StringRes val mTitleRes: Int,
        @LayoutRes val mSampleLayoutRes: Int,
        @LayoutRes val mPracticeLayoutRes: Int
    ) : Parcelable {

        override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeInt(mTitleRes)
             parcel.writeInt(mSampleLayoutRes)
             parcel.writeInt(mPracticeLayoutRes)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<PageModel> {
            override fun createFromParcel(parcel: Parcel): PageModel {
                return PageModel(parcel.readInt(), parcel.readInt(), parcel.readInt())
            }

            override fun newArray(size: Int): Array<PageModel?> {
                return arrayOfNulls(size)
            }
        }
    }

}