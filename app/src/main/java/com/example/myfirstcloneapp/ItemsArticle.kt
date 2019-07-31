package com.example.myfirstcloneapp

import org.w3c.dom.Comment

class ItemsArticle {
    var imageArticle : Int? = null
    var titleArticle: String? = null
    var statusArticle: String? = null
    var dateArticle : String? = null
    var contentArticle : String? = null
    var likeArticle : String? = null
    var commentArticle : String? = null

    constructor(image: Int, title: String, status: String, date : String, content : String, like: String, comment: String){
        this.imageArticle = image
        this.titleArticle = title
        this.statusArticle = status
        this.dateArticle = date
        this.contentArticle = content
        this.likeArticle = like
        this.commentArticle = comment
    }
}