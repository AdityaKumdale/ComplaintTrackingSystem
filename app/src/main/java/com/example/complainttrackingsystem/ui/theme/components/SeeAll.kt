package com.example.complainttrackingsystem.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Data(val title: String, val complaintNo: String, val status: String)

@Composable
fun SeeAll() {
    val data = listOf(
        Data("Biomedical", "56", "Ongoing"),
        Data("Chemical", "57", "Completed"),
        Data("Electrical", "58", "Pending")
        // Add more data as needed
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(data) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color(0xfffefcfc))
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = item.title,
                        color = Color(0xff4285f4),
                        style = TextStyle(fontSize = 20.sp)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff585f7b),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append("Status") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff404969),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append(": ") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff4eb268),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append(item.status) }
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff404969),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append("Complaint No.") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff4285f4),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append(" ") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff828282),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold)
                            ) { append(item.complaintNo) }
                        }
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 411, heightDp = 1223, showBackground = true)
@Composable
private fun lazylistPreview() {
    SeeAll()
}
