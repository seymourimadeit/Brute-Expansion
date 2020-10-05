package tallestegg.bruteexpansion.item;

import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import tallestegg.bruteexpansion.item.renderer.BucklerRenderer;

public class BucklerItem extends ShieldItem {

    public BucklerItem(Properties p_i48470_1_) {
        super(p_i48470_1_.setISTER(BucklerItem::getISTER));
    }

    private static Callable<ItemStackTileEntityRenderer> getISTER() {
        return BucklerRenderer::new;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Vector3d vector3d = playerIn.getMotion();
        double x = vector3d.x;
        double z = vector3d.z;
        playerIn.setMotion(x * 5.0D, 0, z * 5.0D);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }
}
