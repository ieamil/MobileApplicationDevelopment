package com.example.week9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NoteFragment.OnNoteListInteractionListener {

    boolean displayingEditor = false;
    Note editingNote;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes = retrieveNotes();
        if(!displayingEditor){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.container, NoteFragment.newInstance(notes));
            fragmentTransaction.commit();
        }
        else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, EditNoteFragment.newInstance(readContent(editingNote)));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Note> retrieveNotes() {
    }
    private String readContent(Note editingNote) {
    }
    @Override
    public void onNoteSelected(Note note) {

    }
}