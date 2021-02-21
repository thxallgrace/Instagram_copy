package com.thxallgrace.instagram_copy.model

data class ContentDTO(var explain: String? = null,
                      var imageUrl: String? = null,
                      var uid: String? = null,
                      var userId: String? = null,
                      var timestamp: Long? = null,
                      var favoritesCount: Int = 0,
                      var favorites: MutableMap<String, Boolean> = HashMap()){
    data class Comment(var uid: String? = null,
                       var userId: String? = null,
                       var comment: String? = null,
                       var timestamp: Long? = null)
}