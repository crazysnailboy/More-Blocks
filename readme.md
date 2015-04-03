# More Blocks Mod for Minecraft

A Minecraft mod which adds a variety of new vanilla-based block variants, including pillars, slabs, stairs, fences and walls. 

![Screenshot of Granite Pillars](http://i.imgur.com/ZfnLmWu.png)

See the [wiki](http://chris-minecraft-mods.wikia.com/wiki/More_Blocks) for crafting recipes


## Download

[MoreBlocks-0.1.3.jar](https://github.com/crazysnailboy/More-Blocks/raw/master/bin/MoreBlocks-0.1.3.jar)

*Requires Minecraft Forge 11.14.1.1336*



## Build Instructions

1. Execute `gradlew setupDecompWorkspace`. This sets up Forge and downloads the necessary libraries to build the mod. This might take some time, be patient.
    * You will generally only have to do this once until the Forge version in `build.properties` changes.
2. Execute `gradlew build`. If you did everything right, `BUILD SUCCESSFUL` will be displayed after it finishes. This should be relatively quick.
    * If you see `BUILD FAILED`, check the error output (it should be right around `BUILD FAILED`), fix everything (if possible), and try again.
3. Go to '~\MoreBlocks\build\libs'.
    * You should see a `.jar` file named 'MoreBlocks-<version>.jar`.
4. Copy the jar into your Minecraft mods folder, and you are done!
