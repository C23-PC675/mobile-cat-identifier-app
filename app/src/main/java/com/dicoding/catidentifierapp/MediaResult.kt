package com.dicoding.catidentifierapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.catidentifierapp.databinding.ActivityMediaResultBinding
import com.dicoding.catidentifierapp.ml.ModelLiteStev
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class MediaResult : AppCompatActivity() {
    private lateinit var binding: ActivityMediaResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imageUri: Uri? = null

        val imageUriString = intent.getStringExtra("imageUri")
        if (imageUriString != null) {
            imageUri = Uri.parse(imageUriString)
            binding.preview.setImageURI(imageUri)
        } else {
            val data: Uri? = intent.data
            if (data != null) {
                binding.preview.setImageURI(data)
            }
        }

        binding.send.setOnClickListener {
            if (imageUri != null) {
                catModel(imageUri)
            }
        }
    }

    private fun catModel(imageUri: Uri) {
        val model = ModelLiteStev.newInstance(this)

        val inputStream = this.contentResolver.openInputStream(imageUri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        inputStream?.close()

        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)

        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        val byteBuffer = convertBitmapToByteBuffer(resizedBitmap)
        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer
        val max = getMax(outputFeature0.floatArray)
        val labels =
            application.assets.open("labels.txt").bufferedReader().use { it.readText() }.split("\n")

        Log.i("MediaResult.CatModel", "Value: ${labels[max]}")
        model.close()
    }

    private fun getMax(arr: FloatArray): Int {
        var ind = 0
        var min = 0.0f

        for (i in arr.indices) {
            if (arr[i] > min) {
                min = arr[i]
                ind = i
            }
        }
        return ind
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer =
            ByteBuffer.allocateDirect(4 * 224 * 224 * 3)
        byteBuffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(224 * 224)
        bitmap.getPixels(pixels, 0, 224, 0, 0, 224, 224)

        for (pixelValue in pixels) {
            val red = (pixelValue shr 16 and 0xFF) / 255.0f
            val green = (pixelValue shr 8 and 0xFF) / 255.0f
            val blue = (pixelValue and 0xFF) / 255.0f

            byteBuffer.putFloat(red)
            byteBuffer.putFloat(green)
            byteBuffer.putFloat(blue)
        }

        byteBuffer.rewind()
        return byteBuffer
    }
}