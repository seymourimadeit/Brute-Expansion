package tallestegg.bruteexpansion.entity.ai;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.task.AttackTargetTask;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;
import tallestegg.bruteexpansion.item.BucklerItem;

public class UseBucklerTask extends AttackTargetTask {

    public UseBucklerTask() {
       super(0);
    }

    @Override
    protected boolean shouldExecute(ServerWorld worldIn, MobEntity owner) {
        //LivingEntity livingentity = owner.getBrain().getMemory(MemoryModuleType.field_234103_o_).get();
        return super.shouldExecute(worldIn, owner) && owner.getHeldItemOffhand().getItem() instanceof BucklerItem;
    }
    
    protected void updateTask(ServerWorld worldIn, MobEntity owner, long gameTime) {
        owner.setActiveHand(Hand.OFF_HAND);
    }

    @Override
    protected void startExecuting(ServerWorld worldIn, MobEntity entityIn, long gameTimeIn) {
        super.startExecuting(worldIn, entityIn, gameTimeIn);
        entityIn.setActiveHand(Hand.OFF_HAND);
    }
}
