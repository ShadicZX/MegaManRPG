package megateam.megamanxrpg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

/**
 * Name and cast of this class are irrelevant
 */
public class DoubleJumpEventHook{

	protected static KeyBinding key_djump = new KeyBinding("key.djump", 57);
	
	public boolean OnTickInGame(float f, Minecraft minecraft) {
		EntityPlayer m = ModLoader.getMinecraftInstance().thePlayer;
		if(djump)
		{
			m.jumpMovementFactor = 10;
		}
		return true;
	}

	public void KeyboardEvent(KeyBinding event)
	{
		Minecraft minecraft = ModLoader.getMinecraftInstance();
		if (event == this.key_djump)
		{
			djump = !djump;
		}
	}
	
	public boolean djump;
}