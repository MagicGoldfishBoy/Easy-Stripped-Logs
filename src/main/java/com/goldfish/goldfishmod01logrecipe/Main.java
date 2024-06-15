package com.goldfish.goldfishmod01logrecipe;

import org.slf4j.Logger;

import com.goldfish.goldfishmod01logrecipe.item.logdebarkingitem;
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
import com.goldfish.goldfishmod01logrecipe.item.logdebarkingitem;


@Mod(Main.MODID)

public class Main
{

    public static final String MODID = "goldfishmod01logrecipe";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //public static final DeferredItem<Item> DebarkReg = logdebarkingitem.logdebarkingitemRegistrationMethod();

    public static final DeferredItem<Item> DebarkReg = logdebarkingitem.logdebarkingitem;

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public Main(IEventBus modEventBus, ModContainer modContainer)
    
    {

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        logdebarkingitem.logdebarkingitemRegistrationMethod();
        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Goldfish goes bloop");

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
    


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("The server started lol");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("Brillant");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }

        @SubscribeEvent
        public static void buildContents(BuildCreativeModeTabContentsEvent event) { //<- currently this does not actually work as the item is always null, which is very confusing because I can craft it and use the give command
           // LOGGER.info("This was supposed to be easy!");                           // I would ask for help, but as a nohelpian this is against my religion. Also I'm a nooblet so I doubt it would end well anyway :(
            logdebarkingitem.logdebarkingitemget();
            if (event.getTabKey() == CreativeModeTabs.INGREDIENTS && logdebarkingitem.logdebarkingitem != null) {              
                event.accept(logdebarkingitem.logdebarkingitem.get());
               // LOGGER.info("FINALLY!!!");
            }else {
               // LOGGER.info("FML!!!");
            }
        }
    }
    
}

