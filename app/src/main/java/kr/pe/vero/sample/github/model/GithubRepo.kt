package kr.pe.vero.sample.github.model

import com.google.gson.annotations.SerializedName

/**
 * @author vero
 * @since 2017. 10. 17.
 */
data class GithubRepo(
        @SerializedName("owner")
        var owner: Owner,
        @SerializedName("name")
        var name: String,
        @SerializedName("full_name")
        var fullName: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("stargazers_count")
        var stargazersCount: Int
)