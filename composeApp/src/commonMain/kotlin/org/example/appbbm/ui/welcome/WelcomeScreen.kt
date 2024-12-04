package org.example.appbbm.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appbbm.composeapp.generated.resources.Res
import appbbm.composeapp.generated.resources.ballet_gissel
import appbbm.composeapp.generated.resources.prueba
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.appbbm.ui.events.EventScreen
import org.example.appbbm.ui.greeting.GreetingScreen
import org.example.appbbm.ui.promotion.PromotionScreen
import org.jetbrains.compose.resources.painterResource

class WelcomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val gradientBrush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFA8182.toInt()),
                Color(0xFFAE93EE.toInt()),
                Color(0xFF1EBCD2.toInt())
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBrush)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.prueba),
                contentDescription = "Welcome Character",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "¡Bienvenido a Baby Ballet Marbet!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navigator?.push(GreetingScreen())},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Empieza Ahora", fontSize = 16.sp)
                }
                OutlinedButton(
                    onClick = {navigator?.push(EventScreen())},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Ya tengo cuenta", fontSize = 16.sp)
                }
                OutlinedButton(
                    onClick = {navigator?.push(PromotionScreen()) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Franquiciatarios", fontSize = 16.sp)
                }
            }
        }
    }
}
