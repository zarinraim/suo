import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.zarinraim.accounting.scene.ChartAccountsScreen
import com.zarinraim.accounting.di.IsolatedKoinContext
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinIsolatedContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinIsolatedContext(context = IsolatedKoinContext.koinApp) {
            ChartAccountsScreen()
        }
    }
}