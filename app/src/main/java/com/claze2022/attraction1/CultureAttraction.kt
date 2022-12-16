package com.claze2022.attraction1

data class CultureAttraction constructor(var TbVwAttractions:CultureResult)

data class CultureResult constructor(var list_total_count:Int, var row:MutableList<CultureItem>)

data class CultureItem constructor(
    var POST_SJ:String,
    var LANG_CODE_ID:String,
    var NEW_ADDRESS:String,
    var CMMN_TELNO:String,
    var CMMN_HMPG_URL:String,
    var CMMN_USE_TIME:String,
    var CMMN_BSNDE:String,
    var CMMN_RSTDE:String,
    var SUBWAY_INFO:String,
    var POST_SN:String
)