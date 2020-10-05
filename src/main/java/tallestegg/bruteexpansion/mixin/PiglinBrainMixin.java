package tallestegg.bruteexpansion.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import com.google.common.collect.ImmutableSet;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.monster.piglin.PiglinBruteBrain;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;

//This is also where the M.A.G.I.C happens.
//I'm probably using way too many mixins.
@Mixin(PiglinBruteBrain.class)
public class PiglinBrainMixin {
    @Inject(at = @At("TAIL"), method = { " func_242354_a(Lnet/minecraft/entity/monster/piglin/PiglinBruteEntity;Lnet/minecraft/entity/ai/brain/Brain;)Lnet/minecraft/entity/ai/brain/Brain;" })
    protected static Brain<?> func_242354_a(PiglinBruteEntity p_242354_0_, Brain<PiglinBruteEntity> p_242354_1_) {
        p_242354_1_.setDefaultActivities(ImmutableSet.of(Activity.CORE));
        p_242354_1_.setFallbackActivity(Activity.IDLE);
        p_242354_1_.func_233714_e_();
        return p_242354_1_;
     }
}
