@file:OptIn(ExperimentalMaterial3Api::class)

package dev.vaibhav.newsapp.android.presentation.screens.search

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction

@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = modifier,
        value = query,
        onValueChange = onQueryChanged,
        singleLine = true,
        maxLines = 1,
        textStyle = MaterialTheme.typography.titleMedium,
        label = { Text(text = "Search News") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
        placeholder = { Text(text = "What are you looking for?") },
        trailingIcon = { ClearTextButton { onQueryChanged("") } },
        leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = "Search") }
    )
}

@Composable
private fun ClearTextButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(Icons.Rounded.Clear, contentDescription = "Clear Search Query")
    }
}