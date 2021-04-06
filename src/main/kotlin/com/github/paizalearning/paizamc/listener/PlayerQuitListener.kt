package com.github.paizalearning.paizamc.listener

import com.github.paizalearning.paizamc.library.Discord
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuitListener: Listener {
    @EventHandler fun listen(e: PlayerQuitEvent) {
        sendMessageToDiscord(e)
    }

    private fun sendMessageToDiscord(e: PlayerQuitEvent) {
        Discord().sendMessage(e.player.name + " left the game.")
    }
}