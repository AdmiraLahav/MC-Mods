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

public class ModItems {

    //--create the custom modded Item "CUMTOM_ITEM_NAME" with the ingame name of it lowercase
    public static final Item CUSTOM_ITEM_NAME = registerItem("custom_item_name");

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Lavlearning.MOD_ID, name);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new Item(new Item.Settings().registryKey(itemKey));

        return Registry.register(Registries.ITEM, id, item);
    }

    public static void registerModItems() {
        Lavlearning.LOGGER.info("RegModItems has been called");
        Lavlearning.LOGGER.info("Registering Mod items for " + Lavlearning.MOD_ID);

        //--add the item to the inventory catagory
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            //--add the custom Item just made to a group
            fabricItemGroupEntries.add(CUSTOM_ITEM_NAME);
        });
    }
}
