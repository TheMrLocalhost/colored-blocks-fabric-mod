package com.mrlocalhost.coloredblocks.mixin;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")
@Mixin(TitleScreen.class)
public class ColoredBlocksMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		ColoredBlocks.LOGGER.info("Colored Blocks mixin loaded!");
	}
}
