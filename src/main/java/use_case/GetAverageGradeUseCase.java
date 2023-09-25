package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.lang.reflect.Array;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team t = this.gradeDB.getMyTeam();
        String[] members = t.getMembers();
        int n = 0;
        float sum = 0;
        for (String member: members) {
           sum += this.gradeDB.getGrade(member, course).getGrade();
           n += 1;


        }
        return sum / n;
    }
}
