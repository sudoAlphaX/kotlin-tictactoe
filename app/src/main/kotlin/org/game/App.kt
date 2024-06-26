/*
 * This source file was generated by the Gradle 'init' task
 */
package org.game

import kotlin.math.abs

class TicTacToeGame {

    val currentCanvas: MutableList<MutableList<Char>> = mutableListOf(mutableListOf(' ', ' ', 'x'), mutableListOf(' ', 'o', ' '), mutableListOf('x', ' ', ' '))

    fun printCanvas(
        canvas: List<List<Char>> = currentCanvas
    ) {
        println(
            """
┌-----------┐
| ${canvas[0][0]} | ${canvas[0][1]} | ${canvas[0][2]} |
├-----------┤
| ${canvas[1][0]} | ${canvas[1][1]} | ${canvas[1][2]} |
├-----------┤
| ${canvas[2][0]} | ${canvas[2][1]} | ${canvas[2][2]} |
└-----------┘
"""
        )
    }

    fun checkWinner(lastMove: Char, canvas: List<List<Char>>): Char {
        // Check row -
        for (i in 0..2) {
            var sj: Int = 0
            for (j in 0..2) {
                if (lastMove != canvas[i][j]) {
                    break
                }
                sj ++
            }
            if (sj == 3) {
               return lastMove
            }
        }
        // Check Column |
        for (j in 0..2) {
            var si: Int = 0
            for (i in 0..2) {
                if (lastMove != canvas[i][j]) {
                    break
                }
                si ++
            }
            if (si == 3) {
                return lastMove
            }
        }

        // Check Diagonal /
        var sk: Int = 0
        for (k in 0..2){
            if (lastMove != canvas[k][k]) {
                break
            }
            sk ++
        }
        if (sk == 3) {
            return lastMove
        }

        // Check Anti-Diagonal \
        var sl: Int = 0
        for (l in 0..2) {
            val p: Int = abs(l-2)
            if (lastMove != canvas[l][p]) {
                break
            }
            sl ++
        }
        if (sl == 3) {
            return lastMove
        }
        return ' '
    }

}

fun main() {
    val match = TicTacToeGame()
    match.printCanvas()
    print(match.checkWinner('x', match.currentCanvas))
}
