package com.example.nexus

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlin.math.abs


class HomeFragment : Fragment() {

    private lateinit var bannerViewPager: ViewPager2
    private lateinit var dotsIndicator: WormDotsIndicator
    private lateinit var bannerAdapter: BannerAdapter
    private val sliderHandler = Handler(Looper.getMainLooper())

    private val sliderRunnable = object : Runnable {
        override fun run() {
            val currentItem = bannerViewPager.currentItem
            val totalItems = bannerAdapter.itemCount
            bannerViewPager.currentItem = if (currentItem < totalItems - 1) {
                currentItem + 1
            } else 0
            sliderHandler.postDelayed(this, 4000) // ⏱ slide every 4 sec
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        bannerViewPager = view.findViewById(R.id.bannerViewPager)
        dotsIndicator = view.findViewById(R.id.dotsIndicator)

        // ✅ Banner Images (replace with your own)
        val bannerImages = listOf(
            R.drawable.banner_freefire,
            R.drawable.banner_valorant,
            R.drawable.banner_pubg,
            R.drawable.banner_fifa,
            R.drawable.banner_cos
        )

        bannerAdapter = BannerAdapter(bannerImages)
        bannerViewPager.adapter = bannerAdapter
        dotsIndicator.attachTo(bannerViewPager)


        // Carousel effect
        bannerViewPager.offscreenPageLimit = 3
        bannerViewPager.clipToPadding = false
        bannerViewPager.clipChildren = false
        bannerViewPager.setPageTransformer { page, position ->
            val scale = 0.85f + (1 - abs(position)) * 0.15f
            page.scaleY = scale
            page.alpha = 0.5f + (1 - abs(position)) * 0.5f
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 4000)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }
}
