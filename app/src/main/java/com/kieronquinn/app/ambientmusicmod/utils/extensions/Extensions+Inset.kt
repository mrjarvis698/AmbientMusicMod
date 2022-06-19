package com.kieronquinn.app.ambientmusicmod.utils.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import com.kieronquinn.app.ambientmusicmod.R

val View.windowInsets
    get() = ViewCompat.getRootWindowInsets(this)

fun View.onApplyInsets(block: (view: View, insets: WindowInsetsCompat) -> Unit) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        block(view, insets)
        insets
    }
}

fun View.applyBottomNavigationInset(extraPadding: Float = 0f) {
    val bottomNavHeight = resources.getDimension(R.dimen.bottom_nav_height).toInt()
    updatePadding(bottom = bottomNavHeight + extraPadding.toInt())
    onApplyInsets { _, insets ->
        val bottomInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
        updatePadding(bottom = bottomInsets + bottomNavHeight + extraPadding.toInt())
    }
}

fun View.applyBottomNavigationMargin(extraPadding: Float = 0f) {
    val bottomNavHeight = resources.getDimension(R.dimen.bottom_nav_height_margins).toInt()
    onApplyInsets { _, insets ->
        val bottomInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            updateMargins(bottom = bottomInsets + bottomNavHeight + extraPadding.toInt())
        }
    }
}

fun View.applyBottomNavigationMarginShort(extraPadding: Float = 0f) {
    val bottomNavHeight = resources.getDimension(R.dimen.bottom_nav_height).toInt()
    onApplyInsets { _, insets ->
        val bottomInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            updateMargins(bottom = bottomInsets + bottomNavHeight + extraPadding.toInt())
        }
    }
}