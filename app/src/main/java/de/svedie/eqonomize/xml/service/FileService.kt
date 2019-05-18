package de.svedie.eqonomize.xml.service

import android.net.Uri
import de.svedie.eqonomize.xml.entities.EqonomizeDoc
import de.svedie.eqonomize.xml.utils.XmlUtils

/**
 * Reads and writes the XML file.
 *
 * @author svedie
 */
class FileService(private val uri: Uri) {

  fun readFile(): EqonomizeDoc {
    return XmlUtils(uri).readFile()
  }

  fun writeFile(eqonomizeDoc: EqonomizeDoc) {
    XmlUtils(uri).write(eqonomizeDoc)
  }
}