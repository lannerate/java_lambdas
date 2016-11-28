package fp.task;

import java.util.List;

/**
 * Created by apple on 11/28/16.
 */
public class TaskFactory {

    public static EducationTask createTask() {
        boolean isSelectedTxtFormat = true;

        if (isSelectedTxtFormat) return new EducationTxtTask();
        else return new EducationCsvTask();
    }
}
