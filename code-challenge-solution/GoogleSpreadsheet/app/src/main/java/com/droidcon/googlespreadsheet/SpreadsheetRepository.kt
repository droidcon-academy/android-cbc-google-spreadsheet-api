package com.droidcon.googlespreadsheet

import com.droidcon.googlespreadsheet.data.StringArray
import com.droidcon.googlespreadsheet.remote.ApiClient

class SpreadsheetRepository {
	private val apiInterface = ApiClient.retrofitService

	suspend fun getSpreadSheetData(): ArrayList<StringArray> {
		val sheetObject = apiInterface.getGoogleSpreadSheetDataFromWeb()
		val values = sheetObject.values
		return values
	}
}