package com.mrlocalhost.coloredblocks.screen.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class CustomButton extends ButtonWidget {
    protected CustomButton(int x, int y, int width, int height, Text message, PressAction onPress) {
        super(x, y, width, height, message, onPress);
    }
    public static CustomBuilder customBuilder(Text message, PressAction onPress) {
        return new CustomBuilder(message, onPress);
    }
    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        TextRenderer textRenderer = minecraftClient.textRenderer;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, WIDGETS_TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        int i = this.getYImage(this.isHovered());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.drawTexture(matrices, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
        this.drawTexture(matrices, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
        this.renderBackground(matrices, minecraftClient, mouseX, mouseY);
        int j = this.active ? 16777215 : 10526880;
        drawCenteredText(matrices, textRenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }
    @Environment(EnvType.CLIENT)
    public static class CustomBuilder {
        private final Text message;
        private final PressAction onPress;
        @Nullable
        private TooltipComponent tooltip;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;

        public CustomBuilder(Text message, PressAction onPress) {
            this.message = message;
            this.onPress = onPress;
        }
        public CustomButton.CustomBuilder position(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }
        public CustomButton.CustomBuilder width(int width) {
            this.width = width;
            return this;
        }
        public CustomButton.CustomBuilder size(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }
        public CustomButton.CustomBuilder dimensions(int x, int y, int width, int height) {
            return this.position(x, y).size(width, height);
        }
        public CustomButton.CustomBuilder tooltip(@Nullable TooltipComponent tooltip) {
            this.tooltip = tooltip;
            return this;
        }
        public CustomButton build() {
            return new CustomButton(this.x, this.y, this.width, this.height, this.message, this.onPress);
        }
    }
}
