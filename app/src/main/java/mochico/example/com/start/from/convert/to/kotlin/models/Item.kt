package mochico.example.com.start.from.convert.to.kotlin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
        var id: Int = 0,
        var name: String? = null
) : Parcelable {
    fun isSameItem(obj: Any): Boolean {
        return (obj as KotlinItem).id == this.id
    }
}