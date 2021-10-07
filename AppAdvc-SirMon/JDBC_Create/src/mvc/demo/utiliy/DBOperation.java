package mvc.demo.utiliy;

public interface DBOperation {

	String INSERT_RECORD = "INSERT into studentgrade ("
			+ "studentid"
			+ ",name"
			+ ",midterm"
			+ ",preFinal"
			+ ",finalGrade"
			+ ",remarks"
			+ ") VALUES (?,?,?,?,?,?)";
}
