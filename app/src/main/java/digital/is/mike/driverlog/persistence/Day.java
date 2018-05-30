package digital.is.mike.driverlog.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Day {

    @PrimaryKey
    @NonNull
    private CalendarDay date;

    @ColumnInfo(name = "num_deliveries")
    private int numDeliveries;

    @ColumnInfo(name = "num_hours")
    private int numHours;

    @ColumnInfo(name = "mileage_start")
    private int mileageStart;

    @ColumnInfo(name = "mileage_end")
    private int mileageEnd;

    @ColumnInfo(name = "total_mileage")
    private int totalMileage;

    @ColumnInfo(name = "cash_tips")
    private int cashTips;

    @ColumnInfo(name = "credit_tips")
    private int creditTips;

    @ColumnInfo(name = "customer_fees")
    private int customerFees;

    Day( CalendarDay date ) {
        this.date = date;
    }

    public CalendarDay getDate () { return date; }

    public int getNumDeliveries () {
        return numDeliveries;
    }

    public void setNumDeliveries ( int numDeliveries ) {
        this.numDeliveries = numDeliveries;
    }

    public int getNumHours () {
        return numHours;
    }

    public void setNumHours ( int numHours ) {
        this.numHours = numHours;
    }

    public int getMileageStart () {
        return mileageStart;
    }

    public void setMileageStart ( int mileageStart ) {
        this.mileageStart = mileageStart;
    }

    public int getMileageEnd () {
        return mileageEnd;
    }

    public void setMileageEnd ( int mileageEnd ) {
        this.mileageEnd = mileageEnd;
    }

    public int getTotalMileage () {
        return totalMileage;
    }

    public void setTotalMileage ( int totalMileage ) {
        this.totalMileage = totalMileage;
    }

    public int getCashTips () {
        return cashTips;
    }

    public void setCashTips ( int cashTips ) {
        this.cashTips = cashTips;
    }

    public int getCreditTips () {
        return creditTips;
    }

    public void setCreditTips ( int creditTips ) {
        this.creditTips = creditTips;
    }

    public int getCustomerFees () {
        return customerFees;
    }

    public void setCustomerFees ( int customerFees ) {
        this.customerFees = customerFees;
    }
}
