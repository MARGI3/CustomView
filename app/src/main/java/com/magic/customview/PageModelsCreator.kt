package com.magic.customview

import com.magic.customview.PageActivity.PageModel

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
object PageModelsCreator {

    fun getDrawOneModeList(): ArrayList<PageModel> {
        val pageModels = ArrayList<PageModel>()
        pageModels.add(
            PageModel(
                R.string.title_draw_color,
                R.layout.view_drawone_sample_color_view,
                R.layout.view_drawone_practice_color_view
            )
        )
        pageModels.add(
            PageModel(
                R.string.title_draw_circle,
                R.layout.view_drawone_sample_circle_view,
                R.layout.view_drawone_practice_circle_view
            )
        )
        pageModels.add(
            PageModel(
                R.string.title_draw_rect,
                R.layout.view_drawone_sample_rect_view,
                R.layout.view_drawone_practice_rect_view
            )
        )
        pageModels.add(
            PageModel(
                R.string.title_draw_point,
                R.layout.view_drawone_sample_point_view,
                R.layout.view_drawone_practice_point_view
            )
        )
        return pageModels
    }
}