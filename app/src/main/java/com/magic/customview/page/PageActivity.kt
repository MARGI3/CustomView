package com.magic.customview.page

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.magic.customview.R

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class PageActivity : AppCompatActivity() {

    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private var mPageModels: List<PageModel>? = null

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

}