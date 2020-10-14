package tallestegg.bruteexpansion;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tallestegg.bruteexpansion.entity.IHasShieldCoolDown;

//handles events and such
@Mod.EventBusSubscriber(modid = BruteExpansion.MODID)
public class EventHandlerBrute {
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof IHasShieldCoolDown) {
            int coolDown = ((IHasShieldCoolDown) event.getEntity()).getShieldCoolDown();
            if (coolDown > 0 && ((IHasShieldCoolDown) event.getEntity()).isCharging()) {
                coolDown--;
            }
        }
    }
}
