package com.mobile.pytournaments

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.mobile.pytournaments.ui.activity.LoginActivity
import com.mobile.pytournaments.ui.fragment.login.LoginFragment
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer : LinearLayout

    private var splashFirst= "Crie seu próprio perfil"
    private var splashSecond = "Encontre os torneios próximos a você"
    private var splashThird = "Encontre pessoas com gostos similares"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_onboarding)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
    }


    private fun setOnboardingItems(){
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage =  R.drawable.primeira,
                    title = splashFirst,
                    description = ""
                ),
                OnboardingItem(
                    onboardingImage =  R.drawable.segunda_tela_splashscreen,
                    title = splashSecond,
                    description = ""
                ),
                OnboardingItem(
                    onboardingImage =  R.drawable.terceira_tela_splashscreen,
                    title = splashThird,
                    description = ""
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingviewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
            }
        )
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if(onboardingViewPager.currentItem +1 < onboardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem +=1
            }else{
                navigateToLogin()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener {
            navigateToLogin()
        }
        findViewById<MaterialButton>(R.id.btComecar).setOnClickListener{
            navigateToLogin()
        }
    }

    private fun navigateToLogin(){
        startActivity(Intent(applicationContext, LoginActivity::class.java))
        finish()

    }


    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }




    }



}