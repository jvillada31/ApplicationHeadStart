package com.example.myapplication.ui.myscreen.result

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
fun ResultScreen(
    modifier: Modifier,
    onClick: () -> Unit
) {
    val resultViewModel = hiltViewModel<ResultViewModel>()
    val uiState = resultViewModel.uiState

    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (type, header, body, footer) = createRefs()

        Text(
            text = uiState.myScreenModel?.type?.name.orEmpty(),
            modifier = modifier.constrainAs(type) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        HeaderSection(
            title = uiState.myScreenModel?.header?.title ?: "Default title",
            iconUrl = uiState.myScreenModel?.header?.iconUrl,
            modifier = modifier.constrainAs(header) {
                top.linkTo(type.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        BodySection(
            body = uiState.myScreenModel?.body,
            modifier = modifier.constrainAs(body) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            }
        )

        FooterSection(
            buttonList = uiState.myScreenModel?.footer?.buttonList,
            modifier = modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { onClick.invoke() }
        )
    }
}
