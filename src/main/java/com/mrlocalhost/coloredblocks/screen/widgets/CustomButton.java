package com.mrlocalhost.coloredblocks.screen.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomButton extends ButtonWidget {

    private static final Identifier CUSTOM_BUTTON_TEXTURE = new Identifier(ColoredBlocks.MOD_ID, "textures/gui/custom_button_widgets.png");
    private final float red, green, blue, alpha;

    protected CustomButton(int x, int y, int width, int height, Text message, PressAction onPress,
                           float r, float g, float b, float a) {
        super(x, y, width, height, message, onPress);
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;
    }
    public static CustomBuilder customBuilder(Text message, PressAction onPress) {
        return new CustomBuilder(message, onPress);
    }
    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, CUSTOM_BUTTON_TEXTURE);
        RenderSystem.setShaderColor(this.red, this.green, this.blue, this.alpha);
        int i = this.getYImage(this.isHovered());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        //Left half
        this.drawTexture(matrices, this.x, this.y, 0, i * 40, this.width / 2, this.height);

        //Right half
        this.drawTexture(matrices, this.x + this.width / 2, this.y, 200 - this.width / 2, i * 40, this.width / 2, this.height);

        this.renderBackground(matrices, minecraftClient, mouseX, mouseY);
    }
    @Environment(EnvType.CLIENT)
    public static class CustomBuilder {
        private final Text message;
        private final PressAction onPress;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;
        private float red = 1.0F;
        private float green = 1.0F;
        private float blue = 1.0F;
        private float alpha = 1.0F;

        public CustomBuilder(Text message, PressAction onPress) {
            this.message = message;
            this.onPress = onPress;
        }
        public CustomButton.CustomBuilder setRgb(float r) {
            this.red = r;
            return this;
        }
        public CustomButton.CustomBuilder setrGb(float g) {
            this.green = g;
            return this;
        }
        public CustomButton.CustomBuilder setrgB(float b) {
            this.blue = b;
            return this;
        }
        public CustomButton.CustomBuilder setrgbA(float a) {
            this.alpha = a;
            return this;
        }
        public CustomButton.CustomBuilder RGBA(float r, float g, float b, float a) {
            this.red = r;
            this.green = g;
            this.blue = b;
            this.alpha = a;
            return this;
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
        public CustomButton build() {
            return new CustomButton(this.x, this.y, this.width, this.height, this.message, this.onPress,
                this.red, this.green, this.blue, this.alpha);
        }
    }
}
