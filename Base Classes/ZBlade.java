package megateam.megamanxrpg;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ZBlade extends ItemSword{
	int tickssinceuse = 0;
	boolean cantripleslash = false;
	public static DamageSource blades;
	protected static Entity entity;
	protected static EntityPlayer player;
	
	Timer t = new Timer();
	
	public ZBlade(int id, EnumToolMaterial mat){
		super(id, mat);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("megamanxrpg:ZSaber");
	}
	
	@Override
	public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer fplayer, final Entity fentity)
	{
		MyPlayerHandler.ZEntitySelected = true;
		this.player = fplayer;
		this.entity = fentity;
//		if(MyPlayerHandler.canUseAbility == true){
//			MyPlayerHandler.canUseAbility = false;
//			MyPlayerHandler.swings = 0;
//			MyPlayerHandler.ticks = 0;
//			player.sendChatToPlayer("You used the Z-Saber \"Triple Slash\" ability!");
//			entity.hurtResistantTime = 0;
//			
//			MyPlayerHandler.displayedMsg = false;
//			new Timer().schedule(new TimerTask(){
//				@Override
//				public void run(){
//					entity.attackEntityFrom(DamageSource.generic, 10);
//				}
//			}, 0);
//			new Timer().schedule(new TimerTask(){
//				@Override
//				public void run(){
//					entity.attackEntityFrom(DamageSource.generic, 10);
//				}
//			}, 500);
//			new Timer().schedule(new TimerTask(){
//				@Override
//				public void run(){
//					entity.attackEntityFrom(DamageSource.generic, 10);
//				}
//			}, 1000);
//			new Timer().schedule(new TimerTask(){
//				@Override
//				public void run(){
//					MyPlayerHandler.displayedMsg = false;
//					MyPlayerHandler.canUseAbility = false;
//					MyPlayerHandler.swings = 0;
//					MyPlayerHandler.ticks = 0;
//				}
//			}, 1200);
//		}
		
		return false;
	}
	
	public static Entity getEntity(){
		return entity;
	}
	
	public static EntityPlayer getEntityPlayer(){
		return player;
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        if (!world.isRemote) {
        }

        return itemStack;
    }
}
