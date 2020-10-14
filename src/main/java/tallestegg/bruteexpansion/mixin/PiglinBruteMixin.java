package tallestegg.bruteexpansion.mixin;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinAction;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import tallestegg.bruteexpansion.BEItems;
import tallestegg.bruteexpansion.entity.IHasShieldCoolDown;

//This is where the magic happens, and by magic, I mean mechanically automated goring into commodities!
@Mixin(PiglinBruteEntity.class)
public class PiglinBruteMixin extends AbstractPiglinEntity implements IHasShieldCoolDown {
    @Unique
    protected int bucklerCoolDown;
    
    @Unique
    protected boolean isCharging;

    public PiglinBruteMixin(EntityType<? extends AbstractPiglinEntity> p_i241915_1_, World p_i241915_2_) {
        super(p_i241915_1_, p_i241915_2_);
    }

    // I would use a event for this, however, I really wouldn't want it to give a
    // brute a buckler every time it joined the world.
    @Inject(at = @At("HEAD"), method = { "onInitialSpawn(Lnet/minecraft/world/IServerWorld;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/ILivingEntityData;Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/entity/ILivingEntityData;" })
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag, CallbackInfoReturnable<ILivingEntityData> info) {
        this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(BEItems.BUCKLER.get()));
        this.bucklerCoolDown = 240;
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Shadow
    protected boolean func_234422_eK_() {
        return false;
    }

    @Shadow
    public PiglinAction func_234424_eM_() {
        return null;
    }

    @Shadow
    protected void func_241848_eP() {};

    @Override
    public int getShieldCoolDown() {
        return this.bucklerCoolDown;
    }

    @Override
    public boolean isCharging() {
        return this.isCharging;
    }
}
