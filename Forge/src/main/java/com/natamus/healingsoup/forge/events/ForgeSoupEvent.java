package com.natamus.healingsoup.forge.events;

import com.natamus.healingsoup.events.SoupEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeSoupEvent {
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent.RightClickItem e) {
		if (SoupEvent.onPlayerInteract(e.getEntity(), e.getLevel(), e.getHand()).getResult().equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}
}