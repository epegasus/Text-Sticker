package dev.pegasus.stickers.helper.events;

import dev.pegasus.stickers.StickerView;

public class FlipHorizontallyEvent extends AbstractFlipEvent {

    @Override
    @StickerView.Flip
    protected int getFlipDirection() {
        return StickerView.FLIP_HORIZONTALLY;
    }
}
