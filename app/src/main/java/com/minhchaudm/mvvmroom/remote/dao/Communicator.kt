package com.minhchaudm.mvvmroom.remote.dao

import com.minhchaudm.mvvmroom.model.Note

interface Communicator {
    fun sendData(title: String, description: String)
}