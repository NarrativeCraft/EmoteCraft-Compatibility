package fr.loudo.narrativecraftemotecraft.inkTag;

import com.zigythebird.playeranimcore.animation.Animation;
import fr.loudo.narrativecraft.api.inkAction.InkAction;
import fr.loudo.narrativecraft.api.inkAction.InkActionResult;
import fr.loudo.narrativecraft.api.inkAction.InkCommand;
import fr.loudo.narrativecraft.api.inkAction.Side;
import fr.loudo.narrativecraft.api.inkAction.syntax.ParsedCommand;
import fr.loudo.narrativecraft.api.narrative.IStoryHandler;
import fr.loudo.narrativecraft.api.narrative.scene.IScene;
import fr.loudo.narrativecraft.api.session.IPlayerSession;
import io.github.kosmx.emotes.common.tools.UUIDMap;
import io.github.kosmx.emotes.server.serializer.UniversalEmoteSerializer;

@InkCommand(
        keyword = "emote",
        description = "Play an emote animation on a character using EmoteCraft.",
        syntax = "emote <action:string> <emoteName:string> <characterName:string>",
        side = Side.SERVER)
public class EmoteInkAction extends InkAction {

    private String action;
    private Animation animation;

    @Override
    protected InkActionResult doValidate(ParsedCommand cmd, IScene scene) {
        String action = cmd.getString("action");
        if (action.equalsIgnoreCase("play") || action.equalsIgnoreCase("stop")) {
            return InkActionResult.error("Action is either 'play' or 'stop'");
        }

        String emoteName = cmd.getString("emoteName");
        animation = getEmote(emoteName, UniversalEmoteSerializer.getLoadedEmotes());
        if (animation == null) {
            return InkActionResult.error(String.format("Emote '%s' does not exists.", emoteName));
        }

        return InkActionResult.ok();
    }

    @Override
    protected InkActionResult doExecute(IPlayerSession playerSession) {

        IStoryHandler storyHandler = playerSession.getStoryHandler();
        if (storyHandler == null) return InkActionResult.ignored();

        return InkActionResult.ok();
    }

    private Animation getEmote(String emoteName, UUIDMap<Animation> emotes) {
        for (Animation animation : emotes) {
            String name = (String) animation.data().getRaw("name");
            if (name.equalsIgnoreCase(emoteName)) {
                return animation;
            }
        }
        return null;
    }
}
