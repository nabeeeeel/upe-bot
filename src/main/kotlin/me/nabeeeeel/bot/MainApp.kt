package me.nabeeeeel.bot

import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.kordx.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.bot
import me.jakejmattson.discordkt.api.extensions.profileLink
import java.awt.Color


suspend fun main(args: Array<String>) {

    val token = args.first()
    bot(token) {
        prefix {
            val configuration = discord.getInjectionObjects(me.nabeeeeel.bot.data.Configuration::class)
            guild?.let { configuration[it.id.longValue]?.prefix } ?: "<none>"
        }
        configure {
            theme = Color(255, 205, 22)
            allowMentionPrefix = true
            //commandReaction = Emojis.corn
        }

        mentionEmbed {
            val discord = it.discord
            val api = discord.api
            val versions = discord.versions

            author {
                val author = api.getUser(Snowflake(125991444212088832))
                icon = author?.avatar?.url
                name = author?.tag
                url = author?.profileLink
            }

            title = "UPEBot"
            description = "UPEBot is a bot for use by UPE-Beta chapter for automating and optimizing the UPE Tutoring Discord server."
            thumbnail {
                url = api.getSelf().avatar.url
            }

            footer {
                text = "Version 0.0.01 - ${versions.library} - ${versions.kord}"
            }

            field {
                name = "Prefix"
                value = it.prefix()
            }

            field {
                name = "Links"
                value = "[[See Code]](https://github.com/nabeeeeel/upe-bot)"
                inline = true
            }

            field {
                value = "[[Join UPE]]()"
                inline = true
            }

        }

        presence {
            listening("'UPE help' for help")
        }
    }
}