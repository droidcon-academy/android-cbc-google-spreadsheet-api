package com.droidcon.googlespreadsheet.data

import com.google.gson.annotations.SerializedName

typealias StringArray = Array<String>
data class SpreadsheetData(
	@SerializedName("range")
	var range: String,
	@SerializedName("majorDimension")
	var majorDimension: String,
	@SerializedName("values")
	var values: ArrayList<StringArray>
)