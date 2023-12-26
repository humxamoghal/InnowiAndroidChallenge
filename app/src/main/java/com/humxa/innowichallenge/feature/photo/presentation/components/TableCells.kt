package com.humxa.innowichallenge.feature.photo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import com.humxa.innowichallenge.ui.theme.h1
import com.humxa.innowichallenge.ui.theme.headingBold
import com.humxa.innowichallenge.ui.theme.regular12Blue
import com.humxa.innowichallenge.ui.theme.titleSemiBold

@Composable
fun PhotoTableCell(
    photo: PhotoEntity,
    isLast: Boolean
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            /**
             * Un comment below code if you want to add image to be loaded following
             * disk and memory cache mechanism
             */
            /**
             * Un comment below code if you want to add image to be loaded following
             * disk and memory cache mechanism
             */
            /**
             * Un comment below code if you want to add image to be loaded following
             * disk and memory cache mechanism
             */
            /**
             * Un comment below code if you want to add image to be loaded following
             * disk and memory cache mechanism
             */

            /*AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photo.thumbnailUrl)
                    .diskCacheKey(photo.id.toString())
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .width(0.dp)
                    .weight(.15f)
                    .padding(start = 5.dp, top = 5.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )*/

            Text(
                text = photo.title,
                style = titleSemiBold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(0.dp)
                    .weight(.35f)
                    .fillMaxHeight()
                    .padding(8.dp)
            )

            Divider(
                color = Color.Black,
                modifier = Modifier
                    .height(60.dp)
                    .width(0.5.dp)
            )

            Text(
                text = photo.thumbnailUrl,
                style = regular12Blue,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(0.dp)
                    .weight(.5f)
                    .fillMaxHeight()
                    .padding(8.dp)
            )
        }
        if (isLast.not()) {
            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.Black)
            )
        }
    }
}

@Composable
fun HeaderCell(
    firstLabel: String,
    secondLabel: String
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = firstLabel,
                style = headingBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(0.dp)
                    .weight(.35f)
                    .padding(8.dp)
            )
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .height(60.dp)
                    .width(1.dp)
            )

            Text(
                text = secondLabel,
                style = headingBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(0.dp)
                    .weight(.5f)
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun GroupCell(
    modifier: Modifier = Modifier,
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = h1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(20.dp)
        )

        Divider(
            color = Color.Black,
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
        )
    }
}
