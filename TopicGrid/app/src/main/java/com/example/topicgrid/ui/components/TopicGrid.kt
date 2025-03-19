package com.example.topicgrid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic

@Composable
fun TopicGrid(
    topicList: List<Topic>,
    modifier: Modifier = Modifier
){

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topicList){
            topicItem -> TopicCard(topicItem = topicItem)
        }
    }

}

@Composable
@Preview
fun TopicGridPreview(){
    TopicGrid(topicList = DataSource.topics)

}