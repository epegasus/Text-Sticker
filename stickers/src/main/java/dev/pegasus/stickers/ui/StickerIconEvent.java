package dev.pegasus.stickers.ui;

import android.view.MotionEvent;

import dev.pegasus.stickers.StickerView;

public interface StickerIconEvent {
    void onActionDown(StickerView stickerView, MotionEvent event);

    void onActionMove(StickerView stickerView, MotionEvent event);

    void onActionUp(StickerView stickerView, MotionEvent event);
}
