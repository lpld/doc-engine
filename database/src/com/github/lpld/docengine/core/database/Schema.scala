package com.github.lpld.docengine.core.database

/** */
case class Schema(columns: Seq[Column])

sealed abstract class Column(name: String, columnType: ColumnType)
object Column {

  case class ValueColumn(name: String, columnType: ColumnType, value: String)
    extends Column(name, columnType)

  case class ReferenceColumn() extends Column(???, ???)
  case class FormulaColumn() extends Column(???, ???)
}

sealed trait ColumnType
object ColumnType {
  case object String extends ColumnType
  case object Number extends ColumnType
  case object DateTime extends ColumnType
}


