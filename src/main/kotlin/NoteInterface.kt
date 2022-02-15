interface NoteInterface<N, C> {

    fun addNote(n: N): N

    fun addComment(i: Int, c: C): C

    fun deleteNote(i: Int): Boolean

    fun deleteComment(i: Int): Boolean

    fun editNote(i: Int, n: N): Boolean

    fun editComment(i: Int, c: C): Boolean

    fun getNotes(i: Int)

    fun getById(i: Int)

    fun getComments(i: Int)

    fun restoreComment(i: Int): Boolean

}