package fr.loudo.narrativecraftemotecraft;

import fr.loudo.narrativecraftemotecraft.events.OnServerStartEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class NarrativeCraftEmoteCraftFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();

        ServerLifecycleEvents.SERVER_STARTED.register(OnServerStartEvent::serverStart);
    }
}
