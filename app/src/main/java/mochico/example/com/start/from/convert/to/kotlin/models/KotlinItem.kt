package mochico.example.com.start.from.convert.to.kotlin.models

import android.os.Parcel
import android.os.Parcelable

class KotlinItem(
        var id: Int = 0,
        var name: String? = null
) : Parcelable {


    private constructor(source: Parcel) : this(source.readInt(),source.readString())

    public override fun describeContents(): Int {
        return 0
    }

    public override fun writeToParcel(dest: Parcel, atags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
    }

    fun isSameItem(obj: Any): Boolean {
        return (obj is KotlinItem && (obj as KotlinItem).id == this.id)
    }

    companion object {

        val CREATOR: Parcelable.Creator<KotlinItem> = object : Parcelable.Creator<KotlinItem> {

            public override fun createFromParcel(source: Parcel): KotlinItem {
                return KotlinItem(source)
            }

            public override fun newArray(size: Int): Array<KotlinItem> {
                return arrayOfNulls<KotlinItem>(size)
            }
        }
    }
}
