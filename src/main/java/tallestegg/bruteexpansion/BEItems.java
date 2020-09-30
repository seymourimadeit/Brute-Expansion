package tallestegg.bruteexpansion;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tallestegg.bruteexpansion.item.BucklerItem;

@Mod.EventBusSubscriber(modid = BruteExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BEItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BruteExpansion.MODID);
    public static final RegistryObject<BucklerItem> BUCKLER = ITEMS.register("buckler",  () -> new BucklerItem((new Item.Properties()).maxDamage(336).group(ItemGroup.COMBAT)));
}
