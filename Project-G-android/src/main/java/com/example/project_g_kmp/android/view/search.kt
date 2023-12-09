package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_g_kmp.android.R
import com.example.project_g_kmp.android.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search (navController: NavController, modifier: Modifier = Modifier.background(Color(0xFFEBEBEB))) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEBEBEB))
    ) {

        Column(Modifier
            .verticalScroll(rememberScrollState())) {

        Box (
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            )   {

            var pesquisa by remember { mutableStateOf("") }
            androidx.compose.material3.TextField(
                value = pesquisa,
                onValueChange = { pesquisa = it },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.White,
                    unfocusedSuffixColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    focusedSuffixColor = Color.White,
                    containerColor = Color.White

                )
            )

            Row ( Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End){




            IconButton(onClick = { /*TODO*/ }, Modifier
                .size(56.dp)) {
                Icon(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    Modifier.size(40.dp),
                    tint = Color(0xFF202020)
                )
             }
            }
        }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }


            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp,5.dp,10.dp,70.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "marcelo",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "MARANHAO",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }
                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(
                            "PERFIL",
                            color = Color(0xFF202020)
                        )
                    }
                }
            }
        }
    }
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .background(color = Color(0xFF202020)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                IconButton(onClick = { navController.navigate(Destinations.FEED) }) {
                    Icon(
                        painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                IconButton(onClick = { navController.navigate(Destinations.PROJECT) }) {
                    Icon(
                        painterResource(id = R.drawable.baseline_apartment_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    IconButton(onClick = { navController.navigate(Destinations.SEARCH) }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .height(2.dp)
                            .width(40.dp),
                        color = Color(0xFFE5684A)
                    )

                }


                IconButton(onClick = { navController.navigate(Destinations.PROFILE) }) {
                    Icon(
                        painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }
            }
        }
    }

