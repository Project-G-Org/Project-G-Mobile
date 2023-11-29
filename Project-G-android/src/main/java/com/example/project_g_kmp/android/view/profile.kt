package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_g_kmp.android.R
import com.example.project_g_kmp.android.presentation.components.SliderBanner

@Composable
fun Profile (modifier: Modifier = Modifier.background(Color(0xFFEBEBEB))){

    Column(
        Modifier
            .background(color = Color(0xFFEBEBEB))
            .fillMaxSize(),

    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = Color(0xFF202020)),
            verticalArrangement = Arrangement.Center) {

            Box(Modifier
                .fillMaxWidth()
                .height(150.dp)){
                Image(painter = painterResource(id = R.drawable.post4), contentDescription = null)
            }

            Row(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth()
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                    contentDescription = null,
                    Modifier
                        .size(60.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(3.dp, 10.dp)
                ){

                    Text(
                        "marcelo",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        "maranhao",
                        color = Color.White,
                        fontSize = 20.sp,

                    )

                }

            }
        }

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .horizontalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                        contentDescription = null,
                        Modifier
                            .size(60.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(3.dp, 10.dp)
                    ){

                        Text(
                            "marcelo",
                            color = Color(0xFFE5684A),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = "MARANHAO",
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
                SliderBanner()
//                LazyRow(
//                    modifier = Modifier
//                        .padding(all = 10.dp)
//                        .clip(RoundedCornerShape(18.dp))
////                        .horizontalScroll(rememberScrollState())
//                        .fillMaxWidth()
//                ) {
//                    item {
//                        Image(
//                            painter = painterResource(id = R.drawable.backlogin),
//                            contentDescription = null,
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier
//                                .width(300.dp)
//                                .height(500.dp)
//                                .padding(horizontal = 15.dp)
//                        )
//                    }
//                    item {
//                        Image(
//                            painter = painterResource(id = R.drawable.backlogin),
//                            contentDescription = null,
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier
//                                .width(300.dp)
//                                .height(500.dp)
//                                .padding(horizontal = 15.dp)
//                        )
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .padding(all = 10.dp)
//                        .clip(RoundedCornerShape(18.dp))
////                        .horizontalScroll(rememberScrollState())
//                        .fillMaxWidth()
//                        .scrollable(rememberScrollableState {
//                            it
//                        }, Orientation.Horizontal)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.backlogin),
//                        contentDescription = null,
//                        contentScale = ContentScale.FillBounds,
//                        modifier = Modifier
//                            .width(300.dp)
//                            .height(500.dp)
//                            .background(Color.Red)
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.backlogin),
//                        contentDescription = null,
//                        contentScale = ContentScale.FillBounds,
//                        modifier = Modifier
//                            .width(300.dp)
//                            .height(500.dp)
//                            .background(Color.Red)
//                    )
//                }

                Row(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = Color.White),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Icon(
                        painterResource(id = R.drawable.baseline_mode_comment_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A))

                    Icon(
                        painterResource(id = R.drawable.baseline_thumb_up_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A))

                    Icon(
                        painterResource(id = R.drawable.baseline_share_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A))

                    Icon(
                        painterResource(id = R.drawable.baseline_save_alt_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A))

                }
            }

     }
    }
}

@Composable
@Preview
private fun Preview(){
    Profile()
}