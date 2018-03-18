package stuff

fun main(args: Array<String>) {
    writeAsHTML(snowflake(6))
}

fun snowflake(n : Int) : String {
    var kochs = koch0() + "\n"
    for (i in 1..n-1) {
        kochs = kochs + koch(i)
    }

    val lastKoch = "<g id=\"koch$n\" transform=\"scale(0.3333333)\"> \n" +
            "<use xlink:href=\"#koch${n-1}\" /> \n" +
            "<use xlink:href=\"#koch${n-1}\" transform=\"translate(900) rotate(-60,0,900)\" /> \n" +
            "<use xlink:href=\"#koch${n-1}\" transform=\"rotate(60,1800,900) translate(900)\" /> \n" +
            "<use xlink:href=\"#koch${n-1}\" transform=\"translate(1800)\" /> \n" +
            "</g> \n"
    val usage = "<use xlink:href=\"#koch$n\" />\n" +
            "<use xlink:href=\"#koch$n\" transform=\"rotate(60,0,300) translate(900) rotate(180,0,300)\" /> \n" +
            "<use xlink:href=\"#koch$n\" transform=\"rotate(-60,900,300) translate(900) rotate(180,0,300)\" /> \n"
    return tagAsDEFS(kochs + lastKoch) + usage
}

fun koch0() = "<line x1=\"0\" y1=\"900\" x2=\"900\" y2=\"900\" stroke=\"black\" stroke-width=\"60\" id=\"koch0\"></line>"


fun tagAsDEFS(stuff : String) = "<defs>\n" + stuff + "</defs>"

fun koch(i : Int) : String {
    if (i == 0) return koch0()

    val r = (i - 1).toString()

    return "<g id=\"koch$i\" transform=\"translate(0,600) scale(0.3333333)\">\n" +
            "            <use xlink:href=\"#koch$r\"></use>\n" +
            "            <use xlink:href=\"#koch$r\" transform=\"translate(900) rotate(-60,0,900)\"></use>\n" +
            "            <use xlink:href=\"#koch$r\" transform=\"rotate(60,1800,900) translate(900)\"></use>\n" +
            "            <use xlink:href=\"#koch$r\" transform=\"translate(1800)\"></use>\n" +
            "        </g>\n"
}
