package com.mrlocalhost.coloredblocks.screen.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class CustomButton extends ButtonWidget {

    private static final Identifier CUSTOM_BUTTON_TEXTURE = new Identifier(ColoredBlocks.MOD_ID, "textures/gui/custom_button_widgets.png");
    private final float red, green, blue, alpha;

    protected CustomButton(int x, int y, int width, int height, Text message, PressAction onPress,
                           NarrationSupplier narrationSupplier, float r, float g, float b, float a) {
        super(x, y, width, height, message, onPress, narrationSupplier);
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
        TextRenderer textRenderer = minecraftClient.textRenderer;
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, CUSTOM_BUTTON_TEXTURE);
        RenderSystem.setShaderColor(this.red, this.green, this.blue, this.alpha);
        int i = this.getYImage(this.isHovered());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        //Left half
        this.drawTexture(matrices, this.getX(), this.getY(), 0, i * 40, this.width / 2, this.height);

        //Right half
        this.drawTexture(matrices, this.getX() + this.width / 2, this.getY(), 200 - this.width / 2, i * 40, this.width / 2, this.height);

        this.renderBackground(matrices, minecraftClient, mouseX, mouseY);
        int j = this.active ? 16777215 : 10526880;
        drawCenteredText(matrices, textRenderer, this.getMessage(), this.getX() + this.width / 2, this.getY() + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }
    @Environment(EnvType.CLIENT)
    public static class CustomBuilder {
        private final Text message;
        private final PressAction onPress;
        @Nullable
        private Tooltip tooltip;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;
        private float red = 1.0F;
        private float green = 1.0F;
        private float blue = 1.0F;
        private float alpha = 1.0F;
        private NarrationSupplier narrationSupplier;

        public CustomBuilder(Text message, PressAction onPress) {
            this.narrationSupplier = CustomButton.DEFAULT_NARRATION_SUPPLIER;
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
        public CustomButton.CustomBuilder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }
        public CustomButton.CustomBuilder narrationSupplier(NarrationSupplier narrationSupplier) {
            this.narrationSupplier = narrationSupplier;
            return this;
        }
        public CustomButton build() {
            CustomButton customButton = new CustomButton(this.x, this.y, this.width, this.height, this.message, this.onPress,
                    this.narrationSupplier, this.red, this.green, this.blue, this.alpha);
            customButton.setTooltip(this.tooltip);
            return customButton;
        }
    }
}
