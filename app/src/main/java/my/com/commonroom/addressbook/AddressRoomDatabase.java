package my.com.commonroom.addressbook;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Address.class}, version = 1)
public abstract class AddressRoomDatabase extends RoomDatabase{

    public abstract AddressDao wordDao();
    private static AddressRoomDatabase INSTANCE;

    static AddressRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AddressRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AddressRoomDatabase.class, "address_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
