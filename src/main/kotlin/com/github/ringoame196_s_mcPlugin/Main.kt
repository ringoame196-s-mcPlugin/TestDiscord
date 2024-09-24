package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.commands.Command
import com.github.ringoame196_s_mcPlugin.commands.TabCompleter
import com.github.ringoame196_s_mcPlugin.events.Events
import net.dv8tion.jda.api.JDABuilder
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        val plugin = this

        saveDefaultConfig() // configファイル生成
        val config = plugin.config
        val token = config.getString("token") // token取得
        val jdaBuilder = JDABuilder.createDefault(token) // bot起動

        server.pluginManager.registerEvents(Events(), plugin)
        val command = getCommand("discord")
        command!!.setExecutor(Command())
        command.tabCompleter = TabCompleter()
    }
}
