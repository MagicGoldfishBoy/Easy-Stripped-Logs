package com.goldfish.goldfishmod01logrecipe.item;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.goldfish.goldfishmod01logrecipe.*;
import com.goldfish.goldfishmod01logrecipe.Main.*;

public class logdebarkingitem extends Item {
	public static final DeferredItem<Item> logdebarkingitemRegistrationMethod(){
	  
		DeferredItem<Item> logdebarkingitem = Main.ITEMS.register("log_debarking_item", () ->
		new logdebarkingitem(new Item.Properties()));
		System.out.println("registered debarker");
		return logdebarkingitem;
	};
	
    public logdebarkingitem(Item.Properties properties) {
        super(properties);
		properties.craftRemainder(this);
    }

}

    // public Item craftRemainder(Item item) {
	// 	System.out.println("debarker craft remainder");
	//     return this;		
	// }
    
	// public ItemStack getCraftingRemainingItem(ItemStack stack)
	// {
	// 	return stack.copy();
	// }

	// public boolean hasCraftingRemainingItem(ItemStack stack)
	// {
	// 	return true;
	// }