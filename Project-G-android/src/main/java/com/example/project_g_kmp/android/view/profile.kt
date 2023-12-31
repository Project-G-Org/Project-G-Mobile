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
import androidx.navigation.NavController
import com.example.project_g_kmp.android.R
import com.example.project_g_kmp.android.navigation.Destinations
import com.example.project_g_kmp.android.presentation.components.SliderBanner
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile (navController: NavController){

    Column(
        Modifier
            .background(color = Color(0xFFEBEBEB))
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp, alignment = Alignment.Top),
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
                               .fillMaxWidth(), color = Color(0xFFEBEBEB))

                           Column {
                               Row(Modifier.padding(10.dp,0.dp),
                               verticalAlignment = Alignment.CenterVertically) {
                               Icon(
                                   painterResource(id = R.drawable.baseline_location_on_24),
                                   contentDescription = null,
                                   Modifier.size(20.dp),
                                   tint = Color(0xFFE5684A)
                               )
                                   Text(
                                       "Local :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                                       Modifier.size(20.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "De :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                                       Modifier.size(20.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Email :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                                       Modifier.size(20.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Telefone :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                                       Modifier.size(20.dp),
                                       tint = Color(0xFFE5684A)
                                   )
                                   Text(
                                       "Site :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                               Row(Modifier.padding(5.dp,0.dp),
                                   verticalAlignment = Alignment.CenterVertically) {


                                   Icon(
                                       painterResource(id = R.drawable.baseline_home_24),
                                       contentDescription = null,
                                       Modifier.size(20.dp),
                                       tint = Color(0xFFE5684A)
                                   )

                                   Text(
                                       "Link :",
                                       Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                        .fillMaxWidth(),
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

                    Column(
                        modifier = Modifier
                            .padding(25.dp, 5.dp)
                            .fillMaxWidth()
                    ) {

                        Text(
                            text = "Et eius voluptate dolorum debitis ducimus fugit molestiae dolor. Eum et dolores aut reprehenderit dignissimos nihil error. Ducimus voluptas velit laboriosam provident. Labore est quis ad eum sed. Ratione quibusdam fugiat. Qui labore quisquam dolorum maiores deserunt dolores nihil.Et eius voluptate dolorum debitis ducimus fugit molestiae dolor. Eum et dolores aut reprehenderit dignissimos nihil error. Ducimus voluptas velit laboriosam provident. Labore est quis ad eum sed. Ratione quibusdam fugiat. Qui labore quisquam dolorum maiores deserunt dolores nihil.",
                            color = Color.Black,
                            fontSize = 12.sp,
                        )

                    }

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
                                Modifier.size(25.dp),
                                tint = Color(0xFFE5684A))
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painterResource(id = R.drawable.baseline_thumb_up_24),
                                contentDescription = null,
                                Modifier.size(25.dp),
                                tint = Color(0xFFE5684A)
                            )
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painterResource(id = R.drawable.baseline_share_24),
                                contentDescription = null,
                                Modifier.size(25.dp),
                                tint = Color(0xFFE5684A))}

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painterResource(id = R.drawable.baseline_save_alt_24),
                                contentDescription = null,
                                Modifier.size(25.dp),
                                tint = Color(0xFFE5684A))
                        }
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
                        TextButton(onClick = { navController.navigate(Destinations.PROFILE) }) {

                    Text(
                        "post",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )}
                    Divider(modifier = Modifier
                        .height(2.dp)
                        .width(40.dp),
                        color = Color(0xFFE5684A))
                    }

                    TextButton(onClick = { navController.navigate(Destinations.PROFILEP) }) {
                    Text(
                        "projetos",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )}
                }
            }
        }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier
                    .padding(10.dp,5.dp,10.dp,70.dp)
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



        Row(modifier = Modifier
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


            IconButton(onClick = { navController.navigate(Destinations.SEARCH) }) {

                Icon(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }


            Column  (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                IconButton(onClick = { navController.navigate(Destinations.PROFILE) }) {
                    Icon(
                        painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                Divider(modifier = Modifier
                    .height(2.dp)
                    .width(40.dp),
                    color = Color(0xFFE5684A))

            }
        }
    }
}
