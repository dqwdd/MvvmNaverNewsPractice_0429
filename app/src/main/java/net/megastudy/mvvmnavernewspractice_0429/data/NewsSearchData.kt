package net.megastudy.mvvmnavernewspractice_0429.data

data class NewsSearchData(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<Items>,
)