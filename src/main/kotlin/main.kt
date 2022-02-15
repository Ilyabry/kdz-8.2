import NoteBook.addComment
import NoteBook.notes
import NoteBook.addNote
import NoteBook.comments
import NoteBook.deleteComment
import NoteBook.deleteNote
import NoteBook.editComment
import NoteBook.editNote
import NoteBook.getById
import NoteBook.getComments
import NoteBook.getNotes
import NoteBook.restoreComment

fun main(args: Array<String>) {

    val note_1 = Note(100,0, "1", "11", deleted = true)
    val note_2 = Note(100,0, "2", "22", deleted = true)
    val note_3 = Note(100,0, "3", "33", deleted = true)
    val note_4 = Note(100,0, "4", "44", deleted = true)

    addNote(note_1)
    addNote(note_2)
    addNote(note_3)
    addNote(note_4)

    val comment_1 = Comment(0,"коммент", 0, true)
    val comment_2 = Comment(0,"коммент2", 0, true)

    addComment(4, comment_1)
    addComment(4, comment_2)
    println(comments)
    println("йцукен")

    deleteNote(2)


    deleteComment(1)
    println(comments)
    println("фывапр")

    val note_30 = Note(100,0, "3", "33", deleted = true)
    editNote(3, note_30)

    val comment_20 = Comment(20,"коммент для изменения", 10, true)
    editComment(2, comment_20)

    getNotes(10)

    getById(1)

    getComments(4)

    restoreComment(3)
    println(comments)

}