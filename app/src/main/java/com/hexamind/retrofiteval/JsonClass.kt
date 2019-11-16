package com.hexamind.retrofiteval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JsonClass {

    @SerializedName("widget")
    @Expose
    var widget: Widget? = null

}