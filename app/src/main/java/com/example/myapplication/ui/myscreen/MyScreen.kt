package com.example.myapplication.ui.myscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.sections.BodySection
import com.example.myapplication.ui.sections.FooterSection
import com.example.myapplication.ui.sections.HeaderSection

@Composable
fun MyScreen(
    onClick: () -> Unit
) {
    val myScreenViewModel = hiltViewModel<MyScreenViewModel>()
    val uiState = myScreenViewModel.uiState

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (type, header, body, footer) = createRefs()

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

        BodySection(
            body = uiState.myScreenModel?.body,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            }
        )

        FooterSection(
            buttonList = uiState.myScreenModel?.footer?.buttonList,
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { onClick.invoke() }
        )
    }
}
