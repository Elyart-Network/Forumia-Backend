package net.elyow.forumia.storage.redis

import net.elyow.forumia.storage.plugins.sysgetenv
import redis.clients.jedis.*

object busConnection {
    var redis: JedisPool = JedisPool(sysgetenv["BUS_REDIS_ADDRESS"], sysgetenv["BUS_REDIS_PORT"].toInt())
}