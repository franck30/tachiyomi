package eu.kanade.tachiyomi.data.track.bangumi

import com.google.gson.annotations.SerializedName

data class Collection(
  @SerializedName("private") val isprivate: Int? = 0,
  val comment: String? = "",
  val ep_status: Int? = 0,
  val lasttouch: Int? = 0,
  val rating: Int? = 0,
  val status: Status? = Status(),
  val tag: List<String?>? = listOf(),
  val user: User? = User(),
  val vol_status: Int? = 0
)