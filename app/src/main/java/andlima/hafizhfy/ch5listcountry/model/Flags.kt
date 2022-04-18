package andlima.hafizhfy.ch5listcountry.model


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String
)