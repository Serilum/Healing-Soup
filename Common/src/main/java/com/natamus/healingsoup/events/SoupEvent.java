package com.natamus.healingsoup.events;

import com.natamus.healingsoup.config.ConfigHandler;
import com.natamus.healingsoup.items.SoupItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SoupEvent {
	public static InteractionResultHolder<ItemStack> onPlayerInteract(Player player, Level world, InteractionHand hand) {
		ItemStack handstack = player.getItemInHand(hand);
		if (world.isClientSide) {
			return InteractionResultHolder.pass(handstack);
		}

		Item handitem = handstack.getItem();
		
		if (handitem.equals(Items.MUSHROOM_STEW) || SoupItems.soups.contains(handitem)) {
			if (handstack.getCount() > 1) {
				return InteractionResultHolder.fail(handstack);
			}
			
			ItemStack bowl = new ItemStack(Items.BOWL, 1);
			
			FoodData stats = player.getFoodData();
			if (player.getHealth() == 20) {
				if (stats.getFoodLevel() == 20) {
					return InteractionResultHolder.pass(handstack);
				}	

				int food = stats.getFoodLevel() + ConfigHandler.soupHalfHeartHealAmount;

				stats.setFoodLevel(Math.min(food, 20));
			}
			else {
				int health = (int) (player.getHealth() + ConfigHandler.soupHalfHeartHealAmount);

				player.setHealth(Math.min(health, 20));
			}
			
			player.setItemInHand(hand, bowl);
			return InteractionResultHolder.fail(handstack);
		}

		return InteractionResultHolder.pass(handstack);
	}
}