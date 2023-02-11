package com.mrlocalhost.coloredblocks.screen;

import com.mrlocalhost.coloredblocks.networking.PacketHandler;
import com.mrlocalhost.coloredblocks.screen.widgets.CustomButton;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.HashMap;

public class ColorWheelScreen extends Screen {

    private PlayerEntity player;
    private ItemStack paintbrush;
    private HashMap<String, ButtonWidget> upgradeButtons = new HashMap<>();
    private final int buttonWidth = 60;
    private final int buttonHeight = 40;
    private final int buttonGap = 10;

    public ColorWheelScreen(PlayerEntity player, ItemStack paintbrush) {
        super(ColoredBlocksUtils.stringToText("title"));
        this.paintbrush = paintbrush;
        this.player = player;
    }
    @Override
    protected void init() {
        int baseX = (width / 2) - ((buttonGap * 3/2) + (buttonWidth * 4/2));
        int baseY = (height / 2) - ((buttonGap * 3/2) + (buttonHeight * 4/2));
        int colCount = 0;
        int rowCount = 0;
        for (int i = 0; i <= ColoredBlocksConstants.MAX_COLOR_VALUE; i++) {
            int xOffset = (buttonWidth + buttonGap) * colCount;
            int yOffset = (buttonHeight + buttonGap) * rowCount;
            String color = ColoredBlocksConstants.COLOR_MAP.get(i);
            int colorIdx = ColoredBlocksUtils.getIndexOfColor(color);
            String prettyColorName = ColoredBlocksUtils.getColorName(colorIdx);
            Text buttonTitle = ColoredBlocksUtils.stringToText("",
                    Style.EMPTY.withColor(ColoredBlocksConstants.HEX_COLOR_VALUES[colorIdx])
            );
            ColoredBlocksConstants.RGB_SHADER_VALUES shader = ColoredBlocksConstants.RGB_SHADER_VALUES.byIndex(colorIdx);
            System.out.println(prettyColorName+"- r:"+shader.r()+" g:"+shader.g()+" b:"+shader.b());
            CustomButton button =
                CustomButton.customBuilder(
                    buttonTitle,
                    (buttonWidget) -> {
                        this.changePaintbrushColor(this.paintbrush, colorIdx);
                        PacketByteBuf bufData = PacketByteBufs.create();
                        bufData.writeInt(colorIdx);
                        ClientPlayNetworking.send(PacketHandler.PAINTBRUSH_COLOR_ID, bufData);
                        ColoredBlocksUtils.sendMessage(this.player, "New color: "+prettyColorName);
                        this.close();
                    }
                )
                .setRgb(shader.r())
                .setrGb(shader.g())
                .setrgB(shader.b())
                .dimensions((baseX+xOffset), (baseY+yOffset), buttonWidth, buttonHeight)
                .tooltip(Tooltip.of(ColoredBlocksUtils.stringToText("Change color to "+prettyColorName)))
            .build();
            addDrawableChild(button);
            upgradeButtons.put(color, button);
            if (colCount >= 3) { colCount = 0; rowCount++; } else { colCount++; }
        }
    }
    private void changePaintbrushColor(ItemStack paintbrush, int color) {
        NbtCompound nbtCompound = paintbrush.getOrCreateNbt();
        nbtCompound.putInt("color", color);
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);

        int top = ((height / 2) - ((buttonGap * 3/2) + (buttonHeight * 4/2))) - buttonHeight;
        drawCenteredText(matrices, Screens.getTextRenderer(this), ColoredBlocksUtils.stringToText("Color Wheel"), (width / 2), top, 0xFFFFFF);

        //TODO may implement in the future for custom graphics color wheel dial
//        this.children().forEach( (e) -> {
//            if (!(e instanceof ButtonWidget)) { return; }
//
//            ButtonWidget button = ((ButtonWidget) e);
//
//            if (button.isHovered() && !hasShiftDown()) {
//                this.changePaintbrushColor(this.paintbrush, 0);
//                ColoredBlocksUtils.sendMessage(this.player, "New color: Red");
//            }
//
//
//        });
        if (!hasShiftDown()) {
            this.close();
        }
    }
    @Override
    public boolean shouldPause() {
        return false;
    }

}
