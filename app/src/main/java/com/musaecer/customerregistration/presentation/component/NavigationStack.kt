package com.musaecer.customerregistration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.presentation.util.CustomerEvent
import com.musaecer.customerregistration.presentation.view.CustomerAdd
import com.musaecer.customerregistration.presentation.view.HomeScreen
import com.musaecer.customerregistration.presentation.view.UserDetailScreen
import com.musaecer.customerregistration.presentation.view.UserListScreen
import com.musaecer.customerregistration.presentation.viewmodel.CustomerViewModel

@Composable
fun NavigationStack(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Main.route) {

        // Liste ekranı
        composable(Screen.Main.route) {
            HomeScreen(navController)
        }

        // Detay ekranı: argüman olarak id alıyoruz
        composable(
            route = Screen.UserDetail.route,
            arguments = listOf(navArgument("customerId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("customerId") ?: return@composable
            val vm: CustomerViewModel = viewModel()

            // Burada ViewModel’e SearchId eventi yollayıp state güncelliyoruz
            LaunchedEffect(id) {
                vm.onEvent(CustomerEvent.SearchId(id))
            }
            val customer = vm.state.collectAsState().value.customers.firstOrNull()
            customer?.let {
                UserDetailScreen(navController, it)
            }
        }

        // Ekleme ekranı
        composable(Screen.CustomerAdd.route) {
            val vm: CustomerViewModel = viewModel()
            CustomerAdd(
                /*
                onSave = { c ->
                    vm.onEvent(CustomerEvent.Add(c))
                    navController.popBackStack()
                }

                 */
            )
        }
    }
}