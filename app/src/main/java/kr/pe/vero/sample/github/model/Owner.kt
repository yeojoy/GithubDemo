package kr.pe.vero.sample.github.model

import com.google.gson.annotations.SerializedName

/**
 * @author vero
 * @since 2017. 10. 17.
 */
data class Owner(
        @SerializedName("login")
        var login: String,
        @SerializedName("url")
        var url: String
)