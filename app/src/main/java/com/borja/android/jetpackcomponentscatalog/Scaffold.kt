package com.borja.android.jetpackcomponentscatalog

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        modifier = Modifier.background(Color.Red),
        topBar = { MyTopAppBar { coroutineScope.launch { snackbarHostState.showSnackbar("Has pulsado $it") } } },
        snackbarHost = { snackbarHostState },
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = {MyFAB()},
        floatingActionButtonPosition = FabPosition.Center,
        //drawerContent = {MyDrawer()}

    ) {
        //Box(Modifier.height(50.dp).fillMaxWidth().background(Color.Red))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onclickIcon: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp),
        color = Color.White
    ) {
        TopAppBar(
            title = { Text(text = "Mi primera toolbar") },
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                IconButton(onClick = { onclickIcon("Buscar") }) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                }
                IconButton(onClick = { onclickIcon("Peligro") }) {
                    Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
                }
            }
        )
    }
}

@Composable
fun MyBottomNavigation() {
    var index by remember{ mutableStateOf(0) }
    BottomAppBar(modifier = Modifier
        .background(Color.Red)
        .padding(16.dp)) {
        NavigationBarItem(selected = index==0, onClick = {index = 0 }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") })
        NavigationBarItem(selected = index==1, onClick = { index= 1 }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorito")
        }, label = { Text(text = "FAV") })
        NavigationBarItem(selected = index==2, onClick = { index=2}, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        }, label = { Text(text = "Person") })

    }
}

@Composable
fun MyFAB(){
    FloatingActionButton(onClick = { },Modifier.background(Color.Yellow)) {
        Icon(imageVector = Icons.Filled.Add , contentDescription = "Añadir")
    }
}

@Composable
fun MyDrawer(){
    Column(Modifier.padding(8.dp)) {
        Text(text = "Primera opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Segunda opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Tercera opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Cuarta opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

    }
}