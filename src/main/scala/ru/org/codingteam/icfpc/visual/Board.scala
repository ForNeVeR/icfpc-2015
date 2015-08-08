package ru.org.codingteam.icfpc.visual

import java.awt.{Color, Graphics2D, Graphics}
import javax.swing.JPanel


class Board(val rowsCount: Int, val colsCount: Int) extends JPanel {
  private val cells = Array.fill(rowsCount, colsCount)(Color.WHITE)

  override def paintComponent(g: Graphics): Unit = {
    val g2 = g.asInstanceOf[Graphics2D]
    renderCells(g2)
    renderGrid(g2)
  }


  private def renderGrid(g2: Graphics2D): Unit = {
    val cellWidth = getWidth / colsCount.toFloat
    val cellHeight = getHeight / rowsCount.toFloat

    g2.setColor(Color.BLACK)

    for (i <- 1 until colsCount) {
      g2.drawLine((i * cellWidth).toInt, 0, (i * cellWidth).toInt, getHeight)
    }

    for (i <- 1 until rowsCount) {
      g2.drawLine(0, (i * cellHeight).toInt, getWidth, (i * cellHeight).toInt)
    }
  }

  private def renderCells(g2: Graphics2D): Unit = {
    val cellWidth = getWidth / colsCount.toFloat
    val cellHeight = getHeight / rowsCount.toFloat

    for (row <- 0 until rowsCount) {
      for (col <- 0 until colsCount) {
        g2.setColor(cells(row)(col))
        g2.fillRect((col * cellWidth).toInt, (row * cellHeight).toInt,
          cellWidth.toInt, cellHeight.toInt)
      }
    }
  }

  def putCell(row: Int, col: Int, color: Color): Unit = {
    cells(row)(col) = color
  }
}
