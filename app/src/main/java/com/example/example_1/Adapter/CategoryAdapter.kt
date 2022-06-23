package com.example.example_1.Adapter

import android.content.*
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.example_1.Activity.QuotesShow
import com.example.example_1.R
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DataBaseModal
import java.io.File
import java.io.IOException
import java.util.*

class CategoryAdapter(
    val factivity: QuotesShow,
    var list2: ArrayList<DataBaseModal>,
    val list3: ArrayList<CategoryModal>,
    val images: IntArray,

    ) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(factivity).inflate(R.layout.quotesview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Text = list2[position].quote
        holder.txt.text = list2[position].quote


        holder.share.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody =
                "Hello USER,\nPlease Rate Quotes App On Play Store\n⭐️⭐️⭐️⭐️⭐️\n\nYOUR QUOTE\n \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\n\n$Text"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, Text)
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            factivity.startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        holder.copy.setOnClickListener {
            val myClipboard =
                factivity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val myClip: ClipData = ClipData.newPlainText("Label", Text)
            myClipboard.setPrimaryClip(myClip)
            Toast.makeText(factivity, "Copied Successfully", Toast.LENGTH_LONG).show()
        }
        holder.image.setOnClickListener {
            val r = Random()
            val randomNumber: Int = r.nextInt(images.size)
            holder.image.setImageResource(images.get(randomNumber))

        }

        holder.download.setOnClickListener {

            holder.image.setDrawingCacheEnabled(true)
            val bitamp: Bitmap = holder.image.getDrawingCache()

            try {
                saveBitmap(factivity, bitamp, CompressFormat.PNG, "image/*", "newimg.png")
            } catch (e: Exception) {
            }
        }
    }

    override fun getItemCount(): Int {
        Log.e("TAG", "getItemCount: " + list2.size)
        return list2.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<TextView>(R.id.slogan_txt)
        var download = itemView.findViewById<LinearLayout>(R.id.download_btn)
        var copy = itemView.findViewById<LinearLayout>(R.id.copy_btn)
        var share = itemView.findViewById<LinearLayout>(R.id.share_btn)
        var image = itemView.findViewById<ImageView>(R.id.change_images_btn)


    }

    @Throws(IOException::class)
    fun saveBitmap(
        context: Context,
        bitmap: Bitmap,
        format: CompressFormat,
        mimeType: String,
        displayName: String
    ): Uri? {
        val relativeLocation = Environment.DIRECTORY_DCIM + File.separator + "PhotoMaker"
        val values = ContentValues()
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
        values.put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation)
        val resolver = context.contentResolver
        var uri: Uri? = null
        return try {
            val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            uri = resolver.insert(contentUri, values)
            if (uri == null) throw IOException("Failed to create new MediaStore record.")
            resolver.openOutputStream(uri).use { stream ->
                if (stream == null) throw IOException("Failed to open output stream.")
                if (!bitmap.compress(
                        format,
                        95,
                        stream
                    )
                ) throw IOException("Failed to save bitmap.")
            }
            Toast.makeText(context, "" + uri, Toast.LENGTH_SHORT).show()
            uri
        } catch (e: IOException) {
            if (uri != null) {
                // Don't leave an orphan entry in the MediaStore
                resolver.delete(uri, null, null)
            }
            throw e
        }
    }

}