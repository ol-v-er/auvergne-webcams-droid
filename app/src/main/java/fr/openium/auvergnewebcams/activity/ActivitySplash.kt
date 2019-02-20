package fr.openium.auvergnewebcams.activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import fr.openium.auvergnewebcams.R
import fr.openium.auvergnewebcams.viewmodel.ViewModelSplash
import fr.openium.kotlintools.ext.startActivity
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_splash.*
import timber.log.Timber


class ActivitySplash : AbstractActivity() {

    private lateinit var viewModelSplash: ViewModelSplash

    override val layoutId: Int
        get() = R.layout.activity_splash

    // --- LIFE CYCLE ---
    // ---------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Get viewModel
        viewModelSplash = ViewModelProviders.of(this).get(ViewModelSplash::class.java)

        //Get new data
        viewModelSplash.updateData().subscribe({
            startActivityMain()
        }, {
            Timber.e(it)
        }).addTo(disposables)
    }

    override fun onResume() {
        super.onResume()
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha)
        mCloud1.startAnimation(animation)
        mCloud2.startAnimation(animation)
        mCloud3.startAnimation(animation)
        mCloud4.startAnimation(animation)
        mCloud5.startAnimation(animation)
        mCloud6.startAnimation(animation)
        mCloud7.startAnimation(animation)
    }

    // --- OTHER ---
    // ---------------------------------------------------

    private fun startActivityMain() {
        startActivity<ActivityMain>()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}