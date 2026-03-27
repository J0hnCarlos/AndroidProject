package e.johncarlos.testing;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;


public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "db_tpk.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create words table
        String CREATE_WORDS_TABLE = "CREATE TABLE words ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "english TEXT, "+
                "tamil TEXT, "+
                "image INTEGER, "+
                "audio INTEGER, "+
                "category TEXT, "+
                "indonesia TEXT)";

        // create words table
        db.execSQL(CREATE_WORDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older words table if existed
        db.execSQL("DROP TABLE IF EXISTS words");

        // create fresh words table
        this.onCreate(db);
    }

    // Words table name
    private static final String tWords = "words";

    // Words Table Column names
    private static final String kID = "id";
    private static final String kEnglish = "english";
    private static final String kTamil = "tamil";
    private static final String kImage = "image";
    private static final String kAudio = "audio";
    private static final String kCategory = "category";
    private static final String kIndonesia = "indonesia";

    private static final String[] columns = {kID,kEnglish,kTamil,kImage,kAudio,kCategory, kIndonesia};

    public void addWord(Word word){

        // for logging
        Log.d("addWord", word.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(kEnglish, word.getDefaultTranslation()); // get Default Translation
        values.put(kTamil, word.getTamilTranslation()); // get Tamil Translation
        values.put(kImage, word.getImageResourceId()); // get Image resource id
        values.put(kAudio, word.getAudioResourceId()); // get Audio Resource id
        values.put(kCategory, word.getCategory()); // get word category
        values.put(kIndonesia, word.getIndonesiaTranlation());

        db.insert(tWords,null, values);

        db.close();
    }

    public ArrayList<Word> getWords(String category){
        ArrayList<Word> words = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tWords, columns," category = ?", new String[] { String.valueOf(category) },null,null,null,null);

        if (cursor.moveToFirst()) {
            do {
                words.add(new Word(cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), cursor.getString(5), cursor.getString(6)));
            } while (cursor.moveToNext());
        }

        db.close();

        return words;
    }


    // Options //
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public Quiz getQuiz(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor question = db.rawQuery("SELECT id, english, tamil, image, audio, category " + "FROM words " + "WHERE id >= (abs(random()) % (SELECT max(id) FROM words)) LIMIT 1", null);
        if (question.moveToFirst()) {
            Cursor options = db.rawQuery("SELECT DISTINCT english " + "FROM words " + "WHERE id >= (abs(random()) % (SELECT COUNT(id) FROM words WHERE category = ? AND id != ?)) AND category = ? AND id != ? ORDER BY english LIMIT 0,4", new String[] { question.getString(5), question.getString(0), question.getString(5), question.getString(0)});

            if(options != null && options.moveToFirst()) {
                option1 = options.getString(0);
                if(options.moveToNext()) {
                    option2 = options.getString(0);
                }
                if(options.moveToNext()) {
                    option3 = options.getString(0);
                }
                if(options.moveToLast()) {
                    option4 = options.getString(0);
                }
            }

            Random r = new Random();

            switch(r.nextInt(4)) {
                case 0: option1 = question.getString(1); break;
                case 1: option2 = question.getString(1); break;
                case 2: option3 = question.getString(1); break;
                case 3: option4 = question.getString(1); break;
            }

            options.close();

            Quiz q = new Quiz(question.getString(2), question.getString(1), question.getString(5), option1, option2, option3, option4, Integer.parseInt(question.getString(3)), Integer.parseInt(question.getString(4)));
            return q;
        }

        db.close();
        return null;
    }

    public void populateWords() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM words", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count == 0) {

            // Colors //
            addWord(new Word("White", "வெள்ளை", R.drawable.whiteboximage, R.raw.color_white, "Colors", "Putih"));
            addWord(new Word("Gray", "சாம்பல்", R.drawable.grayboximage, R.raw.color_gray, "Colors", "Abu-abu"));
            addWord(new Word("Black", "கருப்பு", R.drawable.blackboximage, R.raw.color_black, "Colors", "Hitam"));
            addWord(new Word("Red", "சிவப்பு", R.drawable.redboximage, R.raw.color_red, "Colors", "Merah"));
            addWord(new Word("Blue", "நீலமான", R.drawable.blueboximage, R.raw.color_blue, "Colors", "Biru"));
            addWord(new Word("Yellow", "மஞ்சள்", R.drawable.yellowboximage, R.raw.color_yellow, "Colors", "Kuning"));
            addWord(new Word("Green", "பச்சை", R.drawable.greenboximage, R.raw.color_green, "Colors", "Hijau"));
            addWord(new Word("Brown", "பழுப்பு", R.drawable.brownboximage, R.raw.color_brown, "Colors", "Coklat"));

            // Numbers //
            addWord(new Word("One", "ஒன்று", R.drawable.number_1, R.raw.number_one, "Numbers", "Satu"));
            addWord(new Word("Two", "இரண்டு", R.drawable.number_2, R.raw.number_two, "Numbers", "Dua"));
            addWord(new Word("Three", "மூன்று", R.drawable.number_3, R.raw.number_three, "Numbers", "Tiga"));
            addWord(new Word("Four", "நான்கு", R.drawable.number_4, R.raw.number_four, "Numbers", "Empat"));
            addWord(new Word("Five", "ஐந்து", R.drawable.number_5, R.raw.number_five, "Numbers", "Lima"));
            addWord(new Word("Six", "ஆறு", R.drawable.number_6, R.raw.number_six, "Numbers", "Enam"));
            addWord(new Word("Seven", "ஏழு", R.drawable.number_7, R.raw.number_seven, "Numbers", "Tujuh"));
            addWord(new Word("Eight", "எட்டு", R.drawable.number_8, R.raw.number_eight, "Numbers", "Delapan"));
            addWord(new Word("Nine", "ஒன்பது", R.drawable.number_9, R.raw.number_nine, "Numbers", "Sembilan"));
            addWord(new Word("Ten", "பத்து", R.drawable.number_10, R.raw.number_ten, "Numbers", "Sepuluh"));

            // Family //
            addWord(new Word("Father", "அப்பா", R.drawable.father, R.raw.family_father, "Family", "Ayah"));
            addWord(new Word("Mother", "அம்மா", R.drawable.mother, R.raw.family_mother, "Family", "Ibu"));
            addWord(new Word("Son", "மகன்", R.drawable.son, R.raw.family_son, "Family", "Anak Laki-laki"));
            addWord(new Word("Daughter", "மகள்", R.drawable.daughter, R.raw.family_daughter, "Family", "Anak Perempuan"));
            addWord(new Word("Older Brother", "அண்ணன்", R.drawable.olderbrother, R.raw.family_onisan, "Family", "Abang Laki-laki"));
            addWord(new Word("Younger Brother", "தம்பி", R.drawable.youngerbrother, R.raw.family_youngerbro, "Family", "Adik Laki-laki"));
            addWord(new Word("Older Sister", "அக்கா", R.drawable.oldersister, R.raw.family_onechan, "Family", "Kakak Perempuan"));
            addWord(new Word("Younger Sister", "தங்கை", R.drawable.youngersister, R.raw.family_youngersister, "Family", "Adik Perempuan"));
            addWord(new Word("Grandmother", "பாட்டி", R.drawable.grandmother, R.raw.family_grandma, "Family", "Nenek"));
            addWord(new Word("Grandfather", "தாத்தா", R.drawable.grandfather, R.raw.family_granpa, "Family", "Kakek"));

            // Phrases //
            addWord(new Word("Where are you going?", "நீஎங்கேபோகிறாய்?", R.drawable.whiteboximage, R.raw.where_are_you_going, "Phrases", "Kamu Kemana?"));
            addWord(new Word("What is your name?", "உங்கள்பெயர்என்ன", R.drawable.whiteboximage, R.raw.kiminonawa, "Phrases", "Nama Kamu siapa?"));
            addWord(new Word("My name is", "என்பெயர்...", R.drawable.whiteboximage, R.raw.watashinonamae, "Phrases", "Nama saya ..."));
            addWord(new Word("How are you feeling?", "நீஎப்படிஇருக்கிறாய்?", R.drawable.whiteboximage, R.raw.how_are_you_feeling, "Phrases", "Bagaimana perasaanmu?"));
            addWord(new Word("I'm feeling good", "நான்நன்றாகஇருகிறேன்.", R.drawable.whiteboximage, R.raw.im_feeling_good, "Phrases", "Saya merasa baik"));
            addWord(new Word("Are you coming?", "நீவருகிறாயா?", R.drawable.whiteboximage, R.raw.you_coming, "Phrases", "Kamu ikut?"));
            addWord(new Word("Yes, I'm coming", "ஆம், நான்வருகிறேன்.", R.drawable.whiteboximage, R.raw.yes_im_coming, "Phrases", "Iya, saya ikut"));
            addWord(new Word("I'm coming", "நான்வருகிறேன்.", R.drawable.whiteboximage, R.raw.im_coming, "Phrases", "Saya datang"));
            addWord(new Word("Let's go", "செல்லலாம்.", R.drawable.whiteboximage, R.raw.letsgo, "Phrases", "Ayo pergi"));
            addWord(new Word("Come Here", "இங்கேவா.", R.drawable.whiteboximage, R.raw.comehere, "Phrases", "Kesini"));
        }
        db.close();
    }
}