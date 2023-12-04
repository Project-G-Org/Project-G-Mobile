package presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import navigation.screencomponents.ProfileScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.SliderBanner

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileScreen(component: ProfileScreenComponent) {
    Scaffold(
        topBar = {
            Header()
        }
    ) { paddingValues ->

    Column(
        modifier = Modifier
            .background(color = Color(0xFFEBEBEB))
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(paddingValues = paddingValues)
            .wrapContentHeight(),

        ) {

//        Column(
//            modifier = Modifier
//            .fillMaxWidth()
//            .height(300.dp)
//            .background(color = Color(0xFFEBEBEB)),
//        ) {

//            Header()

//            Column(
//                verticalArrangement = Arrangement.Bottom
//            ) {

                SobreMim()

                Followers()

//                TabLayouts(
//                    component,
//                    modifier = Modifier
//                        .fillMaxSize()
//                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "poste",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "projetos",
                        color = Color(0xFFE5684A),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
//            }
//        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardPosts()
        }
    }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayouts(component: ProfileScreenComponent, modifier: Modifier = Modifier) {
    var tabIndex by remember {
        mutableIntStateOf(0)
    }
    val tabs = listOf("Feed", "Cadastro", "Login")

    val pagerState = rememberPagerState {
        tabs.size
    }

    LaunchedEffect(tabIndex) {
        pagerState.animateScrollToPage(tabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            tabIndex = pagerState.currentPage
        }
    }

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) {index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when(index) {
                    //0 -> FeedScreen()

                    1 -> component.goToCadastro()

                    2 -> component.goToLogin()
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CardPosts() {
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

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource("carr1.png"),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp),

                        )

                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(0.dp)
                        ) {
                            Text(
                                text = "marcelo",
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
                        painter = painterResource("baseline_more_vert_24.xml"),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                }

            }
            //SliderBanner()
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

            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(color = Color.White),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource("baseline_mode_comment_24.xml"),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource("baseline_thumb_up_24.xml"),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource("baseline_share_24.xml"),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource("baseline_save_alt_24.xml"),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }
            }
        }
    }
}

@Composable
private fun Followers() {
    Card(
        elevation = 6.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp, 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = " 3 Seguidores",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

                Divider(
                    modifier = Modifier
                        .height(10.dp)
                        .width(1.dp), color = Color.Black
                )

                Text(
                    text = "Seguindo 184",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun SobreMim() {
    Card(
        elevation = 6.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp, 5.dp)
            .fillMaxWidth(),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "Sobre min",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "PEDREIRO NO MARANHAO 20 ANOS, SOLTEIRO ¨~¨",
                    color = Color.Black,
                    fontSize = 15.sp,
                )

                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(), color = Color.Black
                )

                Icon(
                    painter = painterResource("baseline_mode_comment_24.xml"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color(0xFFE5684A),
                )
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .paint(
                painter = painterResource("post2.png"),
                contentScale = ContentScale.FillBounds
            )
    ) {

        Row(
            modifier = Modifier
                .padding(all = 10.dp)
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource("carr1.png"),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )

            Column(
                modifier = Modifier
                    .padding(3.dp, 10.dp)
            ) {

                Text(
                    text = "marcelo",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )

                Row {

                    val buttonColor = remember {
                        mutableStateOf(Color(0xFFE5684A))
                    }

                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        modifier = Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFE5684A)
                        )
                    )
                    {
                        Text(text = "Seguir")
                    }

                    Button(
                        onClick = { buttonColor.value = Color(0xFFE5684A) },
                        modifier = Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5684A)),
                    )
                    {
                        Text(text = "Enviar mensagem")
                    }

                }

            }

        }
    }
}