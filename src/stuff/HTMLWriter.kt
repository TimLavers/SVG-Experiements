package stuff

import java.io.File

fun writeAsHTML(svg : String) {
    val dir = File("C:/junk/svg")
    dir.mkdirs()
    val outputFile = File(dir, "Stuff.html")
    val toPrint = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>SVG Experiments 2</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<svg width=\"900\" height=\"900\" viewBox=\"0 0 1200 1200\">\n" + svg + "\n</svg>\n</body>\n</html>"

    outputFile.writeText(toPrint)
}