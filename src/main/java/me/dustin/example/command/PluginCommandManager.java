package me.dustin.example.command;

import me.dustin.events.EventManager;
import me.dustin.example.feature.ExampleFeature;
import me.dustin.jex.feature.command.CommandManagerJex;
import me.dustin.jex.feature.command.core.Command;

import java.util.ArrayList;

public enum PluginCommandManager {
    INSTANCE;
    private final ArrayList<Command> myCommands = new ArrayList<>();
    /*
        For easily supporting disabling the plugin, seperate your own features in a list and manually register/unregister them when enabled/disabled
     */
    public void load() {
        myCommands.add(new ExampleCommand());

        CommandManagerJex.INSTANCE.getCommands().addAll(myCommands);
    }

    public void enablePlugin() {
        myCommands.forEach(command -> {
            CommandManagerJex.INSTANCE.getCommands().add(command);
        });
    }

    public void disablePlugin() {
        myCommands.forEach(command -> {
            CommandManagerJex.INSTANCE.getCommands().remove(command);
        });
    }

    public ArrayList<Command> getMyFeatures() {
        return myCommands;
    }
}
