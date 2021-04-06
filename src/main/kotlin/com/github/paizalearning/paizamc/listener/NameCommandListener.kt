package com.github.paizalearning.paizamc.listener

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object NameCommandListener: CommandExecutor {
    private val manager = Bukkit.getScoreboardManager()
    private val board = manager!!.mainScoreboard

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val team = board.getTeam(sender.name)
            if (args.isEmpty()) {
                team?.prefix = ""
                sender.setDisplayName(sender.name)
            } else {
                team?.prefix = "[" + args[0] + "]"
                sender.setDisplayName(args[0])
            }
        }
        return true
    }
}