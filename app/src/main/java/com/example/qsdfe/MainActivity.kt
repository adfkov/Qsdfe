package com.example.qsdfe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.qsdfe.ui.theme.QsdfeTheme
import com.example.week07.example5.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QsdfeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                   com.example.week07.example6.MainScreen(navController = navController)
                    ExampleIntent()
                }
            }
        }
    }
}


@Composable
fun ExampleIntent() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.SpaceAround) // 같은 간격
    {
        Button(onClick = {
            val webPage = Uri.parse("https://m.naver.com")
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            context.startActivity(intent)
        }) {
            Text(text = "네이버")
        }

        Button(onClick = {
            val messgage = Uri.parse("sms:010-1234-1234")
            val messageIntent = Intent(Intent.ACTION_SENDTO, messgage)
            messageIntent.putExtra("sms_body", "밥 먹자....")
            context.startActivity(messageIntent)
        }) {
            Text(text = "문자 보내기")
        }

        Button(onClick = {
            val number = Uri.parse("tel:010-1234-1234")
            val callIntent = Intent(Intent.ACTION_CALL, number)
            context.startActivity(callIntent)
        }) {
            Text(text = "전화걸기")
        }


    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QsdfeTheme {
        Greeting("Android")
    }
}