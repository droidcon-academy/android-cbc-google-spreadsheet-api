package com.droidcon.googlespreadsheet.remote

import com.droidcon.googlespreadsheet.BuildConfig
import com.droidcon.googlespreadsheet.data.SpreadsheetData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
	@GET("{sheetId}/values/{range}")
	suspend fun getGoogleSpreadSheetDataFromWeb(
		@Path("sheetId") sheetId: String = BuildConfig.SHEET_ID,
		@Path("range") range: String = BuildConfig.RANGE,
		@Query("key") apiKey: String = BuildConfig.API_KEY
	) : SpreadsheetData
}