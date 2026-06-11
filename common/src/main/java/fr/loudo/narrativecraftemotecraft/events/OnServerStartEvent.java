package fr.loudo.narrativecraftemotecraft.events;

import fr.loudo.narrativecraftemotecraft.NarrativeCraftEmoteCraft;
import net.minecraft.server.MinecraftServer;

public class OnServerStartEvent {
    public static void serverStart(MinecraftServer server) {
        NarrativeCraftEmoteCraft.getInstance().setServer(server);
    }
}
