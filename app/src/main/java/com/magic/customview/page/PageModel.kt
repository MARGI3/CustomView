package com.magic.customview.page

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes


class PageModel @JvmOverloads constructor(
    @StringRes val mTitleRes: Int,
    @LayoutRes val mPracticeLayoutRes: Int,
    @LayoutRes val mSampleLayoutRes: Int = -1
) : Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(mTitleRes)
        parcel.writeInt(mPracticeLayoutRes)
        parcel.writeInt(mSampleLayoutRes)
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