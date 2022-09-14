package com.spora.corrutinas.db.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{
    @Insert
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM "+ Contact.table_name)
    fun getContacts(): Flow<List<Contact>>
}

