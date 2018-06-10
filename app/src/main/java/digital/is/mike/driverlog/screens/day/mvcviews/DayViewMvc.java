package digital.is.mike.driverlog.screens.day.mvcviews;

import digital.is.mike.driverlog.persistence.Day;
import digital.is.mike.driverlog.screens.common.mvcviews.ViewMvc;

public interface DayViewMvc extends ViewMvc {

    void bindDay ( Day day );
}
