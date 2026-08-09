package com.hasantuncay.mobsec.maswe0002.vulnerable

import com.hasantuncay.mobsec.maswe0002.R
import com.hasantuncay.mobsec.common.R as CommonR

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import java.io.File
import java.io.FileNotFoundException

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: Path Traversal (CWE-22)
 *
 * This ContentProvider is intentionally exported (`exported="true"`) to allow other apps
 * to download public files (e.g., from the `cacheDir`).
 *
 * THE VULNERABILITY:
 * The `openFile` method takes the "file" query parameter and directly concatenates it
 * with the base directory path, WITHOUT calling `.canonicalPath` or verifying that the
 * resolved file actually resides within the intended directory.
 *
 * ATTACK:
 * An attacker app can send a URI like:
 * `content://com.hasantuncay.mobsec.vulnerable.provider/download?file=../../../shared_prefs/maswe0002_session.xml`
 * The system will blindly resolve `../` and return the sensitive session XML file.
 */
class VulnerableFileProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? = null
    override fun getType(uri: Uri): String? = null
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0

    @Throws(FileNotFoundException::class)
    override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor? {
        // Expected URI format: content://authority/download?file=some_public_file.pdf
        val fileName = uri.getQueryParameter("file") ?: throw FileNotFoundException("Missing 'file' parameter")

        // Intended directory: getCacheDir()
        val baseDir = context?.cacheDir ?: throw FileNotFoundException("Context is null")

        // VULNERABILITY: Directly using the fileName without validation
        // e.g., if fileName is "../shared_prefs/maswe0002_session.xml", it resolves outside cacheDir!
        val targetFile = File(baseDir, fileName)

        if (!targetFile.exists()) {
            throw FileNotFoundException("File not found: ${targetFile.absolutePath}")
        }

        // Return the file descriptor (read-only for demonstration)
        return ParcelFileDescriptor.open(targetFile, ParcelFileDescriptor.MODE_READ_ONLY)
    }
}
