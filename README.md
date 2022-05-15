# Jex Example Plugin
This is an example Plugin for the utility client Jex

# How to get started
## Getting Jex
1. First, download this project, using the green button above either download as zip or copy the link and use `git clone https...`
2. Now do the same with [JexClient](https://github.com/DustinRepo/JexClient)
3. Open terminal in the JexClient folder and type `./gradlew build`
4. Take the jar named `jex-plugin-dev.jar` in `build/libs/` and put it in the `lib` folder in JexPlugin
5. Optionally You can also use the `-sources-dev.jar` file as sources too
## Creating a plugin
1. Open `build.gradle` in Intellij as a gradle project and wait for it to set up
2. `File -> Close Project` if you do not have a run configuration, then re-open the project
3. Edit the JexPlugin.json to specify the plugin name, description, authors, main class, etc.
4. Rename exampleplugin.mixins.json
5. Edit the `gradle.properties` file to specify the same Minecraft version and Yarn Mappings as Jex which you can find [here](https://github.com/DustinRepo/JexClient/blob/main/gradle.properties)
6. To test, just run the "Minecraft Client" run configuration
7. When ready to distribute, run `./gradlew build` and the output will be in `build/libs/`