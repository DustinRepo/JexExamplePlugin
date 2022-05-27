package me.dustin.example.command;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import me.dustin.jex.feature.command.core.Command;
import me.dustin.jex.feature.command.core.annotate.Cmd;
import me.dustin.jex.helper.misc.ChatHelper;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

@Cmd(name = "example", description = "Example command", syntax = ".example", alias = "ex")
public class ExampleCommand extends Command {
    @Override
    public void registerCommand() {
        CommandNode<FabricClientCommandSource> node = dispatcher.register(literal(this.name).executes(this));
        for (String alias : getAlias()) {
            dispatcher.register(literal(alias).redirect(node));
        }
    }

    @Override
    public int run(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        ChatHelper.INSTANCE.addClientMessage("Hello World!");
        return 1;
    }
}
