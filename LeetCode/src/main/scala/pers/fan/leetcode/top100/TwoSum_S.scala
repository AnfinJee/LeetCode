package pers.fan.leetcode.top100


/**
  * 2019-07-06
  */
object TwoSum_S {



    def twoSum(nums: Array[Int], target: Int): Array[Int] = {

        for(i <- 0 until nums.length; j <- i+1 until nums.length){
            if(nums(i)+nums(j) == target) return Array(i,j)
        }
        throw new Exception("match not found")
    }

    def twoSum2(nums: Array[Int], target: Int): Array[Int] = {

        @scala.annotation.tailrec
        def acc(diff: Map[Int, Int], idx: Int): Array[Int] = {
            if (idx >= nums.length) return Array()
            else {
                if (diff.contains(target - nums(idx))) Array(idx, diff(target - nums(idx)))
                else acc(diff + (nums(idx) -> idx), idx + 1)
            }
        }

        acc(Map(), 0)
    }

    def twoSum3(nums: Array[Int], target: Int): Array[Int] = {

        @scala.annotation.tailrec
        def acc(diff: Map[Int, Int], idx: Int): Array[Int] = {
            if (idx == nums.length) throw new Exception("match not found")
            else {
                val comp = target - nums(idx)
                diff.get(comp) match {
                    case Some(x) => Array(x,idx)
                    case None => acc(diff + (nums(idx) -> idx), idx + 1)
                }
            }
        }

        acc(Map(), 0)
    }


    def main(args: Array[String]): Unit = {

        twoSum(Array(1, 2, 3, 4, 5, 6, 7), 9).foreach(println)
    }
}
