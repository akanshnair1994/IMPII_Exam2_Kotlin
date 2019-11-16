package com.hexamind.retrofiteval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Text {

    @SerializedName("data")
    @Expose
    var data: String? = null
    @SerializedName("size")
    @Expose
    var size: Int? = null
    @SerializedName("style")
    @Expose
    var style: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("hOffset")
    @Expose
    var hOffset: Int? = null
    @SerializedName("vOffset")
    @Expose
    var vOffset: Int? = null
    @SerializedName("alignment")
    @Expose
    var alignment: String? = null
    @SerializedName("onMouseUp")
    @Expose
    var onMouseUp: String? = null

}