package com.tugas.dataprojek2.container

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tugas.dataprojek2.Repositori.MahasiswaRepository
import com.tugas.dataprojek2.Repositori.NetworkKontakRepository
import com.tugas.dataprojek2.service.MahasiswaService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val kontakRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer{
    private val baseUrl ="http://10.0.2.2/umyTI/"
    private val json = Json{ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val mahasiswaService: MahasiswaService by lazy {
        retrofit.create(MahasiswaService::class.java) }

    override val kontakRepository: MahasiswaRepository by lazy{
        NetworkKontakRepository(mahasiswaService)
    }
}