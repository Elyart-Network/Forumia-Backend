package net.elyow.forumia.storage.mysql

import org.ktorm.database.Database
import org.ktorm.support.mysql.MySqlDialect
import net.elyow.forumia.storage.plugins.sysgetenv

object dbConnection {
    val mysql = Database.connect(
        url = "jdbc:mysql://" + sysgetenv["DB_MYSQL_ADDRESS"] + ":" + sysgetenv["DB_MYSQL_PORT"] + "/" + sysgetenv["DB_MYSQL_NAME"],
        driver = "com.mysql.cj.jdbc.Driver",
        user = sysgetenv["DB_MYSQL_USER"],
        password = sysgetenv["DB_MYSQL_PASS"],
        dialect = MySqlDialect()
    )
}