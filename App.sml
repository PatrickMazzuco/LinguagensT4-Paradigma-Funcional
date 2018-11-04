(*Versão 0.0.3*)

fun writeFile(filename : string, text : string) =
    let val file = TextIO.openOut(filename)
        val _ = TextIO.output(file, text)
    in TextIO.closeOut(file)
    end
    
fun readFile(filename) =
    let val file = TextIO.openIn filename
        val text = TextIO.inputAll file
        val _ = TextIO.closeIn file
    in String.tokens (fn c => c = #"\n") text
    end