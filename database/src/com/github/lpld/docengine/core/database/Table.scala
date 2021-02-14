package com.github.lpld.docengine.core.database

import zio.Task

trait Database {

  def createTable(name: String): Task[Long]

  def dropTable(id: Long): Task[Boolean]
}

trait Table {

  def name: Task[String]

  def schema: Task[Schema]

  //noinspection MutatorLikeMethodIsParameterless
  def addRow: Task[Long]

  def getRow(id: Long): Task[Option[Row]]
}

trait Row {

  def id: Long

  def cells: Task[Seq[Cell]]
}

trait Cell {
  def values: Task[Seq[String]]
}

trait Schema {
  def 
}