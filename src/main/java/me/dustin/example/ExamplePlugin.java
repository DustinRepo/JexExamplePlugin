package me.dustin.example;

import me.dustin.example.command.PluginCommandManager;
import me.dustin.example.feature.PluginFeatureManager;
import me.dustin.jex.feature.mod.core.Category;
import me.dustin.jex.feature.plugin.JexPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExamplePlugin {
    private static final Logger logger = LogManager.getFormatterLogger("ExamplePlugin");
    private static boolean isEnabled = true;

    /*
        You can create your own Category instances. Creating a new instance automatically adds it to the list of categories.
     */
    public static Category EXAMPLE = new Category("Example", 0xff00ff00);

    /*
        Called at the end of client load. Happens before @FabricLoad
     */
    @JexPlugin.ClientLoad
    public void clientLoad() {
        logger.info("Loaded example plugin!");
    }
    /*
        Called when Fabric would normally load a mod
     */
    @JexPlugin.FabricLoad
    public void fabricLoad() {

    }
    /*
        Called before loading modules, happens before anything else
     */
    @JexPlugin.FeaturesLoad
    public void featuresLoad() {
        PluginFeatureManager.INSTANCE.load();
        logger.info("Loaded Example features");
    }
    /*
        Called before loading commands, happens directly after @FeaturesLoad
     */
    @JexPlugin.CommandsLoad
    public void commandsLoad() {
        PluginCommandManager.INSTANCE.load();
        logger.info("Loaded Example commands");
    }
    /*
        Called only when a plugin is re-enabled from the client
        OPTIONAL
     */
    @JexPlugin.EnablePlugin
    public void enable() {
        isEnabled = true;
        PluginFeatureManager.INSTANCE.enablePlugin();
        PluginCommandManager.INSTANCE.enablePlugin();
        Category.values().add(EXAMPLE);
    }
    /*
        Called when the client disables the plugin
        OPTIONAL
     */
    @JexPlugin.DisablePlugin
    public void disable() {
        isEnabled = false;
        PluginFeatureManager.INSTANCE.disablePlugin();
        PluginCommandManager.INSTANCE.disablePlugin();
        Category.values().remove(EXAMPLE);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static boolean isEnabled() {
        return isEnabled;
    }
}
