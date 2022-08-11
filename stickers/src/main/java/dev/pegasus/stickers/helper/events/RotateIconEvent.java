package dev.pegasus.stickers.helper.events;

import android.view.MotionEvent;

import dev.pegasus.stickers.StickerView;
import dev.pegasus.stickers.ui.StickerIconEvent;

public class RotateIconEvent implements StickerIconEvent {

    @Override
    public void onActionDown(StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionMove(StickerView stickerView, MotionEvent event) {
        stickerView.rotateCurrentSticker(event);
    }

    @Override
    public void onActionUp(StickerView stickerView, MotionEvent event) {
        if (stickerView.getOnStickerOperationListener() != null && stickerView.getCurrentSticker() != null) {
            stickerView.getOnStickerOperationListener().onStickerZoomFinished(stickerView.getCurrentSticker());
        }
    }
}
