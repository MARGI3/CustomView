package com.magic.customview


/**
 * author : maji
 * date   : 12/01/2019
 * mail   : maji@bilibili.com
 */
object ModelsInitialiser {

    fun getDrawOneModeList(): ArrayList<PageActivity.PageModel> {
        val pageModels = ArrayList<PageActivity.PageModel>()
        pageModels.add(
            PageActivity.PageModel(
                R.string.title_draw_color,
                R.layout.view_drawone_sample_color_view,
                R.layout.view_drawone_practice_color_view
            )
        )
        return pageModels
    }
}