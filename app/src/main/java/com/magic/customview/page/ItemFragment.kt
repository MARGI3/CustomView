package com.magic.customview.page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import com.magic.customview.R

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class ItemFragment : Fragment() {

    private var mModel: ItemModel? = null

    companion object {

        const val BUNDLE_KEY_MODEL: String = "bundle.key.model"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        args?.let {
            mModel = it.getParcelable(BUNDLE_KEY_MODEL)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mModel == null) {
            return null
        }

        val view = inflater.inflate(R.layout.fragment_page, container, false)

        val sampleStub = view.findViewById<ViewStub>(R.id.sample_stub)
        mModel?.let {
            if (it.mSampleLayoutRes > 0) {
                sampleStub.layoutResource = it.mSampleLayoutRes
                sampleStub.inflate()
                sampleStub.visibility = View.VISIBLE
            } else {
                val sampleWrapper = view.findViewById<View>(R.id.sample_wrapper)
                sampleWrapper.visibility = View.GONE
                val divider = view.findViewById<View>(R.id.divider)
                divider.visibility = View.GONE
            }

            val practiceStub = view.findViewById<ViewStub>(R.id.practice_stub)
            if (it.mPracticeLayoutRes > 0) {
                practiceStub.layoutResource = mModel!!.mPracticeLayoutRes
                practiceStub.inflate()
                practiceStub.visibility = View.VISIBLE
            } else {
                val practiceWrapper = view.findViewById<View>(R.id.practice_wrapper)
                practiceWrapper.visibility = View.GONE
                val divider = view.findViewById<View>(R.id.divider)
                divider.visibility = View.GONE
            }
        }

        return view
    }
}