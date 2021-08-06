package ca.chrisfillmore.navigationmaterialtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

class MainActivity : ComponentActivity() {
  @ExperimentalMaterialNavigationApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val bottomSheetNavigator = rememberBottomSheetNavigator()
      val navController = rememberNavController().apply {
        navigatorProvider += bottomSheetNavigator
      }
      ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
        NavHost(
          navController = navController,
          startDestination = "myBottomSheet",
        ) {
          composable("myComposable") {

          }

          bottomSheet("myBottomSheet") {

          }
        }
      }
    }
  }
}

