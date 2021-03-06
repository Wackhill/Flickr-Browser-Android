package com.shpakovskiy.flickrbrowser.photo

import android.os.Parcelable
import android.util.Log
import kotlinx.android.parcel.Parcelize
import java.io.IOException
import java.io.ObjectStreamException
import java.io.Serializable

@Parcelize
class Photo(
    var title: String,
    var author: String,
    var authorId: String,
    var link: String,
    var tags: String,
    var image: String
) : Parcelable {

    companion object {
        private const val serialVersionUID = 1L
    }

    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', link='$link', tags='$tags', image='$image')"
    }

    @Throws(IOException::class)
    private fun writeObject(out: java.io.ObjectOutputStream) {
        out.writeUTF(title)
        out.writeUTF(author)
        out.writeUTF(authorId)
        out.writeUTF(link)
        out.writeUTF(tags)
        out.writeUTF(image)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(inStream: java.io.ObjectInputStream) {
        title = inStream.readUTF()
        author = inStream.readUTF()
        authorId = inStream.readUTF()
        link = inStream.readUTF()
        tags = inStream.readUTF()
        image = inStream.readUTF()
    }

    @Throws(ObjectStreamException::class)
    private fun readObjectNoData() {
        Log.d("Photo", "readObjectNoDataCalled")
    }
}