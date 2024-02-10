package com.example.complainttrackingsystem.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.complainttrackingsystem.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewComplaint(

    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "New Complaint",
                    color = Color(0xff404969),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow(color = Color.Black.copy(alpha = 0.25f), offset = Offset(0f, 4f), blurRadius = 4f)
                    ),
                    modifier = modifier)
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 16.dp,
                            bottom = 16.dp,
                            end = 16.dp
                        )
                        .clickable {

                        }
                )
            }
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff475372),
                    fontSize = 18.sp)
                ) {append("Department Name: ")}
                withStyle(style = SpanStyle(
                    color = Color(0xffc4c4c4),
                    fontSize = 18.sp)
                ) {append("IT")}},
            modifier = modifier
                .fillMaxWidth()
                .offset(x = 53.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff475372),
                    fontSize = 18.sp)
                ) {append("Date: ")}
                withStyle(style = SpanStyle(
                    color = Color(0xffc4c4c4),
                    fontSize = 18.sp)
                ) {append("31/12/2022")}},
            modifier = modifier
                .fillMaxWidth()
                .offset(x = 53.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff475372),
                    fontSize = 18.sp)
                ) {append("Time : ")}
                withStyle(style = SpanStyle(
                    color = Color(0xffc4c4c4),
                    fontSize = 18.sp)
                ) {append("05:45")}},
            modifier = modifier
                .fillMaxWidth()
                .offset(x = 53.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff475372),
                    fontSize = 18.sp)
                ) {append("Phone Number ")}
                withStyle(style = SpanStyle(
                    color = Color(0xffc4c4c4),
                    fontSize = 18.sp)
                ) {append("1234567890")}},
            modifier = modifier
                .fillMaxWidth()
                .offset(x = 53.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .requiredWidth(width = 357.dp)
                .requiredHeight(height = 629.dp)
                .clip(shape = RoundedCornerShape(13.dp))
                .background(color = Color(0xffd9d9d9))
        ){
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Select Floor:",
                    color = Color(0xff475372),
                    style = TextStyle(
                        fontSize = 18.sp),
                    modifier = modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                SimpleDropdownMenu()

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Select Problem type:",
                    color = Color(0xff475372),
                    style = TextStyle(
                        fontSize = 18.sp),
                    modifier = modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                SimpleDropdownMenu()

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Select Sub-Problem:",
                    color = Color(0xff475372),
                    style = TextStyle(
                        fontSize = 18.sp),
                    modifier = modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                SimpleDropdownMenu()

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Describe your issue:",
                    color = Color(0xff475372),
                    style = TextStyle(
                        fontSize = 18.sp),
                    modifier = modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xfffefcfc)
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 137.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Select Priority Level:",
                    color = Color(0xff475372),
                    style = TextStyle(
                        fontSize = 18.sp),
                    modifier = modifier
                        .fillMaxWidth()
                )
                RadioButtons()
                Row (
                    modifier = Modifier
                ){
                    Text(
                        text = "Profile photo:",
                        color = Color(0xff475372),
                        style = TextStyle(
                            fontSize = 18.sp),
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .offset(0.dp, 5.dp)
                            .wrapContentWidth()
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .offset(
                                x = 0.dp,
                                y = 0.5.dp
                            )
                            .requiredWidth(width = 150.dp)
                            .requiredHeight(height = 34.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(color = Color(0xff828282))
                    ){
                        Text(
                            text = "Add Photo",
                            color = Color(0xfff1f1f2),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                        )
                    }
                }


            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .requiredWidth(width = 240.dp)
                .requiredHeight(height = 40.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color(0xff828282))
        ){
            Text(
                text = "Submit Complaint",
                color = Color(0xfff1f1f2),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdownMenu() {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var floor by remember {
        mutableStateOf("")
    }

    //anchor the dropdown box to the TextField that we will create in a moment.
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        },
        modifier = Modifier.clip(shape = RoundedCornerShape(13.dp))
    ) {
        TextField(
            value = floor,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "Please select your floor")
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "1")
                },
                onClick = {
                    floor = "1"
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "2")
                },
                onClick = {
                    floor = "2"
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Other")
                },
                onClick = {
                    floor = "Other"
                    isExpanded = false
                }
            )
        }
    }
}

@Composable
fun RadioButtons() {
    val radioOptions = listOf("High","Medium","Low")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Row(
        modifier = Modifier.padding(0.dp),
        //verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        radioOptions.forEach { buttonName ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (buttonName == selectedOption),
                    onClick = { selectedOption = buttonName }
                )
                Text(
                    text = buttonName,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .offset(-10.dp)
                )
            }
        }
    }

}


@Preview(widthDp = 411, heightDp = 1223, showBackground = true)
@Composable
private fun NewComplaintPreview() {
    NewComplaint()
}