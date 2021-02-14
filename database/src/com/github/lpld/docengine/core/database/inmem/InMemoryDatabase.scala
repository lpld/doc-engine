package com.github.lpld.docengine.core.database.inmem

import com.github.lpld.docengine.core.database.{Database, Schema, Table}
import zio.Task

import java.util.concurrent.ConcurrentMap
import scala.collection.mutable

/** */
class InMemoryDatabase(
  private val tables: mutable.Map[Long, Table],
  private var nextId: Long = 1
) extends Database {

  override def createTable(name: String): Task[Long] = {
    val id = nextId
    nextId = nextId + 1
    tables.put(id, new InMemoryTable(name, new Schema(), ))
    id
  }
  override def dropTable(id: Long): Task[Boolean] = ???
}
