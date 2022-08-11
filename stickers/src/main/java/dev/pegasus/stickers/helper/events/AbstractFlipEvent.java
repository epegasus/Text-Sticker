package dev.pegasus.stickers.helper.events;

import android.view.MotionEvent;

import dev.pegasus.stickers.StickerView;
import dev.pegasus.stickers.ui.StickerIconEvent;

public abstract class AbstractFlipEvent implements StickerIconEvent {

    @Override
    public void onActionDown(StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionMove(StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionUp(StickerView stickerView, MotionEvent event) {
        stickerView.flipCurrentSticker(getFlipDirection());
    }

    @StickerView.Flip
    protected abstract int getFlipDirection();
}
