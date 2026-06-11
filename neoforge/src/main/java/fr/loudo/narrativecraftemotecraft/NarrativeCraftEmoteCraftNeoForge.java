package fr.loudo.narrativecraftemotecraft;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(NarrativeCraftEmoteCraft.MOD_ID)
public class NarrativeCraftEmoteCraftNeoForge {

    public NarrativeCraftEmoteCraftNeoForge(IEventBus eventBus) {
        CommonClass.init();
    }
}
