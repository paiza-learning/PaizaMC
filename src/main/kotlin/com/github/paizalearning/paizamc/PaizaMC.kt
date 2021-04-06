package com.github.paizalearning.paizamc;

import com.github.paizalearning.paizamc.listener.NameCommandListener
import com.github.paizalearning.paizamc.listener.PlayerJoinListener
import com.github.paizalearning.paizamc.listener.PlayerQuitListener
import org.bukkit.plugin.java.JavaPlugin;

class PaizaMC: JavaPlugin() {
    override fun onEnable() {
        this.getCommand("name")?.setExecutor(NameCommandListener)

        server.pluginManager.registerEvents(PlayerJoinListener(), this)
        server.pluginManager.registerEvents(PlayerQuitListener(), this)
    }

    override fun onDisable() {
    }
}
