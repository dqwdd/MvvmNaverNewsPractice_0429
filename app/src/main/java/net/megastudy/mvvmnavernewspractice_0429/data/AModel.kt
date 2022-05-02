package net.megastudy.mvvmnavernewspractice_0429.data

import net.megastudy.mvvmnavernewspractice_0429.BaseResponse

data class AModel<T>(
    override val result: String,
    override val msg: String,
    val aData: T
) : BaseResponse()