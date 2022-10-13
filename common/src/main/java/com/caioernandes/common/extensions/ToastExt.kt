package com.caioernandes.common.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showLongToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
}

fun Fragment.showShortToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}