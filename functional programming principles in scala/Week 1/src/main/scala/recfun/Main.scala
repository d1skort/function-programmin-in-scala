package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(chars: List[Char], counter: Int): Int =
        if (chars.isEmpty) counter
        else if (counter < 0) counter
        else if (chars.head == '(') loop(chars.tail, counter + 1)
        else if (chars.head == ')') loop(chars.tail, counter - 1)
        else loop(chars.tail, counter)
      loop(chars, 0) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =
      if (money == 0) 1
      else if (money < 0) 0
      else if (coins.isEmpty) 0
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
