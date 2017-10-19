package kr.pe.vero.sample.github.network

import com.google.gson.annotations.SerializedName
import kr.pe.vero.sample.github.model.GithubRepo

/**
 * @author vero
 * @since 2017. 10. 17.
 */
data class FindResponse(
        @SerializedName("items")
        var items: List<GithubRepo>,
        @SerializedName("total_count")
        var totalCount: Int,
        var nextPage: Int?
)