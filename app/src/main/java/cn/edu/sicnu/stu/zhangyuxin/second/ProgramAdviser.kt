package cn.edu.sicnu.stu.zhangyuxin.second

// Model: returns resource IDs, without depending on Activity.
class ProgramAdviser {
    fun recommend(direction: Int): Int = when (direction) {
        0 -> R.string.mobile
        1 -> R.string.web
        2 -> R.string.data
        else -> R.string.system
    }
}
