package fr.loudo.narrativecraftemotecraft;

import fr.loudo.narrativecraft.api.NarrativeCraftAPI;
import fr.loudo.narrativecraft.api.recording.action.IActionRegistry;
import fr.loudo.narrativecraftemotecraft.events.OnEmotePlay;
import fr.loudo.narrativecraftemotecraft.events.OnEmoteStop;
import fr.loudo.narrativecraftemotecraft.recording.actions.PlayEmoteAction;
import fr.loudo.narrativecraftemotecraft.recording.actions.StopEmoteAction;
import io.github.kosmx.emotes.api.events.server.ServerEmoteEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NarrativeCraftEmoteCraft {

    public static final NarrativeCraftEmoteCraft INSTANCE = new NarrativeCraftEmoteCraft();

    public static final String MOD_ID = "narrativecraft-emotecraft";
    public static final String MOD_NAME = "NarrativeCraft EmoteCraft Compatibility";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    private MinecraftServer server;

    public static void registerEvents() {
        ServerEmoteEvents.EMOTE_PLAY.register(OnEmotePlay::emotePlay);
        ServerEmoteEvents.EMOTE_STOP_BY_USER.register(OnEmoteStop::emoteStop);
    }

    public static void registerActions() {
        IActionRegistry actionRegistry = NarrativeCraftAPI.getInstance().getActionRegistry();

        actionRegistry.register(PlayEmoteAction.ID, PlayEmoteAction::new);
        actionRegistry.register(StopEmoteAction.ID, StopEmoteAction::new);
    }

    public static NarrativeCraftEmoteCraft getInstance() {
        return INSTANCE;
    }

    public MinecraftServer getServer() {
        return server;
    }

    public void setServer(MinecraftServer server) {
        this.server = server;
    }
}
