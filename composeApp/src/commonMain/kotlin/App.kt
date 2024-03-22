import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.zarinraim.accounting.di.CommonGraph
import com.zarinraim.accounting.scene.ChartAccountsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinApplication(application = { modules(CommonGraph.module) }) {
            ChartAccountsScreen()
        }
    }
}