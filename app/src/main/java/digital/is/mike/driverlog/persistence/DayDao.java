package digital.is.mike.driverlog.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.*;

@Dao
public interface DayDao {

    @Query("SELECT * FROM day WHERE date = :date LIMIT 1")
    LiveData<Day> getDay( CalendarDay date );

    @Query("SELECT * FROM day WHERE date(date) BETWEEN date(:day, 'start of month') AND date(:day, 'start of month', '+1 month', '-1 day')")
    LiveData<List<Day>> getMonthOf( CalendarDay day );

    @Insert(onConflict = REPLACE)
    void insertDay( Day day );

    @Update(onConflict = REPLACE)
    void updateDay( Day day );

    @Query("DELETE FROM day WHERE date = :date")
    void deleteDay( Day date );
}
