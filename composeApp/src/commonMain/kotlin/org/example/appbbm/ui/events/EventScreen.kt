package org.example.appbbm.ui.events

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow


class EventScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var isAdmin by remember { mutableStateOf(true) }
        var showEventForm by remember { mutableStateOf(false) }

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var image by remember { mutableStateOf("") }

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFA8182.toInt()))
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Eventos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            listOf("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE").forEach { mes ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = mes,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .clickable {
                                if (isAdmin) {
                                    showEventForm = true
                                } else {
                                    navigator.push(EventDetailScreen(mes))
                                }
                            }
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "+", fontSize = 32.sp, color = Color.Gray)
                    }
                }
            }


            if (showEventForm) {
                EventFormDialog(
                    onSave = {

                        showEventForm = false
                    },
                    onCancel = { showEventForm = false },
                    title = title,
                    onTitleChange = { title = it },
                    description = description,
                    onDescriptionChange = { description = it },
                    date = date,
                    onDateChange = { date = it }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navigator.pop() },
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text("Cancelar")
                }

                Button(
                    onClick = { /* Acción Guardar */ },
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text("Guardar")
                }
            }
        }
    }
}


@Composable
fun EventFormDialog(
    onSave: () -> Unit,
    onCancel: () -> Unit,
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    date: String,
    onDateChange: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = { onCancel() },
        title = { Text(text = "Agregar Evento", fontWeight = FontWeight.Bold) },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                BasicTextField(
                    value = title,
                    onValueChange = onTitleChange,
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions.Default,
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier.background(Color.White).padding(16.dp)) {
                            if (title.isEmpty()) Text("Título", color = Color.Gray)
                            innerTextField()
                        }
                    }
                )

                BasicTextField(
                    value = description,
                    onValueChange = onDescriptionChange,
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions.Default,
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier.background(Color.White).padding(16.dp)) {
                            if (description.isEmpty()) Text("Descripción", color = Color.Gray)
                            innerTextField()
                        }
                    }
                )

                BasicTextField(
                    value = date,
                    onValueChange = onDateChange,
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions.Default,
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier.background(Color.White).padding(16.dp)) {
                            if (date.isEmpty()) Text("Fecha", color = Color.Gray)
                            innerTextField()
                        }
                    }
                )
            }
        },
        confirmButton = {
            Button(onClick = onSave) {
                Text("Guardar Evento")
            }
        },
        dismissButton = {
            Button(onClick = onCancel) {
                Text("Cancelar")
            }
        }
    )
}


class EventDetailScreen(private val mes: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Detalles del Evento de $mes",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navigator.pop() }) {
                Text("Regresar")
            }
        }
    }
}

