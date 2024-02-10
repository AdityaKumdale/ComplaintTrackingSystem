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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.complainttrackingsystem.ui.theme.components.assignedComplaints
import com.example.complainttrackingsystem.ui.theme.components.SearchBarM3
import com.example.complainttrackingsystem.ui.theme.components.newComplaintCard
import com.example.complainttrackingsystem.ui.theme.components.yourComplaintsCard


@Composable
fun HomeScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBarM3()
        Spacer(modifier = Modifier.height(16.dp))
        assignedComplaints(Modifier)
        Spacer(modifier = Modifier.height(36.dp))
        yourComplaintsCard(navController = navController)
        Spacer(modifier = Modifier.height(36.dp))
        newComplaintCard(navController)
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
    HomeScreen(navController = rememberNavController())
}