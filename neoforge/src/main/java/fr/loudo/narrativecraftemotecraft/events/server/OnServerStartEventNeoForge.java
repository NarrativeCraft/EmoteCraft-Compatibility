package fr.loudo.narrativecraftemotecraft.events.server;

import fr.loudo.narrativecraftemotecraft.NarrativeCraftEmoteCraft;
import fr.loudo.narrativecraftemotecraft.events.OnServerStartEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

@Mod(NarrativeCraftEmoteCraft.MOD_ID)
public class OnServerStartEventNeoForge {

    public OnServerStartEventNeoForge(IEventBus modBus) {
        NeoForge.EVENT_BUS.addListener(OnServerStartEventNeoForge::onServerStart);
    }

    private static void onServerStart(ServerStartedEvent event) {
        OnServerStartEvent.serverStart(event.getServer());
    }
}
