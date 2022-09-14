package com.spora.corrutinas.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Contact.table_name)
data class Contact(
    @PrimaryKey
    val name: String,
    val lastName: String,
    val isMale: Boolean,
){
    companion object{
        const val table_name = "contacts"
    }
}
