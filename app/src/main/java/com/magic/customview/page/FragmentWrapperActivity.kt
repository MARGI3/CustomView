package com.magic.customview.page

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.magic.customview.R

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class FragmentWrapperActivity : AppCompatActivity() {

    private lateinit var mFragmentName: String
    private lateinit var mFragmentArgs: Bundle

    companion object {

        private const val BUNDLE_KEY_FRAGMENT_NAME = "bundle.key.fragment.class.name"
        private const val BUNDLE_KEY_ARGS = "bundle.key.args"

        fun createIntent(context: Context, fragmentClass: Class<out Fragment>, args: Bundle): Intent {
            val intent = Intent(context, FragmentWrapperActivity::class.java)
            intent.putExtra(BUNDLE_KEY_FRAGMENT_NAME, fragmentClass.name)
            intent.putExtra(BUNDLE_KEY_ARGS, args)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        extractIntent()

        var fragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
        if (fragment == null) {
            fragment = Fragment.instantiate(this, mFragmentName, mFragmentArgs)
        }

        fragment?.let {
            if (!fragment.isAdded) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.frame_layout, it)
                    .commit()
            }
        }
    }

    private fun extractIntent() {
        mFragmentName = intent.getStringExtra(BUNDLE_KEY_FRAGMENT_NAME)
        mFragmentArgs = intent.getBundleExtra(BUNDLE_KEY_ARGS)
    }

}