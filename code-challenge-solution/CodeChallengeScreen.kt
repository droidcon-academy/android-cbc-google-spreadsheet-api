package com.droidcon.googlespreadsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.droidcon.googlespreadsheet.data.StringArray

/**
 * This code challenge request the Viewer to add a new Tab "Sheet2" in our
 * Google Spreadsheet, this time containing the following informations:
 * - "id" of each row
 * - "name" of the person
 * - "income" of the person, in Billions of Dollars
 * With this information, you can now go ahead and create all the code
 * to display this information in a new Screen of your Android project.
 */
@Composable
fun CodeChallengeScreen(viewModel: SpreadsheetViewModel) {
	val sheet by viewModel.sheetData.collectAsState()
	
	Column(
		modifier = Modifier.padding(10.dp)
		.background(Color.LightGray)
	) {
		if (sheet.isEmpty()) {
			// Show loading indicator or placeholder
			Text(text = "Loading...") 
		} else {
			Sheet2Header(
				color = Color.White,
				fontWeight = FontWeight.Bold
			)
			LazyColumn {
				items(sheet) { item ->
					Sheet2Column(item = item)
					Divider()
				}
			}
		}
	}
}

@Composable
fun Sheet2Header(
	color: Color,
	fontWeight: FontWeight
) {
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceAround
	) {
		Text(
			"id",
			color = color,
			fontWeight = fontWeight,
			modifier = Modifier
				.weight(2f)
				.header()
		)
		Text(
			"name",
			color = color,
			fontWeight = fontWeight,
			modifier = Modifier
				.weight(5f)
				.header()
		)
		Text(
			"income",
			color = color,
			fontWeight = fontWeight,
			modifier = Modifier
				.weight(5f)
				.header()
		)
	}
}

@Composable
fun Sheet2Column(
	item: StringArray
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(5.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceAround
	) {
		Text(
			text = item[0],
			modifier = Modifier.weight(2f)
		)
		Text(
			text = item[1],
			modifier = Modifier.weight(5f)
		)
		Text(
			text = item[2],
			modifier = Modifier.weight(5f)
		)
	}
}