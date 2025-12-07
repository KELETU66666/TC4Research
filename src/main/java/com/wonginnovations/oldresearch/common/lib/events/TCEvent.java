package com.wonginnovations.oldresearch.common.lib.events;

import com.wonginnovations.oldresearch.OldResearch;
import com.wonginnovations.oldresearch.common.lib.network.PacketAspectPool;
import com.wonginnovations.oldresearch.common.lib.network.PacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.research.ResearchEvent;

@Mod.EventBusSubscriber(modid = "oldresearch")
public class TCEvent {

    @SubscribeEvent
    public static void onPlayerGainKnowledge(ResearchEvent.Knowledge event) {
        EntityPlayer player = event.getPlayer();

        if (!player.world.isRemote) {
            for (Aspect a : Aspect.getPrimalAspects()) {
                int q = player.world.rand.nextInt(2) + event.getAmount() / (event.getType() == IPlayerKnowledge.EnumKnowledgeType.OBSERVATION ? 100 : 50);
                OldResearch.proxy.playerKnowledge.addAspectPool(player.getGameProfile().getName(), a, q);
                PacketHandler.INSTANCE.sendTo(new PacketAspectPool(a.getTag(), q, OldResearch.proxy.playerKnowledge.getAspectPoolFor(player.getGameProfile().getName(), a)), (EntityPlayerMP) player);
            }
        }

        event.setCanceled(true);
    }
}
