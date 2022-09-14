package com.spora.corrutinas.db.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{
    @Insert(onConflict = REPLACE)
    suspend fun insert(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM "+ Contact.table_name)
    fun getContacts(): Flow<List<Contact>>
}

