package com.github.lpld.docengine.core.database

import zio.Task

/** */
sealed trait IncomingData

object IncomingData {
  case class CreateDatabase(name: String) extends IncomingData
  case class DropDatabase(id: Long) extends IncomingData

  case class CreateTable(dbId: Long, name: String) extends IncomingData
  case class DropTable(dbId: Long, tableId: Long) extends IncomingData

  case class AddColumn(dbId: Long, tableId: Long, name: String) extends IncomingData
  case class DropColumn(dbId: Long, tableId: Long, columnId: Long) extends IncomingData

  case class AddRow(dbId: Long, tableId: Long) extends IncomingData
  case class DeleteRow(dbId: Long, tableId: Long, rowId: Long) extends IncomingData
}

trait IncomingEventsQueue {

  def nextEvent: Task[Event[IncomingData]]
}

case class Event[+Data](
  uid: String,
  data: Data
)
