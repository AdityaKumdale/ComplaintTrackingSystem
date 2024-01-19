package com.example.complainttrackingsystem.util

import androidx.annotation.DrawableRes
import com.example.complainttrackingsystem.R


sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
     object First : OnBoardingPage(
        image = R.drawable.first,
        title = "Register Complaints",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

     object Second : OnBoardingPage(
        image = R.drawable.second,
        title = "Quick Search Complaints",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

     object Third : OnBoardingPage(
        image = R.drawable.third,
        title = "Manage Complaints",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
