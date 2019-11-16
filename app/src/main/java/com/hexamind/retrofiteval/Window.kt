package com.hexamind.retrofiteval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Window {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null

}