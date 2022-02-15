object NoteBook : NoteInterface<Note, Comment> {
    var notes = mutableListOf<Note>()
    var comments = mutableListOf<Comment>()

    override fun addNote(note: Note): Note {
        val newNote = note.copy(id = notes.size + 1, deleted = false)
        notes.plusAssign(newNote)
        return notes.last()
    }

    override fun addComment(id: Int, comment: Comment): Comment {
        for (note in notes) {
            if (!note.deleted) {
                if (id == note.id) {
                    val newComment = comment.copy(noteId = note.id, commentId = comments.size + 1,
                        message = comment.message, deleted = false)
                    comments.plusAssign(newComment)
                    return comments.last()
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }


    override fun deleteNote(id: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, deleted = true)
                    return true
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    override fun deleteComment(idComment: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.deleted) {
                if (idComment == comment.commentId) {
                    comments[index] = comment.copy(commentId = comment.commentId, deleted = true)
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментария с таким ID не существует!")
    }

    override fun editNote(id: Int, newNote: Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, userId = note.userId, title = newNote.title,
                        text = newNote.text, deleted = false)
                    return true
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    override fun editComment(idComment: Int, newComment: Comment): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.deleted) {
                if (idComment == comment.commentId) {
                    comments[index] = comment.copy(noteId = comment.noteId, commentId = comment.commentId,
                        deleted = false, message = newComment.message)
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментария с таким ID не существует!")
    }

    override fun getNotes(idUser: Int) {
        for (note in notes) {
            if (idUser == note.userId) {
                if (!note.deleted) {
                    println(note.title)
                }
            }
        }
    }

    override fun getById(id: Int) {
        for (note in notes) {
            if (id == note.id) {
                if (!note.deleted) {
                    println("""|        title: ${note.title}
                    |   text: ${note.text}
                """.trimMargin())
                }
            }
        }
    }

    override fun getComments(id: Int) {
        for (comment in comments) {
            if (id == comment.noteId) {
                println(comment.message)
            }
        }
    }

    override fun restoreComment(idComment: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (idComment == comment.commentId) {
                if (comment.deleted) {
                    comments[index] = comment.copy(commentId = comment.commentId, deleted = false)
                    return true
                }
            }
        }
        throw CommentDeleteNotFoundException("Удаленного комментария с таким ID не существует!")
    }
}

class NoteNotFoundException(message: String) : RuntimeException("Заметки с таким ID не существует!")
class CommentNotFoundException(message: String) : RuntimeException("Комментария с таким ID не существует!")
class CommentDeleteNotFoundException(message: String) : RuntimeException("Удаленного комментария с таким ID не существует!")