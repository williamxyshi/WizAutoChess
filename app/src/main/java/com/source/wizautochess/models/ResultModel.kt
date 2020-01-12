package com.source.wizautochess.models

object ResultModel {

    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)


}

