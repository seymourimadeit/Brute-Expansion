package tallestegg.bruteexpansion;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tallestegg.bruteexpansion.entity.IHasShieldCoolDown;

//handles events and such
@Mod.EventBusSubscriber(modid = BruteExpansion.MODID)
public class EventHandlerBrute {
    
    public static int test;
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof IHasShieldCoolDown) {
            int coolDown = ((IHasShieldCoolDown) event.getEntity()).getShieldCoolDown();
            if (coolDown > 0 && ((IHasShieldCoolDown) event.getEntity()).isCharging()) {
                coolDown--;
            }
        }

        if (event.getEntity() instanceof PlayerEntity) {
            Vector3d vector3d = event.getEntity().getMotion();
            test--;
            double x = vector3d.x;
            double y = vector3d.y;
            double z = vector3d.z;
            if (test > 0) {
                event.getEntity().setMotion(x * 1.2D, 0, z * 1.2D);
            }
        }
    }
}
