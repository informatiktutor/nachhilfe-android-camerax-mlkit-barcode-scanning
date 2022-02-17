package de.informatiktutor.camerax_mlkit_barcode_scanning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.barcode.common.Barcode

class BarcodeScannerViewModel : ViewModel() {
    val scannedBarcode = MutableLiveData<Barcode>()

    fun setScannedBarcode(barcode: Barcode) {
        scannedBarcode.value = barcode
    }
}
