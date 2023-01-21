package com.learningcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonItem(person: Person) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(if (MaterialTheme.colors.isLight) Color.LightGray else Color.DarkGray)
            .padding(16.dp),
    ) {
        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.weight(1f)) {
            Text(
                "${person.firstName} ${person.lastName}",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
        }

        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.weight(1f)) {
            Text(
                "${person.age} ans",
                fontSize = MaterialTheme.typography.h5.fontSize,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Preview
@Composable
fun PersonItemPreview() {
    PersonItem(Person("Name", "LASTNAME", 15))
}