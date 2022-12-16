package com.claze2022.attraction1

data class DinningAttraction constructor(var TbVwRestaurants:DinngResult)

data class DinngResult constructor(var list_total_count:Int, var row:MutableList<DinningItem>)

data class DinningItem constructor(
    var LANG_CODE_ID:String,
    var POST_SJ:String,
    var NEW_ADDRESS:String,
    var CMMN_TELNO:String,
    var CMMN_HMPG_URL:String,
    var SUBWAY_INFO:String,
    var FD_REPRSNT_MENU:String,
    var CMMN_USE_TIME:String,
    var POST_SN:String
    )
