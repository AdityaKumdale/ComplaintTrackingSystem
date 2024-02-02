package com.example.complainttrackingsystem.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.complainttrackingsystem.data.newCategory

@Composable
fun assignedComplaints(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color(0xfffefcfc)
        ),
        border = BorderStroke(1.dp, Color.Black),
        content = {

                Text("Complaints To Be Solved",
                    color = Color(0xff404969),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .offset(
                            x = (56.5).dp,
                            y = (44.5).dp
                        )
                )
        },
        modifier = modifier
            .requiredWidth(width = 362.dp)
            .requiredHeight(height = 153.dp)

            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color(0xfffefcfc))
            .border(
                border = BorderStroke(4.dp, Color.Black),
                shape = RoundedCornerShape(15.dp)
            ))

}

@Preview(widthDp = 362, heightDp = 153)
@Composable
private fun assignedComplaintsPreview() {
    assignedComplaints(Modifier)
}



@Composable
fun yourComplaintsCard(){
    Box (

        modifier= Modifier
            .width(362.dp)
            .height(153.dp)
            .border(4.dp, Color.Black, RoundedCornerShape(19.dp))
            .clip(shape = RoundedCornerShape(19.dp))
            .background(color = Color(0xfffefcfc))
    ){
            Text(
                text = "Your Complaints",
                color = Color(0xff404969),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(
                        x = (-56.5).dp,
                        y = (-44.5).dp
                    )
            )
            ClickableText(text = AnnotatedString("See all"),
                onClick = {},
                style = TextStyle(
                    color = Color(0xff404969),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(
                        x = 122.5.dp,
                        y = (-41).dp
                    )
            )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 33.dp,
                    y = 66.dp
                )
                .requiredWidth(width = 293.dp)
                .requiredHeight(height = 65.dp)
                .shadow(4.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .background(color = Color(0xfffefcfc))
        ){
            Text(
                text = "Biomedical",
                color = Color(0xff4285f4),
                style = TextStyle(
                    fontSize = 20.sp),
               modifier = Modifier
                    .offset(
                        x = 18.dp,
                        y = 2.dp
                    )
            )


            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color(0xff404969),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append("Complaint No.")}
                    withStyle(style = SpanStyle(
                        color = Color(0xff4285f4),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append(" ")}
                    withStyle(style = SpanStyle(
                        color = Color(0xff828282),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append("56")}},
                modifier = Modifier
                    .offset(
                        x = 18.dp,
                        y = 39.dp
                    )

            )


            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color(0xff585f7b),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append("Status")}
                    withStyle(style = SpanStyle(
                        color = Color(0xff404969),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append(": ")}
                    withStyle(style = SpanStyle(
                        color = Color(0xff4eb268),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold)) {append("Ongoing")}},
                modifier = Modifier
                    .offset(
                        x = 168.dp,
                        y = 39.dp
                    )
            )
        }


    }
}

@Preview(widthDp = 362, heightDp = 153)
@Composable
private fun yourComplaintsCardPreview() {
    yourComplaintsCard()
}

@Composable
fun newComplaintCard(){
    Box (
        modifier= Modifier
            .width(362.dp)
            .height(271.dp)
            .border(4.dp, Color.Black, RoundedCornerShape(19.dp))
            .clip(shape = RoundedCornerShape(19.dp))
            .background(color = Color(0xfffefcfc))
    ){
        Text(
            text = "Your Complaints",
            color = Color(0xff404969),
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = (106.5).dp,
                    y = (24.5).dp
                )
        )

        Box (
            modifier= Modifier
                .width(362.dp)
                .height(200.dp)
                .align(alignment = Alignment.BottomEnd)
                .border(0.dp, Color.White, RoundedCornerShape(19.dp))
                //.clip(shape = RoundedCornerShape(19.dp))
                .background(color = Color(0xfffefcfc))
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                //modifier = Modifier.height(168.dp).offset(55.dp,88.dp)
            ) {
                items(newComplaintList.size) {
                    newCategoryItem(it)
                }
            }
        }

    }
}
@Preview(widthDp = 362, heightDp = 271)
@Composable
private fun newComplaintCardPreview() {
    newComplaintCard()
}

val newComplaintList= listOf(
    newCategory(
        icon = Icons.Rounded.StarHalf,
        name = "Biomedical",
        background = Color.LightGray
    ) ,
            newCategory(
        icon = Icons.Rounded.StarHalf,
        name = "IT",
        background = Color.LightGray
    ),
    newCategory(
            icon = Icons.Rounded.StarHalf,
            name = "Maintainence",
            background = Color.LightGray
        ),
    newCategory(
            icon = Icons.Rounded.StarHalf,
            name = "Facility",
            background = Color.LightGray
        )
)

@Composable
fun newCategoryItem(
    index: Int
) {
    val complaint = newComplaintList[index]
    var lastPaddingEnd = 0.dp

    Box(modifier = Modifier.padding(start = 5.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .width(152.dp)
                .height(84.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(complaint.background)
                    .padding(0.dp)
                    .width(32.dp)
                    .height(32.dp),
            ) {
                Icon(
                    modifier = Modifier.align(alignment = Alignment.Center),
                    imageVector = complaint.icon,
                    contentDescription = complaint.name,
                    tint = Color.White
                )
            }

            Text(
                text = complaint.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
    }
}
@Preview(widthDp = 362, heightDp = 271)
@Composable
private fun newCategoryItemPreview() {
    newCategoryItem(1)
}