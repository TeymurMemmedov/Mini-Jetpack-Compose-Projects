package com.example.topicgrid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.model.Topic
import com.example.topicgrid.R
import com.example.topicgrid.ui.theme.CardBackground

@Composable
fun TopicCard(
    topicItem:Topic,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier
        .clip(shape = RoundedCornerShape(4.dp))
        .height(64.dp)


    ) {

        Image(
            modifier = Modifier
                .fillMaxHeight(),
            painter = painterResource(id = topicItem.imageRes),
            contentDescription = stringResource(id = topicItem.name),
            contentScale = ContentScale.Crop

        )

        Column(
            modifier = Modifier
                .background(
                    CardBackground
                )
                .fillMaxHeight()
                .fillMaxWidth()
            ,
            verticalArrangement = Arrangement.SpaceEvenly

        ) {

            Text(

                text = stringResource(id = topicItem.name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_small)
                )

            )



            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Icon(painterResource(id = R.drawable.ic_grain) , contentDescription =  null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = topicItem.availableCourses.toString(),
                    style = MaterialTheme.typography.labelMedium)

            }

        }
    }

}

@Composable
@Preview
fun TopicCardPreview(){

        TopicCard(topicItem = Topic(R.string.photography, 58, R.drawable.photography))


}