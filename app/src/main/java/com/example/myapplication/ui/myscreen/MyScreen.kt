package com.example.myapplication.ui.myscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.R

@Composable
fun MyScreen() {
    val myScreenViewModel = hiltViewModel<MyScreenViewModel>()
    val uiState = myScreenViewModel.uiState

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (type, title, iconUrl) = createRefs()

        Text(
            text = uiState.myScreenModel?.type?.name.orEmpty(),
            modifier = Modifier.constrainAs(type) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = uiState.myScreenModel?.header?.title.orEmpty(),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(type.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        AsyncImage(
            model = uiState.myScreenModel?.header?.iconUrl,
            contentDescription = "Header icon url",
            placeholder = painterResource(R.drawable.ic_offline),
            modifier = Modifier
                .size(40.dp)
                .constrainAs(iconUrl) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}
