package com.hexamind.retrofiteval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {

    @SerializedName("src")
    @Expose
    var src: String? = null
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

}