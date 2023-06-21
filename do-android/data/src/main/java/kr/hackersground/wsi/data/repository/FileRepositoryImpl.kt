package kr.hackersground.wsi.data.repository

import java.io.File
import java.time.LocalDateTime
import javax.inject.Inject
import kr.hackersground.wsi.data.remote.service.FileService
import kr.hackersground.wsi.domain.repository.FileRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

class FileRepositoryImpl @Inject constructor(
    private val fileService: FileService
): FileRepository {

    override suspend fun uploadFile(pdfFile: File) {
        val requestBody = pdfFile.asRequestBody("application/pdf".toMediaTypeOrNull())
        fileService.uploadFile(
            file = MultipartBody.Part.createFormData("${LocalDateTime.now()}", pdfFile.name, requestBody)
        )
    }
}
