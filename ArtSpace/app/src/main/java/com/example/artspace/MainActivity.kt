package com.example.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  MainScreen(
                      Modifier.padding(innerPadding)
                  )
                }
            }
        }
    }
}


@Composable
fun MainScreen(


    modifier: Modifier = Modifier
){
    
    val imgResArray = arrayOf(
        R.drawable.img_mona_lisa,
        R.drawable.img_screaming,
        R.drawable.img_last_supper
    )



    var currentImageIndex by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier
            .fillMaxSize()
            .border(4.dp, Color.Black,)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.5f)
                .border(1.dp, Color.Red)
                .shadow(4.dp, ambientColor = Color.Black)
                .padding(32.dp)
            ,
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = imgResArray[currentImageIndex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
//                    .border(1.dp, Color.Green)
                    ,
                contentScale = ContentScale.Crop
            )

        }

        Spacer(modifier = Modifier.height(32.dp))

        ImageIndicators(dotCount = imgResArray.size, activeDotPosition = currentImageIndex )


        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(1.dp, Color.Blue)
            ,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val nextButtonEnabled = currentImageIndex<imgResArray.lastIndex
            val previousButtonEnabled = currentImageIndex>0

            ControlImageButton(btnText = "Previous", previousButtonEnabled,  onClickAction = {
                --currentImageIndex
            })
            ControlImageButton(btnText = "Next", nextButtonEnabled, onClickAction = {
                ++currentImageIndex
            })


        }


    }



}

@Composable
fun ControlImageButton(
    btnText:String,
    enabled:Boolean,
    onClickAction : ()-> Unit,
    modifier: Modifier = Modifier
){

    Button(
        onClick = onClickAction,
        enabled = enabled

    ) {

        Text(text = btnText)
        
    }

}
@Composable
fun ImageIndicators(
    dotCount:Int,
    activeDotPosition:Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier.border(1.dp,Color.Black),
        ) {
        for (i in 0..<dotCount){
            val color = if(i == activeDotPosition)
                Color.Black
            else
                Color.Gray

            Icon(
                painterResource(id = R.drawable.icon_dot_active),
                tint = color,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

    }
}




@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Scaffold(modifier =
        Modifier.fillMaxSize()) { innerPadding ->
        MainScreen(
            Modifier.
                padding(innerPadding)
        )
    }
}