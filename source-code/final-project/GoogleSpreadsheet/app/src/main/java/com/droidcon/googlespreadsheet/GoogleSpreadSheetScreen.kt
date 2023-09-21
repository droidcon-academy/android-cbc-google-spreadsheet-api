package com.droidcon.googlespreadsheet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.droidcon.googlespreadsheet.data.StringArray

@Composable
fun GoogleSpreadSheetScreen(viewModel: SpreadsheetViewModel) {
	val sheet by viewModel.sheetData.collectAsState()

	Column(
		modifier = Modifier.padding(10.dp)
		.background(Color.LightGray)
	) {
		if (sheet.isEmpty()) {
			// Show loading indicator or placeholder
			Text(text = "Loading...") 
		} else {
			SheetHeader(
				color = Color.White,
				fontWeight = FontWeight.Bold
			)
			LazyColumn {
				items(sheet) { item ->
					SheetColumn(
						item = item,
						padding = 5.dp
					)
					Divider()
				}
			}
		}
	}
}

@Composable
fun SheetHeader(
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
			"continent",
			color = color,
			fontWeight = fontWeight,
			modifier = Modifier
				.weight(5f)
				.header()
		)
		Text(
			"flag",
			color = color,
			fontWeight = fontWeight,
			modifier = Modifier
				.weight(4f)
				.header()
		)
	}
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SheetColumn(
	item: StringArray,
	padding: Dp
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
		GlideImage(
			model = item[3],
			contentDescription = "${item[1]} flag",
			modifier = Modifier
				.padding(padding)
				.size(50.dp, 40.dp)
				.weight(4f)
		)
	}
}

fun Modifier.header(): Modifier =
	background(color = Color.Gray)
		.border(BorderStroke(2.dp, Color.White))
		.padding(5.dp)