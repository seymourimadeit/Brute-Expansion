package tallestegg.bruteexpansion;

import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//handles events and such
@Mod.EventBusSubscriber(modid = BruteExpansion.MODID)
public class EventHandlerBrute {
    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PiglinBruteEntity) {
            // TODO : make piglin brutes spawn with ai for using bucklers.
        }
    }
}
