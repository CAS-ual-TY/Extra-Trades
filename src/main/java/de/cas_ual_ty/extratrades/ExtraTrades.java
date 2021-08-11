package de.cas_ual_ty.extratrades;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ExtraTrades.MOD_ID)
public class ExtraTrades
{
    public static final String MOD_ID = "extratrades";
    
    public ExtraTrades()
    {
        MinecraftForge.EVENT_BUS.addListener(this::villagerTrades);
    }
    
    private void villagerTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.BUTCHER)
        {
            event.getTrades().get(4).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.COOKED_MUTTON, 5), 16, 25, 0.05F));
            event.getTrades().get(4).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.COOKED_BEEF, 6), 16, 25, 0.05F));
        }
        else if(event.getType() == VillagerProfession.CARTOGRAPHER)
        {
            event.getTrades().get(5).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.CREEPER_BANNER_PATTERN, 1), 12, 30, 0.05F));
            event.getTrades().get(5).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.FLOWER_BANNER_PATTERN, 1), 12, 30, 0.05F));
            event.getTrades().get(5).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.SKULL_BANNER_PATTERN, 1), 12, 30, 0.05F));
        }
        else if(event.getType() == VillagerProfession.CLERIC)
        {
            event.getTrades().get(3).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.RABBIT_FOOT, 1), 5, 5, 0.05F));
        }
        else if(event.getType() == VillagerProfession.FARMER)
        {
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.WHEAT, 5), 16, 1, 0.05F));
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.POTATO, 6), 16, 1, 0.05F));
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.CARROT, 5), 16, 1, 0.05F));
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.SUGAR_CANE, 6), 16, 1, 0.05F));
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.SUGAR_CANE, 28), new ItemStack(Items.EMERALD, 1), 16, 2, 0.05F));
            event.getTrades().get(2).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.EGG, 4), 16, 5, 0.05F));
            event.getTrades().get(2).add(ExtraTrades.buildTrade(new ItemStack(Items.EGG, 16), new ItemStack(Items.EMERALD, 1), 16, 10, 0.05F));
        }
        else if(event.getType() == VillagerProfession.FISHERMAN)
        {
            event.getTrades().get(5).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.PUFFERFISH, 1), 5, 0, 0.05F));
        }
        else if(event.getType() == VillagerProfession.LEATHERWORKER)
        {
            event.getTrades().get(3).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.LEATHER, 3), 16, 10, 0.05F));
        }
        else if(event.getType() == VillagerProfession.MASON)
        {
            event.getTrades().get(3).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.COBBLESTONE, 8), 16, 10, 0.05F));
            event.getTrades().get(3).add(ExtraTrades.buildTrade(new ItemStack(Items.COBBLESTONE, 32), new ItemStack(Items.EMERALD, 1), 16, 20, 0.05F));
        }
        else if(event.getType() == VillagerProfession.SHEPHERD)
        {
            event.getTrades().get(1).add(ExtraTrades.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.STRING, 3), 5, 1, 0.05F));
        }
    }
    
    public static ItemListing buildTrade(ItemStack wanted1, ItemStack given, int tradesUntilDisabled, int xpToVillagr, float priceMultiplier)
    {
        return ExtraTrades.buildTrade(wanted1, ItemStack.EMPTY, given, tradesUntilDisabled, xpToVillagr, priceMultiplier);
    }
    
    public static ItemListing buildTrade(ItemStack wanted1, ItemStack wanted2, ItemStack given, int tradesUntilDisabled, int xpToVillagr, float priceMultiplier)
    {
        return (entity, random) -> new MerchantOffer(wanted1, wanted2, given, tradesUntilDisabled, xpToVillagr, priceMultiplier);
    }
}
