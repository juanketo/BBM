package org.example.appbbm.ui.reminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.painterResource
import appbbm.composeapp.generated.resources.Res
import appbbm.composeapp.generated.resources.prueba
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.appbbm.ui.greeting.GreetingScreen
import org.example.appbbm.ui.slider.SliderScreen

class ReminderScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Recuerda que la edad de tu peque es fundamental\npara dar una atención personalizada.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            Image(
                painter = painterResource(Res.drawable.prueba),
                contentDescription = "Imagen de recordatorio",
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Fit
            )

            Button(
                onClick = { navigator?.push(SliderScreen())},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Siguiente", fontSize = 16.sp)
            }

        }
    }
}
