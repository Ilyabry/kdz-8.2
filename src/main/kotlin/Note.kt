data class Note(
    var userId: Int,
    var id: Int,
    val title: String,
    val text: String,
    var deleted: Boolean = false
) {
    override fun toString(): String {
        return """|  
            |  Note: (userId = $userId, id = $id, 
            |title = '$title', 
            |text = '$text', 
            |deleted = $deleted)""".trimMargin()
    }
}

data class Comment(
    var noteId: Int = 0,
    val message: String = "",
    var commentId: Int = 0,
    var deleted: Boolean = true
) {
    override fun toString(): String {
        return """|
            |   Comment: (noteId = $noteId, commentId = $commentId, deleted = $deleted
            |   message = '$message')""".trimMargin()
    }
}