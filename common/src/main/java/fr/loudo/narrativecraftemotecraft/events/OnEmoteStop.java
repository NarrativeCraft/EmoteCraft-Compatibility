package fr.loudo.narrativecraftemotecraft.events;

import fr.loudo.narrativecraft.api.NarrativeCraftAPI;
import fr.loudo.narrativecraft.api.recording.IRecording;
import fr.loudo.narrativecraftemotecraft.NarrativeCraftEmoteCraft;
import fr.loudo.narrativecraftemotecraft.recording.actions.StopEmoteAction;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class OnEmoteStop {
    public static void emoteStop(UUID emoteId, UUID playerId) {
        MinecraftServer server = NarrativeCraftEmoteCraft.getInstance().getServer();
        ServerPlayer player = server.getPlayerList().getPlayer(playerId);
        if (player == null) return;

        IRecording recording =
                NarrativeCraftAPI.getInstance().getRecordingManager().getRecording(player);
        if (recording == null || !recording.isRecording()) return;

        recording.addAction(new StopEmoteAction(recording.getTick()), player);
    }
}
