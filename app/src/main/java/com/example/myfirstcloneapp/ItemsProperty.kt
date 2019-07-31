package com.example.myfirstcloneapp

class ItemsProperty {
    var title: String
    var smallImage: Int? = null
    var createTime: String? = null
    var content : String
    var mainImage: Int
    val hearted: Boolean = false
    val stared :  Boolean = false

    constructor(title: String, image: Int, createTime: String, mainImage: Int, content: String, hearted: Boolean, stared : Boolean) {
        this.title = title
        this.smallImage = image
        this.createTime = createTime
        this.content = content
        this.mainImage = mainImage
    }

}