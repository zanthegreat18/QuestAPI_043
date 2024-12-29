package com.tugas.dataprojek2

import android.app.Application
import com.tugas.dataprojek2.container.AppContainer
import com.tugas.dataprojek2.container.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container= MahasiswaContainer()
    }
}