package kr.hackersground.wsi.domain.repository

import java.io.File

interface FileRepository {

    suspend fun uploadFile(pdfFile: File)
}