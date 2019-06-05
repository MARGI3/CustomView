package com.magic.customview.page

import com.magic.customview.R

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
object PageModelsCreator {

    fun getDrawBasicModeList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_draw_basic))
        pageModels.add(
            ItemModel(
                R.string.title_draw_color,
                R.layout.view_drawone_practice_color_view,
                R.layout.view_drawone_sample_color_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_circle,
                R.layout.view_drawone_practice_circle_view,
                R.layout.view_drawone_sample_circle_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_rect,
                R.layout.view_drawone_practice_rect_view,
                R.layout.view_drawone_sample_rect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_point,
                R.layout.view_drawone_practice_point_view,
                R.layout.view_drawone_sample_point_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_oval,
                R.layout.view_drawone_practice_oval_view,
                R.layout.view_drawone_sample_oval_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_line,
                R.layout.view_drawone_practice_line_view,
                R.layout.view_drawone_sample_line_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_round_rect,
                R.layout.view_drawone_practice_round_rect_view,
                R.layout.view_drawone_sample_round_rect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_arc,
                R.layout.view_drawone_practice_arc_view,
                R.layout.view_drawone_sample_arc_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_path,
                R.layout.view_drawone_practice_path_view,
                R.layout.view_drawone_sample_path_view
            )
        )
        return pageModels
    }

    fun getPaintColorModeList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_paint_color))
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_linear_gradient,
                R.layout.view_paint_color_practice_lineargradient_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_radial_gradient,
                R.layout.view_paint_color_practice_radialgradient_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_sweep_gradient,
                R.layout.view_paint_color_practice_sweepgradient_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_bitmap_shader,
                R.layout.view_paint_color_practice_bitmapshader_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_compose_shader,
                R.layout.view_paint_color_practice_composeshader_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_lighting_color_filter,
                R.layout.view_paint_color_practice_lightingcolorfilter_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_porterduff_color_filter,
                R.layout.view_paint_color_practice_porterduff_colorfilter_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_matrix_color_filter,
                R.layout.view_paint_color_practice_matrix_colorfilter_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_color_xfermode,
                R.layout.view_paint_color_practice_xfermode_view
            )
        )
        return pageModels
    }

    fun getPaintEffectModeList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_paint_effect))
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_anti_alias,
                R.layout.view_paint_effect_practice_anti_alias_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_paint_style,
                R.layout.view_paint_effect_practice_paint_style_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_stroke_width,
                R.layout.view_paint_effect_practice_stroke_width_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_stroke_cap,
                R.layout.view_paint_effect_practice_stroke_cap_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_stroke_join,
                R.layout.view_paint_effect_practice_stroke_join_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_stroke_miter,
                R.layout.view_paint_effect_practice_stroke_miter_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_dash_path_effect,
                R.layout.view_paint_effect_practice_dash_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_corner_path_effect,
                R.layout.view_paint_effect_practice_corner_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_discrete_path_effect,
                R.layout.view_paint_effect_practice_discrete_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_path_dash_path_effect,
                R.layout.view_paint_effect_practice_path_dash_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_sum_path_effect,
                R.layout.view_paint_effect_practice_sum_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_compose_path_effect,
                R.layout.view_paint_effect_practice_compose_path_effect_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_shadow_layer_effect,
                R.layout.view_paint_effect_practice_shadow_layer_view
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_paint_effect_blur_mask_filter,
                R.layout.view_paint_effect_practice_blur_mask_filter_view
            )
        )
        return pageModels
    }

    fun getCanvasDrawTextModelList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_paint_effect))
        pageModels.add(
            ItemModel(
                R.string.title_canvas_draw_text_position,
                R.layout.view_canvas_draw_text_position
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_draw_text_on_path,
                R.layout.view_canvas_draw_text_on_path
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_draw_text_static_layout,
                R.layout.view_canvas_draw_text_static_layout
            )
        )
        return pageModels
    }

    fun getCanvasModelList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_canvas))
        pageModels.add(
            ItemModel(
                R.string.title_canvas_transform_order,
                R.layout.view_canvas_transform_order
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_clip,
                R.layout.view_canvas_clip
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_translate,
                R.layout.view_canvas_translate
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_rotate,
                R.layout.view_canvas_rotate
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_scale,
                R.layout.view_canvas_scale
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_canvas_skew,
                R.layout.view_canvas_skew
            )
        )
        return pageModels
    }

    fun getMatrixModelList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_matrix))
        pageModels.add(
            ItemModel(
                R.string.title_matrix_pre_and_post,
                R.layout.view_matrix_pre_post_diff
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_matrix_translate,
                R.layout.view_matrix_translate
            )
        )
        return pageModels
    }

    fun getDrawOrderList(): ArrayList<ItemModel> {
        val pageModels = ArrayList<ItemModel>()
        pageModels.add(ItemModel(R.string.item_title_draw_order))
        pageModels.add(
            ItemModel(
                R.string.title_draw_order_after_on_draw,
                R.layout.view_draw_order_after_on_draw
            )
        )
        pageModels.add(
            ItemModel(
                R.string.title_draw_order_before_on_draw,
                R.layout.view_draw_order_before_on_draw
            )
        )
        return pageModels
    }
}