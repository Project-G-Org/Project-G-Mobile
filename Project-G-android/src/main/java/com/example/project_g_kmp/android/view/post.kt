package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_g_kmp.android.R
import com.example.project_g_kmp.android.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Post (navController: NavController){

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()){

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .padding(10.dp, 5.dp)
                .fillMaxWidth(),) {
            Column (
                Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    IconButton(onClick = { navController.navigate(Destinations.FEED) }) {

                        Icon(
                            painterResource(id = R.drawable.baseline_close_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color.Black
                        )
                    }

                    TextButton(onClick = { navController.navigate(Destinations.FEED) }) {
                        Text(
                            "Post",
                            Modifier.padding(5.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.backlogin),
                            contentDescription = null,
                            Modifier
                                .size(55.dp)
                                .clip(RoundedCornerShape(180.dp)),
                            contentScale = ContentScale.FillBounds,

                            )

                        var post by remember { mutableStateOf("") }
                        androidx.compose.material3.TextField(
                            value = post,
                            onValueChange = { post = it },
                            Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedIndicatorColor = Color.White,
                                unfocusedSuffixColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                focusedSuffixColor = Color.White,
                                containerColor = Color.White
                            )
                        )
                    }

                    IconButton(onClick = { /*TODO*/ }) {

                        Icon(
                            painterResource(id = R.drawable.baseline_add_photo_alternate_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )
                    }

                }
            }
        }
    }
}