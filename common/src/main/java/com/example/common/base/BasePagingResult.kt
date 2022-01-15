package com.example.common.base

/**
 *    author : Bin
 *    date   : 2022/1/1514:38
 *    desc   :
 */
class BasePagingResult<T>(
    var curPage: Int,//当前页
    var offset: Int,
    var over: Boolean,//是否结束，还有没有数据
    var pageCount: Int,//总页数
    var size: Int,//一页多少条数据
    var total: Int,//总数量
    var datas: T//数据
)