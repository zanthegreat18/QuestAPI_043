package com.tugas.dataprojek2.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tugas.dataprojek2.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            InsertViewModel(
                aplikasiKontak().container.kontakRepository
            )
        }

        initializer {
            HomeViewModel(
                aplikasiKontak().container.kontakRepository
            )
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiKontak().container.kontakRepository
            )
        }

        initializer {
            UpdateViewModel(
                createSavedStateHandle(),
                aplikasiKontak().container.kontakRepository
            )
        }
    }
}


fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)