package tallestegg.bruteexpansion.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.monster.piglin.PiglinBruteBrain;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import tallestegg.bruteexpansion.entity.ai.UseBucklerTask;

//This is also where the M.A.G.I.C happens.
//I'm probably using way too many mixins.
@Mixin(PiglinBruteBrain.class)
public class BruteBrainMixin {
    @Inject(at = @At("HEAD"), method = { "func_242364_d(Lnet/minecraft/entity/monster/piglin/PiglinBruteEntity;Lnet/minecraft/entity/ai/brain/Brain;)V" })
    private static void func_242364_d(PiglinBruteEntity brute, Brain<PiglinBruteEntity> brain, CallbackInfo info) {
        brain.func_233698_a_(Activity.CORE, 0, ImmutableList.of(new UseBucklerTask()));
    }
}
