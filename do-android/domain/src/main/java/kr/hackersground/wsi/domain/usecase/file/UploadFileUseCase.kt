package kr.hackersground.wsi.domain.usecase.file

import java.io.File
import javax.inject.Inject
import kr.hackersground.wsi.domain.repository.FileRepository

class UploadFileUseCase @Inject constructor(
    val fileRepository: FileRepository,
) {

    suspend operator fun invoke(pdfFile: File) = kotlin.runCatching {
        fileRepository.uploadFile(pdfFile = pdfFile)
    }
}
