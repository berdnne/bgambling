package berdnne.bgambling.screen;

import berdnne.bgambling.BrendensGambling;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlackjackScreen extends HandledScreen<BlackjackScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(BrendensGambling.MOD_ID, "textures/gui/blackjack_table.png");

    public BlackjackScreen(BlackjackScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        // you can move the location of the titles of the table and inventory by doing the following
        // titleX = (num), titleY = (num), playerInventoryTitleX = (num), playerInventoryTitleY = (num)


    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x , y, 0, 0, backgroundWidth, backgroundHeight);

        renderHand(context, x, y);

    }

    private void renderHand(DrawContext context, int x, int y) {

        // context.drawTexture((card or chip TEXTURE), x, y, (source texture offset x), (source texture offset y, (source texture width), (source texture height)));

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);

    }
}
