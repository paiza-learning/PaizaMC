package com.github.paizalearning.paizamc.listener

import com.github.paizalearning.paizamc.library.Discord
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener: Listener {
    @EventHandler fun listen(e: PlayerJoinEvent) {
        sendMessageToDiscord(e)

        changeName(e)
    }

    private fun sendMessageToDiscord(e: PlayerJoinEvent) {
        Discord().sendMessage(e.player.name + " joined the game.")
    }

    private fun changeName(e: PlayerJoinEvent) {
        val board = Bukkit.getScoreboardManager()?.mainScoreboard ?: return
        var team = board.getTeam(e.player.name)
        if (team == null) {
            team = board.registerNewTeam(e.player.name)
        }

        team.addEntry(e.player.name)
        e.player.scoreboard = board
    }
}