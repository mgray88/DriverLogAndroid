package digital.is.mike.driverlog.persistence;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Day.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
}
