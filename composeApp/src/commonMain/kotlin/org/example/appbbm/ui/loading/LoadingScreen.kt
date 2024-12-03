package org.example.appbbm.ui.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import appbbm.composeapp.generated.resources.Res
import appbbm.composeapp.generated.resources.prueba
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlin.random.Random

class LoadingScreen : Screen {
    private val loadingMessages = listOf(
        "Cargando datos...",
        "Preparando tu experiencia...",
        "Un momento, casi estamos listos..."
    )

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val randomMessage = loadingMessages[Random.nextInt(loadingMessages.size)]

        LaunchedEffect(Unit) {
            delay(5000)

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.prueba),
                contentDescription = "Cargando",
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = randomMessage,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


