package com.wonginnovations.oldresearch.common.items;


import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = "oldresearch")
public class ModItems {

    public static final Item RESEARCHNOTE = new ItemResearchNote();
    public static final Item KNOWLEDGEFRAGMENT = new ItemKnowledgeFragment();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> r = event.getRegistry();

        r.register(RESEARCHNOTE);
        r.register(KNOWLEDGEFRAGMENT);
    }
}
