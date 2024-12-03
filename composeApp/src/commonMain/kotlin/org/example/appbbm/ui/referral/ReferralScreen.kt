package org.example.appbbm.ui.referral

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
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.lazy.items
import appbbm.composeapp.generated.resources.prueba
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.delay
import org.example.appbbm.ui.loading.LoadingScreen
import org.example.appbbm.ui.personaldata.PersonalDataScreen

class ReferralScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val referralSources = listOf(
            "Página web",
            "Instagram",
            "Facebook",
            "TikTok",
            "Google",
            "Familiares y amigos"
        )

        var selectedSource by remember { mutableStateOf<String?>(null) }
        var showLoading by remember { mutableStateOf(true) }


        LaunchedEffect(Unit) {
            delay(3000)
            showLoading = false
            navigator?.push(ReferralScreen() )
        }


        if (showLoading) {

        } else {

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
                        text = "¿Dónde has escuchado hablar de nosotros?",
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
                    items(referralSources) { source ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    if (selectedSource == source) Color.Gray else Color.White,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    selectedSource = source
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
                                    text = source,
                                    color = if (selectedSource == source) Color.Black else Color.Gray,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }

                Button(
                    onClick = { navigator?.push(PersonalDataScreen()) },
                    enabled = selectedSource != null,
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
    }
}
