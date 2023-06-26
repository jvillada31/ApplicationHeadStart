package com.example.myapplication.ui.myscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.domain.myscreen.model.Button

@Composable
fun MyScreen() {
    val myScreenViewModel = hiltViewModel<MyScreenViewModel>()
    val uiState = myScreenViewModel.uiState

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (type, header, footer) = createRefs()

        Text(
            text = uiState.myScreenModel?.type?.name.orEmpty(),
            modifier = Modifier.constrainAs(type) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        HeaderSection(
            title = uiState.myScreenModel?.header?.title ?: "Default title",
            iconUrl = uiState.myScreenModel?.header?.iconUrl,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(type.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        FooterSection(
            buttonList = uiState.myScreenModel?.footer?.buttonList,
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun HeaderSection(
    title: String,
    iconUrl: String?,
    modifier: Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
        )
        AsyncImage(
            model = iconUrl,
            contentDescription = "Header icon url",
            placeholder = painterResource(R.drawable.ic_offline),
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun FooterSection(
    buttonList: List<Button>?,
    modifier: Modifier
) {
    if (buttonList?.isNotEmpty() == true) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            buttonList.map { button ->
                Button(
                    onClick = { TODO("Show a Snackbar here") }
                ) {
                    Text(text = button.label)
                }
            }
        }
    }
}
