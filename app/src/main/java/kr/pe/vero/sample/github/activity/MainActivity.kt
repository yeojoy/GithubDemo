package kr.pe.vero.sample.github.activity

import android.os.Bundle
import dagger.Lazy
import kr.pe.vero.sample.github.R
import kr.pe.vero.sample.github.app.BaseActivity
import kr.pe.vero.sample.github.fragment.MainFragment
import javax.inject.Inject

/**
 * @author vero
 * @since 2017. 10. 16.
 */
class MainActivity: BaseActivity() {

    @Inject lateinit var fragment: Lazy<MainFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            moveToMain()
    }

    private fun moveToMain() {
        var fragment = supportFragmentManager.findFragmentByTag("main")
        if (fragment == null) {
            fragment = this.fragment.get()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.layoutFragment, fragment, "main")
                    .commit()
        }
    }
}