package mochico.example.com.start.from.convert.to.kotlin.models

import android.os.Parcel
import android.os.Parcelable

class JavaItem : Parcelable {

    var id: Int = 0
    var name: String? = null

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

    private constructor(source: Parcel) {
        id = source.readInt()
        name = source.readString()
    }

    public override fun describeContents(): Int {
        return 0
    }

    public override fun writeToParcel(dest: Parcel, atags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
    }

    fun isSameItem(obj: Any): Boolean {
        return (obj is JavaItem && (obj as JavaItem).id == this.id)
    }

    companion object {

        val CREATOR: Parcelable.Creator<JavaItem> = object : Parcelable.Creator<JavaItem> {

            public override fun createFromParcel(source: Parcel): JavaItem {
                return JavaItem(source)
            }

            public override fun newArray(size: Int): Array<JavaItem> {
                return arrayOfNulls<JavaItem>(size)
            }
        }
    }
}
