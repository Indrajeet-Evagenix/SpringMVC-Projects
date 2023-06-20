package com.becoder.dao;

import java.util.List;

import com.becoder.entity.Notes;
import com.becoder.entity.User;

public interface NotesDao {

	public int saveNotes(Notes notes);

	public List<Notes> getNotesByUser(User user);

	public Notes getNotesById(int id);

	public void deleteNotes(int id);

	public void updateNotes(Notes n);

}
