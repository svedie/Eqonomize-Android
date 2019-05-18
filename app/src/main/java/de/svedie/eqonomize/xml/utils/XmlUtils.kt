package de.svedie.eqonomize.xml.utils

import android.net.Uri
import androidx.core.net.toFile
import com.tickaroo.tikxml.TikXml
import de.svedie.eqonomize.xml.entities.EqonomizeDoc
import okio.BufferedSink
import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.InputStream

/**
 * XML Utils to read and write the Eqonomize file.
 *
 * @author svedie
 */
class XmlUtils(private val uri: Uri) {

  fun readFile(): EqonomizeDoc {
    val inputStream: InputStream = File(uri.path).inputStream()

    val tikXml = TikXml.Builder()
    val builder = tikXml.build()

    return builder.read(inputStream.source().buffer(), EqonomizeDoc::class.java)
  }

  fun write(eqonomizeDoc: EqonomizeDoc) {
    val tikXml = TikXml.Builder()
    val builder = tikXml.build()

    builder.write(uri.toFile().sink() as BufferedSink?, eqonomizeDoc)
  }
}