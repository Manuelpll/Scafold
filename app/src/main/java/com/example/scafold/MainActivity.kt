package com.example.scafold
import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scafold.ui.theme.ScafoldTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScafoldTheme {
                ScaffoldExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mis Películas",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Open menu */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Open calendar */ }) {
                        Icon(Icons.Filled.DateRange, contentDescription = "Calendar")
                    }
                    IconButton(onClick = { /* TODO: Open settings */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(174, 214, 241),
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }/*,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = MaterialTheme.shapes.extraLarge,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",

                )
            }
        }*/,
        bottomBar = {

            BottomAppBar(
                containerColor = Color(133, 193, 233),
            ) {
                Spacer(Modifier.weight(0.2f))
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
                Spacer(Modifier.weight(0.7f))
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Delete, contentDescription = "Basura")
                }
                Spacer(Modifier.weight(0.7f))
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.ThumbUp, contentDescription = "Like")
                }
                Spacer(Modifier.weight(0.80f))
                FloatingActionButton(
                    onClick = {},
                    shape = MaterialTheme.shapes.extraLarge,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",)
            }

            }
        } ,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(0.8f)
                    .border(1.dp, Color( 86,85,79)),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.the_super_mario_bros_movie_logo),
                    contentDescription = "Poster de la película",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(end = 8.dp, start = 8.dp,bottom = 8.dp, top = 8.dp) // Espaciado hacia la derecha
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Super Mario Bros: La pelicula.",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre texto
                    Text(
                        text = "Directores: Aaron Horvath y Michael Jelenic",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScafoldTheme {
        ScaffoldExample()
    }
}