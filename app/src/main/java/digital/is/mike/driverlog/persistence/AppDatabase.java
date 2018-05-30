package digital.is.mike.driverlog.persistence;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.TypeConverters;

import digital.is.mike.driverlog.common.CalendarUtils;

@Database(entities = {Day.class}, version = 1)
@TypeConverters({CalendarUtils.class})
abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
}
