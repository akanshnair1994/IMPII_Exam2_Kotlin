package com.hexamind.retrofiteval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Widget {

    @SerializedName("debug")
    @Expose
    var debug: String? = null
    @SerializedName("window")
    @Expose
    var window: Window? = null
    @SerializedName("image")
    @Expose
    var image: Image? = null
    @SerializedName("text")
    @Expose
    var text: Text? = null

}