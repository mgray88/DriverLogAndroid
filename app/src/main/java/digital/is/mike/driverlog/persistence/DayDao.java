package digital.is.mike.driverlog.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.Date;

@Dao
public interface DayDao {

    @Query("SELECT * FROM day WHERE date = :date")
    LiveData<Day> getDay( Date date );
}
