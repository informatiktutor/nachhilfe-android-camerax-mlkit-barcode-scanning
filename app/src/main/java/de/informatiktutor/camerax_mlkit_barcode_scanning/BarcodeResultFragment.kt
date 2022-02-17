package de.informatiktutor.camerax_mlkit_barcode_scanning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class BarcodeResultFragment : Fragment() {

    private val viewModel: BarcodeScannerViewModel by activityViewModels()

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.barcode_result_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.barcodeResult)
        val scannedBarcode = viewModel.scannedBarcode.value
        if (scannedBarcode != null) {
            textView.text = scannedBarcode.displayValue.toString()
        } else {
             findNavController().navigate(R.id.action_global_barcodeScannerFragment)
        }
    }
}
