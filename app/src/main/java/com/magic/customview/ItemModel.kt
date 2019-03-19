package com.magic.customview

import android.support.annotation.StringRes
import com.magic.customview.page.PageModel


class ItemModel(@StringRes titleId: Int, pageModels: ArrayList<PageModel>) {
    var mTitleId = titleId
    var mPageModels = pageModels
}