(*Versão 0.0.1*)

fun writeFile(filename : string, text : string) =
    let val file = TextIO.openOut(filename)
        val _ = TextIO.output(file, text)
    in TextIO.closeOut(file)
    end