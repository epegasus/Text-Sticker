package dev.pegasus.textsticker

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.pegasus.stickers.R.drawable
import dev.pegasus.stickers.StickerView
import dev.pegasus.stickers.TextSticker
import dev.pegasus.stickers.helper.Sticker
import dev.pegasus.stickers.helper.events.DeleteIconEvent
import dev.pegasus.stickers.ui.BitmapStickerIcon
import dev.pegasus.stickers.ui.DrawableSticker
import dev.pegasus.textsticker.databinding.ActivityMainBinding

private const val TAG = "ePegasus"

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initStickerView()
        addSticker()
        listener()
    }

    private fun initStickerView() {
        val deleteIcon = BitmapStickerIcon(ContextCompat.getDrawable(this, R.drawable.ic_cross), BitmapStickerIcon.LEFT_TOP)
        deleteIcon.iconEvent = DeleteIconEvent()

        binding.svViewMain.icons = listOf(deleteIcon)
        binding.svViewMain.isLocked = false
        binding.svViewMain.isConstrained = true
    }

    private fun addSticker() {
        val sticker = TextSticker(this)
        sticker.text = " Enter Text Here "
        sticker.setTextColor(Color.BLUE)
        sticker.setTextAlign(Layout.Alignment.ALIGN_CENTER)
        sticker.resizeText()
        val drawableSticker = DrawableSticker(ContextCompat.getDrawable(this, drawable.img_dummy))
        binding.svViewMain.addSticker(sticker)
        binding.svViewMain.addSticker(drawableSticker)
    }

    private fun listener() {
        binding.svViewMain.onStickerOperationListener = object : StickerView.OnStickerOperationListener {
            override fun onStickerAdded(sticker: Sticker) {
                Log.d(TAG, "onStickerAdded")
            }

            override fun onStickerClicked(sticker: Sticker) {
                if (sticker is TextSticker) {
                    sticker.setTextColor(Color.RED)
                    binding.svViewMain.replace(sticker)
                    binding.svViewMain.invalidate()
                }
                Log.d(TAG, "onStickerClicked")
            }

            override fun onStickerDeleted(sticker: Sticker) {
                Log.d(TAG, "onStickerDeleted")
            }

            override fun onStickerDragFinished(sticker: Sticker) {
                Log.d(TAG, "onStickerDragFinished")
            }

            override fun onStickerTouchedDown(sticker: Sticker) {
                Log.d(TAG, "onStickerTouchedDown")
            }

            override fun onStickerZoomFinished(sticker: Sticker) {
                Log.d(TAG, "onStickerZoomFinished")
            }

            override fun onStickerFlipped(sticker: Sticker) {
                Log.d(TAG, "onStickerFlipped")
            }

            override fun onStickerDoubleTapped(sticker: Sticker) {
                Log.d(TAG, "onDoubleTapped: double tap will be with two click")
            }
        }
    }
}