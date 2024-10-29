package bc.tutorials.lemonade

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bc.tutorials.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 
        setContent {
           LemonadeTheme {
               LemonadeContent()
           }
        }
    }
}

@Composable
fun LemonadeContent(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(0) }

    val imageResource = when (result) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    Column (modifier = modifier.fillMaxWidth()) {
        // First column
        Column(
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Lemonade", textAlign = TextAlign.Center)
        }

        // Second column under the first one
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(border = BorderStroke(1.dp, color = Color.Black),
                colors = ButtonColors(
                    contentColor = Color.LightGray,
                    containerColor = Color(red = 75.toInt(), green = 130.toInt(), blue = 175.toInt()),
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10), onClick = {
                    result = result + 1

                    if(result > 3) {
                        result = 0
                    }

                }) {
                Image(painter = painterResource(imageResource),
                    "1")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Picture Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeContentPreview() {
    LemonadeTheme {
        LemonadeContent()
    }
}