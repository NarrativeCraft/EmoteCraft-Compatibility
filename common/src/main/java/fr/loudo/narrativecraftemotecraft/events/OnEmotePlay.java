package fr.loudo.narrativecraftemotecraft.events;

import com.zigythebird.playeranimcore.animation.Animation;
import fr.loudo.narrativecraft.api.NarrativeCraftAPI;
import fr.loudo.narrativecraft.api.recording.IRecording;
import fr.loudo.narrativecraftemotecraft.NarrativeCraftEmoteCraft;
import fr.loudo.narrativecraftemotecraft.recording.actions.PlayEmoteAction;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class OnEmotePlay {
    public static void emotePlay(Animation animation, float tick, UUID playerId) {

        MinecraftServer server = NarrativeCraftEmoteCraft.getInstance().getServer();
        ServerPlayer player = server.getPlayerList().getPlayer(playerId);
        if (player == null) return;

        IRecording recording =
                NarrativeCraftAPI.getInstance().getRecordingManager().getRecording(player);
        if (recording == null || !recording.isRecording()) return;

        recording.addAction(new PlayEmoteAction(recording.getTick(), animation), player);
    }
}
