package presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import helpers.URLS
import helpers.URLS.BASE_URL
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.launch
import model.Comment
import model.FeedScreenViewModel
import model.Posts
import navigation.screencomponents.FeedScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.ImageFonts
import presentation.Components.SliderBanner

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun FeedScreen(component: FeedScreenComponent, modifier: Modifier = Modifier.background(Color(0xFFEBEBEB))){
    val viewModel = getViewModel(Unit, viewModelFactory { FeedScreenViewModel() })
    val coroutineScope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MyBottomNavigationBar(component)
        },
        scaffoldState = rememberScaffoldState()
    ) { paddingValues ->

        val modalState = rememberModalBottomSheetState(initialValue = uiState.modalBottomSheetState)
        if(uiState.modalBottomSheetState == ModalBottomSheetValue.HalfExpanded) coroutineScope.launch{ modalState.show() }
        ModalBottomSheetLayout(
            modifier = Modifier.background(Color.Black),
            sheetShape = MaterialTheme.shapes.medium,
            sheetState = modalState,

            sheetContent = {
                AnimatedVisibility(visible = uiState.showComments) {
                    if (uiState.comments.isEmpty()) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Nenhum comentário cadastrado!!")
                        }
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize().padding(all = 12.dp)) {
                            items(uiState.comments) { comment ->
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        if(comment.author.profilePic != null) {
                                            KamelImage(
                                                resource = asyncPainterResource(data = "${URLS.POST_IMAGES_URL}${comment.author.profilePic}"),
                                                contentDescription = comment.author.name,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.size(60.dp).clip(CircleShape)
                                            )
                                        } else if (comment.author.image != null) {
                                            KamelImage(
                                                resource = asyncPainterResource(data = "${comment.author.image}"),
                                                contentDescription = comment.author.name,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.size(60.dp).clip(CircleShape)
                                            )
                                        } else {
                                            Image(
                                                painter = painterResource("no_image.jpg"),
                                                contentDescription = comment.author.name,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.size(60.dp).clip(CircleShape)
                                            )
                                        }

                                        Text(
                                            text = comment.author.name,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 12.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(12.dp))

                                    Text(
                                        comment.content,
                                        fontSize = 22.sp,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFEBEBEB))
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(uiState.posts.isEmpty()) {
                    CircularProgressIndicator(color = Color(0xFFF06D4D))
                }
                AnimatedVisibility(visible = uiState.posts.isNotEmpty()) {

                    Column(
                        Modifier
                            //.verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        StoriesTop()
                        Posts(uiState.posts, viewModel)
                    }

                }
            }
        }


    }

}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun MyBottomSheet(comments: List<Comment>, viewModel: FeedScreenViewModel) {
    val modalState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.HalfExpanded)
    ModalBottomSheetLayout(

        sheetShape = MaterialTheme.shapes.large,
        sheetState = modalState,
        sheetContent = {
            LazyColumn(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                items(comments) { comment ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        KamelImage(
                            asyncPainterResource(data = "${BASE_URL}${comment.author.image}"),
                            contentDescription = comment.author.name,
                            modifier = Modifier.size(30.dp)
                        )

                        Text(
                            text = comment.author.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        comment.content,
                        fontSize = 22.sp
                    )
                }
            }
        }
    ) {

    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun Posts(posts: List<Posts>, viewModel: FeedScreenViewModel) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(posts) { post ->
            var showComments by remember {
                mutableStateOf(false)
            }
            if(showComments) {
                viewModel.changeCommentsVisibility(show = true, comments = post.comments)
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
                        if(post.author.profilePic != null) {
                            KamelImage(
                                resource = asyncPainterResource(data = "${URLS.POST_IMAGES_URL}${post.author.profilePic}"),
                                contentDescription = post.author.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(60.dp).clip(CircleShape)
                            )
                        } else if (post.author.image != null) {
                            KamelImage(
                                resource = asyncPainterResource(data = "${post.author.image}"),
                                contentDescription = post.author.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(60.dp).clip(CircleShape)
                            )
                        } else {
                            Image(
                                painter = painterResource("no_image.jpg"),
                                contentDescription = post.author.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(60.dp).clip(CircleShape)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        ) {

                            Text(
                                post.author.name,
                                color = Color(0xFFE5684A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "EUA CALIFORNIA",
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
                            text = post.content,
                            color = Color.Black,
                            fontSize = 16.sp,
                        )

                    }

                    if(post.images.isNotEmpty()) {
                        SliderBanner(images = post.images, imageFont = ImageFonts.Posts)
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        IconButton(onClick = {
                            viewModel.changeCommentsVisibility(show = true, comments = post.comments)
                        }) {
                            Icon(
                                painterResource("baseline_mode_comment_24.xml"),
                                contentDescription = null,
                                Modifier.size(30.dp),
                                tint = Color(0xFFE5684A),
                            )
                        }

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

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MyBottomNavigationBar(component: FeedScreenComponent) {
    BottomNavigation(
        elevation = 4.dp
    ) {
        Column(Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom){

            Column(){

                Box(
                    modifier = Modifier
                        .padding(10.dp,10.dp),
                    contentAlignment = Alignment.Center

                ) {

                    IconButton(onClick = {}) {

                        Icon(
                            painterResource("baseline_circle_24"),
                            contentDescription = null,
                            Modifier
                                .size(80.dp),
                            tint = Color(0xFF202020)
                        )

                        Icon(
                            painterResource("baseline_add_24"),
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

                Column  (verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {

                    IconButton(onClick = {  component.onGoToProfileScreen() }) {
                        Icon(
                            painterResource("baseline_home_24"),
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

                IconButton(onClick = {  component.onGoToProfileScreen() }) {
                    Icon(
                        painterResource("baseline_apartment_24"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }


                IconButton(onClick = {  component.onGoToProfileScreen() }) {

                    Icon(
                        painterResource("baseline_search_24"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }


                IconButton(onClick = {  component.onGoToProfileScreen() }) {
                    Icon(
                        painterResource("baseline_person_24"),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color(0xFFE5684A)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ThirdCard() {
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

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun SecondCard() {
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
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun FirstCard() {
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
                        Modifier
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
            //SliderBanner()

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

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun StoriesTop() {
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
}