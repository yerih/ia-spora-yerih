package com.spora.corrutinas.DB.data

import androidx.room.Entity

@Entity(tableName = Contact.table_name)
data class Contact(
    val name: String,
    val lastName: String,
    val isMale: Boolean,
){
    companion object{
        const val table_name = "contacts"
    }
}
