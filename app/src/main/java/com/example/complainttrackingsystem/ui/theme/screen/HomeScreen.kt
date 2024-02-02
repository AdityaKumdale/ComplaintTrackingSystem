package com.example.complainttrackingsystem.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.complainttrackingsystem.ui.theme.components.assignedComplaints
import com.example.complainttrackingsystem.ui.theme.components.SearchBarM3
import com.example.complainttrackingsystem.ui.theme.components.newComplaintCard
import com.example.complainttrackingsystem.ui.theme.components.yourComplaintsCard


@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
          //  .padding(start = 16.dp, end = 16.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
//            .padding(padding)
    ) {
        SearchBarM3()
        Spacer(modifier = Modifier.height(16.dp))
        assignedComplaints(Modifier)
        Spacer(modifier = Modifier.height(36.dp))
        yourComplaintsCard()
        Spacer(modifier = Modifier.height(36.dp))
        newComplaintCard()
    }



//        Box(
//            modifier = Modifier.fillMaxSize().padding(padding),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = "HOME",
//                fontSize = MaterialTheme.typography.h4.fontSize
//            )
//        }



}

@Composable
@Preview(widthDp = 462, heightDp = 1153,showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}