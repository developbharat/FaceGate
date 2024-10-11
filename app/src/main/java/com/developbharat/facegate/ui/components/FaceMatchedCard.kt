package com.developbharat.facegate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.R
import com.developbharat.facegate.common.toThumbnailBitmap
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData


@Composable
fun FaceMatchCard(modifier: Modifier, match: PersonFaceData) {
    Surface(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            /** TODO: Add support for multiple matches **/
            item {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text("Name: ${match.person.name}")
                    Text("ID: ${match.person.id}")
                    Text("Match Score: ${match.matchScore}")
                }
            }


            item {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        bitmap = match.person.thumbnail.toThumbnailBitmap().asImageBitmap(),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "${match.person.name} Face Matched"
                    )

                    Image(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .height(50.dp)
                            .width(50.dp),
                        painter = painterResource(R.drawable.check_mark),
                        contentDescription = "Check mark"
                    )
                }

            }
        }
    }
}
