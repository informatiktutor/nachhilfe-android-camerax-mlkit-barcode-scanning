package de.informatiktutor.camerax_mlkit_barcode_scanning

import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarcodeImageAnalyzer(
    private val scanner: BarcodeScanner,
    private val listener: (barcode: Barcode) -> Unit
) : ImageAnalysis.Analyzer {

    companion object {
        private const val TAG = "BarcodeImageAnalyzer"
    }

    @androidx.camera.core.ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image =
                InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    // barcodes.map(listener)
                    barcodes.forEach {
                        listener(it)
                    }
                }
                .addOnFailureListener {
                    Log.e(TAG, "Failed to process image: $it")
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }
}
