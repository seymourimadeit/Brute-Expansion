package tallestegg.bruteexpansion.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PiglinModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;

//@ me on discord if all of these mixins are bad
@Mixin(PiglinModel.class)
public class PiglinModelMixin<T extends MobEntity> extends PlayerModel<T> {
    public PiglinModelMixin(float modelSize, boolean smallArmsIn) {
        super(modelSize, smallArmsIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.rightArmPose = BipedModel.ArmPose.EMPTY;
        this.leftArmPose = BipedModel.ArmPose.EMPTY;
        if (entityIn.getPrimaryHand() == HandSide.RIGHT) {
            this.giveModelRightArmPoses(Hand.MAIN_HAND, entityIn);
            this.giveModelLeftArmPoses(Hand.OFF_HAND, entityIn);
        } else {
            this.giveModelRightArmPoses(Hand.OFF_HAND, entityIn);
            this.giveModelLeftArmPoses(Hand.MAIN_HAND, entityIn);
        }
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

    //Shamelessly copy and pasted from one of my other mods
    private void giveModelRightArmPoses(Hand hand, T entityIn) {
        ItemStack itemstack = entityIn.getHeldItem(hand);
        UseAction useaction = itemstack.getUseAction();
        if (entityIn.getItemInUseCount() > 0) {
            switch (useaction) {
            case BLOCK:
                this.rightArmPose = BipedModel.ArmPose.BLOCK;
                break;
            default:
                this.rightArmPose = BipedModel.ArmPose.EMPTY;
                break;
            }
        }
    }

    private void giveModelLeftArmPoses(Hand hand, T entityIn) {
        ItemStack itemstack = entityIn.getHeldItem(hand);
        UseAction useaction = itemstack.getUseAction();
        if (entityIn.getItemInUseCount() > 0) {
            switch (useaction) {
            case BLOCK:
                this.leftArmPose = BipedModel.ArmPose.BLOCK;
                break;
            default:
                this.leftArmPose = BipedModel.ArmPose.EMPTY;
                break;
            }
        }
    }
}
