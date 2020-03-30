package com.mahakal001.sastanotepad.takeNote

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mahakal001.sastanotepad.convertLongToDateString
import com.mahakal001.sastanotepad.database.Notes
import com.mahakal001.sastanotepad.formatNotes
import com.mahakal001.sastanotepad.formatSingleNoteString

@BindingAdapter("noteTimingFormatter")
fun TextView.setNoteTimingFormatter( item: Notes) {
    text = convertLongToDateString(item.recordTiming,context.resources)
}

@BindingAdapter("noteFormatter")
fun TextView.setNoteStringFormatter(item : Notes){
    text = formatSingleNoteString(item.notes,context.resources)
}
