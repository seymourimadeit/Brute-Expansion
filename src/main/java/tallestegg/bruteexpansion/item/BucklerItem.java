package tallestegg.bruteexpansion.item;

import java.util.concurrent.Callable;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import tallestegg.bruteexpansion.item.renderer.BucklerRenderer;

public class BucklerItem extends ShieldItem {

    public BucklerItem(Properties p_i48470_1_) {
        super(p_i48470_1_.setISTER(BucklerItem::getISTER));
    }

    private static Callable<ItemStackTileEntityRenderer> getISTER() {
        return BucklerRenderer::new;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.moveForward = 10.0F;
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }
}
