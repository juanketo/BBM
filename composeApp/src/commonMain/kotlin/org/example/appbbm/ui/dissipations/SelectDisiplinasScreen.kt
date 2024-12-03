package org.example.appbbm.ui.dissipations

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import appbbm.composeapp.generated.resources.Res
import appbbm.composeapp.generated.resources.prueba
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.lazy.items
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.appbbm.ui.location.LocationScreen
import org.example.appbbm.ui.slider.SliderScreen

class SelectDisiplinasScreen(private val userAge: Int) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val disciplines = listOf(
            "Ballet", "Jazz", "Gimnasia Rítmica", "Danza Aérea", "Flamenco",
            "Mexidanza", "Danzas Polinesias", "Danza Árabe", "Cheerpons",
            "Yoga", "Hiphop", "Kpop", "Contemporáneo", "Broadwaydance",
            "Taekwondo", "Capoeira", "Ritmos Latinos", "Break Dance", "Electro Dance"
        )

        val allowedDisciplines = remember { getDisciplinesByAge(userAge, disciplines) }
        var selectedDiscipline by remember { mutableStateOf<String?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(Res.drawable.prueba),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "¿Qué disciplina te gustaría aprender?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(disciplines) { discipline ->
                    val isEnabled = allowedDisciplines.contains(discipline)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (selectedDiscipline == discipline) Color.Gray else Color.White,
                                RoundedCornerShape(8.dp)
                            )
                            .clickable(enabled = isEnabled) {
                                if (isEnabled) selectedDiscipline = discipline
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.prueba),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = discipline,
                                color = if (isEnabled) Color.Black else Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }

            Button(
                onClick = { navigator?.push(LocationScreen())},
                enabled = selectedDiscipline != null,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(
                    text = "CONTINUAR",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    private fun getDisciplinesByAge(age: Int, disciplines: List<String>): List<String> {
        return when {
            age < 5 -> listOf("Ballet", "Jazz")
            age in 5..10 -> listOf("Ballet", "Jazz", "Gimnasia Rítmica", "Danza Aérea")
            age in 11..15 -> listOf("Ballet", "Jazz", "Flamenco", "Yoga", "Taekwondo", "Capoeira")
            else -> disciplines
        }
    }

}