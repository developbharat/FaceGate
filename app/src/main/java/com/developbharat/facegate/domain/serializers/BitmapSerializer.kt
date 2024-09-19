package com.developbharat.facegate.domain.serializers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.io.ByteArrayOutputStream

/// Custom serializer for Bitmap
object BitmapSerializer : KSerializer<Bitmap> {
    // Define how Bitmap will be serialized (as ByteArray)
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Bitmap", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Bitmap) {
        // Convert Bitmap to ByteArray for serialization
        val byteArray = value.toByteArray()
        // Encode ByteArray as a Base64 string to avoid binary issues in JSON
        encoder.encodeString(android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT))
    }

    override fun deserialize(decoder: Decoder): Bitmap {
        // Decode Base64 string back to ByteArray
        val byteArray = android.util.Base64.decode(decoder.decodeString(), android.util.Base64.DEFAULT)
        // Convert ByteArray back to Bitmap
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    // Helper function to convert Bitmap to ByteArray
    private fun Bitmap.toByteArray(): ByteArray {
        val stream = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
}