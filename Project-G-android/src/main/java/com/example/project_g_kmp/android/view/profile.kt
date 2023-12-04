package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_g_kmp.android.R
import com.example.project_g_kmp.android.presentation.components.SliderBanner
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile (modifier: Modifier = Modifier.background(Color(0xFFEBEBEB))){

    Column(
        Modifier
            .background(color = Color(0xFFEBEBEB))
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFEBEBEB)),
            ) {
            Box(){
                Image(painter = painterResource(id = R.drawable.post2),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.FillBounds,
                    )
            Row(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
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
                    ) {
                        Text(
                            "marcelo",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Row {
                            val buttonColor = remember {
                                mutableStateOf(Color(0xFFE5684A))
                            }
                            Button(
                                onClick = {buttonColor.value = Color(0xFFE5684A) },
                                Modifier.padding(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color(0xFFE5684A))
                            )
                            {
                                Text("Sequir",)
                            }
                            Button(
                                onClick = {buttonColor.value = Color(0xFFE5684A) },
                                Modifier.padding(5.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFFE5684A)),
                            )
                            {
                                Text("Enviar mensagem")
                            }
                        }
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.Bottom) {

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                    modifier = Modifier
                        .padding(10.dp, 5.dp)
                        .fillMaxWidth(),) {
                    Row (
                        Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically) {

                        Column {

                        }

                        Text(
                            " 3 Seguidores",
                            Modifier.padding(10.dp),
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Divider(modifier = Modifier
                            .height(10.dp)
                            .width(1.dp), color = Color.Black)

                        Text(
                            "Suguindo 184",
                            Modifier.padding(10.dp),
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top) {
                        Text(
                            "Sobre min",
                            Modifier.padding(5.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                       Column(
                           Modifier
                               .fillMaxWidth()
                               .padding(10.dp),
                       horizontalAlignment = Alignment.Start) {

                           var sobre by remember { mutableStateOf("")}
                           androidx.compose.material3.TextField(
                               value = sobre,
                               onValueChange = { sobre = it },
                               Modifier.fillMaxWidth(),
                               colors = TextFieldDefaults.textFieldColors(
                                   unfocusedIndicatorColor = Color.White,
                                   unfocusedSuffixColor = Color.White,
                                   focusedIndicatorColor = Color.White,
                                   focusedSuffixColor = Color.White,
                                   containerColor = Color.White
                               )
                           )
                           Divider(modifier = Modifier
                               .height(1.dp)
                               .fillMaxWidth(), color = Color.Black)
                           Column {
                               Row(Modifier.padding(10.dp,0.dp),
                               verticalAlignment = Alignment.CenterVertically) {
                               Icon(
                                   painterResource(id = R.drawable.baseline_location_on_24),
                                   contentDescription = null,
                                   Modifier.size(30.dp),
                                   tint = Color(0xFFE5684A)
                               )
                                   Text(
                                       "Local :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,
                                   )
                                   var local by remember { mutableStateOf("")}
                                   androidx.compose.material3.TextField(
                                       value = local,
                                       onValueChange = { local = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }

                               Row(Modifier.padding(10.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {
                                   Icon(
                                       painterResource(id = R.drawable.baseline_home_24),
                                       contentDescription = null,
                                       Modifier.size(30.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "De :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,

                                       )
                                   var de by remember { mutableStateOf("") }
                                   androidx.compose.material3.TextField(
                                       value = de,
                                       onValueChange = { de = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }
                               Row(Modifier.padding(10.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {
                                   Icon(
                                       painterResource(id = R.drawable.baseline_email_24),
                                       contentDescription = null,
                                       Modifier.size(30.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Email :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,
                                       )
                                   var de by remember { mutableStateOf("") }
                                   androidx.compose.material3.TextField(
                                       value = de,
                                       onValueChange = { de = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }
                               Row(Modifier.padding(10.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {

                                   Icon(
                                       painterResource(id = R.drawable.baseline_phone_24),
                                       contentDescription = null,
                                       Modifier.size(30.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Telefone :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,
                                       )
                                   var de by remember { mutableStateOf("") }
                                   androidx.compose.material3.TextField(
                                       value = de,
                                       onValueChange = { de = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }
                               Row(Modifier.padding(10.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {

                                   Icon(
                                       painterResource(id = R.drawable.baseline_web_24),
                                       contentDescription = null,
                                       Modifier.size(30.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Site :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,

                                       )
                                   var de by remember { mutableStateOf("") }
                                   androidx.compose.material3.TextField(
                                       value = de,
                                       onValueChange = { de = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }
                               Row(Modifier.padding(10.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {


                                   Icon(
                                       painterResource(id = R.drawable.baseline_home_24),
                                       contentDescription = null,
                                       Modifier.size(30.dp),
                                       tint = Color(0xFFE5684A)
                                   )

                                   Text(
                                       "Link :",
                                       color = Color.Black,
                                       fontSize = 15.sp,
                                       fontWeight = FontWeight.Bold,

                                       )
                                   var de by remember { mutableStateOf("") }
                                   androidx.compose.material3.TextField(
                                       value = de,
                                       onValueChange = { de = it },
                                       colors = TextFieldDefaults.textFieldColors(
                                           unfocusedIndicatorColor = Color.White,
                                           unfocusedSuffixColor = Color.White,
                                           focusedIndicatorColor = Color.White,
                                           focusedSuffixColor = Color.White,
                                           containerColor = Color.White
                                       )
                                   )
                               }
                           }
                       }
                    }
                }
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        modifier = Modifier
                            .padding(10.dp, 5.dp)
                            .fillMaxWidth(),) {
                        Row (
                            Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {

                            Image(painter = painterResource(id = R.drawable.univer),
                                contentDescription = null,
                                Modifier.size(70.dp)
                                    .padding(10.dp))

                        }
                    }

                Row (
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    Text(
                        "post",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Divider(modifier = Modifier
                        .height(2.dp)
                        .width(40.dp),
                        color = Color(0xFFE5684A))
                    }

                    Text(
                        "projetos",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
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
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically,) {

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.carr1),
                            contentDescription = null,
                            Modifier
                                .size(60.dp),
                            )

                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            TextButton(onClick = { /*TODO*/ },
                                modifier = Modifier.padding(0.dp)) {
                                Text(
                                    "marcelo",
                                    color = Color(0xFFE5684A),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }

                            Text(
                                text = "MARANHAO",
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }

                    IconButton(onClick = { /*TODO*/ }) {

                        Icon(
                            painterResource(id = R.drawable.baseline_more_vert_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color.Black
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
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(color = Color.White),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.baseline_mode_comment_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A))
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_thumb_up_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_share_24),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A))}

                    IconButton(onClick = { /*TODO*/ }) {
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

    Column(Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

        Column(){

            Box(
                modifier = Modifier
                    .padding(10.dp,10.dp),
                contentAlignment = Alignment.Center

            ) {

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        painterResource(id = R.drawable.baseline_circle_24),
                        contentDescription = null,
                        Modifier
                            .size(80.dp),
                        tint = Color(0xFF202020)
                    )

                    Icon(
                        painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null,
                        Modifier
                            .padding(10.dp)
                            .size(40.dp),
                        tint = Color(0xFFE5684A)
                    )
                }
            }
        }

        Row(modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color(0xFF202020)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }


            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }


            IconButton(onClick = { /*TODO*/ }) {
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

@Composable
@Preview
private fun Preview(){
    Profile()
}