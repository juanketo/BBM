package org.example.appbbm.ui.slider

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appbbm.composeapp.generated.resources.Res
import appbbm.composeapp.generated.resources.prueba
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.painterResource
import org.example.appbbm.ui.dissipations.SelectDisiplinasScreen

class SliderScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val age = remember { androidx.compose.runtime.mutableStateOf(1f) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Selecciona la edad de tu peque",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Slider(
                value = age.value,
                onValueChange = { age.value = it },
                valueRange = 1f..18f,
                steps = 17,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Image(
                painter = painterResource(Res.drawable.prueba),
                contentDescription = "Imagen de recordatorio",
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Fit
            )

            Card(
                modifier = Modifier.padding(top = 24.dp).fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Edad seleccionada: ${age.value.toInt()} años",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }


            Button(
                onClick = {
                    val selectedAge = age.value.toInt()

                    navigator?.push(SelectDisiplinasScreen(userAge = selectedAge))
                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Siguiente", fontSize = 16.sp)
            }

        }
    }
}
