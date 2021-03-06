package megateam.megamanxrpg;
import java.util.EnumSet;
import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class MyPlayerHandler implements ITickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		playerTick((EntityPlayer)tickData[0]);
	}

	protected static boolean displayedMsg = false;
	protected static boolean canUseAbility = false;
	protected static int ticks = 0;
	protected static int swings = 0;
	protected static int repairTicks = 0;
	public static boolean ZEntitySelected = false;
	public static boolean XEntitySelected = false;
	private boolean hasJumped = false;
	private World world;
	private void playerTick(final EntityPlayer player)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && (player.isJumping || player.isAirBorne) && player.motionY < 0.07 && !hasJumped)
		{
			if(player.motionY >= -0.44749789698341763 && player.motionY <= -0.230527368912964)
			{
				player.addVelocity(0, 0.75, 0);
				hasJumped = true;
			}
			else{
				player.addVelocity(0, 0.5, 0);
				hasJumped = true;
			}
		}

		if(player.onGround == true){
			hasJumped = false;
		}

		if(player.getCurrentEquippedItem() != null){
			if(player.getCurrentEquippedItem().itemID == megamanxrpg.ZBlade.itemID){
				ticks++;
				if(player.swingProgressInt == 3 && ZEntitySelected == true){
					swings++;
				}
				if(ticks > 200){
					swings = 0;
				}
				if(swings == 0){
					ticks = 0;
					canUseAbility = false;
				}
				if(swings == 3 && ticks < 400){
					canUseAbility = true;
					ZEntitySelected = false;
					if(displayedMsg == true){
						
					}
					else if(displayedMsg == false){
						player.sendChatToPlayer("Z-Saber \"Triple Slash\" available!");
						displayedMsg = true;
					}
				}
				if(canUseAbility == true && ZEntitySelected == true){
					Ability();
				}
				if(player.getCurrentEquippedItem().isItemDamaged() == true){
					player.getCurrentEquippedItem().setItemDamage(0);
				}
			}
			if(player.getCurrentEquippedItem().itemID == megamanxrpg.XBlade.itemID){
				repairTicks++;
				if(repairTicks == 2){
					if(player.getCurrentEquippedItem().isItemDamaged() == true){
						player.getCurrentEquippedItem().setItemDamage(player.getCurrentEquippedItem().getItemDamage() - 50);
					}
					repairTicks = 0;
				}
				if(player.getCurrentEquippedItem().isItemDamaged() == false && XEntitySelected == true){
					Entity entity = XBlade.getEntity();
					entity.attackEntityFrom(DamageSource.generic, 5);
					new Timer().schedule(new TimerTask(){
						@Override
						public void run(){
							XEntitySelected = false;
							player.getCurrentEquippedItem().setItemDamage(950);
						}
					}, 30);
				}
			}
		}
	}
	
	private int abilityTicks = 0;
	private void Ability() {
		Entity entity = ZBlade.getEntity();
		EntityPlayer player = ZBlade.getEntityPlayer();
		entity.hurtResistantTime = 2;
		if(abilityTicks == 0){
			player.sendChatToPlayer("You used the Z-Blade \"Triple Slash\" ability!");
			entity.attackEntityFrom(DamageSource.generic, 3);
			System.out.println("First Strike!");
		}
		if(abilityTicks == 5){
			entity.attackEntityFrom(DamageSource.generic, 3);
			System.out.println("Second Strike!");
		}
		if(abilityTicks == 10){
			entity.attackEntityFrom(DamageSource.generic, 3);
			System.out.println("Third Strike!");
		}
		if(abilityTicks == 12){
			abilityTicks = 0;
			canUseAbility = false;
			swings = 0;
			ticks = 0;
			ZEntitySelected = false;
			ZBlade.entity = null;
			ZBlade.player = null;
			displayedMsg = false;
		}
		abilityTicks++;
		System.out.println(abilityTicks);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "MyPlayerHandler";
	} 

}