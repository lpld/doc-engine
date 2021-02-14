package com.github.lpld.docengine.core.database.inmem

import com.github.lpld.docengine.core.database.{Cell, Row, Schema, Table}
import zio.{Task, UIO}

import scala.collection.mutable

/** */
class InMemoryTable private(
  private var tableName: String,
  private var tableSchema: Schema,
  private var rows: mutable.Map[Long, Row],
  private var nextId: Long = 1
) extends Table {

  override def name: Task[String] = UIO { tableName }
  override def schema: Task[Schema] = UIO { tableSchema }
  override def addRow: Task[Long] = UIO {
    val id = nextId
    nextId = nextId + 1
    rows.put(id, new InMemoryRow(
      id,
      tableSchema.columns.map(_ => new InMemoryCell()).toBuffer
    ))
    id
  }
  override def getRow(id: Long): Task[Option[Row]] = UIO { rows.get(id) }
}

object InMemoryTable {

}

class InMemoryRow(
  val id: Long,
  private var rowCells: mutable.Buffer[InMemoryCell]
) extends Row {

  override def cells: Task[Seq[Cell]] = UIO { rowCells.toSeq }
}

class InMemoryCell(private var cellValues: Seq[String] = Seq.empty) extends Cell {

  override def values: Task[Seq[String]] = UIO { cellValues }
}

