package presentation.screens

import org.jetbrains.compose.resources.painterResource

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import navigation.ScreenAEvent
import navigation.screencomponents.LoginScreenComponent
import navigation.screencomponents.ProfileScreenComponent
import navigation.screencomponents.ProjectScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectScreen(component: ProjectScreenComponent) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEBEBEB))
    ) {

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020))) {

                Column {

                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row {

                            Image(
                                painter = painterResource("carr1.png"),
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
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource("baseline_more_vert_24.xml"),
                                contentDescription = null,
                                Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(25.dp, 5.dp)
                            .fillMaxWidth()
                    ) {

                    }

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(0.dp, 0.dp, 18.dp, .18.dp))
                            .fillMaxWidth()
                    ) {

                        Image(
                            painter = painterResource("post3.png"),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(600.dp)
                        )
                    }
                }

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF202020),
                    ),
                    modifier = Modifier
                        .padding(10.dp, 5.dp)
                        .fillMaxWidth(),
                ) {
                    Column {

                        Row(
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Row {

                                Image(
                                    painter = painterResource("post3.png"),
                                    contentDescription = null,
                                    Modifier
                                        .size(60.dp)
                                        .clip(RoundedCornerShape(180.dp)),
                                    contentScale = ContentScale.FillBounds,
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
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painterResource("baseline_more_vert_24.xml"),
                                    contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = Color.White
                                )
                            }
                        }

                        Column(
                            modifier = Modifier
                                .padding(25.dp, 5.dp)
                                .fillMaxWidth()
                        ) {

                        }

                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(0.dp, 0.dp, 18.dp, .18.dp))
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
                    }
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF202020),
                ),
                modifier = Modifier
                    .padding(10.dp,5.dp,10.dp,70.dp)
                    .fillMaxWidth(),
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row {

                            Image(
                                painter = painterResource("carr1.png"),
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
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painterResource("baseline_more_vert_24.xml"),
                                contentDescription = null,
                                Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                    }

                    Text(
                        text = "Ops, parece que você chegou ao fim!",
                        Modifier.padding(10.dp, 5.dp, 10.dp, 70.dp)
                    )

                    Column(
                        modifier = Modifier

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
                }
            }
        }

    }

    Column(Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

        Column{

            Box(
                modifier = Modifier
                    .padding(10.dp,10.dp),
                contentAlignment = Alignment.Center

            ) {

                IconButton(onClick = {  component.onGoToProfileScreen() }) {

                    Icon(
                        painterResource("baseline_circle_24.xml"),
                        contentDescription = null,
                        Modifier
                            .size(80.dp),
                        tint = Color(0xFF202020)
                    )

                    Icon(
                        painterResource("baseline_add_24.xml"),
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

            IconButton(onClick = {  component.onGoToFeedScreen() }) {
                Icon(
                    painterResource("baseline_home_24.xml"),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }

            Column  (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                IconButton(onClick = {  component.onGoToProfileScreen() }) {
                    Icon(
                        painterResource("baseline_apartment_24.xml"),
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

            IconButton(onClick = { component.onGoToProfileScreen() }) {

                Icon(
                    painterResource("baseline_search_24.xml"),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }


            IconButton(onClick = { component.onGoToProfileScreen() }) {
                Icon(
                    painterResource("baseline_person_24.xml"),
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color(0xFFE5684A)
                )
            }
        }
    }
}