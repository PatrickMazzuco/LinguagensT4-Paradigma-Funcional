(*Versão 0.0.1*)

fun readFile(filename) =
    let val file = TextIO.openIn filename
        val text = TextIO.inputAll file
        val _ = TextIO.closeIn file
    in String.tokens (fn c => c = #"\n") text
    end