package org.example.appbbm.ui.location

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
import org.example.appbbm.ui.referral.ReferralScreen

class LocationScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val branches = listOf(
            "Sucursal Coapa",
            "Sucursal Tláhuac",
            "Sucursal Polanco",
            "Sucursal Coyoacán",
            "Sucursal Roma"
        )

        var selectedBranch by remember { mutableStateOf<String?>(null) }

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
                    text = "Selecciona tu sucursal mas\n" +
                            "cercana a tu domicilio",
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
                items(branches) { branch ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (selectedBranch == branch) Color.Gray else Color.White,
                                RoundedCornerShape(8.dp)
                            )
                            .clickable {
                                selectedBranch = branch
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
                                text = branch,
                                color = if (selectedBranch == branch) Color.Black else Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }

            Button(
                onClick = {navigator?.push(ReferralScreen())},
                enabled = selectedBranch != null,
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
