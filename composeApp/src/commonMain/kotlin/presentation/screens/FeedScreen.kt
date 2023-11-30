package presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.SliderBanner

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FeedScreen(modifier: Modifier = Modifier.background(Color(0xFFEBEBEB))){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                elevation = 4.dp,
            ) {
                Row(
                    modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color(0xFF202020)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Icon(
                        painterResource("baseline_add_24.xml"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )

                    Icon(
                        painterResource("baseline_home_24.xml"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )

                    Icon(
                        painterResource("baseline_search_24.xml"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )

                    Icon(
                        painterResource("baseline_person_24.xml"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }
            }
        },
        scaffoldState = rememberScaffoldState()
    ) { paddingValues ->



    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEBEBEB))
            .padding(paddingValues)
    ) {

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier
                .padding(0.dp, 5.dp)
                .horizontalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource("carr1.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr2.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr3.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                   painter = painterResource("carr4.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr5.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr6.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr7.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
                Image(
                    painter = painterResource("carr8.png"),
                    contentDescription = null,
                    Modifier
                        .size(80.dp)
                )
            }

            Card(
                elevation = 6.dp,
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically,) {

                            Image(
                                painter = painterResource("carr1.png"),
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
                                painterResource("baseline_more_vert_24.xml"),
                                contentDescription = null,
                                Modifier.size(30.dp),
                                tint = Color.Black
                            )
                        }

                    }
                    SliderBanner()

                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Icon(
                            painterResource("baseline_mode_comment_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_thumb_up_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_share_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_save_alt_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                    }
                }

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
            }

            Card(
                elevation = 6.dp,
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth(),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .horizontalScroll(rememberScrollState())
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource("perf2.png"),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ) {

                            Text(
                                "dojavam",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "EUA CALIFORMIA",
                                color = Color.Black,
                                fontSize = 12.sp,
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

                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                    ) {

                        Image(
                            painter = painterResource("post4.png"),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(600.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Icon(
                            painterResource("baseline_mode_comment_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_thumb_up_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_share_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_save_alt_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )
                    }
                }
            }

            Card(
                elevation = 6.dp,
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth(),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .horizontalScroll(rememberScrollState())
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource("perf2.png"),
                            contentDescription = null,
                            Modifier
                                .size(60.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(3.dp, 10.dp)
                        ){

                            Text(
                                "dojavam",
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "EUA CALIFORMIA",
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
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

                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Icon(
                            painterResource("baseline_mode_comment_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_thumb_up_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_share_24.xml"),
                            contentDescription = null,
                            Modifier.size(30.dp),
                            tint = Color(0xFFE5684A)
                        )

                        Icon(
                            painterResource("baseline_save_alt_24.xml"),
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

//    Column(
//        Modifier
//        .fillMaxSize(),
//        verticalArrangement = Arrangement.Bottom
//    ){
//
//
//
//        Row(
//            modifier = Modifier
//            .height(60.dp)
//            .fillMaxWidth()
//            .background(color = Color(0xFF202020)),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceAround
//        ) {
//
//            Icon(
//                painterResource("baseline_add_24.xml"),
//                contentDescription = null,
//                Modifier.size(30.dp),
//                tint = Color(0xFFE5684A)
//            )
//
//            Icon(
//                painterResource("baseline_home_24.xml"),
//                contentDescription = null,
//                Modifier.size(30.dp),
//                tint = Color(0xFFE5684A)
//            )
//
//            Icon(
//                painterResource("baseline_search_24.xml"),
//                contentDescription = null,
//                Modifier.size(30.dp),
//                tint = Color(0xFFE5684A)
//            )
//
//            Icon(
//                painterResource("baseline_person_24.xml"),
//                contentDescription = null,
//                Modifier.size(30.dp),
//                tint = Color(0xFFE5684A)
//            )
//        }
//    }
}