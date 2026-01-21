# <img src="src/main/resources/assets/bark-blocks/icon.png" width="30" /> Bark Blocks

## Features

### Blocks

This mod adds several new blocks: a new bark block for each wood type - including the nether ones. More specifically,

- Oak Bark
- Spruce Bark
- Birch Bark
- Jungle Bark
- Acacia Bark
- Dark Oak Bark
- Mangrove Bark
- Cherry Bark
- Pale Oak Bark
- Crimson Annulus
- Warped Annulus

These blocks are hollow through one axis: a two pixel wide ring showing the log textures outside and stripped texture inside. They're spacious enough to stand in (when verticle) or crawl through (when horizontal). They are also waterloggable.

### Obtaining

Bark blocks are obtained by stripping the associated log or wood block, this requires an axe with silk touch - finally giving silk touch a reasonable use for axes.

### World gen

Recently, minecraft introduced fallen trees as a feature that can generate in some biomes. With this mod, these fallen trees have a 1/5 chance to be replaced with a hollow version composed of bark blocks instead.

## Setup

### Compiling (Optional)

Compiled jar files are available under releases, if you intend to use these then you can ignore this. I suggest ignoring this unless you are familiar with mod development or otherwise understand what you are doing.

Fabric mods use gradle to manage the project, this may be able to be done from your IDE, elsewise from your terminal of choice. Using an IDE may require [setup](https://docs.fabricmc.net/develop/getting-started/setting-up). In any case, you'll need to run the runDatagen task then the build task. The output jar should be located as <nobr>'build/libs/bark-blocks-\<version\>.jar'</nobr>.

Note: there may also be a jar file of similar name <nobr>'bark-blocks-\<version\>-sources.jar'</nobr> this can be ignored.

### Installing

To use this mod you'll need to have fabric installed, if you do not already please see [here](https://docs.fabricmc.net/players/installing-fabric/). As with any fabric mod, simply place the jar file into the mods folder - note that this mod depends on Fabric API. See [here](https://docs.fabricmc.net/players/installing-mods) if you need help.

## See also

### Versioning

As with most minecraft mods, semantic versioning isn't well suited.
Minecraft in unusual in that older version are still played frequently, especially when modded.
Thus it makes sense for modders to target a range of minecraft version as opposed to just the latest.
So I'm going to throw in my two cents here.

The version will look like ```<feature>.<update>.<patch>+<minecraft-version>```
and pre-release versions will be indicated by adding ```-<pre-release>``` before the ```+```.

- ```<feature>``` incremented when features are added/removed/replaced/et cetera
- ```<update>``` incremented when ported to a new minecraft version - should mostly just be technical changes but may include some player facing changes if consequential of the new minecraft version
- ```<patch>``` incremented when bugfixes are made
- ```<minecraft-version>``` indicates the supported minecraft versions (changes with each ```<update>```), may indicate
  - A single minecraft version
  - A range of versions: ```<lower>-<upper>``` where ```<lower>``` is oldest minecraft version and ```<upper>``` is the newest
  - All subsequent versions: ```<first>+``` where ```<first>``` is the first suported minecraft version
    - Will need to be replaced with a range if a new minecraft update breaks compatibility
- ```<pre-release>``` may be ```<stage>.<build-number>``` where
  - ```<stage>``` is ```a``` for alpha, ```b``` for beta or ```rc``` for release candidate
  - ```<build-number>``` is incremented for each build within the same ```<stage>```

### Other

[LICENSE](LICENSE)

[Fabric](https://fabricmc.net/)

[Finding Trustworthy Mods](https://docs.fabricmc.net/players/finding-mods)

Thank You!