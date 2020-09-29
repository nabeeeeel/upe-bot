package me.nabeeeeel.bot.commands

import me.jakejmattson.discordkt.api.dsl.commands

fun testCommands() = commands("Test") {

    command("Ping") {
        description = "ping the bot"
        execute() {
            respond("ping")
        }
    }
}