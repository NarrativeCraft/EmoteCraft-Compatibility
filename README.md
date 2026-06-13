# NarrativeCraft-EmoteCraft

Add EmoteCraft compatibility to NarrativeCraft

## Features

- Records your emote from the recording feature
- Add a new Ink Action to play an emote to a character


## Emote Tag

Play an emote animation on a character using EmoteCraft.
## Side
SERVER

## Syntax

```
emote <action:string> <emoteName:string> <characterName:string>
```

## Parameters

- `action` *(string, required)*: `play` or `stop`.
- `emoteName` *(string, required)*: The emote name to play.
- `characterName` *(string, required)*: Name of the character or NPC in the scene.
## Examples

```ink
// Play the emote "clap" to "Steve"
# emote play clap Steve
```

```ink
// Stop the emote "clap" from "Steve"
# emote stop clap Steve
```
