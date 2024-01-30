package at.ac.htl.ui.layout


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import at.ac.htl.model.Model
import at.ac.htl.model.Store
import at.ac.htl.ui.theme.MyFirstAppTheme
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MainView {
    val store: Store
    @Inject
    constructor(store: Store) {
        this.store = store
    }
    fun setContentView(activity: ComponentActivity) {
        activity.setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(store)
                }
            }
        }

    }
}

@Composable
fun Greeting(store: Store, modifier: Modifier = Modifier) {
    val state = store.subject.subscribeAsState(initial = Model())
    Text(
        text = "Hallo ${state.value.greeting}!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
       // Greeting("Android")
    }
}