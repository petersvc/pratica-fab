package com.example.fab_examples

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fab_examples.ui.theme.FabexamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FabexamplesTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButtonExample(onClick = { /* Handle click */ })
                    },
                    content = { innerPadding ->
                        FABExamples(modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun FABExamples(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(72.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly // Arrangement.spacedBy(72.dp)
    ) {
        Text("Floating Action Button Examples")
        SmallFloatingActionButtonExample(onClick = { /* Handle click */ })
        LargeFloatingActionButtonExample(onClick = { /* Handle click */ })
        ExtendedFloatingActionButtonExample(onClick = { /* Handle click */ })
    }
}

@Composable
fun FloatingActionButtonExample(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Floating action button")
    }
}

@Composable
fun SmallFloatingActionButtonExample(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = Color(0xFFE91E63),
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Small floating action button")
    }
}

@Composable
fun LargeFloatingActionButtonExample(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Large floating action button")
    }
}

@Composable
fun ExtendedFloatingActionButtonExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Edit, contentDescription = "Extended floating action button") },
        text = { Text("Extended FAB") },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFABExamples() {
    FabexamplesTheme {
        FABExamples()
    }
}