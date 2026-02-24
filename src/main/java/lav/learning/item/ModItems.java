package lav.learning.item;

import lav.learning.Lavlearning;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    //--create the custom modded Item "CUMTOM_ITEM_NAME" with the ingame name of it lowercase

    public static final Item DARK_PEARL = registerItem("dark_pearl", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Lavlearning.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey,item);
        return item;
    }
    //--in game name "item.lav-learning.dark_pearl"
    //--fixed in game name to render correctly

    /*--DOES NOT WORK
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Lavlearning.MOD_ID,name), item);
    }*/

    public static void registerModItems(){
        Lavlearning.LOGGER.warn("Registering Mod items for " + Lavlearning.MOD_ID);

        //--add the item to the inventory catagory
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register( entries -> {
            //--add the custom Item just made to a group
           entries.add(DARK_PEARL);
        });
    }
}
