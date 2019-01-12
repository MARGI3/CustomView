package com.magic.customview

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub

/**
 * author : maji
 * date   : 12/01/2019
 * mail   : maji@bilibili.com
 */
class PageFragment : Fragment() {

    @LayoutRes var mSampleLayoutRes: Int = 0
    @LayoutRes var mPracticeLayoutRes: Int = 0

    companion object {
        private const val BUNDLE_KEY_SAMPLE_RES: String = "bundle.key.sample.layout.res"
        private const val BUNDLE_KEY_PRACTICE_RES: String = "bundle.key.practice.layout.res"

        @JvmStatic
        fun newInstance(@LayoutRes sampleLayoutRes: Int, @LayoutRes practiceLayoutRes: Int): Fragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(BUNDLE_KEY_SAMPLE_RES, sampleLayoutRes)
            args.putInt(BUNDLE_KEY_PRACTICE_RES, practiceLayoutRes)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            mSampleLayoutRes = args.getInt(BUNDLE_KEY_SAMPLE_RES)
            mPracticeLayoutRes = args.getInt(BUNDLE_KEY_PRACTICE_RES)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page_one, container, false)

        val sampleStub = view.findViewById<ViewStub>(R.id.sample_stub)
        sampleStub.layoutResource = mSampleLayoutRes
        sampleStub.inflate()

        val practiceStub = view.findViewById<ViewStub>(R.id.practice_stub)
        practiceStub.layoutResource = mPracticeLayoutRes
        practiceStub.inflate()

        return view
    }
}