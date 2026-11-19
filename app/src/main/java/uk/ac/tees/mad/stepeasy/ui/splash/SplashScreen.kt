package uk.ac.tees.mad.stepeasy.ui.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.ac.tees.mad.StepEasyApplication
import uk.ac.tees.mad.stepeasy.R
import uk.ac.tees.mad.stepeasy.di.viewModelFactory
import uk.ac.tees.mad.stepeasy.ui.splash.component.PremiumLinearLoader
import uk.ac.tees.mad.stepeasy.ui.theme.Dimens

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel<SplashViewModel> (
        factory = viewModelFactory {
            SplashViewModel(
                preferenceManager = StepEasyApplication.appModule.preferenceManager
            )
        }
    ) ,
    onNavigateHome:()-> Unit ,
    onNavigateLogin :()-> Unit
){
    val uiState by viewModel.splashUiState.collectAsStateWithLifecycle()
    SplashScreenContent(
        uiState = uiState ,
        onNavigateHome = onNavigateHome ,
        onNavigateLogin = onNavigateLogin
    )
}
@Composable
fun SplashScreenContent(uiState: SplashUiState ,
                        onNavigateHome :()-> Unit ,
                    onNavigateLogin :()-> Unit) {
    when (uiState) {
        SplashUiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                                Color.White
                            )
                        )
                    )
            ) {

                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "App Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = Dimens.paddingLarge)
                        .navigationBarsPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    PremiumLinearLoader(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.paddingLarge)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Getting things ready...",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
        SplashUiState.NavigateToHome -> {
            onNavigateHome()
        }
        SplashUiState.NavigateToLogin -> {
            onNavigateLogin()
        }
    }
}



@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    SplashScreenContent(
        uiState = SplashUiState.Loading,
        onNavigateHome = {},
        onNavigateLogin = {}
    )
}