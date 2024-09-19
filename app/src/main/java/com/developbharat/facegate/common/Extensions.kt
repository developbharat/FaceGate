package com.developbharat.facegate.common

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.security.MessageDigest
import java.util.Locale

fun File.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return this.inputStream().use { fis ->
        val buffer = ByteArray(8192)
        generateSequence {
            when (val bytesRead = fis.read(buffer)) {
                -1 -> null
                else -> bytesRead
            }
        }.forEach { bytesRead -> md.update(buffer, 0, bytesRead) }
        md.digest().joinToString("") { "%02x".format(it) }
    }
}


fun File.validateMD5Hash(hash: String) {
    if (this.md5() != hash) {
        throw Exception("Failed due to corrupted file: ${this.nameWithoutExtension}. FileHash do not match.")
    }
}


fun Long.humanReadableFileSize(): String {
    val kiloByteAsByte = 1.0 * 1024.0
    val megaByteAsByte = 1.0 * 1024.0 * 1024.0
    val gigaByteAsByte = 1.0 * 1024.0 * 1024.0 * 1024.0
    val teraByteAsByte = 1.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0
    val petaByteAsByte = 1.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0

    return when {
        this < kiloByteAsByte -> "${this.toDouble()} B"
        this >= kiloByteAsByte && this < megaByteAsByte -> "${
            String.format(
                Locale.ENGLISH,
                "%.2f", (this / kiloByteAsByte)
            )
        } KB"

        this >= megaByteAsByte && this < gigaByteAsByte -> "${
            String.format(
                Locale.ENGLISH,
                "%.2f", (this / megaByteAsByte)
            )
        } MB"

        this >= gigaByteAsByte && this < teraByteAsByte -> "${
            String.format(
                Locale.ENGLISH,
                "%.2f", (this / gigaByteAsByte)
            )
        } GB"

        this >= teraByteAsByte && this < petaByteAsByte -> "${
            String.format(
                Locale.ENGLISH,
                "%.2f", (this / teraByteAsByte)
            )
        } TB"

        else -> "Bigger than 1024 TB"
    }
}


fun Bitmap.toThumbnail(width: Int, height: Int): Bitmap {
    // crop bitmap
    val cropped = Bitmap.createScaledBitmap(this, width, height, false)

    // compress to JPEG
    val outputStream = ByteArrayOutputStream()
    cropped.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    val bytes = outputStream.toByteArray()
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}