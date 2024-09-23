package com.developbharat.facegate.ui.screens.batch.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.ui.components.SmallTopBar

@Composable
fun CreateBatchScreen(navController: NavController, viewModel: CreateBatchViewModel = hiltViewModel()) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }


    Scaffold(topBar = {
        SmallTopBar(
            title = "Create Batch",
            subtitle = "Batch helps to group faces"
        )
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Batch Name") },
                    placeholder = { Text("Course C10300") })
                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Batch Description") },
                    placeholder = { Text("Attendance sheet for course C10300") })
                Spacer(modifier = Modifier.height(5.dp))

                Button(modifier = Modifier.fillMaxWidth(), onClick = {

                }) {
                    Text("Create Batch")
                }
            }
        }
    }
}