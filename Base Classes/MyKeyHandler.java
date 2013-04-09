package megateam.megamanxrpg;

import java.util.EnumSet;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class MyKeyHandler extends KeyHandler {
	static KeyBinding myBinding = new KeyBinding("MyBind", Keyboard.KEY_B);

	public int jumps = 0;

	public MyKeyHandler() {
		//the first value is an array of KeyBindings, the second is whether or not the call 
		//keyDown should repeat as long as the key is down
		super(new KeyBinding[]{myBinding}, new boolean[]{false});
	}

	@Override
	public String getLabel() {
		return "mykeybindings";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) {
		//do whatever
		final PlayerControllerMP playercontroller = ModLoader.getMinecraftInstance().playerController;
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				playercontroller.enableEverythingIsScrewedUpMode();
			}
		}, 25);
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		//do whatever
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
		//I am unsure if any different TickTypes have any different effects.
	}
}
