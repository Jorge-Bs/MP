package uo.mp.minesweeper.ranking;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import uo.mp.minesweeper.session.GameLevel;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class GameRankingEntry implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String VICTORIA = "victoria";

	public static final String DERROTA = "derrota";
	
	private String userName;
	private Date date;
	private GameLevel level;
	private long duration;
	private boolean hasWon;
	
	
	
	
	/**
	 * Constructor que recibe los siguiente parametros:
	 * @param userName
	 * @param level
	 * @param duration
	 * @param hasWon
	 */
	public GameRankingEntry(String userName, GameLevel level, long duration,boolean hasWon) {
		setUserName(userName);
		setLevel(level);
		setDuration(duration);
		setHasWon(hasWon);
		setDate();
	}
	
	/**
	 * Constructor que recibe los siguientes parametros:
	 * @param userName
	 * @param level
	 * @param duration
	 * @param hasWon
	 * @param date
	 */
	public GameRankingEntry(String userName, GameLevel level, long duration,boolean hasWon,Date date) {
		this(userName,level,duration,hasWon);
		setDate(date);
	}

	/**
	 * Establece el userName del usuarion
	 * @param userName
	 */
	private void setUserName(String userName) {
		ArgumentChecks.isTrue(userName!=null,"Usuario null");
		ArgumentChecks.isTrue(!userName.isBlank() || !userName.isEmpty(),"usuario invalido");
		this.userName = userName;
	}
	
	/**
	 * Establece la fecha
	 * 
	 */
	private void setDate() {
		this.date = new Date();
	}
	
	/**
	 * Establece la fecha con el parametro dado
	 * @param date
	 */
	private void setDate(Date date) {
		this.date = date;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameRankingEntry other = (GameRankingEntry) obj;
		return Objects.equals(date, other.date) && duration == other.duration && hasWon == other.hasWon
				&& level == other.level && Objects.equals(userName, other.userName);
	}

	/**
	 * Establece el parametro dificultad
	 * @param level
	 */
	private void setLevel(GameLevel level) {
		ArgumentChecks.isTrue(level!=null,"dificultad invalida");
		this.level = level;
	}
	
	/**
	 * Establece el tiempo que duro la partida
	 * @param duration
	 */
	private void setDuration(long duration) {
		ArgumentChecks.isTrue(duration>=0,"Tiempo negativo");
		this.duration = duration;
	}
	
	/**
	 * Establece si ha ganado o no
	 * @param hasWon
	 */
	private void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}

	/**
	 * Devuelve el usuario
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Devuelve la fecha
	 * @return date , de tipo Date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Devuelve la dificultad del juego
	 * @return level, de tipo GameLevel
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * Devuelve la duracion
	 * @return duartion
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Devulve true si ha ganado, false en caso contrario
	 * @return boolean value
	 */
	public boolean isHasWon() {
		return hasWon;
	}
	
	/**
	 * Devuelve la informacion del objeto en una cadena Stringg
	 * @return a string with the information about one single entry
	 */
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(userName+" \t");
		sb.append(processDate(getDate())+"\t");
		sb.append(processTime(getDate())+"\t");
		sb.append(level+"\t");
		sb.append(victoria()+"  ");
		sb.append(duration);
		return sb.toString();
	}
	
	private String victoria() {
		if(hasWon) {
			return "Victoria";
		}else {
			return "Derrota";
		}
	}
	
	public GameRankingEntry clone() {
		GameRankingEntry clone =  new GameRankingEntry(this.userName, 
								this.level, this.duration, this.hasWon);
		clone.date=this.date;
		return clone;
	}
	
	/**
	 * Crea el objeto en formato texto para ser guardado
	 * @return strign con toda la informacion del objeto
	 */
	public String serialize() {
		StringBuilder sb = new StringBuilder();
		sb.append(getUserName()+";");
		sb.append(processDate(getDate())+";");
		sb.append(processTime(getDate())+";");
		sb.append(getLevel()+";");
		sb.append(stringHasWon()+";");
		sb.append(getDuration());
		return sb.toString();
	}

	private String stringHasWon() {
		if(isHasWon()) {
			return VICTORIA;
		}else {
			return DERROTA;
		}
	}

	/**
	 * Procesa la fecha para poder ser representada
	 * @param date
	 * @return string with date info
	 */
	private String processDate(Date date) {
		return String.format("%td/%<tm/%<tY", date);
	}

	/**
	 * Procesa la hora para poder ser representada
	 * @param date
	 * @return string with hour info
	 */
	private String processTime(Date date) {
		return String.format("%tH:%<tM",date);
	}
	
	
}

