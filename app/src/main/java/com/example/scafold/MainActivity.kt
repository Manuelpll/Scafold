package com.example.scafold
import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
data class Pelicula(val titulo: String, val director: String, val image: Int)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val FilmList = mutableListOf<Pelicula>()
    FilmList.add(Pelicula("Super Mario Bros: La pelicula", "Aaron Horvath y Michael Jelenic", R.drawable.the_super_mario_bros_movie_logo))
    FilmList.add(Pelicula("Star Wars: Rogue One", "George Lucas", R.drawable.rogue_))
    FilmList.add(Pelicula("Venom", "Ruben Fleischer", R.drawable.venom))
    FilmList.add(Pelicula("Arceus y la joya de la vida", "Nick Ficano", R.drawable.arceus_y_la_joya_de_la_vida))
    FilmList.add(Pelicula("The amazing Spiderman", "Marc Webb", R.drawable.the_amazing_spiderman))
    FilmList.add(Pelicula("Cars", "John Lasseter", R.drawable.cars))

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
       LazyColumn {
           items(FilmList) { pelicula ->
               Estruture(pelicula.titulo, pelicula.director, pelicula.image, innerPadding)
       }
        }
    }
}
@Composable
fun Estruture(titulo: String, director: String, image: Int, innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(0.9f)
                .border(1.dp, Color(86, 85, 79)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Poster de la película",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp) // Tamaño más compacto
                    .padding(8.dp) // Espaciado uniforme más pequeño
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(2.dp)) // Espaciado reducido
                Text(
                    text = "Director/es: $director",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

    /*data class Person(val name: String, val age: Int)
@Composable
fun NumerList(){
    val persons = listOf(
        Person("Juan", 25),
        Person("María", 30),
        Person("Pedro", 35),
        Person("Ana",23 ))
    LazyColumn{
        items(persons.size) { index ->
            Text(text = "Name: ${persons[index].name}, \nAge: ${persons[index].age}\n---------")
        }
    }
}

@Composable
fun SimpleStringList() {
    // List of fruit names
    val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Grapes")

// LazyColumn to display the list
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()     // Fill the available height and width
            .padding(16.dp)    // Add padding around the LazyColumn
    ) {
        // Use the items function to iterate over the list
        items(fruits) { fruit ->
            // Display each fruit name using a Text composable
            Text(
                text = fruit,
                modifier = Modifier
                    .padding(8.dp)       // Add padding around each item
                    .fillMaxWidth(),     // Make each item fill the available width
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
// Data class representing a User
data class User(val name: String, val email: String)

// Function to simulate fetching user data
fun getUserData(): List<User> {
    return listOf(
        User("John Doe", "john@example.com"),
        User("Jane Doe", "jane@example.com")
    )
}

// Composable function to display the list of users
@Composable
fun UserList(users: List<User>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Iterate over the list of users
        items(users) { user ->
            // Display each user using the UserItem composable
            UserItem(user)
        }
    }
}

// Composable function to display individual user items
@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.LightGray)                // Background color for the item
            .clip(RoundedCornerShape(1.dp))            // Rounded corners
    ) {
        // Display the user's name
        Text(
            text = user.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        // Display the user's email
        Text(
            text = user.email,
            style = MaterialTheme.typography.bodySmall
        )
    }
}*/

    @Preview(showBackground = true)
    @Composable
    fun ScaffoldPreview() {
        ScafoldTheme {
            ScaffoldExample()
            //NumerList()
//SimpleStringList()
            //UserList(getUserData())
        }
    }
