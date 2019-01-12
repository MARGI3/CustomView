package com.magic.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_basic).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_basic -> startActivity(PageActivity.createIntent(this, ModelsInitialiser.getDrawOneModeList()))
        }
    }
}
