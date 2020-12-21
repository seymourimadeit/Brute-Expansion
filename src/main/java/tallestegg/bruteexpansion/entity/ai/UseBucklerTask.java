package tallestegg.bruteexpansion.entity.ai;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.task.AttackTargetTask;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.server.ServerWorld;
import tallestegg.bruteexpansion.entity.IHasShieldCoolDown;
import tallestegg.bruteexpansion.item.BucklerItem;

public class UseBucklerTask extends AttackTargetTask {

    public UseBucklerTask() {
       super(0);
    }

    @Override
    protected boolean shouldExecute(ServerWorld worldIn, MobEntity owner) {
        //LivingEntity livingentity = owner.getBrain().getMemory(MemoryModuleType.field_234103_o_).get();
        return super.shouldExecute(worldIn, owner) && owner.getHeldItemOffhand().getItem() instanceof BucklerItem && ((IHasShieldCoolDown)owner).getShieldCoolDown() == 0;
    }

    @Override
    protected void startExecuting(ServerWorld worldIn, MobEntity entityIn, long gameTimeIn) {
        System.out.println("my ass");
        BucklerItem.moveFowards(entityIn);
        ((IHasShieldCoolDown)entityIn).setShieldCoolDown(140);
        entityIn.playSound(SoundEvents.field_242133_ld, 1.0F, entityIn.isChild() ? (entityIn.getRNG().nextFloat() - entityIn.getRNG().nextFloat()) * 0.2F + 1.5F : (entityIn.getRNG().nextFloat() - entityIn.getRNG().nextFloat()) * 0.2F + 1.0F);
    }
}
