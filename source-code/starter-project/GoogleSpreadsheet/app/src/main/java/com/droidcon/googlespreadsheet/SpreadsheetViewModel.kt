package com.droidcon.googlespreadsheet

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.googlespreadsheet.data.StringArray
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SheetViewModel : ViewModel() {
	private val repository = SheetRepository()

	private val _sheetData = MutableStateFlow(ArrayList<StringArray>())
	val sheetData: StateFlow<ArrayList<StringArray>> = _sheetData

	init {
		fetchGoogleSpreadSheetData()
	}

	private fun fetchGoogleSpreadSheetData() {
		viewModelScope.launch {
			try {
				val items = repository.getSpreadSheetData()
				_sheetData.value = items
			} catch (e: Exception) {
				// Handle error
				Log.d(TAG, e.message.toString())
			}
		}
	}
}