public class Product
{
	
	private String Programme;
	private String RestartCounter;
	private String Short;
	private String Date;
	private String Time;
	private String Shift;
	private String Table;
	private String Groupe;
	public String getProgramme() {
		return Programme;
	}
	public void setProgramme(String programme) {
		this.Programme = programme;
	}
	public String getRestartCounter() {
		return RestartCounter;
	}
	public void setRestartCounter(String restartCounter) {
		this.RestartCounter = restartCounter;
	}
	public String getShort() {
		return Short;
	}
	public void setShort(String s) {
		this.Short = s;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		this.Time = time;
	}
	public String getShift() {
		return Shift;
	}
	public void setShift(String shift) {
		this.Shift = shift;
	}
	public String getTable() {
		return Table;
	}
	public void setTable(String table) {
		this.Table = table;
	}
	

	public String getGroupe() {
		return Groupe;
	}
	public void setGroupe(String groupe) {
		Groupe = groupe;
	}
	public Product(String programme, String restartCounter, String s, String date, String time, String shift,
			String table, String groupe) {
		super();
		Programme = programme;
		RestartCounter = restartCounter;
		Short = s;
		Date = date;
		Time = time;
		Shift = shift;
		Table = table;
		Groupe = groupe;
	}

}